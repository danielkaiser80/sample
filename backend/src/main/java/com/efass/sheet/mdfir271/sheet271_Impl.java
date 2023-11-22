package com.efass.sheet.mdfir271;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir192.sheet192DAO;
import com.efass.sheet.mdfir192.sheetQdfir192DAO;
import com.efass.sheet.mdfir250.sheet250DAO;
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
public class sheet271_Impl implements sheet271_Service {

	@Autowired
	Qdfir271Repo qdfir271Repo;
	@Autowired
	sheet271Repository sheet271Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet271XmlList() {
		return genericXmlList;
	}

	public void setSheet271XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}
// ############################## MDFIR271 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet271DAO data) throws ResourceNotFoundException {
		sheet271Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS271Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir271DAO data) throws ResourceNotFoundException {
		qdfir271Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS271Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet271DAO> data = null;
		Iterable<sheetQdfir271DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR271";
			daoClass = sheet271DAO.class;
			data = sheet271Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getBank_name() == null ? "" : e.getBank_name());
				result.add(e.getBank_code() == null ? "" : e.getBank_code());
				result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
				result.add(e.getAmount().toString() == null ? ".00"
						: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRemarks()  == null ? "" : e.getRemarks());
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());
			setSheet271XmlList(genericXmls);
			Response res = new Response();
			res.setSheet271(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR271";
			daoClass = sheetQdfir271DAO.class;
			qdfirData = qdfir271Repo.findAll();

			qdfirData.forEach((e) -> {
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getBank_name() == null ? "" : e.getBank_name());
					result.add(e.getBank_code() == null ? "" : e.getBank_code());
					result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
					result.add(e.getAmount().toString() == null ? ".00"
							: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? "" : e.getRemarks());
					// result.add(e.getRemarks() == null ?".00" :
					// String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());
			setSheet271XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir271(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet271DAO> data = sheet271Repository.findById(dataId);

			if (data.isPresent()) {
				sheet271Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir271DAO> data = qdfir271Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir271Repo.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> updateData(int id, sheet271DAO Data) throws ResourceNotFoundException {
		Optional<sheet271DAO> DataDb = sheet271Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet271DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_name(Data.getBank_name());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setAccount_number(Data.getAccount_number());
			sheet271Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS271Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir271DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir271DAO> DataDb = qdfir271Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir271DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_name(Data.getBank_name());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setAccount_number(Data.getAccount_number());
			qdfir271Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS271Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet271DAO data = sheet271Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS271Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir271DAO data = qdfir271Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS271Data(data);
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
