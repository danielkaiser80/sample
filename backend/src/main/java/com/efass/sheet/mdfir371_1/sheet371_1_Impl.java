package com.efass.sheet.mdfir371_1;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir292_1.sheet292_1DAO;
import com.efass.sheet.mdfir292_1.sheetQdfir292_1DAO;
import com.efass.sheet.mdfir363.sheet363DAO;
import com.efass.sheet.mdfir363.sheet363Repository;
import com.efass.sheet.mdfir363.sheet363_Service;
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
public class sheet371_1_Impl implements sheet371_1_Service {

    @Autowired
    Qdfir371_1Repo qdfir371_1Repo;
    @Autowired
    sheet371_1Repository _371_1Repository;

    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet371_1XmlList() {
        return genericXmlList;
    }
    public void setSheet371_1XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR371_1 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet371_1DAO data) throws ResourceNotFoundException {

        _371_1Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS371_1Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet371_1DAO> data = null;
        Iterable<sheetQdfir371_1DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);



        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR371";
            daoClass = sheet371_1DAO.class;
            data = _371_1Repository.findAll();

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
                    .prefix(".T1")
                    .result(result)
                .daoClass(daoClass)
                    .reportName(reportName)
                            .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)

                    .build());

            setSheet371_1XmlList(genericXmls);
            Response res = new Response();
            res.setSheet371_1(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR371";
            daoClass = sheetQdfir371_1DAO.class;
            qdfirData = qdfir371_1Repo.findAll();

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
                .prefix(".T1")
                .result(result)
            .daoClass(daoClass)
                .reportName(reportName)
                        .isNoneSpecialWithPrefix(true)
                .isIdPresent(true)

                .build());

        setSheet371_1XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir371_1(qdfirData);
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet371_1DAO data = _371_1Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS371_1Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheet371_1DAO> data = _371_1Repository.findById(dataId);

        if (data.isPresent()) {
            _371_1Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    public ResponseEntity<?> updateData(int id , sheet371_1DAO Data) throws ResourceNotFoundException {

        Optional<sheet371_1DAO> DataDb = _371_1Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet371_1DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setCarrying_value(Data.getCarrying_value());
            DataUpdate.setDerivative_financial_assets(Data.getDerivative_financial_assets());
            DataUpdate.setNotional_amount(Data.getNotional_amount());

            _371_1Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS371_1Data(DataUpdate);
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
	public ResponseEntity<?> createDataQ(sheetQdfir371_1DAO data) throws ResourceNotFoundException {
		qdfir371_1Repo.save(data);
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Success");
	        res.setResponseCode(00);
	        res.setS371_1Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir371_1DAO data = qdfir371_1Repo.findById(dataId)
	                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS371_1Data(data);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir371_1DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir371_1DAO> DataDb = qdfir371_1Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir371_1DAO DataUpdate = DataDb.get();
	            DataUpdate.setId(Data.getId());
	            DataUpdate.setCarrying_value(Data.getCarrying_value());
	            DataUpdate.setDerivative_financial_assets(Data.getDerivative_financial_assets());
	            DataUpdate.setNotional_amount(Data.getNotional_amount());

	            qdfir371_1Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS371_1Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
	        }
	}


}

