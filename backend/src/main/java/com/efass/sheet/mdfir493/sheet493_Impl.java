package com.efass.sheet.mdfir493;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;

import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet493_Impl implements sheet493_Service{

    @Autowired
    Qdfir493Repo qdfir493Repo;
    @Autowired
  sheet493Repository sheet493Repository;
    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet493XmlList() {
        return genericXmlList;
    }

    public void setSheet493XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

 // ############################## MDFIR493 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet493DAO data) throws ResourceNotFoundException {


		sheet493Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS493Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet493DAO> data = null;
        Iterable<sheetQdfir493DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR493";
            daoClass = sheet493DAO.class;
            data = sheet493Repository.findAll();

            data.forEach((e) -> {

                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getType()== null ? "" : e.getType());
                        result.add(e.getDescription() == null ? "" :e.getDescription());
                        result.add(e.getLocation() == null ? "" :e.getLocation());
                        result.add(e.getDate_of_purchase().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_purchase().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getDate_transferred_to_held_for_sale().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_transferred_to_held_for_sale().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getPurchase_cost().toString() == null ? ".00" :String.valueOf(e.getPurchase_cost().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCurrent_book_value().toString() == null ? ".00" :String.valueOf(e.getCurrent_book_value().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCurrent_market_value().toString() == null ? ".00" :String.valueOf(e.getCurrent_market_value().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getRevaluation_gain_or_loss().toString() == null ? ".00" :String.valueOf(e.getRevaluation_gain_or_loss().setScale(2, RoundingMode.HALF_EVEN)));

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
            setSheet493XmlList(genericXmls);
     		Response res = new Response();
     		res.setSheet493(data);
     		res.setResponseMessage("Success");
     		res.setResponseCode(00);
     		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR493";
            daoClass = sheetQdfir493DAO.class;
            qdfirData = qdfir493Repo.findAll();

            qdfirData.forEach((e) -> {
            	try {
        			//System.out.println("i am here 493");
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getType()== null ? "" : e.getType());
                        result.add(e.getDescription() == null ? "" :e.getDescription());
                        result.add(e.getLocation() == null ? "" :e.getLocation());
                        result.add(e.getDate_of_purchase().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_purchase().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
        				result.add(e.getDate_transferred_to_held_for_sale().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_transferred_to_held_for_sale().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getPurchase_cost().toString() == null ? ".00" :String.valueOf(e.getPurchase_cost().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCurrent_book_value().toString() == null ? ".00" :String.valueOf(e.getCurrent_book_value().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCurrent_market_value().toString() == null ? ".00" :String.valueOf(e.getCurrent_market_value().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getRevaluation_gain_or_loss().toString() == null ? ".00" :String.valueOf(e.getRevaluation_gain_or_loss().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getRemarks() == null ? "" :e.getRemarks());
                        //result.add(e.getRemarks()== null ?  ".00" :String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));
    			}
    			 catch(NullPointerException ex)
    	            {
    	    			System.out.println("NullPointerException thrown!");
    	            }
                    });
        }
        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .genericXmls(genericXmls)
                .prefix("")
                .result(result)
                .daoClass(daoClass)
                .reportName(reportName)
                .isNoneSpecialWithPrefix(true)
                .isIdPresent(true)
                .build());
        setSheet493XmlList(genericXmls);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setQdfir493(qdfirData);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet493DAO> data = sheet493Repository.findById(dataId);

		if (data.isPresent()) {
			sheet493Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet493DAO Data) throws ResourceNotFoundException {
        Optional<sheet493DAO> DataDb = sheet493Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet493DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setType(Data.getType());
			DataUpdate.setDescription(Data.getDescription());
			DataUpdate.setLocation(Data.getLocation());
			DataUpdate.setDate_of_purchase(Data.getDate_of_purchase());
			DataUpdate.setDate_transferred_to_held_for_sale(Data.getDate_transferred_to_held_for_sale());
			DataUpdate.setPurchase_cost(Data.getPurchase_cost());
			DataUpdate.setCurrent_book_value(Data.getCurrent_book_value());
			DataUpdate.setCurrent_market_value(Data.getCurrent_market_value());
			DataUpdate.setRevaluation_gain_or_loss(Data.getRevaluation_gain_or_loss());
            DataUpdate.setRemarks(Data.getRemarks());
            sheet493Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS493Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet493DAO data = sheet493Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS493Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir493DAO data) throws ResourceNotFoundException {
		qdfir493Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS493Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir493DAO data = qdfir493Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS493Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir493DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir493DAO> DataDb = qdfir493Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir493DAO DataUpdate = DataDb.get();
				DataUpdate.setId(Data.getId());
				DataUpdate.setType(Data.getType());
				DataUpdate.setDescription(Data.getDescription());
				DataUpdate.setLocation(Data.getLocation());
				DataUpdate.setDate_of_purchase(Data.getDate_of_purchase());
				DataUpdate.setDate_transferred_to_held_for_sale(Data.getDate_transferred_to_held_for_sale());
				DataUpdate.setPurchase_cost(Data.getPurchase_cost());
				DataUpdate.setCurrent_book_value(Data.getCurrent_book_value());
				DataUpdate.setCurrent_market_value(Data.getCurrent_market_value());
				DataUpdate.setRevaluation_gain_or_loss(Data.getRevaluation_gain_or_loss());
	            DataUpdate.setRemarks(Data.getRemarks());
	            qdfir493Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS493Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}
}
