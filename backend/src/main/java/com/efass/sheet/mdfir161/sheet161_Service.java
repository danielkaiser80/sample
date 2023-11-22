package com.efass.sheet.mdfir161;

import com.efass.exceptions.ResourceNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

public interface sheet161_Service{
	 public ResponseEntity<?> createData(sheet161DAO data) throws ResourceNotFoundException;
	 public ResponseEntity<?> fetchAllData();
	 public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
	 public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
	 public ResponseEntity<?> updateData(int id , sheet161DAO Data) throws ResourceNotFoundException;
	 public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
	 
	 public ResponseEntity<?> createDataQ(sheetQdfir161DAO data) throws ResourceNotFoundException;
	 public ResponseEntity<?> fetchAllDataQ();
	 public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
	 public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
	 public ResponseEntity<?> updateDataQ(int id , sheetQdfir161DAO Data) throws ResourceNotFoundException;
	 public ResponseEntity<?> callPrepareTableProceduresQ(String start_date, String end_date) throws ResourceNotFoundException;
		
		
		
		}
