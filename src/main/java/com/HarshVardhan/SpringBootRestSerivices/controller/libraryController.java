package com.HarshVardhan.SpringBootRestSerivices.controller;

import org.springframework.http.HttpHeaders;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.HarshVardhan.SpringBootRestSerivices.Service.LibraryService;
import com.HarshVardhan.SpringBootRestSerivices.repository.LibraryRepository;

@RestController
public class libraryController 
{
	@Autowired
	LibraryRepository repository;
	
	@Autowired 
	LibraryService lib;
	
	private static final Logger logf = LoggerFactory.getLogger(libraryController.class);

	 
	
	@GetMapping("/addBook")
	public ResponseEntity<AddResponse> addBookImplementation(@RequestBody LibraryOne Library)
	{
		AddResponse ad=new AddResponse();
		if(lib.checkBookAlreayExist(Library.getIsbn()+Library.getAisle()))
		{
		 logf.info("Book does not exist creating one");
		System.out.println(Library.getAuthor());
		Library.setId(Library.getIsbn()+Library.getAisle());
		Library.setAuthor(Library.getAuthor());
		Library.setAisle(Library.getAisle());
        Library.setBook_name( Library.getBook_name());
		repository.save(Library);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Unique",Library.getIsbn()+Library.getAisle());
		
		ad.setMsg("SuccessBook Is added");
		ad.setId(Library.getIsbn()+Library.getAisle());
		
		return new ResponseEntity<AddResponse>(ad,headers,HttpStatus.CREATED);
		}
		else
		{
			logf.info("Book was Existing so skipping this one");
		 
			ad.setMsg("Book Already present");
			ad.setId(Library.getIsbn()+Library.getAisle());
			return new ResponseEntity<AddResponse>(ad,HttpStatus.ACCEPTED);
		}
		
		}
	@GetMapping("/getbook/{id}")
	 public LibraryOne getbookbyid(@PathVariable(value="id")String id)
	 {
		try{
		LibraryOne lib=repository.findById(id).get();
		return lib;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	 }
	@GetMapping("/getbook/author")
	public List<LibraryOne> getbookbyauthorname(@RequestParam(value="authorname")String authorname)
	{
		 
		return  repository.findAllByAuthor(authorname);
		
	}
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<LibraryOne> updateBook(@PathVariable(value="id")String id,@RequestBody LibraryOne Library )
	{
	 LibraryOne hh=repository.findById(id).get();
	hh.setAisle(Library.getAisle());
	hh.setAuthor(Library.getAuthor());
	hh.setBook_name(Library.getBook_name());
	repository.save(hh);
	return new ResponseEntity<LibraryOne>(hh,HttpStatus.OK);
	 
	}
	@DeleteMapping("/deleteBook")
	public ResponseEntity<String> deleteBookbyid(@RequestBody LibraryOne library)
	{
		LibraryOne lib=repository.findById(library.getId()).get();
		repository.delete(lib);
		 
		 
		return new ResponseEntity<>("Book deleted",HttpStatus.CREATED);
		
	}
	@GetMapping("/Getall")
	public List<LibraryOne> getallbooks()
	{
		 return repository.findAll();
		 
		
	}
			

}
