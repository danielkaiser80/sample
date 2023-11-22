package com.efass.sheet.mdfir400;

import com.efass.exceptions.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;

public interface sheet400_Service {
	    public ResponseEntity<?> createData(sheet400_DAO dataM, sheetQdfir400_DAO dataQ) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int dataId , sheet400_DAO dataM, sheetQdfir400_DAO dataQ) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;

}
