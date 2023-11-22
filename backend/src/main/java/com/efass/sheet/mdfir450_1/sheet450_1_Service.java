package com.efass.sheet.mdfir450_1;

import com.efass.exceptions.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;

public interface sheet450_1_Service {
	 public ResponseEntity<?> createData(sheet450_1DAO data) throws ResourceNotFoundException;

	 public ResponseEntity<?> createDataQ(sheetQdfir450_1DAO data) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id , sheetQdfir450_1DAO Data) throws ResourceNotFoundException;

	public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet450_1DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;

}
