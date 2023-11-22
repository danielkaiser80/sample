package com.efass.sheet.mdfir371_1;

import com.efass.exceptions.ResourceNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

public interface sheet371_1_Service{
	 public ResponseEntity<?> createData(sheet371_1DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet371_1DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
		
		public ResponseEntity<?> createDataQ(sheetQdfir371_1DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllDataQ();
		public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id , sheetQdfir371_1DAO Data) throws ResourceNotFoundException;
}
