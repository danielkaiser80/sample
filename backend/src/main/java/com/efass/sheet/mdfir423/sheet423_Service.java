package com.efass.sheet.mdfir423;

import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public interface sheet423_Service {
    ResponseEntity<?> fetchAllData();

    ResponseEntity<?> updateData(int id, sheet423DAO Data) throws ResourceNotFoundException;

    ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
	
	 ResponseEntity<?> fetchAllDataQ();

	    ResponseEntity<?> updateDataQ(int id, sheetQdfir423DAO Data) throws ResourceNotFoundException;

	    ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
}




