package com.efass.sheet.mdfir450;

import com.efass.exceptions.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;

public interface sheet450_Service {
	 public ResponseEntity<?> createData(String type, sheet450_DAO dataM, sheetQdfir450_DAO dataQ) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId, String type) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId, String type) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int dataId , String type, sheet450_DAO dataM, sheetQdfir450_DAO dataQ) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
}
