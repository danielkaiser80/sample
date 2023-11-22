package com.efass.sheet.mdfir422;

import com.efass.exceptions.ResourceNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

public interface sheet422_Service{
	 public ResponseEntity<?> createData(sheet422DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet422DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
		
		public ResponseEntity<?> createDataQ(sheetQdfir422DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllDataQ();
		public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id , sheetQdfir422DAO Data) throws ResourceNotFoundException;

}
