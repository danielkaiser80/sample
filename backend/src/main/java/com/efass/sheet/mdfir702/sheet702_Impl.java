package com.efass.sheet.mdfir702;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.Validation;

import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.mdfir432.sheet432DAO;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet702_Impl implements sheet702_Service{

    @Autowired
    sheet702Repository sheet702Repository;

	@Autowired Qdfir702Repo qdfir702Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet702XmlList() {
		return genericXmlList;
	}

	public void setSheet702XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}


	// ############################## MDFIR702 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet702DAO data) throws ResourceNotFoundException {

		sheet702Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS702Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet702DAO> data = null;
		 Iterable<sheetQdfir702DAO> qdfir702DAOS = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR702";
            daoClass = sheet702DAO.class;
			data = sheet702Repository.findAll();

			data.forEach((e) -> {
						counter.getAndIncrement();
						result.add(String.valueOf(counter));
						result.add(e.getDescription()== null ? "" :e.getDescription());
						result.add(e.getAmount().toString() == null ? ".00" :String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
					}
			);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR702";
            daoClass = sheetQdfir702DAO.class;
			qdfir702DAOS = qdfir702Repo.findAll();

			qdfir702DAOS.forEach((e) -> 
			{
				try {
        			//System.out.println("i am here 702");
						counter.getAndIncrement();
						result.add(String.valueOf(counter));
						result.add(e.getDescription()== null ? "" :e.getDescription());
						result.add(e.getAmount().toString() == null ? ".00" :String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
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
		setSheet702XmlList(genericXmls);
		Response res = new Response();
 		res.setSheet702(data);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet702DAO> data = sheet702Repository.findById(dataId);

		if (data.isPresent()) {
			sheet702Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet702DAO Data) throws ResourceNotFoundException {
        Optional<sheet702DAO> DataDb = sheet702Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet702DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setDescription(Data.getDescription());
            sheet702Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS702Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet702DAO data = sheet702Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS702Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public Boolean writesheet702(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
	EncryptedDocumentException, InvalidFormatException {

ArrayList<sheet702DAO> sheetdata = new ArrayList<>();
sheetdata = (ArrayList<sheet702DAO>) sheet702Repository.findAllOrderByCode();

System.out.println("*************************** I'm here"+sheetdata);
//List<List<Object>> listofLists = new ArrayList<List<Object>>();

	for (int i = 0; i < sheetdata.size(); i++) {

		System.out.println("*************************** Entered here again "+sheetdata);
		ArrayList<sheet702DAO> data = new ArrayList<>();


		//String sheetCode = sheetdata.get(i).getCode();
		BigDecimal col1 = sheetdata.get(i).getAmount();

		sheet702DAO dt = new sheet702DAO();
		dt.setAmount(col1);
		sheet702Repository.save(dt);
	}


	//Fetch Values from temporary table and save in arraylist
	ArrayList<sheet702DAO> sheetData = new ArrayList<sheet702DAO>();
	 sheetData = sheet702Repository.findAllOrderByCode();

		List<List<Object>> listOfLists = new ArrayList<List<Object>>();

		for (int i = 0; i < sheetData.size(); i++) {
			ArrayList<Object> data = new ArrayList<>();
			//data.clear();

			data.add(sheetData.get(i).getAmount());

			listOfLists.add(data);

		}
		return null;
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir702DAO data) throws ResourceNotFoundException {
		
		qdfir702Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS702Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir702DAO data = qdfir702Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS702Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir702DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir702DAO> DataDb = qdfir702Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir702DAO DataUpdate = DataDb.get();

				DataUpdate.setId(Data.getId());
				DataUpdate.setAmount(Data.getAmount());
				DataUpdate.setDescription(Data.getDescription());
	            qdfir702Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS702Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}
}
