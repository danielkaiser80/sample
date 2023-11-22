
package com.efass.sheet.mdfir321;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.sheet.mdfir291.sheet291DAO;
import com.efass.sheet.mdfir291.sheetQdfir291DAO;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;

@Service
public class sheet321_Impl implements sheet321_Service {

	@Autowired
	sheet321Repository _321Repository;

	@Autowired
	Qdfir321Repo qdfir321Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet321XmlList() {
		return genericXmlList;
	}

	public void setSheet321XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MMFBR311 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet321DAO data) throws ResourceNotFoundException {

		_321Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS321Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir321DAO data) throws ResourceNotFoundException {
		qdfir321Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS321Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet321DAO> data = null;
		Iterable<sheetQdfir321DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR321";
			daoClass = sheet321DAO.class;
			data = _321Repository.findAll();

			data.forEach((e) -> {
				try {
					// System.out.println("i am here 321");

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getBankName() == null ? "" : e.getBankName());
					result.add(e.getBankCode() == null ? "" : e.getBankCode());
					result.add(e.getTypeOfPlacements() == null ? "" : e.getTypeOfPlacements());
					result.add(e.getAccountNumber() == null ? "" : e.getAccountNumber());
					result.add(e.getAmount().toString() == null ? ".00"
							: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAmount2().toString() == null ? ".00"
							: String.valueOf(e.getAmount2().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTenor() == null ? "" : e.getTenor());
                    result.add(e.getEffectiveDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
                        ? String.valueOf(.00)
                        : e.getEffectiveDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getMaturityDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
                        ? String.valueOf(.00)
                        : e.getMaturityDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
					result.add(e.getUpfrontInterestReceived().toString() == null ? ".00"
							: String.valueOf(e.getUpfrontInterestReceived().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAccruedInterestReceivable().toString() == null ? ".00"
							: String.valueOf(e.getAccruedInterestReceivable().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTimes_rolled_over().toString() == null ? ".00"
                        : String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getRemarks() == null ? "" : e.getRemarks());
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet321XmlList(genericXmls);
			Response res = new Response();
			res.setSheet321(data);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR321";
			daoClass = sheetQdfir321DAO.class;
			qdfirData = qdfir321Repo.findAll();

			qdfirData.forEach((e) -> {
				try {
					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getBankName() == null ? "" : e.getBankName());
					result.add(e.getBankCode() == null ? "" : e.getBankCode());
					result.add(e.getTypeOfPlacements() == null ? "" : e.getTypeOfPlacements());
					result.add(e.getAccountNumber() == null ? "" : e.getAccountNumber());
					result.add(e.getAmount().toString() == null ? ".00"
							: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAmount2().toString() == null ? ".00"
							: String.valueOf(e.getAmount2().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTenor() == null ? "" : e.getTenor());
					result.add(e.getEffectiveDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
							? String.valueOf(.00)
							: e.getEffectiveDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
					result.add(e.getMaturityDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
							? String.valueOf(.00)
							: e.getMaturityDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
					result.add(e.getInterestRate().toString() == null ? ".00"
							: String.valueOf(e.getInterestRate().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getUpfrontInterestReceived().toString() == null ? ".00"
							: String.valueOf(e.getUpfrontInterestReceived().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAccruedInterestReceivable().toString() == null ? ".00"
							: String.valueOf(e.getAccruedInterestReceivable().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTimes_rolled_over().toString() == null ? ".00"
							: String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? "" : e.getRemarks());
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet321XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir321(qdfirData);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet321DAO data = _321Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS321Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir321DAO data = qdfir321Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS321Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet321DAO> data = _321Repository.findById(dataId);

			if (data.isPresent()) {
				_321Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir321DAO> data = qdfir321Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir321Repo.delete(data.get());
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

	public ResponseEntity<?> updateData(int id, sheet321DAO Data) throws ResourceNotFoundException {

		Optional<sheet321DAO> DataDb = _321Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet321DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setTypeOfPlacements(Data.getTypeOfPlacements());
			DataUpdate.setAccountNumber(Data.getAccountNumber());

			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setAmount2(Data.getAmount2());
			DataUpdate.setTenor(Data.getTenor());
			DataUpdate.setEffectiveDate(Data.getEffectiveDate());
			DataUpdate.setMaturityDate(Data.getMaturityDate());
			DataUpdate.setInterestRate(Data.getInterestRate());
			DataUpdate.setUpfrontInterestReceived(Data.getUpfrontInterestReceived());
			DataUpdate.setAccruedInterestReceivable(Data.getAccruedInterestReceivable());
			DataUpdate.setRemarks(Data.getRemarks());
			_321Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS321Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir321DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir321DAO> DataDb = qdfir321Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir321DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setTypeOfPlacements(Data.getTypeOfPlacements());
			DataUpdate.setAccountNumber(Data.getAccountNumber());

			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setAmount2(Data.getAmount2());
			DataUpdate.setTenor(Data.getTenor());
			DataUpdate.setEffectiveDate(Data.getEffectiveDate());
			DataUpdate.setMaturityDate(Data.getMaturityDate());
			DataUpdate.setInterestRate(Data.getInterestRate());
			DataUpdate.setUpfrontInterestReceived(Data.getUpfrontInterestReceived());
			DataUpdate.setAccruedInterestReceivable(Data.getAccruedInterestReceivable());
			DataUpdate.setRemarks(Data.getRemarks());
			qdfir321Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS321Data(DataUpdate);
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
