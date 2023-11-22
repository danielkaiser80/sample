package com.efass.sheet.mdfir192;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir182.sheetQdfir182DAO;
import com.efass.sheet.mdfir191.sheet191DAO;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;

@Service
public class sheet192_Impl implements sheet192_Service {

	@Autowired
	sheet192Repository _192Repository;

	@Autowired
	Qdfir192Repo qdfir192Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet192XmlList() {
		return genericXmlList;
	}

	public void setSheet192XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR192 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet192DAO data) throws ResourceNotFoundException {
		_192Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS192Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir192DAO data) throws ResourceNotFoundException {
		qdfir192Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS192Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {

		Iterable<sheet192DAO> data = null;
		Iterable<sheetQdfir192DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR192";
			daoClass = sheet192DAO.class;
			data = _192Repository.findAll();

			data.forEach((e) -> {
				result.add(e.getBankCode() == null ? "" : e.getBankCode());
				result.add(e.getBankName() == null ? "" : e.getBankName());
				result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
				result.add(e.getForeign_currency() == null ? "" : e.getForeign_currency());
				result.add(e.getRate_of_exchange().toString() == null ? ".00"
						: String.valueOf(e.getRate_of_exchange().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAmount().toString() == null ? ".00"
						: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).build());
			setSheet192XmlList(genericXmls);

			Response res = new Response();
			res.setSheet192(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR192";
			daoClass = sheetQdfir192DAO.class;
			qdfirData = qdfir192Repo.findAll();

			qdfirData.forEach((e) -> {
				result.add(e.getBankCode() == null ? "" : e.getBankCode());
				result.add(e.getBankName() == null ? "" : e.getBankName());
				result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
				result.add(e.getForeign_currency() == null ? "" : e.getForeign_currency());
				result.add(e.getRate_of_exchange().toString() == null ? ".00"
						: String.valueOf(e.getRate_of_exchange().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAmount().toString() == null ? ".00"
						: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).build());
			setSheet192XmlList(genericXmls);

			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir192(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet192DAO data = _192Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS192Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir192DAO data = qdfir192Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS192Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet192DAO> data = _192Repository.findById(dataId);

			if (data.isPresent()) {
				_192Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir192DAO> data = qdfir192Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir192Repo.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> updateData(int id, sheet192DAO Data) throws ResourceNotFoundException {
		Optional<sheet192DAO> DataDb = _192Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet192DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAccount_number(Data.getAccount_number());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setForeign_currency(Data.getForeign_currency());
			DataUpdate.setRate_of_exchange(Data.getRate_of_exchange());
			_192Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS192Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir192DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir192DAO> DataDb = qdfir192Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir192DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAccount_number(Data.getAccount_number());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setForeign_currency(Data.getForeign_currency());
			DataUpdate.setRate_of_exchange(Data.getRate_of_exchange());
			qdfir192Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS192Data(DataUpdate);
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
