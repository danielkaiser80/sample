package com.efass.sheet.mdfir292_2;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir292_1.sheet292_1DAO;
import com.efass.sheet.mdfir292_1.sheetQdfir292_1DAO;
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
public class sheet292_2_Impl implements sheet292_2_Service{

	@Autowired
	Qdfir292_2Repo qdfir292_2Repo;
    @Autowired
    private sheet292_2Repository sheet292_2Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet292_2XmlList() {
		return genericXmlList;
	}

	public void setSheet292_2XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}



	// ############################## MDFIR292_2 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet292_2DAO data) throws ResourceNotFoundException {

 		int length = sheet292_2Repository.getid();
 		length = length + 1;
 		data.setId(length);
		sheet292_2Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS292_2Data(data);


 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet292_2DAO> data = null;
		 Iterable<sheetQdfir292_2DAO>qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR292";
            daoClass = sheet292_2DAO.class;
			data = sheet292_2Repository.findAll();

			data.forEach((e) -> 
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

        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
				.genericXmls(genericXmls)
				.prefix(".T2")
				.result(result)
            .daoClass(daoClass)
				.reportName(reportName)
				.isNoneSpecialWithPrefix(true)
				.isIdPresent(true)
				.build());
		setSheet292_2XmlList(genericXmls);

		Response res = new Response();

 		res.setSheet292_2(data);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR292";
            daoClass = sheetQdfir292_2DAO.class;
			qdfirData = qdfir292_2Repo.findAll();

			qdfirData.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getDerivative_financial_liabilities() == null ? "" : e.getDerivative_financial_liabilities());
				result.add(e.getNotional_amount().toString() == null ? ".00" : String.valueOf(e.getNotional_amount().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getCarrying_value().toString() == null ? ".00" : String.valueOf(e.getCarrying_value().setScale(2, RoundingMode.HALF_EVEN)));

			});
        }
		GenericXml.writeIntoXmlFormat(XmlParameters.builder()
				.genericXmls(genericXmls)
				.prefix(".T2")
				.result(result)
            .daoClass(daoClass)
				.reportName(reportName)
				.isNoneSpecialWithPrefix(true)
				.isIdPresent(true)
				.build());
		setSheet292_2XmlList(genericXmls);

		ResponseQuarterly res = new ResponseQuarterly();

 		res.setQdfir292_2(qdfirData);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet292_2DAO> data = sheet292_2Repository.findById(dataId);

		if (data.isPresent()) {
			sheet292_2Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet292_2DAO Data) throws ResourceNotFoundException {
        Optional<sheet292_2DAO> DataDb = sheet292_2Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet292_2DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCarrying_value(Data.getCarrying_value());
			DataUpdate.setDerivative_financial_liabilities(Data.getDerivative_financial_liabilities());
			DataUpdate.setNotional_amount(Data.getNotional_amount());

            sheet292_2Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS292_2Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet292_2DAO data = sheet292_2Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS292_2Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir292_2DAO data) throws ResourceNotFoundException {
		int length = qdfir292_2Repo.getid();
 		length = length + 1;
 		data.setId(length);
 		
		qdfir292_2Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS292_2Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir292_2DAO data = qdfir292_2Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS292_2Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir292_2DAO Data) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
