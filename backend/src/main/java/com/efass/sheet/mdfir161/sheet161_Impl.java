package com.efass.sheet.mdfir161;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir142.sheetQdfir142DAO;
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
public class sheet161_Impl implements sheet161_Service{

    @Autowired
    sheet161Repository sheet161Repository;

	@Autowired
	Qdfir161Repo qdfir161Repo;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet161XmlList() {
		return genericXmlList;
	}

	public void setSheet161XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}
// ############################## MDFIR161 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet161DAO data) throws ResourceNotFoundException {

 		int length = sheet161Repository.getid();
 		length = length + 1;
 		data.setId(length);
 		sheet161Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS161Data(data);
 		
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet161DAO> data = null;
 		Iterable<sheetQdfir161DAO> qdfirData = null;
 		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR161";
            daoClass = sheet161DAO.class;
			data = sheet161Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getBank_name() == null ? "" :e.getBank_name());
				result.add(e.getBank_code() == null ? "" :e.getBank_code());
				result.add(e.getType_of_balance()== null ? "" : e.getType_of_balance());
				result.add(e.getAccount_number()== null ? "" :e.getAccount_number());
				result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRemarks()== null ? "" : e.getRemarks());

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

			setSheet161XmlList(genericXmls);
	 		Response res = new Response();
	 		res.setSheet161(data);
	 		res.setResponseMessage("Success");
	 		res.setResponseCode(00);
	 		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR161";
            daoClass = sheetQdfir161DAO.class;
			qdfirData = qdfir161Repo.findAll();

			qdfirData.forEach((e) -> 
			{
				try {
	    			
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getBank_name() == null ? "" :e.getBank_name());
				result.add(e.getBank_code() == null ? "" :e.getBank_code());
				result.add(e.getType_of_balance()== null ? "" : e.getType_of_balance());
				result.add(e.getAccount_number()== null ? "" :e.getAccount_number());
				result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRemarks().toString() == null ? "" : e.getRemarks());
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

			setSheet161XmlList(genericXmls);
	 		ResponseQuarterly res = new ResponseQuarterly();
	 		res.setQdfir161(qdfirData);
	 		res.setResponseMessage("Success");
	 		res.setResponseCode(00);
	 		return new ResponseEntity<>(res, HttpStatus.OK);
        }
		return null;
		
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet161DAO> data = sheet161Repository.findById(dataId);

		if (data.isPresent()) {
			sheet161Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet161DAO Data) throws ResourceNotFoundException {
        Optional<sheet161DAO> DataDb = sheet161Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet161DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_name(Data.getBank_name());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setAccount_number(Data.getAccount_number());
            sheet161Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS161Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet161DAO data = sheet161Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS161Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir161DAO data) throws ResourceNotFoundException {
 		
 		int length = qdfir161Repo.getid();
 		length = length + 1;
 		data.setId(length);
 		qdfir161Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS161Data(data);

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
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir161DAO Data) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> callPrepareTableProceduresQ(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
