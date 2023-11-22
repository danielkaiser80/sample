package com.efass.report;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.ResponseEntity;

public interface ReportService {

	public ResponseEntity<?> selectDate(LocalDate since);

	public Boolean checkDate(LocalDate Date);

	public ReportDAO findDate(LocalDate Date);

	public ResponseEntity<?> NoDateFound();

	public ResponseEntity<?> fetchallActivity() throws FileNotFoundException;

	public void saveReportActivity(String date, String folderPath, String filename, int fileId);

	public Boolean checkByFileId(int fileId);
	
	public ResponseEntity<?> DeleteGeneratedFile(int Id);

}
