package com.efass.sheet.mdfir292_3;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir292_1.sheet292_1DAO;
import com.efass.sheet.mdfir292_1.sheetQdfir292_1DAO;
import com.efass.sheet.mdfir292_2.sheet292_2DAO;
import com.efass.sheet.mdfir292_2.sheetQdfir292_2DAO;
import com.efass.sheet.mdfir321.sheet321DAO;
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
public class sheet292_3_Impl implements sheet292_3_Service{

	@Autowired
	Qdfir292_3Repo qdfir292_3Repo;
    @Autowired
    sheet292_3Repository sheet292_3Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet292_3XmlList() {
		return genericXmlList;
	}

	public void setSheet292_3XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR292_3 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet292_3DAO data) throws ResourceNotFoundException {

 		int length = sheet292_3Repository.getid();
 		length = length + 1;
 		data.setId(length);
		sheet292_3Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS292_3Data(data);


 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet292_3DAO> data = null;
		 Iterable<sheetQdfir292_3DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR292";
            daoClass = sheet292_3DAO.class;
			data = sheet292_3Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getDerivative_financial_liabilities() == null ? "" : e.getDerivative_financial_liabilities());
				result.add(e.getNotional_amount().toString() == null ? ".00" : String.valueOf(e.getNotional_amount().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getCarrying_value().toString() == null ? ".00" : String.valueOf(e.getCarrying_value().setScale(2, RoundingMode.HALF_EVEN)));

			});
			
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.genericXmls(genericXmls)
					.prefix(".T3")
					.result(result)
	            .daoClass(daoClass)
					.reportName(reportName)
					.isNoneSpecialWithPrefix(true)
					.isIdPresent(true)
					.build());
			setSheet292_3XmlList(genericXmls);
			Response res = new Response();
	 		res.setSheet292_3(data);
	 		res.setResponseMessage("Success");
	 		res.setResponseCode(00);
	 		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR292";
            daoClass = sheetQdfir292_3DAO.class;
			qdfirData = qdfir292_3Repo.findAll();

			qdfirData.forEach((e) -> 
			{
				try {
        			
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getDerivative_financial_liabilities() == null ? "" : e.getDerivative_financial_liabilities());
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
		setSheet292_3XmlList(genericXmls);
		ResponseQuarterly res = new ResponseQuarterly();
 		res.setQdfir292_3(qdfirData);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet292_3DAO> data = sheet292_3Repository.findById(dataId);

		if (data.isPresent()) {
			sheet292_3Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet292_3DAO Data) throws ResourceNotFoundException {
        Optional<sheet292_3DAO> DataDb = sheet292_3Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet292_3DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCarrying_value(Data.getCarrying_value());
			DataUpdate.setDerivative_financial_liabilities(Data.getDerivative_financial_liabilities());
			DataUpdate.setNotional_amount(Data.getNotional_amount());

            sheet292_3Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS292_3Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet292_3DAO data = sheet292_3Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS292_3Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir292_3DAO data) throws ResourceNotFoundException {
		int length = qdfir292_3Repo.getid();
 		length = length + 1;
 		data.setId(length);
 		
		qdfir292_3Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS292_3Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir292_3DAO data = qdfir292_3Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS292_3Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir292_3DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir292_3DAO> DataDb = qdfir292_3Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir292_3DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCarrying_value(Data.getCarrying_value());
			DataUpdate.setDerivative_financial_liabilities(Data.getDerivative_financial_liabilities());
			DataUpdate.setNotional_amount(Data.getNotional_amount());

			qdfir292_3Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS292_3Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }
}

