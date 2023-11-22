package com.efass.sheet.mdfir900;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.Validation;

import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.mdfir702.sheet702DAO;
import com.efass.sheet.mdfir921.sheetQdfir921DAO;
import com.efass.sheet.table.TabController;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Column;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet900_Impl implements sheet900_Service{

    @Autowired
     sheet900Repository sheet900Repository;

    @Autowired Qdfir900Repo qdfir900Repo;
    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet900XmlList() {
        return genericXmlList;
    }

    public void setSheet900XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

 // ############################## MDFIR900 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet900DAO data) throws ResourceNotFoundException {

		sheet900Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS900Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet900DAO> data = null;
         Iterable<sheetQdfir900DAO> qdfir900DAOS = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR900";
            daoClass = sheet900DAO.class;
            data = sheet900Repository.findAll();

            data.forEach((e) ->
            {
            	try {

                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getCustomer_code() == null ? "" :e.getCustomer_code());
                        result.add(e.getCustomer_name() == null ? "" :e.getCustomer_name());
                        result.add(e.getType_of_facility() == null ? "" :e.getType_of_facility());
                        result.add(e.getAmount_granted().toString() == null ? ".00" :String.valueOf(e.getAmount_granted().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
        				result.add(e.getExpiry_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getExpiry_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getUnutilised_credit().toString() == null ? ".00" :String.valueOf(e.getUnutilised_credit().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getOutstanding_credit().toString() == null ? ".00" :String.valueOf(e.getOutstanding_credit().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getDebt_instruments().toString() == null ? ".00" :String.valueOf(e.getDebt_instruments().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getStatus()== null ? "" : e.getStatus());
                        result.add(e.getDate_utilization_on_exceeded_limit().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_utilization_on_exceeded_limit().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getCbn_approval().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getCbn_approval().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
            	}
   			 catch(NullPointerException ex)
      	            {
      	    			System.out.println("NullPointerException thrown!");
      	            }
                    });

            Field[] declaredFields = sheetQdfir900DAO.class.getDeclaredFields();
            Field field = null;
      			try {
      			    field = sheetQdfir900DAO.class.getField("total");
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

                 setSheet900XmlList(genericXmls);
          		Response res = new Response();
          		res.setSheet900(data);
          		res.setResponseMessage("Success");
          		res.setResponseCode(00);
          		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR900";
            daoClass = sheetQdfir900DAO.class;
            qdfir900DAOS = qdfir900Repo.findAll();

            qdfir900DAOS.forEach((e) ->
            {
            	try {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getCustomer_code() == null ? "" :e.getCustomer_code());
                        result.add(e.getCustomer_name() == null ? "" :e.getCustomer_name());
                        result.add(e.getType_of_facility() == null ? "" :e.getType_of_facility());
                        result.add(e.getAmount_granted().toString() == null ? ".00" :String.valueOf(e.getAmount_granted().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
        				result.add(e.getExpiry_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getExpiry_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getUnutilised_credit().toString() == null ? ".00" :String.valueOf(e.getUnutilised_credit().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getOutstanding_credit().toString() == null ? ".00" :String.valueOf(e.getOutstanding_credit().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getDebt_instruments().toString() == null ? ".00" :String.valueOf(e.getDebt_instruments().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getStatus()== null ? "" : e.getStatus());
                        result.add(e.getDate_utilization_on_exceeded_limit().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_utilization_on_exceeded_limit().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
        				result.add(e.getCbn_approval().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getCbn_approval().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
            }
  			 catch(NullPointerException ex)
     	            {
     	    			System.out.println("NullPointerException thrown!");
     	            }
            });
        }

        Field[] declaredFields = sheetQdfir900DAO.class.getDeclaredFields();
        Field field = null;
  			try {
  			    field = sheetQdfir900DAO.class.getField("total");
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

        setSheet900XmlList(genericXmls);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setQdfir900(qdfir900DAOS);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet900DAO> data = sheet900Repository.findById(dataId);

		if (data.isPresent()) {
			sheet900Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet900DAO Data) throws ResourceNotFoundException {
        Optional<sheet900DAO> DataDb = sheet900Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet900DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setType_of_facility(Data.getType_of_facility());
			DataUpdate.setAmount_granted(Data.getAmount_granted());
			DataUpdate.setDate_granted(Data.getDate_granted());
			DataUpdate.setExpiry_date(Data.getExpiry_date());
			DataUpdate.setUnutilised_credit(Data.getUnutilised_credit());
			DataUpdate.setOutstanding_credit(Data.getOutstanding_credit());
			DataUpdate.setDebt_instruments(Data.getDebt_instruments());
			DataUpdate.setStatus(Data.getStatus());
			DataUpdate.setDate_utilization_on_exceeded_limit(Data.getDate_utilization_on_exceeded_limit());
			DataUpdate.setCbn_approval(Data.getCbn_approval());
            sheet900Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS900Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet900DAO data = sheet900Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS900Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir900DAO data) throws ResourceNotFoundException {

		qdfir900Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS900Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir900DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir900DAO> DataDb = qdfir900Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir900DAO DataUpdate = DataDb.get();

				DataUpdate.setId(Data.getId());
				DataUpdate.setCustomer_code(Data.getCustomer_code());
				DataUpdate.setCustomer_name(Data.getCustomer_name());
				DataUpdate.setType_of_facility(Data.getType_of_facility());
				DataUpdate.setAmount_granted(Data.getAmount_granted());
				DataUpdate.setDate_granted(Data.getDate_granted());
				DataUpdate.setExpiry_date(Data.getExpiry_date());
				DataUpdate.setUnutilised_credit(Data.getUnutilised_credit());
				DataUpdate.setOutstanding_credit(Data.getOutstanding_credit());
				DataUpdate.setDebt_instruments(Data.getDebt_instruments());
				DataUpdate.setStatus(Data.getStatus());
				DataUpdate.setDate_utilization_on_exceeded_limit(Data.getDate_utilization_on_exceeded_limit());
				DataUpdate.setCbn_approval(Data.getCbn_approval());
				qdfir900Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS900Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}

}
