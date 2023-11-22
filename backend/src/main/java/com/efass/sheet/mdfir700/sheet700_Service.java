package com.efass.sheet.mdfir700;

import com.efass.exceptions.ResourceNotFoundException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public interface sheet700_Service {

    public ResponseEntity<?> fetchAllData();

    public ResponseEntity<?> updateData(int id, sheet700DAO Data) throws ResourceNotFoundException;

    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
    
    public ResponseEntity<?> fetchAllDataQ();

    public ResponseEntity<?> updateDataQ(int id, sheetQdfir700DAO Data) throws ResourceNotFoundException;

    public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
    
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
}
