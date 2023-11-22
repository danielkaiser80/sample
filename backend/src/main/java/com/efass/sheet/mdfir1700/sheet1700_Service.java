package com.efass.sheet.mdfir1700;

import com.efass.exceptions.ResourceNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface sheet1700_Service {
	public ResponseEntity<?> createData(sheet1700DAO data) throws ResourceNotFoundException;
	public ResponseEntity<?> createDataQ(sheetQdfir1700DAO data) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id, sheet1700DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id , sheetQdfir1700DAO Data) throws ResourceNotFoundException;

	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException;
	void saveSheet1700ToDataBase(MultipartFile file, String sheetNo);
}
