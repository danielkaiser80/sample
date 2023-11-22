package com.efass.sheet.mdfir921;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1600.ExcelSheetData1600;
import com.efass.sheet.mdfir1600.sheet1600DAO;
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
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet921_Impl implements sheet921_Service {
    private static final String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Autowired
    Qdfir921Repo qdfir921Repo;

    @Autowired
    sheet921Repository _921Repository;

    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet921XmlList() {
        return genericXmlList;
    }

    public void setSheet921XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR921 CRUD OPERATIONS #################################


    public ResponseEntity<?> createData(sheet921DAO data) throws ResourceNotFoundException {

        _921Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS921Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet921DAO> data = null;
        Iterable<sheetQdfir921DAO> sheetQdfir921DAOS = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR921";
            daoClass = sheet921DAO.class;
            data = _921Repository.findAll();

            data.forEach((e) -> {
                    counter.getAndIncrement();
                    result.add(String.valueOf(counter));
                    result.add(e.getSurname() == null ? "" :e.getSurname());
                    result.add(e.getFirst_name() == null ? "" :e.getFirst_name());
                    result.add(e.getMiddle_name() == null ? "" :e.getMiddle_name());
                    result.add(e.getDesignation() == null ? "" :e.getDesignation());
                    result.add(e.getSex()== null ? "" : e.getSex());
                    result.add(e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getNationality() == null ? "" :e.getNationality());
                    result.add(e.getState_of_origin() == null ? "" :e.getState_of_origin());
                    result.add(e.getPassport_number() == null ? "" :e.getPassport_number());
                    result.add(e.getNational_id_card_number()== null ? "" : e.getNational_id_card_number());
                    result.add(e.getBranch_name() == null ? "" :e.getBranch_name());
                    result.add(e.getBranch_code() == null ? "" :e.getBranch_code());
                    result.add(e.getState_code()== null ? "" :e.getState_code());
                    result.add(e.getDepartment()== null ? "" : e.getDepartment());
                    result.add(e.getDate_of_fraud().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_fraud().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getDate_discovered().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_discovered().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getAmount_involved().toString() == null ? ".00" :String.valueOf(e.getAmount_involved().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getStatus()== null ? "" : e.getStatus());
                    result.add(e.getAmount_recovered().toString() == null ? BigDecimal.ZERO.toString() :e.getAmount_recovered().toString());
                    // result.add(e.getActual_loss().toString() == null ? ".00" :String.valueOf(e.getActual_loss().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getType()== null ? "" : e.getType());
                    result.add(e.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());

                }
            );

            Field[] declaredFields = sheet921DAO.class.getDeclaredFields();
            Field field = null;
      			try {
      			    field = sheet921DAO.class.getField("actual_loss");
      			} catch (NoSuchFieldException e) {
      			    e.printStackTrace();
      			}
      			List<Integer> list = Collections.singletonList(Arrays.asList(declaredFields).indexOf(field));
      			GenericXml.writeIntoXmlFormat(XmlParameters.builder()

      		   .genericXmls(genericXmls)
                  .prefix("")
                  .result(result)
                  .daoClass(daoClass)
                  .reportName(reportName)
                  .isNoneSpecialWithPrefix(true)
                  .isIdPresent(true)
                  .isSkipColumns(true)
                  .skipColumns(list)
                  .build());

              setSheet921XmlList(genericXmls);
              Response res = new Response();
              res.setSheet921(data);
              res.setResponseCode(00);
              return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR921";
            daoClass = sheetQdfir921DAO.class;
            sheetQdfir921DAOS = qdfir921Repo.findAll();

            sheetQdfir921DAOS.forEach((e) ->
            {
            	try {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getSurname() == null ? "" :e.getSurname());
                        result.add(e.getFirst_name() == null ? "" :e.getFirst_name());
                        result.add(e.getMiddle_name() == null ? "" :e.getMiddle_name());
                        result.add(e.getDesignation() == null ? "" :e.getDesignation());
                        result.add(e.getSex()== null ? "" : e.getSex());
                        result.add(e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getNationality() == null ? "" :e.getNationality());
                        result.add(e.getState_of_origin() == null ? "" :e.getState_of_origin());
                        result.add(e.getPassport_number() == null ? "" :e.getPassport_number());
                        result.add(e.getNational_id_card_number()== null ? "" : e.getNational_id_card_number());
                        result.add(e.getBranch_name() == null ? "" :e.getBranch_name());
                        result.add(e.getBranch_code() == null ? "" :e.getBranch_code());
                        result.add(e.getState_code()== null ? "" :e.getState_code());
                        result.add(e.getDepartment()== null ? "" : e.getDepartment());
                        result.add(e.getDate_of_fraud().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_fraud().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getDate_discovered().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_discovered().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getAmount_involved().toString() == null ? ".00" :String.valueOf(e.getAmount_involved().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getStatus()== null ? "" : e.getStatus());
                        result.add(e.getAmount_recovered().toString() == null ? BigDecimal.ZERO.toString() :e.getAmount_recovered().toString());
                       // result.add(e.getActual_loss().toString() == null ? ".00" :String.valueOf(e.getActual_loss().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getType()== null ? "" : e.getType());
                        result.add(e.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
            	}
            	 catch(NullPointerException ex)
  	            {
  	    			System.out.println("NullPointerException thrown!");
  	            }
                });
     };
      Field[] declaredFields = sheetQdfir921DAO.class.getDeclaredFields();
      Field field = null;
			try {
			    field = sheetQdfir921DAO.class.getField("actual_loss");
			} catch (NoSuchFieldException e) {
			    e.printStackTrace();
			}
			List<Integer> list = Collections.singletonList(Arrays.asList(declaredFields).indexOf(field));
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()

		   .genericXmls(genericXmls)
            .prefix("")
            .result(result)
            .daoClass(daoClass)
            .reportName(reportName)
            .isNoneSpecialWithPrefix(true)
            .isIdPresent(true)
            .isSkipColumns(true)
            .skipColumns(list)
            .build());

        setSheet921XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir921(sheetQdfir921DAOS);
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet921DAO data = _921Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS921Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheet921DAO> data = _921Repository.findById(dataId);

        if (data.isPresent()) {
            _921Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    public ResponseEntity<?> updateData(int id , sheet921DAO Data) throws ResourceNotFoundException {

        Optional<sheet921DAO> DataDb = _921Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet921DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setSurname(Data.getSurname());
            DataUpdate.setFirst_name(Data.getFirst_name());
            DataUpdate.setMiddle_name(Data.getMiddle_name());
            DataUpdate.setDesignation(Data.getDesignation());
            DataUpdate.setSex(Data.getSex());
            DataUpdate.setDate_of_birth(Data.getDate_of_birth());
            DataUpdate.setNationality(Data.getNationality());
            DataUpdate.setState_of_origin(Data.getState_of_origin());
            DataUpdate.setPassport_number(Data.getPassport_number());
            DataUpdate.setNational_id_card_number(Data.getNational_id_card_number());
            DataUpdate.setBranch_name(Data.getBranch_name());
            DataUpdate.setBranch_code(Data.getBranch_code());
            DataUpdate.setState_code(Data.getState_code());
            DataUpdate.setDepartment(Data.getDepartment());
            DataUpdate.setDate_of_fraud(Data.getDate_of_fraud());
            DataUpdate.setDate_discovered(Data.getDate_discovered());
            DataUpdate.setAmount_involved(Data.getAmount_involved());
            DataUpdate.setStatus(Data.getStatus());
            DataUpdate.setAmount_recovered(Data.getAmount_recovered());
            DataUpdate.setType(Data.getType());
            DataUpdate.setDate(Data.getDate());
            _921Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS921Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }


  /*  public ResponseEntity<?> updateDataQDFIR921(int id , sheetQdfir921DAO Data) throws ResourceNotFoundException {

        Optional<sheetQdfir921DAO> DataDb = qdfir921Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir921DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setSurname(Data.getSurname());
            DataUpdate.setFirst_name(Data.getFirst_name());
            DataUpdate.setMiddle_name(Data.getMiddle_name());
            DataUpdate.setDesignation(Data.getDesignation());
            DataUpdate.setSex(Data.getSex());
            DataUpdate.setDate_of_birth(Data.getDate_of_birth());
            DataUpdate.setNationality(Data.getNationality());
            DataUpdate.setState_of_origin(Data.getState_of_origin());
            DataUpdate.setPassport_number(Data.getPassport_number());
            DataUpdate.setNational_id_card_number(Data.getNational_id_card_number());
            DataUpdate.setBranch_name(Data.getBranch_name());
            DataUpdate.setBranch_code(Data.getBranch_code());
            DataUpdate.setState_code(Data.getState_code());
            DataUpdate.setDepartment(Data.getDepartment());
            DataUpdate.setDate_of_fraud(Data.getDate_of_fraud());
            DataUpdate.setDate_discovered(Data.getDate_discovered());
            DataUpdate.setAmount_involved(Data.getAmount_involved());
            DataUpdate.setStatus(Data.getStatus());
            DataUpdate.setAmount_recovered(Data.getAmount_recovered());
           // DataUpdate.setActual_loss(Data.getActual_loss());
            DataUpdate.setType(Data.getType());
            DataUpdate.setDate(Data.getDate());
            qdfir921Repo.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.s921QDFIRData(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }*/

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
	public ResponseEntity<?> createDataQ(sheetQdfir921DAO data) throws ResourceNotFoundException {
		qdfir921Repo.save(data);
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Success");
	        res.setResponseCode(00);
	        res.setS921Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir921DAO data = qdfir921Repo.findById(dataId)
	                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS921Data(data);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir921DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir921DAO> DataDb = qdfir921Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir921DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setSurname(Data.getSurname());
            DataUpdate.setFirst_name(Data.getFirst_name());
            DataUpdate.setMiddle_name(Data.getMiddle_name());
            DataUpdate.setDesignation(Data.getDesignation());
            DataUpdate.setSex(Data.getSex());
            DataUpdate.setDate_of_birth(Data.getDate_of_birth());
            DataUpdate.setNationality(Data.getNationality());
            DataUpdate.setState_of_origin(Data.getState_of_origin());
            DataUpdate.setPassport_number(Data.getPassport_number());
            DataUpdate.setNational_id_card_number(Data.getNational_id_card_number());
            DataUpdate.setBranch_name(Data.getBranch_name());
            DataUpdate.setBranch_code(Data.getBranch_code());
            DataUpdate.setState_code(Data.getState_code());
            DataUpdate.setDepartment(Data.getDepartment());
            DataUpdate.setDate_of_fraud(Data.getDate_of_fraud());
            DataUpdate.setDate_discovered(Data.getDate_discovered());
            DataUpdate.setAmount_involved(Data.getAmount_involved());
            DataUpdate.setStatus(Data.getStatus());
            DataUpdate.setAmount_recovered(Data.getAmount_recovered());
            DataUpdate.setType(Data.getType());
            DataUpdate.setDate(Data.getDate());
            qdfir921Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS921Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
	}

    @Override
    public void saveSheet921ToDataBase(MultipartFile file, String sheetNo) {
        if (isValidExcelFile(file)) {
            try {
                List<sheet921DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
                _921Repository.saveAll(excelData);
            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }

    private static List<sheet921DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
        List<sheet921DAO> sheet921_list = new ArrayList<>();
        List<ExcelSheetData921> excelSheet921Data = new ArrayList<>();
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

                    sheet921DAO sheet921 = new sheet921DAO();
                    ExcelSheetData921 excelSheetData921  = new ExcelSheetData921();

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cellIndex) {
                            case 0 : excelSheetData921.setSurname(cell.getStringCellValue());
                            case 1 : excelSheetData921.setFirst_name(cell.getStringCellValue());
                            case 2 : excelSheetData921.setMiddle_name(cell.getStringCellValue());
                            case 3 : excelSheetData921.setDesignation(cell.getStringCellValue());
                            case 4 : excelSheetData921.setSex(cell.getStringCellValue());
                            case 5 : excelSheetData921.setDate_of_birth(LocalDate.parse(cell.getStringCellValue()));
                            case 6 : excelSheetData921.setNationality(cell.getStringCellValue());
                            case 7 : excelSheetData921.setState_of_origin(cell.getStringCellValue());
                            case 8 : excelSheetData921.setPassport_number(cell.getStringCellValue());
                            case 9 : excelSheetData921.setNational_id_card_number(cell.getStringCellValue());
                            case 10 : excelSheetData921.setBranch_name(cell.getStringCellValue());
                            case 11 : excelSheetData921.setBranch_code(cell.getStringCellValue());
                            case 12 : excelSheetData921.setState_code(cell.getStringCellValue());
                            case 13 : excelSheetData921.setDepartment(cell.getStringCellValue());
                            case 14 : excelSheetData921.setDate_of_fraud(LocalDate.parse(cell.getStringCellValue()));
                            case 15 : excelSheetData921.setDate_discovered(LocalDate.parse(cell.getStringCellValue()));
                            case 16 : excelSheetData921.setAmount_involved(BigDecimal.valueOf(cell.getNumericCellValue()));
                            case 17 : excelSheetData921.setStatus(cell.getStringCellValue());
                            case 18 : excelSheetData921.setAmount_recovered(BigDecimal.valueOf(cell.getNumericCellValue()));
                            case 19 : excelSheetData921.setActual_loss(BigDecimal.valueOf(cell.getNumericCellValue()));
                            case 20 : excelSheetData921.setType(cell.getStringCellValue());
                            case 21 : excelSheetData921.setDate(LocalDate.parse(cell.getStringCellValue())); //optional
                            default : break;
                        }
                        cellIndex++;
                    }
                    excelSheet921Data.add(excelSheetData921);
                    excelSheet921Data.forEach(sheet921D -> {
                        sheet921.setSurname(sheet921D.getSurname());
                        sheet921.setFirst_name(sheet921D.getFirst_name());
                        sheet921.setMiddle_name(sheet921D.getMiddle_name());
                        sheet921.setDesignation(sheet921D.getDesignation());
                        sheet921.setSex(sheet921D.getSex());
                        sheet921.setDate_of_birth(sheet921D.getDate_of_birth());
                        sheet921.setNationality(sheet921D.getNationality());
                        sheet921.setState_of_origin(sheet921D.getState_of_origin());
                        sheet921.setPassport_number(sheet921D.getPassport_number());
                        sheet921.setNational_id_card_number(sheet921D.getNational_id_card_number());
                        sheet921.setBranch_name(sheet921D.getBranch_name());
                        sheet921.setBranch_code(sheet921D.getBranch_code());
                        sheet921.setState_code(sheet921D.getState_code());
                        sheet921.setDepartment(sheet921D.getDepartment());
                        sheet921.setDate_of_fraud(sheet921D.getDate_of_fraud());
                        sheet921.setDate_discovered(sheet921D.getDate_discovered());
                        sheet921.setAmount_involved(sheet921D.getAmount_involved());
                        sheet921.setStatus(sheet921D.getStatus());
                        sheet921.setAmount_recovered(sheet921D.getAmount_recovered());
                        sheet921.setActual_loss(sheet921D.getActual_loss());
                        sheet921.setType(sheet921D.getType());
                        sheet921.setDate(sheet921D.getDate()); //optional? will the date be pass as part of the Excel data
                    });
                    sheet921_list.add(sheet921);

                    //excelSheet921D not tested yet
                }
            }
            else {
                throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
            }
        }  catch (IOException e) {
            throw new RuntimeException("file too large");
        }
        return sheet921_list;
    }

    private static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), contentType);
    }
}

