package com.efass.sheet.mdfir412;

import com.efass.exceptions.ResourceNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

public interface sheet412_Service{
	 public ResponseEntity<?> createData(sheet412DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet412DAO Data) throws ResourceNotFoundException;
		Boolean writesheet412(LocalDate Date, String folderPath)
				throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
		
		 public ResponseEntity<?> createDataQ(sheetQdfir412DAO data) throws ResourceNotFoundException;
			public ResponseEntity<?> fetchAllDataQ();
			public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
			public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
			public ResponseEntity<?> updateDataQ(int id , sheetQdfir412DAO Data) throws ResourceNotFoundException;
}
