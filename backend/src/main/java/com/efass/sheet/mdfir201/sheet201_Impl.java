package com.efass.sheet.mdfir201;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir192.sheet192DAO;
import com.efass.sheet.mdfir192.sheetQdfir192DAO;
import com.efass.sheet.mdfir321.sheet321DAO;
import com.efass.sheet.mdfir321.sheet321Repository;
import com.efass.sheet.mdfir321.sheet321_Service;
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
public class sheet201_Impl implements sheet201_Service {

	@Autowired
	Qdfir201Repo qdfir201Repo;

	@Autowired
	sheet201Repository _201Repository;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet201XmlList() {
		return genericXmlList;
	}

	public void setSheet201XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MMFBR201 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet201DAO data) throws ResourceNotFoundException {
		_201Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS201Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir201DAO data) throws ResourceNotFoundException {
		qdfir201Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS201Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet201DAO> data = null;
		Iterable<sheetQdfir201DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR201";
			daoClass = sheet201DAO.class;
			data = _201Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getBankName() == null ? "" : e.getBankName());
				result.add(e.getBankCode() == null ? "" : e.getBankCode());
				result.add(e.getType_of_balance() == null ? "" : e.getType_of_balance());
				result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
				result.add(e.getAmount().toString() == null ? ".00"
						: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRemarks()  == null ? "" : e.getRemarks());
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isSpecial(false)
					.isIdPresent(true).build());

			setSheet201XmlList(genericXmls);
			Response res = new Response();
			res.setSheet201(data);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR201";
			daoClass = sheetQdfir201DAO.class;
			qdfirData = qdfir201Repo.findAll();

			qdfirData.forEach((e) -> {
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getBankName() == null ? "" : e.getBankName());
					result.add(e.getBankCode() == null ? "" : e.getBankCode());
					result.add(e.getType_of_balance() == null ? "" : e.getType_of_balance());
					result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
					result.add(e.getAmount().toString() == null ? ".00"
							: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? "" : e.getRemarks());

				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isSpecial(false)
					.isIdPresent(true).build());

			setSheet201XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir201(qdfirData);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {

			sheet201DAO data = _201Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS201Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {

			sheetQdfir201DAO data = qdfir201Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS201Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet201DAO> data = _201Repository.findById(dataId);

			if (data.isPresent()) {
				_201Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir201DAO> data = qdfir201Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir201Repo.delete(data.get());
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

	public ResponseEntity<?> updateData(int id, sheet201DAO Data) throws ResourceNotFoundException {

			Optional<sheet201DAO> DataDb = _201Repository.findById(id);

			if (DataDb.isPresent()) {
				sheet201DAO DataUpdate = DataDb.get();
				DataUpdate.setId(Data.getId());
				DataUpdate.setAccount_number(Data.getAccount_number());
				DataUpdate.setBankName(Data.getBankName());
				DataUpdate.setBankCode(Data.getBankCode());
				DataUpdate.setAmount(Data.getAmount());
				DataUpdate.setType_of_balance(Data.getType_of_balance());
				DataUpdate.setRemarks(Data.getRemarks());

				_201Repository.save(DataUpdate);
				Response res = new Response();
				res.setResponseMessage("Record Updated");
				res.setResponseCode(00);
				res.setS201Data(DataUpdate);
				return new ResponseEntity<>(res, HttpStatus.OK);

			} else {
				throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
			}
		}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir201DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir201DAO> DataDb = qdfir201Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir201DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAccount_number(Data.getAccount_number());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setType_of_balance(Data.getType_of_balance());
			DataUpdate.setRemarks(Data.getRemarks());

			qdfir201Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS201Data(DataUpdate);
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
