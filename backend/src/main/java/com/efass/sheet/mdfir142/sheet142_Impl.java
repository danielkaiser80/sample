package com.efass.sheet.mdfir142;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir122.sheetQdfir122DAO;
import com.efass.sheet.mstdr2.sheetQstdr2DAO;
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

@Service
public class sheet142_Impl implements sheet142_Service{

    @Autowired
    sheet142Repository sheet142Repository;

	@Autowired
	Qdfir142Repo qdfir142Repo;

    @Autowired
    TabController tabController;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet142XmlList() {
		return genericXmlList;
	}

	public void setSheet142XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}


 // ############################## MDFIR142 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet142DAO data) throws ResourceNotFoundException {
 		int length = sheet142Repository.getid();
 		length = length + 1;
 		data.setId(length);
 		
		sheet142Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS142Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}
 	
 	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir142DAO data) throws ResourceNotFoundException {
 		int length = qdfir142Repo.getid();
 		length = length + 1;
 		data.setId(length);
		qdfir142Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS142Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

 	public ResponseEntity<?> fetchAllData() {

		Iterable<sheet142DAO> data = null;
		Iterable<sheetQdfir142DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR142";
            daoClass = sheet142DAO.class;
			data = sheet142Repository.findAll();

			data.forEach((e) -> {
				result.add(e.getBank_code()== null ? "":e.getBank_code());
				result.add(e.getBank_name()== null ? "":e.getBank_name());
				result.add(e.getAccount_number()== null ? "":e.getAccount_number());
				result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.genericXmls(genericXmls)
					.prefix("")
					.result(result)
	            .daoClass(daoClass)
					.reportName(reportName)
					.isNoneSpecialWithPrefix(true)
					.build());

			setSheet142XmlList(genericXmls);
			Response res = new Response();
			res.setSheet142(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR142";
            daoClass = sheetQdfir142DAO.class;
			qdfirData = qdfir142Repo.findAll();

			qdfirData.forEach((e) -> {
				result.add(e.getBank_code()== null ? "":e.getBank_code());
				result.add(e.getBank_name()== null ? "":e.getBank_name());
				result.add(e.getAccount_number()== null ? "":e.getAccount_number());
				result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.genericXmls(genericXmls)
					.prefix("")
					.result(result)
	            .daoClass(daoClass)
					.reportName(reportName)
					.isNoneSpecialWithPrefix(true)
					.build());

			setSheet142XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir142(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
        }
		return null;
		
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet142DAO> data = sheet142Repository.findById(dataId);

		if (data.isPresent()) {
			sheet142Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet142DAO Data) throws ResourceNotFoundException {
        Optional<sheet142DAO> DataDb = sheet142Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet142DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_name(Data.getBank_name());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setAccount_number(Data.getAccount_number());
            sheet142Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS142Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet142DAO data = sheet142Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS142Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir142DAO Data) throws ResourceNotFoundException {
		System.out.println("ID passed :" +id);
		 Optional<sheetQdfir142DAO> DataDb = qdfir142Repo.findById(id);
		 System.out.println("Data Related ToThe ID :" + DataDb.get().getId());
		 System.out.println("Data Related ToThe ID :" + DataDb.get().getAccount_number());
		 System.out.println("Data Related ToThe ID :" + DataDb.get().getBank_code());
		 System.out.println("Data Related ToThe ID :" + DataDb.get().getBank_name());
		 System.out.println("Data Related ToThe ID :" + DataDb.get().getAmount());
	        if (DataDb.isPresent()) {
	        	sheetQdfir142DAO DataUpdate = DataDb.get();

				DataUpdate.setId(Data.getId());
				DataUpdate.setAmount(Data.getAmount());
				DataUpdate.setBank_name(Data.getBank_name());
				DataUpdate.setBank_code(Data.getBank_code());
				DataUpdate.setAccount_number(Data.getAccount_number());
				qdfir142Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS142Data(DataUpdate);
	            System.out.println("Saved");
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
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
	public ResponseEntity<?> callPrepareTableProceduresQ(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
