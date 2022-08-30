package com.HarshVardhan.SpringBootRestSerivices.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingController
{
	@Autowired
	Greeting greeting;
	
	AtomicLong counter=new AtomicLong();
	@GetMapping("/greeting")
	public Greeting greeting()
	{
		greeting.setId(counter.incrementAndGet());
		   greeting.setName("Hey!! I am learning Spring Boot from  Harsh Vardhan Gupta" );
		   return greeting;
	}

}
