package com.efass.sheet.mdfir302;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import org.springframework.http.ResponseEntity;

public interface sheet302_Service {
    ResponseEntity<?> fetchAllData();

    ResponseEntity<?> updateData(int id, sheet302DAO Data) throws ResourceNotFoundException;
    ResponseEntity<?> updateDataQ(int id, sheetQdfir302DAO Data) throws ResourceNotFoundException;

    ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
}
