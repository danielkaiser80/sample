package com.efass.sheet.mdfir920;

import com.efass.exceptions.ResourceNotFoundException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public interface sheet920_Service {
    ResponseEntity<?> createData(sheet920DAO data) throws ResourceNotFoundException;
    public ResponseEntity<?> fetchAllData();
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
    public ResponseEntity<?> updateData(int id, sheet920DAO Data) throws ResourceNotFoundException;
    
    ResponseEntity<?> createDataQ(sheetQdfir920DAO data) throws ResourceNotFoundException;
    public ResponseEntity<?> fetchAllDataQ();
    public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
    public ResponseEntity<?> updateDataQ(int id, sheetQdfir920DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
    void saveSheet920ToDataBase(MultipartFile file, String sheetNo);

}
