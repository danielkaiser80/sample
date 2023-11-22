package com.efass.sheet.mstdr1;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mdfir1700.sheet1700DAO;
import org.springframework.http.ResponseEntity;

public interface sheet001_Service {
    ResponseEntity<?> createData(sheet001DAO data) throws ResourceNotFoundException;
    ResponseEntity<?> fetchAllData();

    ResponseEntity<?> updateData(int id, sheet001DAO Data) throws ResourceNotFoundException;

    ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
    
    ResponseEntity<?> createDataQ(sheetQstdr1DAO data) throws ResourceNotFoundException;
    ResponseEntity<?> fetchAllDataQ();

    ResponseEntity<?> updateDataQ(int id, sheetQstdr1DAO Data) throws ResourceNotFoundException;

    ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
}
