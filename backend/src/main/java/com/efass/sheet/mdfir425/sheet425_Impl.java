package com.efass.sheet.mdfir425;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.Validation;

import com.efass.sheet.mdfir412.sheet412DAO;
import com.efass.sheet.mdfir412.sheetQdfir412DAO;
import com.efass.sheet.mdfir422.sheet422DAO;
import com.efass.sheet.table.TabController;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet425_Impl implements sheet425_Service{

	@Autowired
	Qdfir425Repo qdfir425Repo;
    @Autowired
    sheet425Repository sheet425Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet425XmlList() {
		return genericXmlList;
	}

	public void setSheet425XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}


	// ############################## MDFIR425 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet425DAO data) throws ResourceNotFoundException {

		sheet425Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS425Data(data);
 		
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet425DAO> data = null;
		Iterable<sheetQdfir425DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR425";
            daoClass = sheet425DAO.class;
			data = sheet425Repository.findAll();

			data.forEach((e) -> {
						counter.getAndIncrement();
						result.add(String.valueOf(counter));
						result.add(e.getDescription()== null ? "" :e.getDescription());
						result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
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
			setSheet425XmlList(genericXmls);
	 		Response res = new Response();
	 		res.setSheet425(data);
	 		res.setResponseMessage("Success");
	 		res.setResponseCode(00);
	 		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR425";
            daoClass = sheetQdfir425DAO.class;
			qdfirData = qdfir425Repo.findAll();

			qdfirData.forEach((e) -> 
			{
				try {
        			//System.out.println("i am here 425");
						counter.getAndIncrement();
						result.add(String.valueOf(counter));
						result.add(e.getDescription()== null ? "" :e.getDescription());
						result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
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
		setSheet425XmlList(genericXmls);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setQdfir425(qdfirData);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet425DAO> data = sheet425Repository.findById(dataId);

		if (data.isPresent()) {
			sheet425Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet425DAO Data) throws ResourceNotFoundException {
        Optional<sheet425DAO> DataDb = sheet425Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet425DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setDescription(Data.getDescription());
            sheet425Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS425Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet425DAO data = sheet425Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS425Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir425DAO data) throws ResourceNotFoundException {
		qdfir425Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS425Data(data);
 		
 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir425DAO data = qdfir425Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS425Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir425DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir425DAO> DataDb = qdfir425Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir425DAO DataUpdate = DataDb.get();

				DataUpdate.setId(Data.getId());
				DataUpdate.setAmount(Data.getAmount());
				DataUpdate.setDescription(Data.getDescription());
				qdfir425Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS425Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}

}
