package com.efass.sheet.mdfir600;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mdfir300.sheet300DAO;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public interface sheet600_Service {


    public ResponseEntity<?> fetchAllData();


    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

    public ResponseEntity<?> updateData(int id, sheet600DAO Data) throws ResourceNotFoundException;
    
    public ResponseEntity<?> fetchAllDataQ();


    public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;

    public ResponseEntity<?> updateDataQ(int id, sheetQdfir600DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;

    void saveSheet600ToDataBase(MultipartFile file, String sheet600);
}
