package com.efass.sheet.mdfir533;

import com.efass.exceptions.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;

public interface sheet533_Service{
    ResponseEntity<?> fetchAllData();

    ResponseEntity<?> updateData(int id, sheet533DAO Data) throws ResourceNotFoundException;

    ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
    
    ResponseEntity<?> fetchAllDataQ();

    ResponseEntity<?> updateDataQ(int id, sheetQdfir533DAO Data) throws ResourceNotFoundException;

    ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
    
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
}
