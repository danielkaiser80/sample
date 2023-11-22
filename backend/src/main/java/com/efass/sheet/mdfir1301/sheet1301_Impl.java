package com.efass.sheet.mdfir1301;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir100.ExcelSheet100Data;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import com.efass.sheet.mdfir1000.sheetQdfir1000DAO;
import com.efass.sheet.mdfir1300.sheet1300DAO;
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
public class sheet1301_Impl implements sheet1301_Service {

	private static final String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	@Autowired
	sheet1301Repository sheet1301Repository;

	@Autowired
	Qdfir1301Repo qdfir1301Repo;

	List<GenericXml> genericXmlList;


	public List<GenericXml> getSheet1301XmlList() {
		return genericXmlList;
	}

	public void setSheet1301XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR1301 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet1301DAO data) throws ResourceNotFoundException {
		sheet1301Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1301Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1301DAO data) throws ResourceNotFoundException {
		qdfir1301Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1301Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1301DAO> data = null;
		Iterable<sheetQdfir1301DAO> qdfir1301DAOS = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1301";
			daoClass = sheet1301DAO.class;
			data = sheet1301Repository.findAll();
			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
				result.add(e.getCustomer_name() == null ? "" : e.getCustomer_name());
				result.add(e.getTotal_credit().toString() == null ? ".00"
						: String.valueOf(e.getTotal_credit().setScale(2, RoundingMode.HALF_EVEN)));

				result.add(e.getPrincipal_payment_due_and_unpaid().toString() == null ? ".00"
						: String.valueOf(e.getPrincipal_payment_due_and_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAccrued_interest_unpaid().toString() == null ? ".00"
						: String.valueOf(e.getAccrued_interest_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getTotal_impaired_credits().toString() == null ? ".00"
						: String.valueOf(e.getTotal_impaired_credits().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getImpairment().toString() == null ? ".00"
						: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
				result.add(e.getRemarks()  == null ? "" : e.getRemarks());
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());

			setSheet1301XmlList(genericXmls);

			Response res = new Response();
			res.setSheet1301(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1301";
			daoClass = sheetQdfir1301DAO.class;
			qdfir1301DAOS = qdfir1301Repo.findAll();

			qdfir1301DAOS.forEach((e) -> {
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
					result.add(e.getCustomer_name() == null ? "" : e.getCustomer_name());
					result.add(e.getTotal_credit().toString() == null ? ".00"
							: String.valueOf(e.getTotal_credit().setScale(2, RoundingMode.HALF_EVEN)));

					result.add(e.getPrincipal_payment_due_and_unpaid().toString() == null ? ".00"
							: String.valueOf(
									e.getPrincipal_payment_due_and_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAccrued_interest_unpaid().toString() == null ? ".00"
							: String.valueOf(e.getAccrued_interest_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal_impaired_credits().toString() == null ? ".00"
							: String.valueOf(e.getTotal_impaired_credits().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getImpairment().toString() == null ? ".00"
							: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? "" : e.getRemarks());
					// result.add(e.getRemarks() == null ? ".00"
					// :String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));

				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());

			setSheet1301XmlList(genericXmls);

			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1301(qdfir1301DAOS);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet1301DAO> data = sheet1301Repository.findById(dataId);

			if (data.isPresent()) {
				sheet1301Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir1301DAO> data = qdfir1301Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1301Repo.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> updateData(int id, sheet1301DAO Data) throws ResourceNotFoundException {
		Optional<sheet1301DAO> DataDb = sheet1301Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1301DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setTotal_credit(Data.getTotal_credit());
			DataUpdate.setPrincipal_payment_due_and_unpaid(Data.getPrincipal_payment_due_and_unpaid());
			DataUpdate.setAccrued_interest_unpaid(Data.getAccrued_interest_unpaid());
			DataUpdate.setTotal_impaired_credits(Data.getTotal_impaired_credits());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setRemarks(Data.getRemarks());
			sheet1301Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1301Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1301DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1301DAO> DataDb = qdfir1301Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1301DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setTotal_credit(Data.getTotal_credit());
			DataUpdate.setPrincipal_payment_due_and_unpaid(Data.getPrincipal_payment_due_and_unpaid());
			DataUpdate.setAccrued_interest_unpaid(Data.getAccrued_interest_unpaid());
			DataUpdate.setTotal_impaired_credits(Data.getTotal_impaired_credits());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setRemarks(Data.getRemarks());

			qdfir1301Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1301Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1301DAO data = sheet1301Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1301Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheetQdfir1301DAO data = qdfir1301Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1301Data(data);
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
				List<sheet1301DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
			sheet1301Repository.saveAll(excelData);

			} catch (IOException e) {
				throw new IllegalArgumentException("File is not a valid excel file");
			}
		}
	}
	private static List<sheet1301DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
		List<sheet1301DAO> sheet1301_list = new ArrayList<>();
		List<ExcelSheetData1301> excelSheet1301Data = new ArrayList<>();
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
					Iterator<Cell> cellIterator = row.iterator();
					int cellIndex = 0;

					sheet1301DAO sheet1301 = new sheet1301DAO();
					ExcelSheetData1301 excelSheet1301D  = new ExcelSheetData1301();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cellIndex) {
							case 0 : excelSheet1301D.setSerial_no(String.valueOf(cell.getNumericCellValue()));
							case 1 : excelSheet1301D.setCustomer_code(String.valueOf(cell.getNumericCellValue()));
							case 2 : excelSheet1301D.setCustomer_name(cell.getStringCellValue());
							case 3 : excelSheet1301D.setTotal_credit(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 4 : excelSheet1301D.setPrincipal_payment_due_and_unpaid(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 5 : excelSheet1301D.setAccrued_interest_unpaid(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 6 : excelSheet1301D.setTotal_impaired_credits(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 7 : excelSheet1301D.setImpairment(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 8 : excelSheet1301D.setRemarks(String.valueOf(cell.getNumericCellValue()));
							default : break;
						}
						cellIndex++;
					}
					excelSheet1301Data.add(excelSheet1301D);
					excelSheet1301Data.forEach(sheet100Data -> {
						sheet1301.setCustomer_name(excelSheet1301D.getCustomer_name());
						sheet1301.setCustomer_code(excelSheet1301D.getCustomer_code());
						sheet1301.setTotal_credit(excelSheet1301D.getTotal_credit());
						sheet1301.setPrincipal_payment_due_and_unpaid(excelSheet1301D.getPrincipal_payment_due_and_unpaid());
						sheet1301.setAccrued_interest_unpaid(excelSheet1301D.getAccrued_interest_unpaid());
						sheet1301.setTotal_impaired_credits(excelSheet1301D.getTotal_impaired_credits());
						sheet1301.setImpairment(excelSheet1301D.getImpairment());
						sheet1301.setRemarks(excelSheet1301D.getRemarks());
					});
					sheet1301_list.add(sheet1301);
				}
			}
			else {
				throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
				}
		}  catch (IOException e) {
			throw new RuntimeException("file too large");
		}
		return sheet1301_list;
	}

	private static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(), contentType);
	}
}