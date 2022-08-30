package com.HarshVardhan.SpringBootRestSerivices;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.HarshVardhan.SpringBootRestSerivices.repository.LibraryRepository;

@SpringBootApplication
public class SpringBootRestSerivicesApplication  {
	@Autowired
	LibraryRepository repo;
	public static void main(String[] args) 
	{		
		SpringApplication.run(SpringBootRestSerivicesApplication.class, args);
	}

 
		 
		
	}

	

