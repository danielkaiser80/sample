package com.efass.sheet.mdfir333;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir291.sheet291DAO;
import com.efass.sheet.mdfir291.sheetQdfir291DAO;
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
public class sheet333_Impl implements sheet333_Service {

    @Autowired
    sheet333Repository _333Repository;

    @Autowired
    Qdfir333Repo qdfir333Repo;
    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet333XmlList() {
        return genericXmlList;
    }
    public void setSheet333XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR333 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet333DAO data) throws ResourceNotFoundException {
        _333Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS333Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir333DAO data) throws ResourceNotFoundException {
		qdfir333Repo.save(data);
         ResponseQuarterly res = new ResponseQuarterly();
         res.setResponseMessage("Success");
         res.setResponseCode(00);
         res.setS333Data(data);
         return new ResponseEntity<>(res, HttpStatus.OK);
	}

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet333DAO> data = null;
        Iterable<sheetQdfir333DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR333";
            daoClass = sheet333DAO.class;
            data = _333Repository.findAll();

            data.forEach((e) ->
            {
            	try {
        			//System.out.println("i am here 333");
                counter.getAndIncrement();
                result.add(String.valueOf(counter));
                result.add(e.getInvestee_name()== null ? "" : e.getInvestee_name());
                result.add(e.getType_of_investment()== null ? "" : e.getType_of_investment());
                result.add(e.getInvestment_cert_number()== null ? "" :  e.getInvestment_cert_number());
                result.add(e.getAmount_invested().toString() == null ? ".00" : String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getFair_value_gains().toString() == null ? ".00" : String.valueOf(e.getFair_value_gains().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getImpairment().toString() == null ? ".00" : String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getCarrying_value_unquoted_eq_inv().toString() == null ? ".00" : String.valueOf(e.getCarrying_value_unquoted_eq_inv().setScale(2, RoundingMode.HALF_EVEN)));
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

            setSheet333XmlList(genericXmls);
            Response res = new Response();
            res.setSheet333(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR333";
            daoClass = sheetQdfir333DAO.class;
            qdfirData = qdfir333Repo.findAll();

            qdfirData.forEach((e) -> {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getInvestee_name()== null ? "" : e.getInvestee_name());
                        result.add(e.getType_of_investment()== null ? "" : e.getType_of_investment());
                        result.add(e.getInvestment_cert_number()== null ? "" :  e.getInvestment_cert_number());
                        result.add(e.getAmount_invested().toString() == null ? ".00" : String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getFair_value_gains().toString() == null ? ".00" : String.valueOf(e.getFair_value_gains().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getImpairment().toString() == null ? ".00" : String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCarrying_value_unquoted_eq_inv().toString() == null ? ".00" : String.valueOf(e.getCarrying_value_unquoted_eq_inv().setScale(2, RoundingMode.HALF_EVEN)));
                    }
            );
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix("")
                    .result(result)
                .daoClass(daoClass)
                    .reportName(reportName)
                .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)
                    .build());

            setSheet333XmlList(genericXmls);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setQdfir333(qdfirData);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return null;
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	 if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
        sheet333DAO data = _333Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS333Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    	 }
    	 if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
    		 sheetQdfir333DAO data = qdfir333Repo.findById(dataId)
    	                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
    	        ResponseQuarterly res = new ResponseQuarterly();
    	        res.setResponseMessage("Record Found");
    	        res.setResponseCode(00);
    	        res.setS333Data(data);

    	        return new ResponseEntity<>(res, HttpStatus.OK);
    	    	 }
    	 return null;
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
    	 if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
        Optional<sheet333DAO> data = _333Repository.findById(dataId);

        if (data.isPresent()) {
            _333Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    	 }
    	 if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
    	        Optional<sheetQdfir333DAO> data = qdfir333Repo.findById(dataId);

    	        if (data.isPresent()) {
    	        	qdfir333Repo.delete(data.get());
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

    public ResponseEntity<?> updateData(int id , sheet333DAO Data) throws ResourceNotFoundException {

        Optional<sheet333DAO> DataDb = _333Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet333DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setInvestee_name(Data.getInvestee_name());
            DataUpdate.setType_of_investment(Data.getType_of_investment());
            DataUpdate.setInvestement_cert_number(Data.getInvestment_cert_number());
            DataUpdate.setAmount_invested(Data.getAmount_invested());

            DataUpdate.setFair_value_gains(Data.getFair_value_gains());
            DataUpdate.setImpairment(Data.getImpairment());
            DataUpdate.setCarrying_value_unquoted_eq_inv(Data.getCarrying_value_unquoted_eq_inv());

            _333Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS333Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir333DAO Data) throws ResourceNotFoundException {

        Optional<sheetQdfir333DAO> DataDb = qdfir333Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir333DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setInvestee_name(Data.getInvestee_name());
            DataUpdate.setType_of_investment(Data.getType_of_investment());
            DataUpdate.setInvestement_cert_number(Data.getInvestment_cert_number());
            DataUpdate.setAmount_invested(Data.getAmount_invested());

            DataUpdate.setFair_value_gains(Data.getFair_value_gains());
            DataUpdate.setImpairment(Data.getImpairment());
            DataUpdate.setCarrying_value_unquoted_eq_inv(Data.getCarrying_value_unquoted_eq_inv());

            qdfir333Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS333Data(DataUpdate);
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


}

