package com.efass.sheet.mdfir201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mdfir192.sheetQdfir192DAO;

public interface sheet201_Service {
	 public ResponseEntity<?> createData(sheet201DAO data) throws ResourceNotFoundException; 
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet201DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
		
		
		public ResponseEntity<?> createDataQ(sheetQdfir201DAO data) throws ResourceNotFoundException; 
		public ResponseEntity<?> updateDataQ(int id , sheetQdfir201DAO Data) throws ResourceNotFoundException;
}
