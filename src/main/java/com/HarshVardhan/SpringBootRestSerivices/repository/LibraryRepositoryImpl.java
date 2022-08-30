package com.HarshVardhan.SpringBootRestSerivices.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.HarshVardhan.SpringBootRestSerivices.controller.LibraryOne;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom
{
	List<LibraryOne> booksbyauthor= new ArrayList<LibraryOne>();
	@Autowired 
	LibraryRepository library;

	@Override
	public List<LibraryOne> findAllByAuthor(String authorName) 
	{
		List<LibraryOne> L=library.findAll();
		for(LibraryOne item: L)
		{
			if(item.getAuthor().equalsIgnoreCase(authorName))
			{
				booksbyauthor.add(item);
			}
		}
		 
		return booksbyauthor;
	}

}
