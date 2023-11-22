package com.efass.sheet.mdfir1300;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.table.TabController;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet1300_Impl implements sheet1300_Service {

	@Autowired
	sheet1300Repository sheet1300Repository;

	@Autowired
	Qdfir1300Repo qdfir1300Repo;

	List<GenericXml> genericXmlList;

	private static final String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	public List<GenericXml> getSheet1300XmlList() {
		return genericXmlList;
	}

	public void setSheet1300XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR1300 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet1300DAO data) throws ResourceNotFoundException {
		sheet1300Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1300Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1300DAO data) throws ResourceNotFoundException {
		qdfir1300Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1300Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1300DAO> data = null;
		Iterable<sheetQdfir1300DAO> qdfir1300DAOS = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			
			reportName = "MDFIR1300";
			daoClass = sheet1300DAO.class;
			data = sheet1300Repository.findAll();
			data.forEach((e) -> {
				
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
					result.add(e.getCustomer_name() == null ? "" : e.getCustomer_name());
					result.add(e.getTotal_credit() == null ? ".00"
							: String.valueOf(e.getTotal_credit().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getPrincipal_payment_due_and_unpaid() == null ? ".00"
							: String.valueOf(
									e.getPrincipal_payment_due_and_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAccrued_interest_unpaid() == null ? ".00"
							: String.valueOf(e.getAccrued_interest_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal_outstanding_credits() == null ? ".00"
							: String.valueOf(e.getTotal_outstanding_credits().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getWatch_list() == null ? ".00"
							: String.valueOf(e.getWatch_list().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getSubstandard() == null ? ".00"
							: String.valueOf(e.getSubstandard().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getDoubtful() == null ? ".00"
							: String.valueOf(e.getDoubtful().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getVery_doubtful() == null ? ".00"
							: String.valueOf(e.getVery_doubtful().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getLost() == null ? ".00"
							: String.valueOf(e.getLost().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getDfi_provision() == null ? ".00"
							: String.valueOf(e.getDfi_provision()));
					result.add(e.getRemarks() == null ? ".00"
							: String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).isIdPresent(true).reportName(reportName).build());

			setSheet1300XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1300(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1300";
			daoClass = sheetQdfir1300DAO.class;
			qdfir1300DAOS = qdfir1300Repo.findAll();

			qdfir1300DAOS.forEach((e) -> {
				try {
					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
					result.add(e.getCustomer_name() == null ? "" : e.getCustomer_name());
					result.add(e.getTotal_credit() == null ? ".00"
							: String.valueOf(e.getTotal_credit().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getPrincipal_payment_due_and_unpaid() == null ? ".00"
							: String.valueOf(
									e.getPrincipal_payment_due_and_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAccrued_interest_unpaid() == null ? ".00"
							: String.valueOf(e.getAccrued_interest_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal_outstanding_credits() == null ? ".00"
							: String.valueOf(e.getTotal_outstanding_credits().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getWatch_list() == null ? ".00"
							: String.valueOf(e.getWatch_list().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getSubstandard() == null ? ".00"
							: String.valueOf(e.getSubstandard().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getDoubtful() == null ? ".00"
							: String.valueOf(e.getDoubtful().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getVery_doubtful() == null ? ".00"
							: String.valueOf(e.getVery_doubtful().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getLost() == null ? ".00"
							: String.valueOf(e.getLost().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getDfi_provision() == null ? ".00"
							: String.valueOf(e.getDfi_provision().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? ".00"
							: String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));

				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).isIdPresent(true).reportName(reportName).build());

			setSheet1300XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1300(qdfir1300DAOS);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet1300DAO> data = sheet1300Repository.findById(dataId);

			if (data.isPresent()) {
				sheet1300Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir1300DAO> data = qdfir1300Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1300Repo.delete(data.get());
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
	public ResponseEntity<?> updateData(int id, sheet1300DAO Data) throws ResourceNotFoundException {
		Optional<sheet1300DAO> DataDb = sheet1300Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1300DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setTotal_credit(Data.getTotal_credit());
			DataUpdate.setPrincipal_payment_due_and_unpaid(Data.getPrincipal_payment_due_and_unpaid());
			DataUpdate.setAccrued_interest_unpaid(Data.getAccrued_interest_unpaid());
			DataUpdate.setTotal_outstanding_credits(Data.getTotal_outstanding_credits());
			DataUpdate.setWatch_list(Data.getWatch_list());
			DataUpdate.setSubstandard(Data.getSubstandard());
			DataUpdate.setDoubtful(Data.getDoubtful());
			DataUpdate.setVery_doubtful(Data.getVery_doubtful());
			DataUpdate.setLost(Data.getLost());
			DataUpdate.setDfi_provision(Data.getDfi_provision());
			DataUpdate.setRemarks(Data.getRemarks());
			sheet1300Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1300Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1300DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1300DAO> DataDb = qdfir1300Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1300DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setTotal_credit(Data.getTotal_credit());
			DataUpdate.setPrincipal_payment_due_and_unpaid(Data.getPrincipal_payment_due_and_unpaid());
			DataUpdate.setAccrued_interest_unpaid(Data.getAccrued_interest_unpaid());
			DataUpdate.setTotal_outstanding_credits(Data.getTotal_outstanding_credits());
			DataUpdate.setWatch_list(Data.getWatch_list());
			DataUpdate.setSubstandard(Data.getSubstandard());
			DataUpdate.setDoubtful(Data.getDoubtful());
			DataUpdate.setVery_doubtful(Data.getVery_doubtful());
			DataUpdate.setLost(Data.getLost());
			DataUpdate.setDfi_provision(Data.getDfi_provision());
			DataUpdate.setRemarks(Data.getRemarks());

			qdfir1300Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1300Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1300DAO data = sheet1300Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1300Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1300DAO data = qdfir1300Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1300Data(data);
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
	public void saveSheet1300ToDataBase(MultipartFile file, String sheet1300) {
		if (Objects.equals(file.getContentType(), contentType)) {
			try {
				sheet1300Repository.deleteAll();
				List<sheet1300DAO> excelData = excelToEntity(file.getInputStream(), sheet1300);
				sheet1300Repository.saveAll(excelData);
			} catch (IOException e) {
				throw new IllegalArgumentException("File is not a valid excel file");
			}
		}
	}
	public static List<sheet1300DAO> excelToEntity(InputStream is, String sheetName) {
		try {
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rows = sheet.iterator();
			List<sheet1300DAO> sheet1300DAOS = new ArrayList<>();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				sheet1300DAO sheet1300DAO = new sheet1300DAO();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch (cellIdx) {
						case 1:
							sheet1300DAO.setCustomer_code(String.valueOf(currentCell.getNumericCellValue()));
							break;

						case 2:
							sheet1300DAO.setCustomer_name(currentCell.getStringCellValue());
							break;

						case 3:
							sheet1300DAO.setTotal_credit(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 4:
							sheet1300DAO.setPrincipal_payment_due_and_unpaid(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 5:
							sheet1300DAO.setAccrued_interest_unpaid(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 6:
							sheet1300DAO.setTotal_outstanding_credits(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 7:
							sheet1300DAO.setWatch_list(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 8:
							sheet1300DAO.setSubstandard(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 9:
							sheet1300DAO.setDoubtful(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 10:
							sheet1300DAO.setVery_doubtful(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 11:
							sheet1300DAO.setLost(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						case 12:
							sheet1300DAO.setDfi_provision(String.valueOf(currentCell.getNumericCellValue()));
							break;

						case 13:
							sheet1300DAO.setRemarks(BigDecimal.valueOf(currentCell.getNumericCellValue()));
							break;

						default:
							break;
					}
					cellIdx++;
				}
				sheet1300DAOS.add(sheet1300DAO);
			}
			workbook.close();
			return sheet1300DAOS;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}


}
