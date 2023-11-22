package com.efass.procedures;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface ProcedureService {
	


	//public void callPrepareTableProcedure( String date, String procedureName) throws ParseException;
	
	public ResponseEntity<?> callPrepareTableProcedures( String date, String procedureName) throws ResourceNotFoundException;
	
}
