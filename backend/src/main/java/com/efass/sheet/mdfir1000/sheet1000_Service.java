package com.efass.sheet.mdfir1000;

import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface sheet1000_Service {
	
	public ResponseEntity<?> fetchAllData();
	
	public ResponseEntity<?> updateData(int id, sheet1000DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1000DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
	
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;




}
