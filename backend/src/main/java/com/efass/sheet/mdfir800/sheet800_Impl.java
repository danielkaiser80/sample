package com.efass.sheet.mdfir800;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.mdfir700.sheet700DAO;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;

@Service
public class sheet800_Impl implements sheet800_Service {

	@Autowired
	sheet800Repository sheet800Repo;

	@Autowired Qdfir800Repo qdfir800Repo;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet800XmlList() {
		return genericXmlList;
	}

	public void setSheet800XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}
// ############################## MMFBR800 CRUD OPERATIONS #################################


	public ResponseEntity<?> fetchAllData() {

		Iterable<sheet800DAO> data = null;
		Iterable<sheetQdfir800DAO> qdfir800DAOS = null;

		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		List<String> codes = new ArrayList<>();
		System.out.println(data);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR800";
            daoClass = sheet800DAO.class;
			data = sheet800Repo.findAll();


			data.forEach((e) -> {
				codes.add(e.getCode()== null ? "" :e.getCode());
				result.add(e.getDemand().toString() == null ? ".00" :String.valueOf(e.getDemand().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getSaving().toString() == null ? ".00" :String.valueOf(e.getSaving().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getUp_to_90_days().toString() == null ? ".00" :String.valueOf(e.getUp_to_90_days().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getSchedule_91_to_180_days().toString() == null ? ".00" :String.valueOf(e.getSchedule_91_to_180_days().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getSchedule_181_to_365_days().toString() == null ? ".00" :String.valueOf(e.getSchedule_181_to_365_days().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getOver_365_days().toString() == null ? ".00" :String.valueOf(e.getOver_365_days().setScale(2, RoundingMode.HALF_EVEN)));

			});
			
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.isSpecial(true)
					.prefix(".T0")
					.isSkipRows(false)
					.daoClass(daoClass)
					.reportName(reportName)
					.result(result)
					.genericXmls(genericXmls)
					.codes(codes)
					.build());
			setSheet800XmlList(genericXmls);
			Response res = new Response();
			res.setSheet800(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
       
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR800";
            daoClass = sheetQdfir800DAO.class;
			qdfir800DAOS = qdfir800Repo.findAll();


			qdfir800DAOS.forEach((e) -> 
			{
				try {
        			//System.out.println("i am here 800");
				codes.add(e.getCode()== null ? "" :e.getCode());
				result.add(e.getDemand().toString() == null ? ".00" :String.valueOf(e.getDemand().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getSaving().toString() == null ? ".00" :String.valueOf(e.getSaving().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getUp_to_90_days().toString() == null ? ".00" :String.valueOf(e.getUp_to_90_days().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getSchedule_91_to_180_days().toString() == null ? ".00" :String.valueOf(e.getSchedule_91_to_180_days().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getSchedule_181_to_365_days().toString() == null ? ".00" :String.valueOf(e.getSchedule_181_to_365_days().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getOver_365_days().toString() == null ? ".00" :String.valueOf(e.getOver_365_days().setScale(2, RoundingMode.HALF_EVEN)));
				}
				 catch(NullPointerException ex) 
			            {
			    			System.out.println("NullPointerException thrown!");
			            }	
			});
    	
        }
		GenericXml.writeIntoXmlFormat(XmlParameters.builder()
				.isSpecial(true)
				.prefix(".T0")
				.isSkipRows(false)
				.daoClass(daoClass)
				.reportName(reportName)
				.result(result)
				.genericXmls(genericXmls)
				.codes(codes)
				.build());
		setSheet800XmlList(genericXmls);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setQdfir800(qdfir800DAOS);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet800DAO data = sheet800Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS800Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> updateData(int id, sheet800DAO Data) throws ResourceNotFoundException {

		Optional<sheet800DAO> DataDb = sheet800Repo.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheet800DAO DataUpdate = DataDb.get();
			DataUpdate.setDescription(Data.getDescription());
            DataUpdate.setDemand(Data.getDemand());
            DataUpdate.setSaving(Data.getSaving());
            DataUpdate.setUp_to_90_days(Data.getUp_to_90_days());
            DataUpdate.setSchedule_91_to_180_days(Data.getSchedule_91_to_180_days());
            DataUpdate.setSchedule_181_to_365_days(Data.getSchedule_181_to_365_days());
            DataUpdate.setOver_365_days(Data.getOver_365_days());
            sheet800Repo.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS800Data(DataUpdate);
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
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir800DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir800DAO> DataDb = qdfir800Repo.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheetQdfir800DAO DataUpdate = DataDb.get();
			DataUpdate.setDescription(Data.getDescription());
            DataUpdate.setDemand(Data.getDemand());
            DataUpdate.setSaving(Data.getSaving());
            DataUpdate.setUp_to_90_days(Data.getUp_to_90_days());
            DataUpdate.setSchedule_91_to_180_days(Data.getSchedule_91_to_180_days());
            DataUpdate.setSchedule_181_to_365_days(Data.getSchedule_181_to_365_days());
            DataUpdate.setOver_365_days(Data.getOver_365_days());
            qdfir800Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS800Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getCode());
		}
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir800DAO data = qdfir800Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS800Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
