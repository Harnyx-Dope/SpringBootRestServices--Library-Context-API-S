package com.HarshVardhan.SpringBootRestSerivices.controller;

import org.springframework.stereotype.Component;

@Component
public class Greeting
{
	private long id;
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public long getId() {
		return id; 
	}
	public String getName() {
		return name;
	}
	
	

}
