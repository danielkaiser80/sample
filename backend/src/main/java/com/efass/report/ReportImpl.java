package com.efass.report;

import org.springframework.core.io.Resource;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.efass.auth.jwt.JwtRequest;
import com.efass.payload.Response;
import com.efass.sheet.mdfir221.sheet221Repository;
import com.efass.sheet.mdfir311.sheet311Repository;
import com.efass.sheet.mdfir321.sheet321DAO;
import com.efass.specials.SpecialFunction;

@Service
public class ReportImpl implements ReportService {

	private final Path fileStorageLocation = null;

	@Autowired
	ReportRepository ReportRepo;

	@Autowired
	ReportCall reportCall;

	ReportDAO data = new ReportDAO();

	public void saveReportActivity(String date, String folderPath, String filename, int fileId) {

		// Get Authenication Details
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();

		SpecialFunction special = new SpecialFunction();
		String rand = special.generateRandomString();

		// Update Data

		Optional<ReportDAO> DataDb = ReportRepo.findById(fileId);
		if (DataDb.isPresent()) {
			ReportDAO DataUpdate = DataDb.get();
			DataUpdate.setFile_name(filename);
			DataUpdate.setFile_path(folderPath);
			DataUpdate.setReport_date(date);
			DataUpdate.setStatus("Approved");
//			DataUpdate.setUser_id(currentPrincipalName);
			ReportRepo.save(DataUpdate);
		}

	}

	public ResponseEntity<?> fetchallActivity() {

		// Get Authenication Details
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
//
//		String status = "Approved";
//		ArrayList<ReportDAO> data = ReportRepo.findAllByUsername(currentPrincipalName, status);

		ReportResponse res = new ReportResponse();
//		res.setReportData(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> selectDate(LocalDate Date) {

		// Check if Date Exists
//		Boolean isDate=checkDate(Date);
//		if(isDate == true) {
//		
//		
//			Response res = new Response();
//			res.setResponseMessage("Success,File Exists");
//			res.setResponseCode(00);
//			res.setFilePath(data.getFile_path());
//			return new ResponseEntity<>(res, HttpStatus.OK);	
//		}

		String selectedDate = Date.toString();

		// Create a folder inside exports
		SpecialFunction special = new SpecialFunction();
		Response res = new Response();
		String rand = special.generateRandomString();
		String filename = selectedDate + "-" + rand;// System.currentTimeMillis()
		// String filepath = special.createFolderDirectory( filename,rand);
		String filepath = "./datafiles/export";
		if (!filepath.equals(null)) {

			// Get Authenication Details
//			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//			String currentPrincipalName = authentication.getName();

			// Save Data
			ReportDAO data = new ReportDAO();
			data.setFile_name(filename);
			data.setFile_path(filepath);
			data.setReport_date(Date.toString());
			data.setStatus("Saved");
//			data.setUser_id(currentPrincipalName);
			ReportRepo.save(data);

			// search with filename and return date
			String fileId = ReportRepo.findByFilename(filename);

			// Run Procedure to populate the tables on DB
			res.setResponseMessage("Success,File Created");
			res.setResponseCode(00);
			res.setFilePath(filepath);
			res.setFileId(fileId);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} else {
			res.setResponseMessage("Failed to generate report");
			res.setResponseCode(-1001);
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		}

		// Call Procedure to populate tables
	}

	public ResponseEntity<?> DeleteGeneratedFile(int id) {

		System.out.println("I am inside delete");

		Response res = new Response();
		try {
			ReportRepo.deleteById(id);
//		res.setResponseMessage("Failed To Prepare For Generation");
//		res.setResponseCode(00);
			return ResponseEntity.noContent().header("Content-Length", "0").build();

		} catch (Exception e) {
			// TODO: handle exception
			res.setResponseMessage("Failed To Delete");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		}

	}

//	public String getFilePath() {
//		
//		System.out.println("I am inside delete");
//		
//		
//		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
//	}
//		

	public Boolean checkDate(LocalDate Date) {

		return true;

//		String date= null;
//		
//		 //data = ReportRepo.findByDate(Date.toString());
//	
//		
//		 
//			String data =reportCall.fetchDate(Date.toString());
//		
//		if(data.equals(null)) {
//			
//			return false;
//			
//		}else {
//			System.out.println("Date Exists");
//			return true;
//		}

	}

	public Boolean checkByFileId(int fileId) {
		// check if file exists in db

		String filename = ReportRepo.fileReportRepo(fileId);

		if (filename == null || filename.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	public ReportDAO findDate(LocalDate Date) {

		data = ReportRepo.findByDate(Date.toString());

		if (data == null) {
			return data;

		} else {
			System.out.println("Selected Date=" + data.getReport_date());
			return data;
		}

	}

	public ResponseEntity<?> NoDateFound() {
		Response res = new Response();
		res.setResponseMessage("Failed, Report Date Not Selected");
		res.setResponseCode(-1001);
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);

	}

}
