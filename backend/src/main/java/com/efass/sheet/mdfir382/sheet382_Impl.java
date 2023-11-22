package com.efass.sheet.mdfir382;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir371_1.sheet371_1DAO;
import com.efass.sheet.mdfir371_1.sheetQdfir371_1DAO;
import com.efass.sheet.mdfir372.sheet372DAO;
import com.efass.sheet.mdfir372.sheet372Repository;
import com.efass.sheet.mdfir372.sheet372_Service;
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
public class sheet382_Impl implements sheet382_Service {

    @Autowired
    sheet382Repository _382Repository;

    @Autowired
    Qdfir382Repo qdfir382Repo;

    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet382XmlList() {
        return genericXmlList;
    }
    public void setSheet382XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR382 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet382DAO data) throws ResourceNotFoundException {

        _382Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS382Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet382DAO> data = null;
        Iterable<sheetQdfir382DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR382";
            daoClass = sheet382DAO.class;
            data = _382Repository.findAll();

            data.forEach((e) ->
            {
            	try {
        			//System.out.println("i am here 382");

                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getCustomer_code()== null ? "" : e.getCustomer_code());
                        result.add(e.getCustomer_name() == null ? "" :e.getCustomer_name());
                        result.add(e.getPrincipal_granted().toString() == null ? ".00" : String.valueOf(e.getPrincipal_granted().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getPurpose()== null ? "" : e.getPurpose());
                        result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getPrincipal_outstanding().toString() == null ? ".00" : String.valueOf(e.getPrincipal_outstanding().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInterest_rate().toString() == null ? ".00" : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUpfront_interest().toString() == null ? ".00" : String.valueOf(e.getUpfront_interest().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInterest_payable().toString() == null ? ".00" : String.valueOf(e.getInterest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnpaid_principal_interest().toString() == null ? ".00" : String.valueOf(e.getUnpaid_principal_interest().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getTimes_rolled_over() == null ? "" :e.getTimes_rolled_over());
                        result.add(e.getColl_or_value() == null ? "" :e.getColl_or_value());
            	}
   			 catch(NullPointerException ex)
   	            {
   	    			System.out.println("NullPointerException thrown!");
   	            }
            	});

            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix("")
                    .result(result)
                     .daoClass(daoClass)
                    .reportName(reportName)
                    .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)
                    .build());

            setSheet382XmlList(genericXmls);
            Response res = new Response();
            res.setSheet382(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR382";
            daoClass = sheetQdfir382DAO.class;
            qdfirData = qdfir382Repo.findAll();

            qdfirData.forEach((e) -> {
            	try {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getCustomer_code()== null ? "" : e.getCustomer_code());
                        result.add(e.getCustomer_name() == null ? "" :e.getCustomer_name());
                        result.add(e.getPrincipal_granted().toString() == null ? ".00" : String.valueOf(e.getPrincipal_granted().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getPurpose()== null ? "" : e.getPurpose());
                        result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
        				result.add(e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getPrincipal_outstanding().toString() == null ? ".00" : String.valueOf(e.getPrincipal_outstanding().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInterest_rate().toString() == null ? ".00" : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUpfront_interest().toString() == null ? ".00" : String.valueOf(e.getUpfront_interest().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInterest_payable().toString() == null ? ".00" : String.valueOf(e.getInterest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnpaid_principal_interest().toString() == null ? ".00" : String.valueOf(e.getUnpaid_principal_interest().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getTimes_rolled_over() == null ? "" :e.getTimes_rolled_over());
                        result.add(e.getColl_or_value() == null ? "" :e.getColl_or_value());
            	}
      			 catch(NullPointerException ex)
      	            {
      	    			System.out.println("NullPointerException thrown!");
      	            }
            	}
            );
        }
        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .genericXmls(genericXmls)
                .prefix("")
                .result(result)
                 .daoClass(daoClass)
                .reportName(reportName)
                .isNoneSpecialWithPrefix(true)
                .isIdPresent(true)
                .build());

        setSheet382XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir382(qdfirData);
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet382DAO data = _382Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS382Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheet382DAO> data = _382Repository.findById(dataId);

        if (data.isPresent()) {
            _382Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    public ResponseEntity<?> updateData(int id , sheet382DAO Data) throws ResourceNotFoundException {

        Optional<sheet382DAO> DataDb = _382Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet382DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setCustomer_code(Data.getCustomer_code());
            DataUpdate.setCustomer_name(Data.getCustomer_name());
            DataUpdate.setPrincipal_granted(Data.getPrincipal_granted());
            DataUpdate.setPurpose(Data.getPurpose());
            DataUpdate.setDate_granted(Data.getDate_granted());
            DataUpdate.setDue_date(Data.getDue_date());
            DataUpdate.setPrincipal_outstanding(Data.getPrincipal_outstanding());
            DataUpdate.setInterest_rate(Data.getInterest_rate());
            DataUpdate.setUpfront_interest(Data.getUpfront_interest());
            DataUpdate.setInterest_payable(Data.getInterest_payable());
            DataUpdate.setUnpaid_principal_interest(Data.getUnpaid_principal_interest());
            DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
            DataUpdate.setColl_or_value(Data.getColl_or_value());

            _382Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS382Data(DataUpdate);
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
	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir382DAO data) throws ResourceNotFoundException {
		qdfir382Repo.save(data);
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Success");
	        res.setResponseCode(00);
	        res.setS382Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir382DAO data = qdfir382Repo.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS382Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir382DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir382DAO> DataDb = qdfir382Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir382DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setCustomer_code(Data.getCustomer_code());
            DataUpdate.setCustomer_name(Data.getCustomer_name());
            DataUpdate.setPrincipal_granted(Data.getPrincipal_granted());
            DataUpdate.setPurpose(Data.getPurpose());
            DataUpdate.setDate_granted(Data.getDate_granted());
            DataUpdate.setDue_date(Data.getDue_date());
            DataUpdate.setPrincipal_outstanding(Data.getPrincipal_outstanding());
            DataUpdate.setInterest_rate(Data.getInterest_rate());
            DataUpdate.setUpfront_interest(Data.getUpfront_interest());
            DataUpdate.setInterest_payable(Data.getInterest_payable());
            DataUpdate.setUnpaid_principal_interest(Data.getUnpaid_principal_interest());
            DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
            DataUpdate.setColl_or_value(Data.getColl_or_value());

            qdfir382Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS382Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
	}


}

