package com.efass.sheet.mdfir321;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mdfir311.sheet311DAO;

public interface sheet321_Service {

	public ResponseEntity<?> createData(sheet321DAO data) throws ResourceNotFoundException;
	public ResponseEntity<?> createDataQ(sheetQdfir321DAO data) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id , sheet321DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id , sheetQdfir321DAO Data) throws ResourceNotFoundException;
	
	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
	
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;

}
