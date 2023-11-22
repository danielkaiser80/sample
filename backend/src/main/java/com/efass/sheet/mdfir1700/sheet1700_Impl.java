package com.efass.sheet.mdfir1700;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1600.ExcelSheetData1600;
import com.efass.sheet.mdfir1600.sheet1600DAO;
import com.efass.sheet.mdfir1650.sheet1650DAO;
import com.efass.sheet.mdfir1650.sheet1650Repository;
import com.efass.sheet.mdfir1650.sheet1650_Service;
import com.efass.sheet.mdfir1650.sheetQdfir1650DAO;
import com.efass.sheet.table.TabController;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Log4j2
public class sheet1700_Impl implements sheet1700_Service {

	private static final String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";


	@Autowired
	sheet1700Repository _1700Repository;

	@Autowired
	Qdfir1700Repo qdfir1700Repo;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1700XmlList() {
		return genericXmlList;
	}

	public void setSheet1700XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MMFBR1700 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet1700DAO data) throws ResourceNotFoundException {
		_1700Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1700Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1700DAO data) throws ResourceNotFoundException {
		qdfir1700Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1700Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1700DAO> data = null;
		Iterable<sheetQdfir1700DAO> qdfir1700DAOS = null;

		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1700";
			daoClass = sheet1700DAO.class;
			data = _1700Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getName() == null ? "" : e.getName());
				result.add(e.getSector() == null ? "" : e.getSector());
				result.add(e.getCrms_borrower_code() == null ? "" : e.getCrms_borrower_code());
				result.add(e.getRc_or_br_or_sr_no().toString() == null ?  "" : String.valueOf(e.getRc_or_br_or_sr_no()));
				result.add(e.getTotal().toString() == null ? ".00"
						: String.valueOf(e.getTotal().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getClassified_as_npa() == null ? "" : e.getClassified_as_npa());
				result.add(e.getInvestment().toString() == null ? ".00"
						: String.valueOf(e.getInvestment().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getLiabilities().toString() == null ? ".00"
						: String.valueOf(e.getLiabilities().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getTotal_exposure().toString() == null ? ".00"
						: String.valueOf(e.getTotal_exposure().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true)

					.build());

			setSheet1700XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1700(data);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1700";
			daoClass = sheetQdfir1700DAO.class;
			qdfir1700DAOS = qdfir1700Repo.findAll();

			qdfir1700DAOS.forEach((e) -> {
				try {
					// System.out.println("i am here 1700");

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getName() == null ? "" : e.getName());
					result.add(e.getSector() == null ? "" : e.getSector());
					result.add(e.getCrms_borrower_code() == null ? "" : e.getCrms_borrower_code());
					result.add(e.getRc_or_br_or_sr_no().toString() == null ?  "" : e.getRc_or_br_or_sr_no());
					result.add(e.getTotal().toString() == null ? ".00"
							: String.valueOf(e.getTotal().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getClassified_as_npa() == null ? "" : e.getClassified_as_npa());
					result.add(e.getInvestment().toString() == null ? ".00"
							: String.valueOf(e.getInvestment().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getLiabilities().toString() == null ? ".00"
							: String.valueOf(e.getLiabilities().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal_exposure().toString() == null ? ".00"
							: String.valueOf(e.getTotal_exposure().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true)

					.build());

			setSheet1700XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1700(qdfir1700DAOS);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
		
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
		sheet1700DAO data = _1700Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS1700Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1700DAO data = qdfir1700Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1700Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
		Optional<sheet1700DAO> data = _1700Repository.findById(dataId);

		if (data.isPresent()) {
			_1700Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheetQdfir1700DAO> data = qdfir1700Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1700Repo.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> updateData(int id, sheet1700DAO Data) throws ResourceNotFoundException {

		Optional<sheet1700DAO> DataDb = _1700Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1700DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setName(Data.getName());
			DataUpdate.setSector(Data.getSector());
			DataUpdate.setCrms_borrower_code(Data.getCrms_borrower_code());
			DataUpdate.setRc_or_br_or_sr_no(Data.getRc_or_br_or_sr_no());
			DataUpdate.setTotal(Data.getTotal());
			DataUpdate.setClassified_as_npa(Data.getClassified_as_npa());
			DataUpdate.setInvestment(Data.getInvestment());
			DataUpdate.setLiabilities(Data.getLiabilities());
			DataUpdate.setTotal_exposure(Data.getTotal_exposure());

			_1700Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1700Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1700DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1700DAO> DataDb = qdfir1700Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1700DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setName(Data.getName());
			DataUpdate.setSector(Data.getSector());
			DataUpdate.setCrms_borrower_code(Data.getCrms_borrower_code());
			DataUpdate.setRc_or_br_or_sr_no(Data.getRc_or_br_or_sr_no());
			DataUpdate.setTotal(Data.getTotal());
			DataUpdate.setClassified_as_npa(Data.getClassified_as_npa());
			DataUpdate.setInvestment(Data.getInvestment());
			DataUpdate.setLiabilities(Data.getLiabilities());
			DataUpdate.setTotal_exposure(Data.getTotal_exposure());

			qdfir1700Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1700Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}


	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSheet1700ToDataBase(MultipartFile file, String sheetNo) {
		if (isValidExcelFile(file)) {
			try {
				List<sheet1700DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
				_1700Repository.saveAll(excelData);
			} catch (IOException e) {
				throw new IllegalArgumentException("File is not a valid excel file");
			}
		}
	}

	private static List<sheet1700DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
		List<sheet1700DAO> sheet1700_list = new ArrayList<>();
		List<ExcelSheetData1700> excelSheet1700Data = new ArrayList<>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet(sheetNumber.trim());

			if (sheet != null) {
				int rowIndex = 0;
				for (Row row : sheet) {
					if (rowIndex == 0) {
						rowIndex++;
						continue;
					}
					if (rowIndex == 1) {
						rowIndex++;
						continue;
					}
					if (rowIndex == 2) {
						rowIndex++;
						continue;
					}
					Iterator<Cell> cellIterator = row.iterator();
					int cellIndex = 0;

					sheet1700DAO sheet1700 = new sheet1700DAO();
					ExcelSheetData1700 excelSheet1700D  = new ExcelSheetData1700();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cellIndex) {
							case 0 : excelSheet1700D.setSerial_no(String.valueOf(cell.getNumericCellValue()));
							case 1 : excelSheet1700D.setName(cell.getStringCellValue());
							case 2 : excelSheet1700D.setSector(cell.getStringCellValue());
							case 3 : excelSheet1700D.setCrms_borrower_code(cell.getStringCellValue());
							case 4 : excelSheet1700D.setRc_or_br_or_sr_no(cell.getStringCellValue());
							case 5 : excelSheet1700D.setTotal(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 6 : excelSheet1700D.setClassified_as_npa(String.valueOf(cell.getNumericCellValue()));
							case 7 : excelSheet1700D.setInvestment(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 8 : excelSheet1700D.setLiabilities(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 9 : excelSheet1700D.setTotal_exposure(BigDecimal.valueOf(cell.getNumericCellValue()));

							default : break;
						}
						cellIndex++;
					}
					excelSheet1700Data.add(excelSheet1700D);
					excelSheet1700Data.forEach(sheet1700Data -> {
						sheet1700.setName(sheet1700Data.getName());
						sheet1700.setSector(sheet1700Data.getSector());
						sheet1700.setCrms_borrower_code(sheet1700Data.getCrms_borrower_code());
						sheet1700.setRc_or_br_or_sr_no(null);
						sheet1700.setInvestment(sheet1700Data.getInvestment());
						sheet1700.setTotal(sheet1700Data.getTotal());
						sheet1700.setClassified_as_npa(sheet1700Data.getClassified_as_npa());
						sheet1700.setLiabilities(sheet1700Data.getLiabilities());
						sheet1700.setTotal_exposure(sheet1700Data.getTotal_exposure());
						sheet1700.setSector(sheet1700Data.getSector());
						System.out.println(sheet1700);
					});

					sheet1700_list.add(sheet1700);
				}
			}
			else {
				throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
			}
		}  catch (IOException e) {
			throw new RuntimeException("file too large");
		}
		return sheet1700_list;
	}

	private static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(), contentType);
	}
}
