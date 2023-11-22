package com.efass.sheet.mdfir101;


import org.springframework.http.ResponseEntity;
import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface sheet101_Service {
	
	public ResponseEntity<?> createData(sheet101DAO data) throws ResourceNotFoundException;
	public ResponseEntity<?> createDataQ(sheetQdfir101DAO data) throws ResourceNotFoundException;
	 
	public ResponseEntity<?> fetchAllData();
		
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
	
	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
		
	public ResponseEntity<?> updateData(int id, sheet101DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir101DAO Data) throws ResourceNotFoundException;
		
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;


	void saveSheet101ToDataBase(MultipartFile file, String sheet101);
}
