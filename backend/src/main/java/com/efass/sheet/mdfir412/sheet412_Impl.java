package com.efass.sheet.mdfir412;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir321.sheet321DAO;
import com.efass.sheet.mdfir363.sheet363DAO;
import com.efass.sheet.mdfir363.sheetQdfir363DAO;
import com.efass.sheet.table.TabController;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet412_Impl implements sheet412_Service{

	@Autowired
	Qdfir412Repo qdfir412Repo;
    @Autowired
    sheet412Repository sheet412Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet412XmlList() {
		return genericXmlList;
	}

	public void setSheet412XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR412 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet412DAO data) throws ResourceNotFoundException {


		sheet412Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS412Data(data);


 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet412DAO> data = null;
		Iterable<sheetQdfir412DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR412";
            daoClass = sheet412DAO.class;
			data = sheet412Repository.findAll();

			data.forEach((e) -> {
						counter.getAndIncrement();
						result.add(String.valueOf(counter));
						result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
						result.add(e.getDescription()== null ? "" :e.getDescription());
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

			setSheet412XmlList(genericXmls);
			Response res = new Response();
	 		res.setSheet412(data);
	 		res.setResponseMessage("Success");
	 		res.setResponseCode(00);
	 		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR412";
            daoClass = sheetQdfir412DAO.class;
			qdfirData = qdfir412Repo.findAll();

			qdfirData.forEach((e) -> 
			{
				try {
        			//System.out.println("i am here 412");
        			
						counter.getAndIncrement();
						result.add(String.valueOf(counter));
						result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
						result.add(e.getDescription()== null ? "" :e.getDescription());
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

		setSheet412XmlList(genericXmls);
		ResponseQuarterly res = new ResponseQuarterly();
 		res.setQdfir412(qdfirData);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet412DAO> data = sheet412Repository.findById(dataId);

		if (data.isPresent()) {
			sheet412Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet412DAO Data) throws ResourceNotFoundException {
        Optional<sheet412DAO> DataDb = sheet412Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet412DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setDescription(Data.getDescription());
            sheet412Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS412Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet412DAO data = sheet412Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS412Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public Boolean writesheet412(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir412DAO data) throws ResourceNotFoundException {
		qdfir412Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS412Data(data);
 		
 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir412DAO data = qdfir412Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

		ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS412Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir412DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir412DAO> DataDb = qdfir412Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir412DAO DataUpdate = DataDb.get();

				DataUpdate.setId(Data.getId());
				DataUpdate.setAmount(Data.getAmount());
				DataUpdate.setDescription(Data.getDescription());
				qdfir412Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS412Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	    }
	}

