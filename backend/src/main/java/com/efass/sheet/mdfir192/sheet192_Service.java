package com.efass.sheet.mdfir192;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet192_Service {
	public ResponseEntity<?> createData(sheet192DAO data) throws ResourceNotFoundException;

	public ResponseEntity<?> createDataQ(sheetQdfir192DAO data) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id, sheet192DAO Data) throws ResourceNotFoundException;

	public ResponseEntity<?> updateDataQ(int id, sheetQdfir192DAO Data) throws ResourceNotFoundException;

	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException;

}
