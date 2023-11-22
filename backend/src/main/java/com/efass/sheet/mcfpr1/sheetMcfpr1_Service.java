package com.efass.sheet.mcfpr1;

import com.efass.exceptions.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;

public interface sheetMcfpr1_Service{
	 	
		public ResponseEntity<?> fetchAllData();
		
		public ResponseEntity<?> createData(sheetMcfpr1DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> createDataQ(sheetQcfpr1Dao data) throws ResourceNotFoundException;
		
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
		
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
		
		public ResponseEntity<?> updateData(int id , sheetMcfpr1DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id , sheetQcfpr1Dao Data) throws ResourceNotFoundException;
		
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
}
