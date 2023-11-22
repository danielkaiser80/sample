package com.efass.sheet.mdfir371_3;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir371_1.sheet371_1DAO;
import com.efass.sheet.mdfir371_1.sheet371_1Repository;
import com.efass.sheet.mdfir371_1.sheet371_1_Service;
import com.efass.sheet.mdfir371_1.sheetQdfir371_1DAO;
import com.efass.sheet.mdfir371_2.sheetQdfir371_2DAO;
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
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet371_3_Impl implements sheet371_3_Service {

    @Autowired
    Qdfir371_3Repo qdfir371_3Repo;
    @Autowired
    sheet371_3Repository _371_3Repository;

    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet371_3XmlList() {
        return genericXmlList;
    }
    public void setSheet371_3XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR371_3 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet371_3DAO data) throws ResourceNotFoundException {

        _371_3Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS371_3Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet371_3DAO> data = null;
        Iterable<sheetQdfir371_3DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR371";
            daoClass = sheet371_3DAO.class;
            data = _371_3Repository.findAll();

            data.forEach((e) -> {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getDerivative_financial_assets()== null ? "" :e.getDerivative_financial_assets());
                        result.add(e.getNotional_amount().toString() == null ? ".00" : String.valueOf(e.getNotional_amount().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCarrying_value().toString() == null ? ".00" : String.valueOf(e.getCarrying_value().setScale(2, RoundingMode.HALF_EVEN)));
                    }
            );
            
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix(".T3")
                    .result(result)
                .daoClass(daoClass)
                    .reportName(reportName)
                            .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)
                    .build());

            setSheet371_3XmlList(genericXmls);
            Response res = new Response();
            res.setSheet371_3(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR371";
            daoClass = sheetQdfir371_3DAO.class;
            qdfirData = qdfir371_3Repo.findAll();

            qdfirData.forEach((e) -> 
            {
            	try {
        			   counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getDerivative_financial_assets()== null ? "" :e.getDerivative_financial_assets());
                        result.add(e.getNotional_amount().toString() == null ? ".00" : String.valueOf(e.getNotional_amount().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCarrying_value().toString() == null ? ".00" : String.valueOf(e.getCarrying_value().setScale(2, RoundingMode.HALF_EVEN)));
            	}
   			 catch(NullPointerException ex) 
   	            {
   	    			System.out.println("NullPointerException thrown!");
   	            }	
            	});
        }
        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .genericXmls(genericXmls)
                .prefix(".T3")
                .result(result)
            .daoClass(daoClass)
                .reportName(reportName)
                        .isNoneSpecialWithPrefix(true)
                .isIdPresent(true)
                .build());

        setSheet371_3XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir371_3(qdfirData);
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet371_3DAO data = _371_3Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS371_3Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheet371_3DAO> data = _371_3Repository.findById(dataId);

        if (data.isPresent()) {
            _371_3Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    public ResponseEntity<?> updateData(int id , sheet371_3DAO Data) throws ResourceNotFoundException {

        Optional<sheet371_3DAO> DataDb = _371_3Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet371_3DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setCarrying_value(Data.getCarrying_value());
            DataUpdate.setDerivative_financial_assets(Data.getDerivative_financial_assets());
            DataUpdate.setNotional_amount(Data.getNotional_amount());

            _371_3Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS371_3Data(DataUpdate);
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
	public ResponseEntity<?> createDataQ(sheetQdfir371_3DAO data) throws ResourceNotFoundException {
		qdfir371_3Repo.save(data);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS371_3Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir371_3DAO data = qdfir371_3Repo.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS371_3Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir371_3DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir371_3DAO> DataDb = qdfir371_3Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir371_3DAO DataUpdate = DataDb.get();
	            DataUpdate.setId(Data.getId());
	            DataUpdate.setCarrying_value(Data.getCarrying_value());
	            DataUpdate.setDerivative_financial_assets(Data.getDerivative_financial_assets());
	            DataUpdate.setNotional_amount(Data.getNotional_amount());

	            qdfir371_3Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS371_3Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
	        }
	}
}
