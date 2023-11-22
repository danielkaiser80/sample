package com.efass.sheet.mdfir423;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir300.sheet300DAO;
import com.efass.sheet.mdfir412.sheet412DAO;
import com.efass.sheet.mdfir412.sheetQdfir412DAO;
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
public class sheet423_Impl implements sheet423_Service{

    @Autowired
    Qdfir423Repo qdfir423Repo;
    @Autowired
    sheet423Repository sheet423Repository;

    public List<GenericXml> getSheet423XmlList() {
        return genericXmlList;
    }

    public void setSheet423XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    List<GenericXml> genericXmlList;

    @Override
    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet423DAO> data = null;
        Iterable<sheetQdfir423DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> codes = new ArrayList<>();
        System.out.println(data);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR423";
            daoClass = sheet423DAO.class;
            data = sheet423Repository.findAll();

            data.forEach((e) -> {
                codes.add(e.getCode() == null ? "" :e.getCode());
                result.add((e.getAmount() == null ? BigDecimal.ZERO.toString() : e.getAmount().toString()));

            });
            
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .isSpecial(true)
                    .prefix(".T0")
                    .daoClass(daoClass)
                     .isSkipRows(false)
                    .reportName(reportName)
                    .result(result)
                    .genericXmls(genericXmls)
                    .codes(codes)
                    .build());
            setSheet423XmlList(genericXmls);
            Response res = new Response();
            res.setSheet423(data);
            res.setResponseMessage("Success");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR423";
            daoClass = sheetQdfir423DAO.class;
            qdfirData = qdfir423Repo.findAll();

            qdfirData.forEach((e) ->
            {
            	try {
        			//System.out.println("i am here 423");
                codes.add(e.getCode() == null ? "" :e.getCode());
                result.add((e.getAmount() == null ? BigDecimal.ZERO.toString() : e.getAmount().toString()));
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
                 .isSkipRows(false)
                .reportName(reportName)
                .result(result)
                .genericXmls(genericXmls)
                .codes(codes)
                .build());
        setSheet423XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir423(qdfirData);
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateData(int id, sheet423DAO Data) throws ResourceNotFoundException {
        Optional<sheet423DAO> DataDb = sheet423Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet423DAO DataUpdate = DataDb.get();

            DataUpdate.setAmount(Data.getAmount());
            sheet423Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS423Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet423DAO data = sheet423Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS423Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
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
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir423DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir423DAO> DataDb = qdfir423Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir423DAO DataUpdate = DataDb.get();

	            DataUpdate.setAmount(Data.getAmount());
	            qdfir423Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS423Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir423DAO data = qdfir423Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS423Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
