package com.efass.sheet.mdfir1500;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1400.sheet1400DAO;
import com.efass.sheet.mdfir1400.sheetQdfir1400DAO;
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
public class sheet1500_Impl implements sheet1500_Service {

	@Autowired
	sheet1500Repository sheet1500Repository;

	@Autowired
	Qdfir1500Repo qdfir1500Repo;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1500XmlList() {
		return genericXmlList;
	}

	public void setSheet1500XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR1500 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet1500DAO data) throws ResourceNotFoundException {
		sheet1500Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1500Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1500DAO data) throws ResourceNotFoundException {
		qdfir1500Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1500Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1500DAO> data = null;
		Iterable<sheetQdfir1500DAO> qdfir1500DAOS = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1500";
			daoClass = sheet1500DAO.class;

			data = sheet1500Repository.findAll();
			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getBranch_code() == null ? "" : e.getBranch_code());
				result.add(e.getBranch_name() == null ? "" : e.getBranch_name());
				result.add(e.getTotal_value_of_contingent_liability().toString() == null ? ".00"
						: String.valueOf(
								e.getTotal_value_of_contingent_liability().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getTotal_impaired_contingent_liability().toString() == null ? ".00"
						: String.valueOf(
								e.getTotal_impaired_contingent_liability().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getImpairment().toString() == null ? ".00"
						: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRemarks() == null ? "" : e.getRemarks());
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());

			setSheet1500XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1500(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1500";
			daoClass = sheetQdfir1500DAO.class;
			qdfir1500DAOS = qdfir1500Repo.findAll();

			qdfir1500DAOS.forEach((e) -> {
				try {
					// System.out.println("i am here 1500");

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getBranch_code() == null ? "" : e.getBranch_code());
					result.add(e.getBranch_name() == null ? "" : e.getBranch_name());
					result.add(e.getTotal_value_of_contingent_liability().toString() == null ? ".00"
							: String.valueOf(
									e.getTotal_value_of_contingent_liability().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal_impaired_contingent_liability().toString() == null ? ".00"
							: String.valueOf(
									e.getTotal_impaired_contingent_liability().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getImpairment().toString() == null ? ".00"
							: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? "" : e.getRemarks());
					// result.add(e.getRemarks()== null ? ".00"
					// :String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());

			setSheet1500XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1500(qdfir1500DAOS);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet1500DAO> data = sheet1500Repository.findById(dataId);

			if (data.isPresent()) {
				sheet1500Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir1500DAO> data = qdfir1500Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1500Repo.delete(data.get());
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
	public ResponseEntity<?> updateData(int id, sheet1500DAO Data) throws ResourceNotFoundException {
		Optional<sheet1500DAO> DataDb = sheet1500Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1500DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBranch_code(Data.getBranch_code());
			DataUpdate.setBranch_name(Data.getBranch_name());
			DataUpdate.setTotal_impaired_contingent_liability(Data.getTotal_impaired_contingent_liability());
			DataUpdate.setTotal_value_of_contingent_liability(Data.getTotal_value_of_contingent_liability());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setRemarks(Data.getRemarks());
			sheet1500Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1500Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}


	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1500DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1500DAO> DataDb = qdfir1500Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1500DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBranch_code(Data.getBranch_code());
			DataUpdate.setBranch_name(Data.getBranch_name());
			DataUpdate.setTotal_impaired_contingent_liability(Data.getTotal_impaired_contingent_liability());
			DataUpdate.setTotal_value_of_contingent_liability(Data.getTotal_value_of_contingent_liability());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setRemarks(Data.getRemarks());
			qdfir1500Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1500Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1500DAO data = sheet1500Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1500Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1500DAO data = qdfir1500Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1500Data(data);
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
