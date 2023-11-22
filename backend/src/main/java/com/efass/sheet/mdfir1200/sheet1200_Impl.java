package com.efass.sheet.mdfir1200;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.report.ReportResponse;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir1000.sheetQdfir1000DAO;
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
public class sheet1200_Impl implements sheet1200_Service {
	@Autowired
	sheet1200Repository sheet1200Repository;

	@Autowired
	Qdfir1200Repo qdfir1200Repo;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1200XmlList() {
		return genericXmlList;
	}

	public void setSheet1200XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}
// ############################## MDFIR1200 CRUD OPERATIONS #################################

	@Override
	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1200DAO> data = null;
		Iterable<sheetQdfir1200DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> codes = new ArrayList<>();
		List<String> result = new ArrayList<>();

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1200";
			daoClass = sheet1200DAO.class;
			data = sheet1200Repository.findAll();

			data.forEach((e) -> {
				codes.add(e.getCode() == null ? "" : e.getCode());
				// result.add(e.getItem_description()== null ? "" : e.getItem_description());
				result.add(e.getFrom_1_to_100000().toString() == null ? ".00"
						: String.valueOf(e.getFrom_1_to_100000().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getFrom_100001_to_200000().toString() == null ? ".00"
						: String.valueOf(e.getFrom_100001_to_200000().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getFrom_200001_to_500000().toString() == null ? ".00"
						: String.valueOf(e.getFrom_200001_to_500000().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getOver_500000().toString() == null ? ".00"
						: String.valueOf(e.getOver_500000().setScale(2, RoundingMode.HALF_EVEN)));
			});
			
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().isSpecialWithPrefix(true).prefix(".T0").daoClass(daoClass)
					.reportName(reportName).isSkipRows(false).result(result).genericXmls(genericXmls).codes(codes).build());
			setSheet1200XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1200(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1200";
			daoClass = sheetQdfir1200DAO.class;
			qdfirData = qdfir1200Repo.findAll();

			qdfirData.forEach((e) -> {
				codes.add(e.getCode() == null ? "" : e.getCode());
				// result.add(e.getItem_description()== null ? "" : e.getItem_description());
				result.add(e.getFrom_1_to_100000().toString() == null ? ".00"
						: String.valueOf(e.getFrom_1_to_100000().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getFrom_100001_to_200000().toString() == null ? ".00"
						: String.valueOf(e.getFrom_100001_to_200000().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getFrom_200001_to_500000().toString() == null ? ".00"
						: String.valueOf(e.getFrom_200001_to_500000().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getOver_500000().toString() == null ? ".00"
						: String.valueOf(e.getOver_500000().setScale(2, RoundingMode.HALF_EVEN)));
			});
			
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().isSpecialWithPrefix(true).prefix(".T0").daoClass(daoClass)
					.reportName(reportName).isSkipRows(false).result(result).genericXmls(genericXmls).codes(codes).build());
			setSheet1200XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1200(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
		
	}

	@Override
	public ResponseEntity<?> updateData(int id, sheet1200DAO Data) throws ResourceNotFoundException {
		// validate(Data);

		Optional<sheet1200DAO> DataDb = sheet1200Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1200DAO DataUpdate = DataDb.get();
			DataUpdate.setFrom_1_to_100000(Data.getFrom_1_to_100000());
			DataUpdate.setFrom_100001_to_200000(Data.getFrom_100001_to_200000());
			DataUpdate.setFrom_200001_to_500000(Data.getFrom_100001_to_200000());
			DataUpdate.setOver_500000(Data.getOver_500000());
			// DataUpdate.setCreate_dt(LocalDate.now());
			sheet1200Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1200Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1200DAO Data) throws ResourceNotFoundException {
		// validate(Data);

		Optional<sheetQdfir1200DAO> DataDb = qdfir1200Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1200DAO DataUpdate = DataDb.get();
			DataUpdate.setFrom_1_to_100000(Data.getFrom_1_to_100000());
			DataUpdate.setFrom_100001_to_200000(Data.getFrom_100001_to_200000());
			DataUpdate.setFrom_200001_to_500000(Data.getFrom_100001_to_200000());
			DataUpdate.setOver_500000(Data.getOver_500000());
			// DataUpdate.setCreate_dt(LocalDate.now());
			qdfir1200Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1200Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1200DAO data = sheet1200Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1200Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1200DAO data = qdfir1200Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1200Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
