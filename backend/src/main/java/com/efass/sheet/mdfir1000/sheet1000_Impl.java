package com.efass.sheet.mdfir1000;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir100.sheetQdfirDAO;
import com.efass.sheet.mdfir300.sheet300DAO;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class sheet1000_Impl implements sheet1000_Service{

	@Autowired 
	Qdfir1000Repo qdfir1000Repo;
	@Autowired
	sheet1000Repository sheet1000Repo;
    @Autowired
    TabController tabController;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1000XmlList() {
		return genericXmlList;
	}

	public void setSheet1000XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	public ResponseEntity<?> fetchAllData() {

		Iterable<sheet1000DAO> data = null;
		Iterable<sheetQdfir1000DAO> qdfir1000DAO = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> codes = new ArrayList<>();
		List<String> result = new ArrayList<>();


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR1000";
            daoClass = sheet1000DAO.class;
			data = sheet1000Repo.findAll();
            
			data.forEach((e) -> {
				codes.add(e.getCode()== null ? "" : e.getCode());

				result.add(e.getCurrenMonth() == null ? ".00" :String.valueOf(e.getCurrenMonth().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getYearToDate() == null ? ".00" :String.valueOf(e.getYearToDate().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.isSpecial(true)
					.prefix(".T0")
	                .daoClass(daoClass)
					.reportName(reportName)
					.isSkipRows(false)
					.result(result)
					.genericXmls(genericXmls)
					.codes(codes)
					.build());
			setSheet1000XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1000(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
        	
            reportName = "QDFIR1000";
            daoClass = sheetQdfir1000DAO.class;

            qdfir1000DAO = qdfir1000Repo.findAll();
			qdfir1000DAO.forEach((e) -> {
				codes.add(e.getCode()== null ? "" : e.getCode());

				result.add(e.getCurrenMonth() == null ? ".00" :String.valueOf(e.getCurrenMonth().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getYearToDate() == null ? ".00" :String.valueOf(e.getYearToDate().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.isSpecial(true)
					.prefix(".T0")
	                .daoClass(daoClass)
					.reportName(reportName)
					.isSkipRows(false)
					.result(result)
					.genericXmls(genericXmls)
					.codes(codes)
					.build());
			setSheet1000XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1000(qdfir1000DAO);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
        }
		return null;
		
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet1000DAO data = sheet1000Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS1000Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir1000DAO data = qdfir1000Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS1000Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> updateData(int id, sheet1000DAO Data) throws ResourceNotFoundException {

		Optional<sheet1000DAO> DataDb = sheet1000Repo.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheet1000DAO DataUpdate = DataDb.get();
			DataUpdate.setCurrenMonth(Data.getCurrenMonth());
			DataUpdate.setYearToDate(Data.getYearToDate());

			sheet1000Repo.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1000Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1000DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1000DAO> DataDb = qdfir1000Repo.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheetQdfir1000DAO DataUpdate = DataDb.get();
			DataUpdate.setCurrenMonth(Data.getCurrenMonth());
			DataUpdate.setYearToDate(Data.getYearToDate());

			qdfir1000Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1000Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}



	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}



