package com.efass.sheet.mdfir1600;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import com.efass.sheet.mdfir1000.sheetQdfir1000DAO;
import com.efass.sheet.mdfir1300.sheetQdfir1300DAO;
import com.efass.sheet.mdfir1301.ExcelSheetData1301;
import com.efass.sheet.mdfir1301.sheet1301DAO;
import com.efass.sheet.mdfir1500.sheet1500DAO;
import com.efass.sheet.table.TabController;
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

@Service
public class sheet1600_Impl implements sheet1600_Service {
	private static final String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";


	@Autowired
	sheet1600Repository sheet1600Repository;

	@Autowired
	Qdfir1600Repo qdfir1600Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1600XmlList() {
		return genericXmlList;
	}

	public void setSheet1600XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

// ############################## MDFIR1600 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet1600DAO data) throws ResourceNotFoundException {
		sheet1600Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1600Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1600DAO data) throws ResourceNotFoundException {
		qdfir1600Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1600Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1600DAO> data = null;
		Iterable<sheetQdfir1600DAO> qdfir1600DAO = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1600";
			daoClass = sheet1600DAO.class;
			data = sheet1600Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getLoan_or_facilities_type() == null ? ".00"
						: String.valueOf(e.getLoan_or_facilities_type().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAggregate_amt_principal().toString() == null ? ".00"
						: String.valueOf(e.getAggregate_amt_principal().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAggregate_amt_accrued_interest().toString() == null ? ".00"
						: String.valueOf(e.getAggregate_amt_accrued_interest().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAggregate_amt_total_outstanding().toString() == null ? ".00"
						: String.valueOf(e.getAggregate_amt_total_outstanding().setScale(2, RoundingMode.HALF_EVEN)));

			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());
			setSheet1600XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1600(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1600";
			daoClass = sheetQdfir1600DAO.class;
			qdfir1600DAO = qdfir1600Repo.findAll();

			qdfir1600DAO.forEach((e) -> {
				try {
					// System.out.println("i am here 1600");

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getLoan_or_facilities_type() == null ? ".00"
							: String.valueOf(e.getLoan_or_facilities_type().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAggregate_amt_principal().toString() == null ? ".00"
							: String.valueOf(e.getAggregate_amt_principal().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAggregate_amt_accrued_interest().toString() == null ? ".00"
							: String.valueOf(
									e.getAggregate_amt_accrued_interest().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAggregate_amt_total_outstanding().toString() == null ? ".00"
							: String.valueOf(
									e.getAggregate_amt_total_outstanding().setScale(2, RoundingMode.HALF_EVEN)));

				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());
			setSheet1600XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1600(qdfir1600DAO);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet1600DAO> data = sheet1600Repository.findById(dataId);

			if (data.isPresent()) {
				sheet1600Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir1600DAO> data = qdfir1600Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1600Repo.delete(data.get());
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

	@Override
	public ResponseEntity<?> updateData(int id, sheet1600DAO Data) throws ResourceNotFoundException {
		Optional<sheet1600DAO> DataDb = sheet1600Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1600DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setLoan_or_facilities_type(Data.getLoan_or_facilities_type());
			DataUpdate.setAggregate_amt_principal(Data.getAggregate_amt_principal());
			DataUpdate.setAggregate_amt_accrued_interest(Data.getAggregate_amt_accrued_interest());
			DataUpdate.setAggregate_amt_total_outstanding(Data.getAggregate_amt_total_outstanding());
			sheet1600Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1600Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1600DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1600DAO> DataDb = qdfir1600Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1600DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setLoan_or_facilities_type(Data.getLoan_or_facilities_type());
			DataUpdate.setAggregate_amt_principal(Data.getAggregate_amt_principal());
			DataUpdate.setAggregate_amt_accrued_interest(Data.getAggregate_amt_accrued_interest());
			DataUpdate.setAggregate_amt_total_outstanding(Data.getAggregate_amt_total_outstanding());
			qdfir1600Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1600Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1600DAO data = sheet1600Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1600Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1600DAO data = qdfir1600Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1600Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSheet1301ToDataBase(MultipartFile file, String sheetNo) {
		if (isValidExcelFile(file)) {
			try {
				List<sheet1600DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
				updateOrSaveSheet100Data(excelData);

			} catch (IOException e) {
				throw new IllegalArgumentException("File is not a valid excel file");
			}
		}
	}


	private static List<sheet1600DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
		List<sheet1600DAO> sheet1600_list = new ArrayList<>();
		List<ExcelSheetData1600> excelSheet1301Data = new ArrayList<>();
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
					Iterator<Cell> cellIterator = row.iterator();
					int cellIndex = 0;

					sheet1600DAO sheet1600 = new sheet1600DAO();
					ExcelSheetData1600 excelSheet1600D  = new ExcelSheetData1600();


					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cellIndex) {
							case 0 : excelSheet1600D.setLoan_or_facilities_type(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 1 : excelSheet1600D.setAggregate_amt_accrued_interest(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 2 : excelSheet1600D.setAggregate_amt_principal(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 3 : excelSheet1600D.setAggregate_amt_total_outstanding(BigDecimal.valueOf(cell.getNumericCellValue()));
							default : break;
						}
						cellIndex++;
					}
					excelSheet1301Data.add(excelSheet1600D);
					excelSheet1301Data.forEach(sheet100Data -> {
						sheet1600.setLoan_or_facilities_type(sheet100Data.getLoan_or_facilities_type());
						sheet1600.setAggregate_amt_accrued_interest(sheet100Data.getAggregate_amt_accrued_interest());
						sheet1600.setAggregate_amt_principal(sheet100Data.getAggregate_amt_principal());
						sheet1600.setAggregate_amt_total_outstanding(sheet100Data.getAggregate_amt_total_outstanding());
					});
					sheet1600_list.add(sheet1600);

					//Tested with excelSheet1600D but still under review
				}
			}
			else {
				throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
			}
		}  catch (IOException e) {
			throw new RuntimeException("file too large");
		}
		return sheet1600_list;
	}

	private static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(), contentType);
	}

	private void updateOrSaveSheet100Data(List<sheet1600DAO> excelData) {
		sheet1600DAO newSheetRecord = new sheet1600DAO();
		// Update existing record
		for (sheet1600DAO sheet1600 : excelData) {
			sheet1600DAO existingRecord = sheet1600Repository.findById(sheet1600.getId()).orElse(null);
//			if (existingRecord != null) {
//				existingRecord.setNumber_1(sheet100.getNumber_1());
//				existingRecord.setValue_1(sheet100.getValue_1());
//				existingRecord.setNumber_2(sheet100.getNumber_2());
//				existingRecord.setValue_2(sheet100.getValue_2());
//				sheet100Repo.save(existingRecord);
//				// Save as a new record
//			} else {
//				newSheetRecord.setCode(sheet100.getCode());
//				newSheetRecord.setNumber_1(sheet100.getNumber_1());
//				newSheetRecord.setValue_1(sheet100.getValue_1());
//				newSheetRecord.setNumber_2(sheet100.getNumber_2());
//				newSheetRecord.setValue_2(sheet100.getValue_2());
//				sheet100Repo.save(newSheetRecord);
//			}
		}
	}

}
