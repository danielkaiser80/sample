package com.efass.sheet.mdfir101;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.sheet.mdfir100.ExcelSheet100Data;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir100.sheetQdfirDAO;
import com.efass.sheet.mdfir161.sheet161DAO;
import com.efass.sheet.mdfir321.sheet321DAO;
import com.efass.sheet.table.TabController;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import org.springframework.web.multipart.MultipartFile;


@Service
public class sheet101_Impl implements sheet101_Service{

	@Autowired
	sheet101Repository _101Repository;

	@Autowired
	Qdfir101Repo qdfir101Repo;

    @Autowired
    TabController tabController;
	List<GenericXml> genericXmlList;

	private static final String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	public List<GenericXml> getSheet101XmlList() {
		return genericXmlList;
	}

	public void setSheet101XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}


	public ResponseEntity<?> createData(sheet101DAO data) throws ResourceNotFoundException {

		int length = _101Repository.getid();
 		length = length + 1;
 		data.setId(length);

 		_101Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS101Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir101DAO data) throws ResourceNotFoundException {
		int length = qdfir101Repo.getid();
 		length = length + 1;
 		data.setId(length);

 		qdfir101Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS101Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet101DAO> data = null;
		Iterable<sheetQdfir101DAO> qdfir101Data = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR101";
            daoClass = sheet101DAO.class;
            data = _101Repository.findAll();

    		data.forEach((e) -> {
    			counter.getAndIncrement();
    			result.add(String.valueOf(counter));
    			result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
    			result.add(e.getCustomer_name() == null ? "" :e.getCustomer_name());
    			result.add(e.getPrincipal_granted().toString()== null ? String.valueOf(.00) : String.valueOf(e.getPrincipal_granted().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getPurpose() == null ?String.valueOf(.00) :e.getPurpose().toString());
                result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                result.add(e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
    			result.add(e.getPrincipal_outstanding().toString()== null ? String.valueOf(.00) : String.valueOf(e.getPrincipal_outstanding().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getInterest_rate().toString() == null ? String.valueOf(.00) : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getUpfront_interest().toString() == null ? String.valueOf(.00) : String.valueOf(e.getUpfront_interest().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getInterest_payable().toString()== null ? String.valueOf(.00) : String.valueOf(e.getInterest_payable().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getUnpaid_principal_interest().toString() == null ? String.valueOf(.00) : String.valueOf(e.getUnpaid_principal_interest().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getTimes_rolled_over()== null ? String.valueOf(.00) :e.getTimes_rolled_over().toString());
    			result.add(e.getCol_value()== null ? String.valueOf(.00) :e.getCol_value().toString());

    		});

    		GenericXml.writeIntoXmlFormat(XmlParameters.builder()
    				.genericXmls(genericXmls)
    				.prefix("")
    				.result(result)
                .daoClass(daoClass)
    				.reportName(reportName)
    				.isNoneSpecialWithPrefix(true)
    				.isIdPresent(true)
    				.build());
    		setSheet101XmlList(genericXmls);

    		Response res = new Response();
    		res.setSheet101(data);
    		res.setResponseMessage("Success");
    		res.setResponseCode(00);
    		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0)
        {

            reportName = "QDFIR101";
            daoClass = sheetQdfir101DAO.class;
            qdfir101Data = qdfir101Repo.findAll();

            qdfir101Data.forEach((e) ->
            {
            	try {
        			//System.out.println("i am here");

    			counter.getAndIncrement();
    			result.add(String.valueOf(counter));
    			result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
    			result.add(e.getCustomer_name() == null ? "" :e.getCustomer_name());
    			result.add(e.getPrincipal_granted().toString() == null ? String.valueOf(.00) : String.valueOf(e.getPrincipal_granted().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getPurpose() == null ?String.valueOf(.00) :e.getPurpose().toString());
    			result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
    			result.add(e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                result.add(e.getPrincipal_outstanding().toString()== null ? String.valueOf(.00) : String.valueOf(e.getPrincipal_outstanding().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getInterest_rate().toString() == null ? String.valueOf(.00) : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getUpfront_interest().toString() == null ? String.valueOf(.00) : String.valueOf(e.getUpfront_interest().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getInterest_payable().toString()== null ? String.valueOf(.00) : String.valueOf(e.getInterest_payable().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getUnpaid_principal_interest().toString() == null ? String.valueOf(.00) : String.valueOf(e.getUnpaid_principal_interest().setScale(2, RoundingMode.HALF_EVEN)));
    			result.add(e.getTimes_rolled_over()== null ? String.valueOf(.00) :e.getTimes_rolled_over().toString());
    			result.add(e.getCol_value()== null ? String.valueOf(.00) :e.getCol_value().toString());
            }
            catch(NullPointerException ex)
            {
    			System.out.println("NullPointerException thrown!");
    		}

        	});

            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
    				.genericXmls(genericXmls)
    				.prefix("")
    				.result(result)
                .daoClass(daoClass)
    				.reportName(reportName)
    				.isNoneSpecialWithPrefix(true)
    				.isIdPresent(true)
    				.build());
    		setSheet101XmlList(genericXmls);

    		ResponseQuarterly res = new ResponseQuarterly();
    		res.setQdfir101(qdfir101Data);
    		res.setResponseMessage("Success");
    		res.setResponseCode(00);
    		return new ResponseEntity<>(res, HttpStatus.OK);
        }
		return null;

	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet101DAO data = _101Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS101Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir101DAO data = qdfir101Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS101Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet101DAO> data = _101Repository.findById(dataId);

		if (data.isPresent()) {
			_101Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		Optional<sheetQdfir101DAO> data = qdfir101Repo.findById(dataId);

		if (data.isPresent()) {
			qdfir101Repo.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> updateData(int id, sheet101DAO Data) throws ResourceNotFoundException {

		Optional<sheet101DAO> DataDb = _101Repository.findById(id);


		if (DataDb.isPresent()) {
			sheet101DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setPrincipal_granted(Data.getPrincipal_granted());
			DataUpdate.setPurpose(Data.getPurpose());
			DataUpdate.setDate_granted(Data.getDate_granted());
			DataUpdate.setDue_date(Data.getDue_date());
			DataUpdate.setPrincipal_outstanding(Data.getPrincipal_outstanding());
			DataUpdate.setInterest_rate(Data.getInterest_rate());
			DataUpdate.setUpfront_interest(Data.getUpfront_interest());
			DataUpdate.setInterest_payable(Data.getInterest_payable());
			DataUpdate.setUnpaid_principal_interest(Data.getUnpaid_principal_interest());
			DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
            DataUpdate.setCol_value(Data.getCol_value());
			_101Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS101Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir101DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir101DAO> DataDb = qdfir101Repo.findById(id);


		if (DataDb.isPresent()) {
			sheetQdfir101DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			//DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setPrincipal_granted(Data.getPrincipal_granted());
			DataUpdate.setPurpose(Data.getPurpose());
			DataUpdate.setDate_granted(Data.getDate_granted());
			DataUpdate.setDue_date(Data.getDue_date());
			DataUpdate.setPrincipal_outstanding(Data.getPrincipal_outstanding());
			DataUpdate.setInterest_rate(Data.getInterest_rate());
			DataUpdate.setUpfront_interest(Data.getUpfront_interest());
			DataUpdate.setInterest_payable(Data.getInterest_payable());
			DataUpdate.setUnpaid_principal_interest(Data.getUnpaid_principal_interest());
			DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
            DataUpdate.setCol_value(Data.getCol_value());

            qdfir101Repo.save(DataUpdate);

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS101Data(DataUpdate);
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
	public void saveSheet101ToDataBase(MultipartFile file, String sheet101) {
		if (Objects.equals(file.getContentType(), contentType)) {
			try {
				_101Repository.deleteAll();
				List<sheet101DAO> excelData = excelToEntity(file.getInputStream(), sheet101);
				_101Repository.saveAll(excelData);
			} catch (IOException e) {
				throw new IllegalArgumentException("File is not a valid excel file");
			}
		}
	}

	public static List<sheet101DAO> excelToEntity(InputStream is,String sheetName) {
		List<sheet101DAO> sheet101DAOS = new ArrayList<>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet(sheetName.trim());
			if (sheet != null) {
				int rowIndex = 0;
				for (Row row : sheet) {
					if (rowIndex == 0) {
						rowIndex++;
						continue;
					}
					Iterator<Cell> cellIterator = row.iterator();
					int cellIndex = 0;

					sheet101DAO sheet101 = new sheet101DAO();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cellIndex) {
//							case 0 -> sheet101.setId((int) cell.getNumericCellValue());
							case 1 :
								sheet101.setCustomer_code(cell.getStringCellValue());
								break;
							case 2 :
								sheet101.setCustomer_name(cell.getStringCellValue());
								break;
							case 3 :
								sheet101.setPrincipal_granted(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							case 4 :
								sheet101.setPurpose(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							case 5 :
								sheet101.setDate_granted(LocalDateTime.from(cell.getLocalDateTimeCellValue()).toLocalDate());
								break;
							case 6 :
								sheet101.setDue_date(LocalDateTime.from(cell.getLocalDateTimeCellValue()).toLocalDate());
								break;
							case 7 :
								sheet101.setPrincipal_outstanding(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							case 8 :
								sheet101.setInterest_rate(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							case 9 :
								sheet101.setUpfront_interest(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							case 10 :
								sheet101.setInterest_payable(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							case 11 :
								sheet101.setUnpaid_principal_interest(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							case 12 :
								sheet101.setTimes_rolled_over(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							case 13 :
								sheet101.setCol_value(BigDecimal.valueOf(cell.getNumericCellValue()));
								break;
							default : break;
						}
						cellIndex++;
					}
					sheet101DAOS.add(sheet101);
				}
				workbook.close();
			}
			else {
				throw new IllegalStateException("Sheet is null. Verify the sheet name in the Excel file.");
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException("file too large");
		}
		return sheet101DAOS;
	}



	private static List<sheet101DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
		List<sheet101DAO> sheet101s = new ArrayList<>();
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

					sheet101DAO sheet101 = new sheet101DAO();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cellIndex) {
							case 0 : sheet101.setCustomer_code(cell.getStringCellValue());
							case 1 : sheet101.setCustomer_name(cell.getStringCellValue());
							case 2 : sheet101.setUnpaid_principal_interest(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 3 : sheet101.setUpfront_interest(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 4 : sheet101.setPrincipal_granted(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 5 : sheet101.setInterest_payable(BigDecimal.valueOf(cell.getNumericCellValue()));
							default: break;
						}
						cellIndex++;
					}
					sheet101s.add(sheet101);
				}
			}
			else {
				throw new IllegalStateException("Sheet is null. Verify the sheet name in the Excel file.");
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException("file too large");
		}
		return sheet101s;
	}
}
