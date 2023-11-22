package com.efass.sheet.mdfir300;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.report.ReportRepository;
import com.efass.report.ReportResponse;
import com.efass.sheet.mdfir291.sheet291DAO;
import com.efass.sheet.mdfir291.sheetQdfir291DAO;
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
public class sheet300_Impl implements sheet300_Service {

	@Autowired
	Qdfir300Repo qdfir300Repo;
	@Autowired
	sheet300Repository _300Repository;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet300XmlList() {
		return genericXmlList;
	}

	public void setSheet300XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MMFBR300 CRUD OPERATIONS
	// #################################

	@SuppressWarnings("unchecked")
	public ResponseEntity<?> fetchAllData() {

		Iterable<sheet300DAO> data = null;
		Iterable<sheetQdfir300DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		List<String> codes = new ArrayList<>();
		System.out.println(data);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR300";
            daoClass = sheet300DAO.class;
			data = _300Repository.findAll();

			data.forEach((e) -> {
				codes.add(e.getCode() == null ? "" :e.getCode());
				result.add(e.getAmount() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));

			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.isSpecial(true)
							.isSkipRows(false)
	            .daoClass(daoClass)
					.reportName(reportName)
					.codes(codes)
					.genericXmls(genericXmls)
					.prefix("")
					.result(result)
					.build());
			setSheet300XmlList(genericXmls);
			Response res = new Response();
			res.setSheet300(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR300";
            daoClass = sheetQdfir300DAO.class;

			qdfirData = qdfir300Repo.findAll();

			qdfirData.forEach((e) -> 
			{
				try {
        			
				codes.add(e.getCode() == null ? "" :e.getCode());
				result.add(e.getAmount() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
			}
 			 catch(NullPointerException ex) 
 	            {
 	    			System.out.println("NullPointerException thrown!");
 	            }
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.isSpecial(true)
							.isSkipRows(false)
	            .daoClass(daoClass)
					.reportName(reportName)
					.codes(codes)
					.genericXmls(genericXmls)
					.prefix("")
					.result(result)
					.build());
			setSheet300XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir300(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
        }
		return null;
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet300DAO data = _300Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS300Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> updateData(int id, sheet300DAO Data) throws ResourceNotFoundException {

		Optional<sheet300DAO> DataDb = _300Repository.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheet300DAO DataUpdate = DataDb.get();

			DataUpdate.setAmount(Data.getAmount());
			_300Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS300Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getCode());
		}
	}

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir300DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir300DAO> DataDb = qdfir300Repo.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheetQdfir300DAO DataUpdate = DataDb.get();

			DataUpdate.setAmount(Data.getAmount());
			qdfir300Repo.save(DataUpdate);
			
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS300Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getCode());
		}
	}


}
