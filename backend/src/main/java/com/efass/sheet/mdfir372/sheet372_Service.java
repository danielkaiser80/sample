package com.efass.sheet.mdfir372;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet372_Service {
	 public ResponseEntity<?> createData(sheet372DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet372DAO Data) throws ResourceNotFoundException;
		
		public ResponseEntity<?> createDataQ(sheetQdfir372DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllDataQ();
		public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id , sheetQdfir372DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;

}
