package com.efass.sheet.mdfir1200;

import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface sheet1200_Service {
	ResponseEntity<?> fetchAllData();

	ResponseEntity<?> updateData(int id, sheet1200DAO Data) throws ResourceNotFoundException;
	ResponseEntity<?> updateDataQ(int id, sheetQdfir1200DAO Data) throws ResourceNotFoundException;

	ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException;
}
