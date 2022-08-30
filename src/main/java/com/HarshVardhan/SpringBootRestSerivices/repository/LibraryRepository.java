package com.HarshVardhan.SpringBootRestSerivices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HarshVardhan.SpringBootRestSerivices.controller.LibraryOne;

public interface LibraryRepository extends JpaRepository<LibraryOne,String> ,LibraryRepositoryCustom
{
	
	

}
