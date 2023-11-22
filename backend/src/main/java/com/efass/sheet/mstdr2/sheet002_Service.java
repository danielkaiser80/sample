package com.efass.sheet.mstdr2;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mstdr1.sheet001DAO;
import org.springframework.http.ResponseEntity;

public interface sheet002_Service {
    ResponseEntity<?> fetchAllData();

    ResponseEntity<?> updateData(int id, sheet002DAO Data) throws ResourceNotFoundException;

    ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
    
    
    ResponseEntity<?> fetchAllDataQ();

    ResponseEntity<?> updateDataQ(int id, sheetQstdr2DAO Data) throws ResourceNotFoundException;

    ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
}
