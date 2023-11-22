package com.efass.sheet.mdfir1650;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet1650_Impl implements sheet1650_Service {

	@Autowired
	sheet1650Repository _1650Repository;

	@Autowired
	Qdfir1650Repo qdfir1650Repo;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1650XmlList() {
		return genericXmlList;
	}

	public void setSheet1650XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MMFBR1650 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet1650DAO data) throws ResourceNotFoundException {
		_1650Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1650Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1650DAO data) throws ResourceNotFoundException {
		qdfir1650Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1650Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1650DAO> data = null;
		Iterable<sheetQdfir1650DAO> qdfir1650DAOS = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1650";
			daoClass = sheet1650DAO.class;
			data = _1650Repository.findAll();

			data.forEach((e) -> {

                counter.getAndIncrement();
                result.add(String.valueOf(counter));

                result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
                result.add(e.getCustomer_name() == null ? "" : e.getCustomer_name());
                result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
                result.add(e.getRelationship_to_institution() == null ? "" : e.getRelationship_to_institution());
                result.add(e.getAmount_granted().toString() == null ? ".00"
                    : String.valueOf(e.getAmount_granted().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
                    ? String.valueOf(.00)
                    : e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                result.add(e.getExpiry_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
                    ? String.valueOf(.00)
                    : e.getExpiry_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                result.add(e.getTotal_outstanding_credit().toString() == null ? ".00"
                    : String.valueOf(e.getTotal_outstanding_credit().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getPerforming() == null ? "" : e.getPerforming());
                result.add(e.getNon_performing() == null ? "" : e.getNon_performing());
                result.add(e.getRate_of_interest().toString() == null ? ".00"
                    : String.valueOf(e.getRate_of_interest().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getNature() == null ? "" : e.getNature());
                result.add(e.getValue().toString() == null ? ".00"
                    : String.valueOf(e.getValue().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getDate_of_valuation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    .toString() == null ? String.valueOf(.00)
                    : e.getDate_of_valuation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    .toString());
                result.add(e.getAmount().toString() == null ? ".00"
                    : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getRemarks() == null ? ".00"
                    : String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));

			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet1650XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1650(data);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1650";
			daoClass = sheetQdfir1650DAO.class;
			qdfir1650DAOS = qdfir1650Repo.findAll();

			qdfir1650DAOS.forEach((e) -> {

				try {
					// System.out.println("i am here 161");
					counter.getAndIncrement();
					result.add(String.valueOf(counter));

					result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
					result.add(e.getCustomer_name() == null ? "" : e.getCustomer_name());
					result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
					result.add(e.getRelationship_to_institution() == null ? "" : e.getRelationship_to_institution());
					result.add(e.getAmount_granted().toString() == null ? ".00"
							: String.valueOf(e.getAmount_granted().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
							? String.valueOf(.00)
							: e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
					result.add(e.getExpiry_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
							? String.valueOf(.00)
							: e.getExpiry_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
					result.add(e.getTotal_outstanding_credit().toString() == null ? ".00"
							: String.valueOf(e.getTotal_outstanding_credit().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getPerforming() == null ? "" : e.getPerforming());
					result.add(e.getNon_performing() == null ? "" : e.getNon_performing());
					result.add(e.getRate_of_interest().toString() == null ? ".00"
							: String.valueOf(e.getRate_of_interest().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getNature() == null ? "" : e.getNature());
					result.add(e.getValue().toString() == null ? ".00"
							: String.valueOf(e.getValue().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getDate_of_valuation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
							.toString() == null ? String.valueOf(.00)
									: e.getDate_of_valuation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
											.toString());
					result.add(e.getAmount().toString() == null ? ".00"
							: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? ".00"
							: String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));
				}

				catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet1650XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1650(qdfir1650DAOS);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1650DAO data = _1650Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1650Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1650DAO data = qdfir1650Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1650Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
		Optional<sheet1650DAO> data = _1650Repository.findById(dataId);

		if (data.isPresent()) {
			_1650Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir1650DAO> data = qdfir1650Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1650Repo.delete(data.get());
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

	public ResponseEntity<?> updateData(int id, sheet1650DAO Data) throws ResourceNotFoundException {

		Optional<sheet1650DAO> DataDb = _1650Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1650DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setAccount_number(Data.getAccount_number());
			DataUpdate.setRelationship_to_institution(Data.getRelationship_to_institution());
			DataUpdate.setAmount_granted(Data.getAmount_granted());
			DataUpdate.setDate_granted(Data.getDate_granted());
			DataUpdate.setExpiry_date(Data.getExpiry_date());
			DataUpdate.setTotal_outstanding_credit(Data.getTotal_outstanding_credit());
			DataUpdate.setPerforming(Data.getPerforming());
			DataUpdate.setNon_performing(Data.getNon_performing());
			DataUpdate.setRate_of_interest(Data.getRate_of_interest());
			DataUpdate.setNature(Data.getNature());
			DataUpdate.setValue(Data.getValue());
			DataUpdate.setDate_of_valuation(Data.getDate_of_valuation());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setRemarks(Data.getRemarks());

			_1650Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1650Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1650DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1650DAO> DataDb = Optional.empty();

		if (DataDb.isPresent()) {
			sheetQdfir1650DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setAccount_number(Data.getAccount_number());
			DataUpdate.setRelationship_to_institution(Data.getRelationship_to_institution());
			DataUpdate.setAmount_granted(Data.getAmount_granted());
			DataUpdate.setDate_granted(Data.getDate_granted());
			DataUpdate.setExpiry_date(Data.getExpiry_date());
			DataUpdate.setTotal_outstanding_credit(Data.getTotal_outstanding_credit());
			DataUpdate.setPerforming(Data.getPerforming());
			DataUpdate.setNon_performing(Data.getNon_performing());
			DataUpdate.setRate_of_interest(Data.getRate_of_interest());
			DataUpdate.setNature(Data.getNature());
			DataUpdate.setValue(Data.getValue());
			DataUpdate.setDate_of_valuation(Data.getDate_of_valuation());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setRemarks(Data.getRemarks());

			qdfir1650Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1650Data(DataUpdate);
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
