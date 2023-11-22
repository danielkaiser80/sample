package com.efass.sheet.mdfir223;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir192.sheet192DAO;
import com.efass.sheet.mdfir192.sheetQdfir192DAO;
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
public class sheet223_Impl implements sheet223_Service {

	@Autowired
	sheet223Repository sheet223Repository;

	@Autowired
	Qdfir223Repo qdfir223Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet223XmlList() {
		return genericXmlList;
	}

	public void setSheet223XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR223 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet223DAO data) throws ResourceNotFoundException {
		sheet223Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS223Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir223DAO data) throws ResourceNotFoundException {
		qdfir223Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS223Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet223DAO> data = null;
		Iterable<sheetQdfir223DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR223";
			daoClass = sheet223DAO.class;
			data = sheet223Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));

				result.add(e.getInvestee_name() == null ? "" : e.getInvestee_name());
				result.add(e.getType_of_investment() == null ? "" : e.getType_of_investment());
				result.add(e.getInvestement_cert_number() == null ? "" : e.getInvestement_cert_number());
				result.add(e.getAmount_invested().toString() == null ? ".00"
						: String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getFair_value_gain_or_loss().toString() == null ? ".00"
						: String.valueOf(e.getFair_value_gain_or_loss().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getImpairment().toString() == null ? ".00"
						: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getCarrying_amt_quoted_eq_inv().toString() == null ? ".00"
						: String.valueOf(e.getCarrying_amt_quoted_eq_inv().setScale(2, RoundingMode.HALF_EVEN)));

			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet223XmlList(genericXmls);
			Response res = new Response();
			res.setSheet223(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR223";
			daoClass = sheetQdfir223DAO.class;
			qdfirData = qdfir223Repo.findAll();

			qdfirData.forEach((e) -> {
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));

					result.add(e.getInvestee_name() == null ? "" : e.getInvestee_name());
					result.add(e.getType_of_investment() == null ? "" : e.getType_of_investment());
					result.add(e.getInvestement_cert_number() == null ? "" : e.getInvestement_cert_number());
					result.add(e.getAmount_invested().toString() == null ? ".00"
							: String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getFair_value_gain_or_loss().toString() == null ? ".00"
							: String.valueOf(e.getFair_value_gain_or_loss().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getImpairment().toString() == null ? ".00"
							: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getCarrying_amt_quoted_eq_inv().toString() == null ? ".00"
							: String.valueOf(e.getCarrying_amt_quoted_eq_inv().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet223XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir223(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet223DAO> data = sheet223Repository.findById(dataId);

			if (data.isPresent()) {
				sheet223Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir223DAO> data = qdfir223Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir223Repo.delete(data.get());
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

	@Override
	public ResponseEntity<?> updateData(int id, sheet223DAO Data) throws ResourceNotFoundException {
		Optional<sheet223DAO> DataDb = sheet223Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet223DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setInvestee_name(Data.getInvestee_name());
			DataUpdate.setType_of_investment(Data.getType_of_investment());
			DataUpdate.setInvestement_cert_number(Data.getInvestement_cert_number());
			DataUpdate.setAmount_invested(Data.getAmount_invested());
			DataUpdate.setFair_value_gain_or_loss(Data.getFair_value_gain_or_loss());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setCarrying_amt_quoted_eq_inv(Data.getCarrying_amt_quoted_eq_inv());
			sheet223Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS223Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir223DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir223DAO> DataDb = qdfir223Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir223DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setInvestee_name(Data.getInvestee_name());
			DataUpdate.setType_of_investment(Data.getType_of_investment());
			DataUpdate.setInvestement_cert_number(Data.getInvestement_cert_number());
			DataUpdate.setAmount_invested(Data.getAmount_invested());
			DataUpdate.setFair_value_gain_or_loss(Data.getFair_value_gain_or_loss());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setCarrying_amt_quoted_eq_inv(Data.getCarrying_amt_quoted_eq_inv());
			qdfir223Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS223Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet223DAO data = sheet223Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS223Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheetQdfir223DAO data = qdfir223Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS223Data(data);
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
