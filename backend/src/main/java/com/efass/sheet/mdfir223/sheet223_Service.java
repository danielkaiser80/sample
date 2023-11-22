package com.efass.sheet.mdfir223;

import com.efass.exceptions.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;

public interface sheet223_Service {
	public ResponseEntity<?> createData(sheet223DAO data) throws ResourceNotFoundException;
	public ResponseEntity<?> createDataQ(sheetQdfir223DAO data) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id, sheet223DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir223DAO Data) throws ResourceNotFoundException;
	
	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;


	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException;
}
