package com.efass.sheet.mdfir221;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet221_Service {
	
	public ResponseEntity<?> createData(sheet221DAO data) throws ResourceNotFoundException;
	public ResponseEntity<?> createDataQ(sheetQdfir221DAO data) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id , sheet221DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id , sheetQdfir221DAO Data) throws ResourceNotFoundException;
	
	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;


}
