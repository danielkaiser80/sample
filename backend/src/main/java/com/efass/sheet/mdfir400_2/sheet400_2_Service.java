package com.efass.sheet.mdfir400_2;

import com.efass.exceptions.ResourceNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

public interface sheet400_2_Service{
	ResponseEntity<?> createData(sheet400_2DAO data) throws ResourceNotFoundException;
	ResponseEntity<?> createDataQ(sheetQdfir400_2DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		 ResponseEntity<?> updateData(int id , sheet400_2DAO Data) throws ResourceNotFoundException;
		 ResponseEntity<?> updateDataQ(int id, sheetQdfir400_2DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
		}
