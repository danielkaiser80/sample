package com.efass.sheet.mdfir600;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.RecordNotFoundException;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir101.sheet101DAO;
import com.efass.sheet.mdfir250.sheet250DAO;
import com.efass.sheet.mdfir300.sheet300DAO;
import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
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


@Service
public class sheet600_Impl implements sheet600_Service {

    @Autowired
    Qdfir600Repo qdfir600Repo;

    @Autowired
    sheet600Repository sheet600Repo;
    List<GenericXml> genericXmlList;
    private static final String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public List<GenericXml> getSheet600XmlList() {
        return genericXmlList;
    }

    public void setSheet600XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet600DAO> data = null;
        Iterable<sheetQdfir600DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR600";
            daoClass = sheet600DAO.class;
            data = sheet600Repo.findAll();

            data.forEach((e) -> {
                codes.add(e.getCode()== null ? "" :e.getCode());
                result.add(e.getTerm_loan() == null ? ".00" :String.valueOf(e.getTerm_loan().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOver_draft()== null ? ".00" :String.valueOf(e.getOver_draft().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOthers_1() == null? "" : e.getOthers_1());
                result.add(e.getAdvances_under_lease()== null ? ".00" :String.valueOf(e.getAdvances_under_lease().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getBankers_acceptances() == null? "" : e.getBankers_acceptances());
                result.add(e.getCommercial_papers() == null? "" : e.getCommercial_papers());
                result.add(e.getBills_discounted() == null ? ".00" :String.valueOf(e.getBills_discounted().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOthers_2() == null? "" : e.getOthers_2());
            });

            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .isSpecialWithPrefix(true)
                    .prefix(".T0")
                     .isSkipRows(false)
                    .daoClass(daoClass)
                    .reportName(reportName)
                    .result(result)
                    .genericXmls(genericXmls)
                    .codes(codes)
                    .build());
            setSheet600XmlList(genericXmls);
        Response resp = new Response();
        resp.setSheet600(data);
        resp.setResponseMessage("Success");
        resp.setResponseCode(00);
        return  new ResponseEntity<>(resp, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR600";
            daoClass = sheetQdfir600DAO.class;
            qdfirData = qdfir600Repo.findAll();

            qdfirData.forEach((e) ->
            {
            	try {
        			//System.out.println("i am here 600");
                codes.add(e.getCode()== null ? "" :e.getCode());
                result.add(e.getTerm_loan() == null ? ".00" :String.valueOf(e.getTerm_loan().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOver_draft()== null ? ".00" :String.valueOf(e.getOver_draft().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOthers_1() == null? "" : e.getOthers_1());
                result.add(e.getAdvances_under_lease()== null ? ".00" :String.valueOf(e.getAdvances_under_lease().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getBankers_acceptances() == null? "" : e.getBankers_acceptances());
                result.add(e.getCommercial_papers() == null? "" : e.getCommercial_papers());
                result.add(e.getBills_discounted() == null ? ".00" :String.valueOf(e.getBills_discounted().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOthers_2() == null? "" : e.getOthers_2());
            	}
   			 catch(NullPointerException ex)
   	            {
   	    			System.out.println("NullPointerException thrown!");
   	            }
            	});
        }
        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .isSpecialWithPrefix(true)
                .prefix(".T0")
                 .isSkipRows(false)
                .daoClass(daoClass)
                .reportName(reportName)
                .result(result)
                .genericXmls(genericXmls)
                .codes(codes)
                .build());
        setSheet600XmlList(genericXmls);
    ResponseQuarterly resp = new ResponseQuarterly();
    resp.setQdfir600(qdfirData);
    resp.setResponseMessage("Success");
    resp.setResponseCode(00);
    return  new ResponseEntity<>(resp, HttpStatus.OK);

    }

    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException{
        sheet600DAO data = sheet600Repo.findById(dataId)
                .orElseThrow(() -> new RecordNotFoundException( "Record not found for this id :: " + dataId));
        Response resp = new Response();
        resp.setResponseMessage("Record Found");
        resp.setResponseCode(00);
        resp.setS600Data(data);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    public ResponseEntity<?> updateData(int id, sheet600DAO Data) throws ResourceNotFoundException{


        Optional<sheet600DAO> DataDb = sheet600Repo.findByCode(Data.getCode());

        if (DataDb.isPresent()){
            sheet600DAO DataUpdate = DataDb.get();
            DataUpdate.setDescription(Data.getDescription());
            DataUpdate.setOver_draft(Data.getTerm_loan());
            DataUpdate.setOver_draft(Data.getOver_draft());
            DataUpdate.setOthers_1(Data.getOthers_1());
            DataUpdate.setAdvances_under_lease(Data.getAdvances_under_lease());
            DataUpdate.setBankers_acceptances(Data.getBankers_acceptances());
            DataUpdate.setCommercial_papers(Data.getCommercial_papers());
            DataUpdate.setBills_discounted(Data.getBills_discounted());
            DataUpdate.setOthers_2(Data.getOthers_2());

            sheet600Repo.save(DataUpdate);
            Response resp = new Response();
            resp.setResponseMessage("Record Updated");
            resp.setResponseCode(00);
            resp.setS600Data(DataUpdate);

            return  new ResponseEntity<>(resp, HttpStatus.OK);
        }
        else {
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
    public void saveSheet600ToDataBase(MultipartFile file, String sheet600) {
        if (Objects.equals(file.getContentType(), contentType)) {
            try {
                List<sheet600DAO> excelData = excelToEntity(file.getInputStream(), sheet600);
                updateSheet600Data(excelData);
            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }

    private void updateSheet600Data(List<sheet600DAO> excelData) {
        for (sheet600DAO _sheet600DAO : excelData) {
            Optional<sheet600DAO> existingRecord = sheet600Repo.findByCode(_sheet600DAO.getCode());
            sheet600DAO record;
            if(existingRecord.isPresent()){
                record = existingRecord.get();
                record.setDescription(_sheet600DAO.getDescription());
                record.setTerm_loan(_sheet600DAO.getTerm_loan());
                record.setOver_draft(_sheet600DAO.getOver_draft());
                record.setOthers_1(_sheet600DAO.getOthers_1());
                record.setAdvances_under_lease(_sheet600DAO.getAdvances_under_lease());
                record.setBankers_acceptances(_sheet600DAO.getBankers_acceptances());
                record.setCommercial_papers(_sheet600DAO.getCommercial_papers());
                record.setBills_discounted(_sheet600DAO.getBills_discounted());
                record.setOthers_2(_sheet600DAO.getOthers_2());
                sheet600Repo.save(record);
            }
        }
    }

    public static List<sheet600DAO> excelToEntity(InputStream is, String sheetName) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rows = sheet.iterator();
            List<sheet600DAO> sheet600DAOS = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                if (rowNumber == 1) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                sheet600DAO sheet600DAO = new sheet600DAO();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    if (cellIdx == 0 && (currentCell.getNumericCellValue() == 40100
                    || currentCell.getNumericCellValue() == 40200 || currentCell.getNumericCellValue() == 40300
                    || currentCell.getNumericCellValue() == 40400 || currentCell.getNumericCellValue() == 40500
                    || currentCell.getNumericCellValue() == 40600 || currentCell.getNumericCellValue() == 40700
                    || currentCell.getNumericCellValue() == 40800 || currentCell.getNumericCellValue() == 40900
                    || currentCell.getNumericCellValue() == 41000 || currentCell.getNumericCellValue() == 41200
                    || currentCell.getNumericCellValue() == 41300 || currentCell.getNumericCellValue() == 41400
                    || currentCell.getNumericCellValue() == 41500 || currentCell.getNumericCellValue() == 41600
                    || currentCell.getNumericCellValue() == 41700 || currentCell.getNumericCellValue() == 41800
                    || currentCell.getNumericCellValue() == 41900 || currentCell.getNumericCellValue() == 42000
                    || currentCell.getNumericCellValue() == 42100 || currentCell.getNumericCellValue() == 42200
                    || currentCell.getNumericCellValue() == 42300 || currentCell.getNumericCellValue() == 42400
                    )) {
                        break;
                    }
                    switch (cellIdx) {
                        case 0:
                            sheet600DAO.setCode(String.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 1:
                            sheet600DAO.setDescription(currentCell.getStringCellValue());
                            break;
                        case 2:
                            sheet600DAO.setTerm_loan(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 3:
                            sheet600DAO.setOver_draft(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 4:
                            sheet600DAO.setOthers_1(String.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 5:
                            sheet600DAO.setAdvances_under_lease(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 6:
                            sheet600DAO.setBankers_acceptances(String.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 7:
                            sheet600DAO.setCommercial_papers(String.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 8:
                            sheet600DAO.setBills_discounted(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case 9:
                            sheet600DAO.setOthers_2(String.valueOf(currentCell.getNumericCellValue()));
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                sheet600DAOS.add(sheet600DAO);
            }
            workbook.close();
            return sheet600DAOS;
        } catch (IOException e) {
            throw new IllegalStateException("fail to parse Excel file: " + e.getMessage());
        }
    }

    @Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir600DAO data = qdfir600Repo.findById(dataId)
	                .orElseThrow(() -> new RecordNotFoundException( "Record not found for this id :: " + dataId));
	        ResponseQuarterly resp = new ResponseQuarterly();
	        resp.setResponseMessage("Record Found");
	        resp.setResponseCode(00);
	        resp.setS600Data(data);

	        return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir600DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir600DAO> DataDb = qdfir600Repo.findByCode(Data.getCode());

	        if (DataDb.isPresent()){
	        	sheetQdfir600DAO DataUpdate = DataDb.get();
	            DataUpdate.setDescription(Data.getDescription());
	            DataUpdate.setOver_draft(Data.getTerm_loan());
	            DataUpdate.setOver_draft(Data.getOver_draft());
	            DataUpdate.setOthers_1(Data.getOthers_1());
	            DataUpdate.setAdvances_under_lease(Data.getAdvances_under_lease());
	            DataUpdate.setBankers_acceptances(Data.getBankers_acceptances());
	            DataUpdate.setCommercial_papers(Data.getCommercial_papers());
	            DataUpdate.setBills_discounted(Data.getBills_discounted());
	            DataUpdate.setOthers_2(Data.getOthers_2());

	            qdfir600Repo.save(DataUpdate);
	            ResponseQuarterly resp = new ResponseQuarterly();
	            resp.setResponseMessage("Record Updated");
	            resp.setResponseCode(00);
	            resp.setS600Data(DataUpdate);

	            return  new ResponseEntity<>(resp, HttpStatus.OK);
	        }
	        else {
	            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
	        }
	}

   }
