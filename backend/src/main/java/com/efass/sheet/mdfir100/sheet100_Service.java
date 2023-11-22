package com.efass.sheet.mdfir100;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface sheet100_Service {
	
	public ResponseEntity<?> fetchAllData();
	
	public ResponseEntity<?> updateData(int id, sheet100DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id, sheetQdfirDAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
	
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
	
	public ResponseEntity<?> saveCBNDate(String date) throws ResourceNotFoundException;

	void saveSheet100ToDataBase(MultipartFile file, String sheetNo);

}
