package com.efass.sheet.mdfir1400;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import com.efass.sheet.mdfir1000.sheetQdfir1000DAO;
import com.efass.sheet.mdfir1301.sheet1301DAO;
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
public class sheet1400_Impl implements sheet1400_Service {

	@Autowired
	sheet1400Repository sheet1400Repository;

	@Autowired
	Qdfir1400Repo qdfir1400Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1400XmlList() {
		return genericXmlList;
	}

	public void setSheet1400XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}
// ############################## MDFIR1400 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet1400DAO data) throws ResourceNotFoundException {
		sheet1400Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1400Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1400DAO data) throws ResourceNotFoundException {
		qdfir1400Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1400Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1400DAO> data = null;
		Iterable<sheetQdfir1400DAO> qdfir1400DAOS = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1400";
			daoClass = sheet1400DAO.class;

			data = sheet1400Repository.findAll();
			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getBranch_code() == null ? "" : e.getBranch_code());
				result.add(e.getBranch_name() == null ? "" : e.getBranch_name());
				result.add(e.getTotal_other_assets().toString() == null ? ".00"
						: String.valueOf(e.getTotal_other_assets().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getTotal_non_other_performing_assets() == null ? ".00"
						: String.valueOf(e.getTotal_non_other_performing_assets().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getWatch_list() == null ? ".00"
						: String.valueOf(e.getWatch_list().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getSubstandard() == null ? ".00"
						: String.valueOf(e.getSubstandard().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getDoubtful() == null ? ".00"
						: String.valueOf(e.getDoubtful().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getVery_doubtful() == null ? ".00"
						: String.valueOf(e.getVery_doubtful().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(
						e.getLost() == null ? ".00" : String.valueOf(e.getLost().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getDfi_provision() == null ? ".00"
						: String.valueOf(e.getDfi_provision().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRemarks() == null ? "" : e.getRemarks());
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());

			setSheet1400XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1400(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1400";
			daoClass = sheetQdfir1400DAO.class;
			qdfir1400DAOS = qdfir1400Repo.findAll();

			qdfir1400DAOS.forEach((e) -> {
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getBranch_code() == null ? "" : e.getBranch_code());
					result.add(e.getBranch_name() == null ? "" : e.getBranch_name());
					result.add(e.getTotal_other_assets().toString() == null ? ".00"
							: String.valueOf(e.getTotal_other_assets().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal_non_other_performing_assets() == null ? ".00"
							: String.valueOf(
									e.getTotal_non_other_performing_assets().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getWatch_list() == null ? ".00"
							: String.valueOf(e.getWatch_list().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getSubstandard() == null ? ".00"
							: String.valueOf(e.getSubstandard().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getDoubtful() == null ? ".00"
							: String.valueOf(e.getDoubtful().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getVery_doubtful() == null ? ".00"
							: String.valueOf(e.getVery_doubtful().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getLost() == null ? ".00"
							: String.valueOf(e.getLost().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getDfi_provision() == null ? ".00"
							: String.valueOf(e.getDfi_provision().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? "" : e.getRemarks());
					// result.add(e.getRemarks() == null ? ".00" :
					// String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));

				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());

			setSheet1400XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1400(qdfir1400DAOS);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet1400DAO> data = sheet1400Repository.findById(dataId);

			if (data.isPresent()) {
				sheet1400Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir1400DAO> data = qdfir1400Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1400Repo.delete(data.get());
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
	public ResponseEntity<?> updateData(int id, sheet1400DAO Data) throws ResourceNotFoundException {
		Optional<sheet1400DAO> DataDb = sheet1400Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1400DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBranch_code(Data.getBranch_code());
			DataUpdate.setBranch_name(Data.getBranch_name());
			DataUpdate.setTotal_non_other_performing_assets(Data.getTotal_non_other_performing_assets());
			DataUpdate.setTotal_other_assets(Data.getTotal_other_assets());
			DataUpdate.setWatch_list(Data.getWatch_list());
			DataUpdate.setSubstandard(Data.getSubstandard());
			DataUpdate.setDoubtful(Data.getDoubtful());
			DataUpdate.setVery_doubtful(Data.getVery_doubtful());
			DataUpdate.setLost(Data.getLost());
			DataUpdate.setDfi_provision(Data.getDfi_provision());
			DataUpdate.setRemarks(Data.getRemarks());
			sheet1400Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1400Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1400DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1400DAO> DataDb = qdfir1400Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1400DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBranch_code(Data.getBranch_code());
			DataUpdate.setBranch_name(Data.getBranch_name());
			DataUpdate.setTotal_non_other_performing_assets(Data.getTotal_non_other_performing_assets());
			DataUpdate.setTotal_other_assets(Data.getTotal_other_assets());
			DataUpdate.setWatch_list(Data.getWatch_list());
			DataUpdate.setSubstandard(Data.getSubstandard());
			DataUpdate.setDoubtful(Data.getDoubtful());
			DataUpdate.setVery_doubtful(Data.getVery_doubtful());
			DataUpdate.setLost(Data.getLost());
			DataUpdate.setDfi_provision(Data.getDfi_provision());
			DataUpdate.setRemarks(Data.getRemarks());
			qdfir1400Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1400Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1400DAO data = sheet1400Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1400Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1400DAO data = qdfir1400Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1400Data(data);
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
