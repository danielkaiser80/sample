package com.efass.sheet.mdfir700;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.RecordNotFoundException;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir300.sheet300DAO;
import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class sheet700_Impl implements sheet700_Service{

    @Autowired
    Qdfir700Repo qdfir700Repo;
    @Autowired
    sheet700Repository sheet700Repo;
    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet700XmlList() {
        return genericXmlList;
    }

    public void setSheet700XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    public ResponseEntity<?> fetchAllData(){
        Iterable<sheet700DAO> data = null;
        Iterable<sheetQdfir700DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> codes = new ArrayList<>();
        System.out.println(data);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR700";
            daoClass = sheet700DAO.class;
            data = sheet700Repo.findAll();

            data.forEach((e) -> {
                codes.add(e.getCode()== null ? "" : e.getCode());
                result.add(e.getOutstanding_at_beginning_of_month() == null? BigDecimal.ZERO.toString() : e.getOutstanding_at_beginning_of_month().toString());
                result.add(e.getOutstanding_at_end_of_month() == null? BigDecimal.ZERO.toString() : e.getOutstanding_at_end_of_month().toString());
                result.add(e.getAverage_opening_and_closing_balance() == null? BigDecimal.ZERO.toString() : e.getAverage_opening_and_closing_balance().toString());
                result.add(e.getPaid_interest_during_the_month() == null? BigDecimal.ZERO.toString() : e.getPaid_interest_during_the_month().toString());
            });
            
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .isSpecial(true)
                    .prefix(".T0")
                    .daoClass(daoClass)
                    .reportName(reportName)
                    .result(result)
                    .genericXmls(genericXmls)
                    .codes(codes)
                    .build());
            setSheet700XmlList(genericXmls);
            Response resp =new Response();
            resp.setSheet700(data);
            resp.setResponseMessage("Success");
            resp.setResponseCode(00);

            return new ResponseEntity<>(resp, HttpStatus.OK);

        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR700";
            daoClass = sheetQdfir700DAO.class;
            qdfirData = qdfir700Repo.findAll();

            qdfirData.forEach((e) -> {
            	try {
        			//System.out.println("i am here 700");
                codes.add(e.getCode()== null ? "" : e.getCode());
                result.add(e.getOutstanding_at_beginning_of_month() == null? BigDecimal.ZERO.toString() : e.getOutstanding_at_beginning_of_month().toString());
                result.add(e.getOutstanding_at_end_of_month() == null? BigDecimal.ZERO.toString() : e.getOutstanding_at_end_of_month().toString());
                result.add(e.getAverage_opening_and_closing_balance() == null? BigDecimal.ZERO.toString() : e.getAverage_opening_and_closing_balance().toString());
                result.add(e.getPaid_interest_during_the_month() == null? BigDecimal.ZERO.toString() : e.getPaid_interest_during_the_month().toString());
            	}
   			 catch(NullPointerException ex) 
   	            {
   	    			System.out.println("NullPointerException thrown!");
   	            }	
            	});
        }
        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .isSpecial(true)
                .prefix(".T0")
                .daoClass(daoClass)
                .reportName(reportName)
                .result(result)
                .genericXmls(genericXmls)
                .codes(codes)
                .build());
        setSheet700XmlList(genericXmls);
        ResponseQuarterly resp =new ResponseQuarterly();
        resp.setQdfir700(qdfirData);
        resp.setResponseMessage("Success");
        resp.setResponseCode(00);

        return new ResponseEntity<>(resp, HttpStatus.OK);

    }
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException{
        sheet700DAO data = sheet700Repo.findById(dataId)
                .orElseThrow(() -> new RecordNotFoundException("Record not found for this id :: " + dataId));
        Response resp = new Response();
        resp.setResponseMessage("Record Found");
        resp.setResponseCode(00);
        resp.setS700Data(data);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    public  ResponseEntity<?> updateData(int id, sheet700DAO Data) throws ResourceNotFoundException{

        Optional<sheet700DAO> DataDb = sheet700Repo.findByCode(Data.getCode());

        if(DataDb.isPresent()){
            sheet700DAO DataUpdate = DataDb.get();
            DataUpdate.setOutstanding_at_beginning_of_month(Data.getOutstanding_at_beginning_of_month());
            DataUpdate.setOutstanding_at_end_of_month(Data.getOutstanding_at_end_of_month());
            DataUpdate.setAverage_opening_and_closing_balance(Data.getAverage_opening_and_closing_balance());
            DataUpdate.setPaid_interest_during_the_month(Data.getPaid_interest_during_the_month());

            sheet700Repo.save(DataUpdate);
            Response resp = new Response();
            resp.setResponseMessage("Record Updated");
            resp.setResponseCode(00);
            resp.setS700Data(DataUpdate);

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
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir700DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir700DAO> DataDb = qdfir700Repo.findByCode(Data.getCode());

        if(DataDb.isPresent()){
        	sheetQdfir700DAO DataUpdate = DataDb.get();
            DataUpdate.setOutstanding_at_beginning_of_month(Data.getOutstanding_at_beginning_of_month());
            DataUpdate.setOutstanding_at_end_of_month(Data.getOutstanding_at_end_of_month());
            DataUpdate.setAverage_opening_and_closing_balance(Data.getAverage_opening_and_closing_balance());
            DataUpdate.setPaid_interest_during_the_month(Data.getPaid_interest_during_the_month());

            qdfir700Repo.save(DataUpdate);
            ResponseQuarterly resp = new ResponseQuarterly();
            resp.setResponseMessage("Record Updated");
            resp.setResponseCode(00);
            resp.setS700Data(DataUpdate);

            return  new ResponseEntity<>(resp, HttpStatus.OK);
        }
        else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());

        }
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir700DAO data = qdfir700Repo.findById(dataId)
	                .orElseThrow(() -> new RecordNotFoundException("Record not found for this id :: " + dataId));
	        ResponseQuarterly resp = new ResponseQuarterly();
	        resp.setResponseMessage("Record Found");
	        resp.setResponseCode(00);
	        resp.setS700Data(data);

	        return new ResponseEntity<>(resp, HttpStatus.OK);
	}

 }
