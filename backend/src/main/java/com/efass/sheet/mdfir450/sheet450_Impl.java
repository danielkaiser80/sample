package com.efass.sheet.mdfir450;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir400.sheet400_DAO;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet450_Impl implements sheet450_Service {

    @Autowired
    Qdfir450_Repo qdfir450_Repo;
    @Autowired
    sheet450_Repository mdfir450_Repo;

    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet450_XmlList() {
        return genericXmlList;
    }
    public void setSheet450_XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR450_1 CRUD OPERATIONS #################################

    @Override
	public ResponseEntity<?> createData(String type, sheet450_DAO dataM, sheetQdfir450_DAO dataQ) throws ResourceNotFoundException {
		if(type == "MONTHLY") {

			mdfir450_Repo.save(dataM);
			Response res = new Response();
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			res.setS450_Data(dataM);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if(type == "QUARTERLY") {

			qdfir450_Repo.save(dataQ);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			res.setS450_Data(dataQ);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet450_DAO> data = null;
		Iterable<sheetQdfir450_DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR450";
            daoClass = sheet450_DAO.class;
            data = mdfir450_Repo.findAll();
            data.forEach((e) ->

			{
				try {
                    result.add(String.valueOf(counter));
                    result.add(e.getType() == null ? "" : e.getType());
                    result.add(e.getAmount_invested() == null ? ".00": String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getInvested_certificate_number() == null ? ".00": String.valueOf(e.getInvested_certificate_number().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTenor() == null ? ".00" : String.valueOf(e.getTenor().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00)
                        : e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
                        ? String.valueOf(.00) : e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getInterest_rate() == null ? ".00"
                        : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getUpfront_interest_paid() == null ? ".00"
                        : String.valueOf(e.getUpfront_interest_paid().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getAccrued_interest_payable() == null ? ".00"
                        : String.valueOf(e.getAccrued_interest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTimes_rolled_over() == null ? ".00"
                        : String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getPrincipal_payable() == null ? ".00"
                        : String.valueOf(e.getPrincipal_payable().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getImpairment() == null ? ".00"
                        : String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));

                } catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});

            Field[] declaredFields = sheet450_DAO.class.getDeclaredFields();
            Field field = null;
            try {
                field = sheet450_DAO.class.getField("impairment");

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            List<Integer> list = Collections.singletonList(Arrays.asList(declaredFields).indexOf(field));
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()

                .genericXmls(genericXmls)
                .prefix("")
                .result(result)
                .daoClass(daoClass)
                .reportName(reportName)
                .isSpecialReportWithPrefix_450(true)
                .isSkipColumns(false)
                .skipColumns(list)
                .build());

            setSheet450_XmlList(genericXmls);
            Response res = new Response();
            res.setSheet450(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);

		}
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {

			reportName = "QDFIR450";
			daoClass = sheetQdfir450_DAO.class;
			qdfirData = qdfir450_Repo.findAll();

			qdfirData.forEach((e) -> {
				try {

					//counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getType() == null ? "" : e.getType());
					result.add(e.getAmount_invested() == null ? ".00": String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getInvested_certificate_number() == null ? ".00": String.valueOf(e.getInvested_certificate_number().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTenor() == null ? ".00" : String.valueOf(e.getTenor().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00)
									: e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
					result.add(e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
							? String.valueOf(.00) : e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
					result.add(e.getInterest_rate() == null ? ".00"
							: String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getUpfront_interest_paid() == null ? ".00"
							: String.valueOf(e.getUpfront_interest_paid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAccrued_interest_payable() == null ? ".00"
							: String.valueOf(e.getAccrued_interest_payable().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTimes_rolled_over() == null ? ".00"
							: String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getPrincipal_payable() == null ? ".00"
							: String.valueOf(e.getPrincipal_payable().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getImpairment() == null ? ".00"
							: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
					//result.add(e.getTotal_principal_accrued_interest() == null ? ".00"
					//		: String.valueOf(e.getTotal_principal_accrued_interest().setScale(2, RoundingMode.HALF_EVEN)));


				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});

			Field[] declaredFields = sheetQdfir450_DAO.class.getDeclaredFields();
	        Field field = null;
	  			try {
	  			    field = sheetQdfir450_DAO.class.getField("impairment");

	  			} catch (NoSuchFieldException e) {
	  			    e.printStackTrace();
	  			}
	  			List<Integer> list = Collections.singletonList(Arrays.asList(declaredFields).indexOf(field));
	  			GenericXml.writeIntoXmlFormat(XmlParameters.builder()

	                .genericXmls(genericXmls)
	                .prefix("")
	                .result(result)
	            .daoClass(daoClass)
	            .reportName(reportName)
	                .isUniqueReportWithPrefix_450(true)
	                .isIdPresent(true)
	                .isSkipColumns(false)
	                .skipColumns(list)
	                .build());

				setSheet450_XmlList(genericXmls);
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setQdfir450(qdfirData);
	        res.setResponseCode(00);
	        return new ResponseEntity<>(res, HttpStatus.OK);

		}
		return null;

	}

	public ResponseEntity<?> getDataById(int dataId, String type) throws ResourceNotFoundException {
		if(type == "MONTHLY") {
			sheet450_DAO data = mdfir450_Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS450_Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (type == "QUARTERLY") {
			sheetQdfir450_DAO data = qdfir450_Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS450_Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> deleteById(int dataId, String type) throws ResourceNotFoundException {
		if (type == "MONTHLY") {
			Optional<sheet450_DAO> data = mdfir450_Repo.findById(dataId);

			if (data.isPresent()) {
				mdfir450_Repo.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if(type == "QUARTERLY") {
			Optional<sheetQdfir450_DAO> data = qdfir450_Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir450_Repo.delete(data.get());
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
	public ResponseEntity<?> updateData(int id, String type, sheet450_DAO dataM, sheetQdfir450_DAO dataQ) throws ResourceNotFoundException {

		if(type == "MONTHLY") {

			Optional<sheet450_DAO> DataDb = mdfir450_Repo.findById(id);

			if (DataDb.isPresent()) {
				sheet450_DAO DataUpdate = DataDb.get();
                DataUpdate.setId(dataM.getId());
                DataUpdate.setAccrued_interest_payable(dataM.getAccrued_interest_payable());
                DataUpdate.setAmount_invested(dataM.getAmount_invested());
                DataUpdate.setImpairment(dataM.getImpairment());
                DataUpdate.setInterest_rate(dataM.getInterest_rate());
                DataUpdate.setInvested_certificate_number(dataM.getInvested_certificate_number());
                DataUpdate.setEffective_date(dataM.getEffective_date());
                DataUpdate.setMaturity_date(dataM.getMaturity_date());
                DataUpdate.setPrincipal_payable(dataM.getPrincipal_payable());
                DataUpdate.setTenor(dataM.getTenor());
                DataUpdate.setTimes_rolled_over(dataM.getTimes_rolled_over());
                DataUpdate.setType(dataM.getType());
                DataUpdate.setUpfront_interest_paid(dataM.getUpfront_interest_paid());


                mdfir450_Repo.save(DataUpdate);
				Response res = new Response();
				res.setResponseMessage("Record Updated");
				res.setResponseCode(00);
				res.setS450_Data(DataUpdate);
				return new ResponseEntity<>(res, HttpStatus.OK);

			} else {
				throw new ResourceNotFoundException("Record not found with id : " );
			}
		}

		if(type == "QUARTERLY") {

			Optional<sheetQdfir450_DAO> DataDb = qdfir450_Repo.findById(id);

			if (DataDb.isPresent()) {
				sheetQdfir450_DAO DataUpdate = DataDb.get();
				DataUpdate.setId(dataQ.getId());
				DataUpdate.setAccrued_interest_payable(dataQ.getAccrued_interest_payable());
				DataUpdate.setAmount_invested(dataQ.getAmount_invested());
				DataUpdate.setImpairment(dataQ.getImpairment());
				DataUpdate.setInterest_rate(dataQ.getInterest_rate());
				DataUpdate.setInvested_certificate_number(dataQ.getInvested_certificate_number());
				DataUpdate.setEffective_date(dataQ.getEffective_date());
				DataUpdate.setMaturity_date(dataQ.getMaturity_date());
				DataUpdate.setPrincipal_payable(dataQ.getPrincipal_payable());
				DataUpdate.setTenor(dataQ.getTenor());
				DataUpdate.setTimes_rolled_over(dataQ.getTimes_rolled_over());
				DataUpdate.setType(dataQ.getType());
				DataUpdate.setUpfront_interest_paid(dataQ.getUpfront_interest_paid());

				qdfir450_Repo.save(DataUpdate);
				ResponseQuarterly res = new ResponseQuarterly();
				res.setResponseMessage("Record Updated");
				res.setResponseCode(00);
				res.setS450_Data(DataUpdate);
				return new ResponseEntity<>(res, HttpStatus.OK);

			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataQ.getId());
			}
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

