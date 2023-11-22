
package com.efass.sheet.mdfir300;

import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;


public interface sheet300_Service {

		public ResponseEntity<?> fetchAllData();

	
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;   
				
		public ResponseEntity<?> updateData(int id, sheet300DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id, sheetQdfir300DAO Data) throws ResourceNotFoundException;
		
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;

}


