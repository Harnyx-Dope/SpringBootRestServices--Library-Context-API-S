package com.HarshVardhan.SpringBootRestSerivices.repository;

import java.util.List;

import com.HarshVardhan.SpringBootRestSerivices.controller.LibraryOne;

public interface LibraryRepositoryCustom 
{
	 List<LibraryOne> findAllByAuthor(String authorName);
}
