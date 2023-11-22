package com.efass.sheet.mdfir142;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mstdr2.sheetQstdr2DAO;

import org.springframework.http.ResponseEntity;

public interface sheet142_Service{
	    
		public ResponseEntity<?> fetchAllData();
		
		public ResponseEntity<?> createData(sheet142DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> createDataQ(sheetQdfir142DAO data) throws ResourceNotFoundException;		

		public ResponseEntity<?> updateData(int id , sheet142DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id , sheetQdfir142DAO Data) throws ResourceNotFoundException;
		
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
		
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
		
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProceduresQ(String start_date, String end_date) throws ResourceNotFoundException;
	}
