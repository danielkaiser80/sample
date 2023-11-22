package com.efass.sheet.mdfir453;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir302.sheet302DAO;
import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.mdfir533.sheet533DAO;
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

@Service
public class sheet453_Impl implements sheet453_Service{

	@Autowired
	Qdfir453Repo qdfir453Repo;
    @Autowired
    sheet453Repository sheet453Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet453XmlList() {
		return genericXmlList;
	}

	public void setSheet453XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}


	// ############################## MDFIR453 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet453DAO data) throws ResourceNotFoundException {

		sheet453Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS453Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 		public ResponseEntity<?> fetchAllData() {

		Iterable<sheet453DAO> data = null;
		Iterable<sheetQdfir453DAO> qdfirData = null;
			List<GenericXml> genericXmls = new ArrayList<>();
			List<String> result = new ArrayList<>();
			List<String> codes = new ArrayList<>();

            String reportName = "";
            Class<?> daoClass = null;

            if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
                reportName = "MDFIR453";
                daoClass = sheet453DAO.class;
				data = sheet453Repository.findAll();

				data.forEach((e) -> {
					codes.add(e.getCode() == null ? "" :e.getCode());
					result.add(e.getCost().toString() == null ? ".00" :String.valueOf(e.getCost().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getImpairment().toString() == null ? ".00" :String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
//				result.add(e.getAmount() == null ? BigDecimal.ZERO.toString() : e.getAmount().toString());

				});
				
				GenericXml.writeIntoXmlFormat(XmlParameters.builder()
						.isSpecial(true)
						.prefix("")
						.isSkipRows(false)
						.daoClass(daoClass)
						.reportName(reportName)
						.result(result)
						.genericXmls(genericXmls)
						.codes(codes)
						.build());
				setSheet453XmlList(genericXmls);
			Response res = new Response();
			res.setSheet453(data);

			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
            }
            if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
                reportName = "QDFIR453";
                daoClass = sheetQdfir453DAO.class;
				qdfirData = qdfir453Repo.findAll();

				qdfirData.forEach((e) -> 
				{
					try {
	        			//System.out.println("i am here 453");
					codes.add(e.getCode() == null ? "" :e.getCode());
					result.add(e.getCost().toString() == null ? ".00" :String.valueOf(e.getCost().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getImpairment().toString() == null ? ".00" :String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
//				result.add(e.getAmount() == null ? BigDecimal.ZERO.toString() : e.getAmount().toString());
					}
					 catch(NullPointerException ex) 
			            {
			    			System.out.println("NullPointerException thrown!");
			            }	
				});
            }
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.isSpecial(true)
					.prefix("")
					.isSkipRows(false)
					.daoClass(daoClass)
					.reportName(reportName)
					.result(result)
					.genericXmls(genericXmls)
					.codes(codes)
					.build());
			setSheet453XmlList(genericXmls);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setQdfir453(qdfirData);

		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet453DAO> data = sheet453Repository.findById(dataId);

		if (data.isPresent()) {
			sheet453Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet453DAO Data) throws ResourceNotFoundException {
        Optional<sheet453DAO> DataDb = sheet453Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet453DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setDescription(Data.getDescription());
			DataUpdate.setCost(Data.getCost());
			DataUpdate.setImpairment(Data.getImpairment());
            sheet453Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS453Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet453DAO data = sheet453Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS453Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir453DAO data) throws ResourceNotFoundException 
	{
		qdfir453Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS453Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir453DAO data = qdfir453Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS453Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir453DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir453DAO> DataDb = qdfir453Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir453DAO DataUpdate = DataDb.get();

				DataUpdate.setId(Data.getId());
				DataUpdate.setDescription(Data.getDescription());
				DataUpdate.setCost(Data.getCost());
				DataUpdate.setImpairment(Data.getImpairment());
	            qdfir453Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS453Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}

 }
