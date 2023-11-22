package com.efass.sheet.mdfir193;

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
public class sheet193_Impl implements sheet193_Service {

	@Autowired
	sheet193Repository _193Repository;

	@Autowired
	Qdfir193Repo qdfir193Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet193XmlList() {
		return genericXmlList;
	}

	public void setSheet193XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MMFBR193 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet193DAO data) throws ResourceNotFoundException {
		_193Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS193Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir193DAO data) throws ResourceNotFoundException {
		qdfir193Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS193Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet193DAO> data = null;
		Iterable<sheetQdfir193DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR193";
			daoClass = sheet193DAO.class;
			data = _193Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getDescription() == null ? "" : e.getDescription());
				result.add(e.getAmount_current_month().toString() == null ? ".00"
						: String.valueOf(e.getAmount_current_month().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAmount_year_to_date().toString() == null ? ".00"
						: String.valueOf(e.getAmount_year_to_date().setScale(2, RoundingMode.HALF_EVEN)));
			});

			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isSpecial(false)
					.isIdPresent(true).build());

			setSheet193XmlList(genericXmls);
			Response res = new Response();
			res.setSheet193(data);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR193";
			daoClass = sheetQdfir193DAO.class;
			qdfirData = qdfir193Repo.findAll();

			qdfirData.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getDescription() == null ? "" : e.getDescription());
				result.add(e.getAmount_current_month().toString() == null ? ".00"
						: String.valueOf(e.getAmount_current_month().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAmount_year_to_date().toString() == null ? ".00"
						: String.valueOf(e.getAmount_year_to_date().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isSpecial(false)
					.isIdPresent(true).build());

			setSheet193XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir193(qdfirData);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet193DAO data = _193Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS193Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir193DAO data = qdfir193Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS193Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet193DAO> data = _193Repository.findById(dataId);

			if (data.isPresent()) {
				_193Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir193DAO> data = qdfir193Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir193Repo.delete(data.get());
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

	public ResponseEntity<?> updateData(int id, sheet193DAO Data) throws ResourceNotFoundException {

		Optional<sheet193DAO> DataDb = _193Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet193DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setDescription(Data.getDescription());
			DataUpdate.setAmount_current_month(Data.getAmount_current_month());
			DataUpdate.setAmount_year_to_date(Data.getAmount_year_to_date());

			_193Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS193Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir193DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir193DAO> DataDb = qdfir193Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir193DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setDescription(Data.getDescription());
			DataUpdate.setAmount_current_month(Data.getAmount_current_month());
			DataUpdate.setAmount_year_to_date(Data.getAmount_year_to_date());

			qdfir193Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS193Data(DataUpdate);
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
