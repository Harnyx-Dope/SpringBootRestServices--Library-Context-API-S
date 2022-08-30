package com.HarshVardhan.SpringBootRestSerivices.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HarshVardhan.SpringBootRestSerivices.controller.LibraryOne;
import com.HarshVardhan.SpringBootRestSerivices.repository.LibraryRepository;

 
@Service
public class LibraryService
{
	@Autowired
	LibraryRepository repository;
	public boolean checkBookAlreayExist(String id)
	{
		 Optional<LibraryOne> libt= repository.findById(id);
		 if(libt.isPresent())
		return false;
		 else
			 return true;
		
		
	}

}
