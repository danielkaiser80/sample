package com.efass.sheet.mdfir921;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mdfir702.sheet702DAO;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public interface sheet921_Service {

	 public ResponseEntity<?> createData(sheet921DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet921DAO Data) throws ResourceNotFoundException;
		
		public ResponseEntity<?> createDataQ(sheetQdfir921DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllDataQ();
		public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id , sheetQdfir921DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;
		void saveSheet921ToDataBase(MultipartFile file, String sheetNo);


}
