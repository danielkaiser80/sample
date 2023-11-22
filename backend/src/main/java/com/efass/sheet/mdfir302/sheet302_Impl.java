package com.efass.sheet.mdfir302;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.report.ReportResponse;

import com.efass.sheet.mdfir291.sheet291DAO;
import com.efass.sheet.mdfir291.sheetQdfir291DAO;
import com.efass.sheet.mdfir423.sheet423DAO;
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
public class sheet302_Impl implements sheet302_Service {

	@Autowired
	Qdfir302Repo qdfir302Repo;
	@Autowired
	sheet302Repository sheet302Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet302XmlList() {
		return genericXmlList;
	}

	public void setSheet302XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	@Override
	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet302DAO> data = null;
		Iterable<sheetQdfir302DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		List<String> codes = new ArrayList<>();
		System.out.println(data);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR302";
			daoClass = sheet302DAO.class;
			data = sheet302Repository.findAll();

			data.forEach((e) -> {
				codes.add(e.getCode() == null ? "" : e.getCode());
				result.add(e.getAmount().toString() == null ? ".00"
						: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().isSpecial(true).prefix("").daoClass(daoClass)
					.reportName(reportName).result(result).genericXmls(genericXmls).codes(codes).build());
			setSheet302XmlList(genericXmls);
			Response res = new Response();
			res.setSheet302(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR302";
			daoClass = sheetQdfir302DAO.class;
			qdfirData = qdfir302Repo.findAll();

			qdfirData.forEach((e) -> {
				try {

					codes.add(e.getCode() == null ? "" : e.getCode());
					result.add(e.getAmount().toString() == null ? ".00"
							: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().isSpecial(true).prefix("").daoClass(daoClass)
					.reportName(reportName).result(result).genericXmls(genericXmls).codes(codes).build());
			setSheet302XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir302(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	@Override
	public ResponseEntity<?> updateData(int id, sheet302DAO Data) throws ResourceNotFoundException {

		Optional<sheet302DAO> DataDb = sheet302Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet302DAO DataUpdate = DataDb.get();
			DataUpdate.setAmount(Data.getAmount());
			sheet302Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS302Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir302DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir302DAO> DataDb = qdfir302Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir302DAO DataUpdate = DataDb.get();
			DataUpdate.setAmount(Data.getAmount());
			qdfir302Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS302Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet302DAO data = sheet302Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS302Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir302DAO data = qdfir302Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS302Data(data);
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
