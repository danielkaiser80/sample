
package com.efass.download;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;

@RestController
@RequestMapping("api/v1/download")
public class ExcelDownloadController {

	@Autowired
	ReportRepository ReportRepo;

//private final static String UPLOAD_DIR = "./datafiles/archives/2019-04-25~1614767134659/cbn_MFB_rpt_12345m052087.xlsx";

	// @Autowired
	// CustomerRepository customerRepository;

	@GetMapping(value = "/excel/{id}")
	public ResponseEntity<InputStreamResource> excelCustomersReport(@PathVariable int id) throws IOException {

		Optional<ReportDAO> DataDb = ReportRepo.findById(id);

		if (DataDb.isPresent()) {
			ReportDAO data = DataDb.get();

			String filePath = data.getFile_path();
			String fileName = data.getFile_name();

			String UPLOAD_DIR = filePath;

			File file = new File(UPLOAD_DIR);

			ByteArrayInputStream in = retrieveByteArrayInputStream(file);
			// return IOUtils.toByteArray(in);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=cbn_MFB_rpt_12345m052087.xlsx");

			return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

		} else {

			return null;
		}
	}

	public static ByteArrayInputStream retrieveByteArrayInputStream(File file) throws IOException {
		return new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
	}

	private static byte[] readContentIntoByteArray(File file) {

		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];

		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
//  for (int i = 0; i < bFile.length; i++) { 
//	  System.out.print((char) bFile[i]);
//	  }
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("File Not Found !");
		}
		return bFile;
	}

}
