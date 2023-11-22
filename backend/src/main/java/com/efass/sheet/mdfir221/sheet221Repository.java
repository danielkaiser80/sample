package com.efass.sheet.mdfir221;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sheet221Repository extends CrudRepository<sheet221DAO, Integer>{


	@Override
	List<sheet221DAO> findAll();
	  
	
	  
	    
}