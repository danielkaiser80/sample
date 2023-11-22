package com.efass.sheet.mdfir450_8;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir450_1.sheet450_1DAO;
import com.efass.sheet.mdfir450_1.sheetQdfir450_1DAO;
import com.efass.sheet.mdfir450_5.sheet450_5DAO;
import com.efass.sheet.mdfir450_5.sheet450_5Repository;
import com.efass.sheet.mdfir450_5.sheet450_5_Service;
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
public class sheet450_8_Impl implements sheet450_8_Service {

    @Autowired
    Qdfir450_8Repo qdfir450_8Repo;
    @Autowired
    sheet450_8Repository _450_8Repository;

    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet450_8XmlList() {
        return genericXmlList;
    }
    public void setSheet450_8XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR450_8 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet450_8DAO data) throws ResourceNotFoundException {

        _450_8Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS450_8Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createDataQ(sheetQdfir450_8DAO data) throws ResourceNotFoundException {

        qdfir450_8Repo.save(data);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS450_8Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet450_8DAO> data = null;
        Iterable<sheetQdfir450_8DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR450";
            daoClass = sheet450_8DAO.class;
            data = _450_8Repository.findAll();

            data.forEach((e) -> {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getType() == null ? "" : e.getType());
                        result.add(e.getAmount_invested().toString() == null ? ".00" :String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInvested_certificate_number().toString() == null ? ".00" :String.valueOf(e.getInvested_certificate_number().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getTenor().toString()== null ? ".00" :String.valueOf(e.getTenor().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getEffective_date().toString()== null ? "" :e.getEffective_date().toString());
                        result.add(e.getMaturity_date().toString()== null ? "" :e.getMaturity_date().toString());
                        result.add(e.getInterest_rate().toString() == null ? ".00" :String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUpfront_interest_paid().toString()== null ? ".00" :String.valueOf(e.getUpfront_interest_paid().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getAccrued_interest_payable().toString()== null ? ".00" : String.valueOf(e.getAccrued_interest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getTimes_rolled_over().toString()== null ? ".00" :String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getPrincipal_payable().toString()== null ? ".00" :String.valueOf(e.getPrincipal_payable().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getImpairment().toString() == null ? ".00" :String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));

                    }
            );
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix(".T8")
                    .result(result)
                    .daoClass(daoClass)
                    .reportName(reportName)
                    .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)
                    .build());

            setSheet450_8XmlList(genericXmls);
            Response res = new Response();
            res.setSheet450_8(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR450";
            daoClass = sheetQdfir450_8DAO.class;
            qdfirData = qdfir450_8Repo.findAll();

            qdfirData.forEach((e) -> {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getType() == null ? "" : e.getType());
                        result.add(e.getAmount_invested() == null ? ".00" :String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInvested_certificate_number() == null ? ".00" :String.valueOf(e.getInvested_certificate_number().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getTenor()== null ? ".00" :String.valueOf(e.getTenor().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getInterest_rate() == null ? ".00" :String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUpfront_interest_paid()== null ? ".00" :String.valueOf(e.getUpfront_interest_paid().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getAccrued_interest_payable()== null ? ".00" : String.valueOf(e.getAccrued_interest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getTimes_rolled_over()== null ? ".00" :String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getPrincipal_payable()== null ? ".00" :String.valueOf(e.getPrincipal_payable().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getImpairment() == null ? ".00" :String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));

                    }
            );
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix(".T8")
                    .result(result)
                    .daoClass(daoClass)
                    .reportName(reportName)
                    .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)
                    .build());

            setSheet450_8XmlList(genericXmls);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setQdfir450_8(qdfirData);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        return null;
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            sheet450_8DAO data = _450_8Repository.findById(dataId)
                    .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
            Response res = new Response();
            res.setResponseMessage("Record Found");
            res.setResponseCode(00);
            res.setS450_8Data(data);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            sheetQdfir450_8DAO data = qdfir450_8Repo.findById(dataId)
                    .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Found");
            res.setResponseCode(00);
            res.setS450_8Data(data);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        return null;
    }
    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            Optional<sheet450_8DAO> data = _450_8Repository.findById(dataId);

            if (data.isPresent()) {
                _450_8Repository.delete(data.get());
            } else {
                throw new ResourceNotFoundException("Record not found with id : " + dataId);
            }
            Response res = new Response();
            res.setResponseMessage("Record Deleted");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            Optional<sheetQdfir450_8DAO> data = qdfir450_8Repo.findById(dataId);

            if (data.isPresent()) {
                qdfir450_8Repo.delete(data.get());
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

    public ResponseEntity<?> updateData(int id , sheet450_8DAO Data) throws ResourceNotFoundException {

        Optional<sheet450_8DAO> DataDb = _450_8Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet450_8DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setAccrued_interest_payable(Data.getAccrued_interest_payable());
            DataUpdate.setAmount_invested(Data.getAmount_invested());
            DataUpdate.setImpairment(Data.getImpairment());
            DataUpdate.setInterest_rate(Data.getInterest_rate());
            DataUpdate.setInvested_certificate_number(Data.getInvested_certificate_number());
            DataUpdate.setEffective_date(Data.getEffective_date());
            DataUpdate.setMaturity_date(Data.getMaturity_date());
            DataUpdate.setPrincipal_payable(Data.getPrincipal_payable());
            DataUpdate.setTenor(Data.getTenor());
            DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
            DataUpdate.setType(Data.getType());
            DataUpdate.setUpfront_interest_paid(Data.getUpfront_interest_paid());

            _450_8Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS450_8Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> updateDataQ(int id, sheetQdfir450_8DAO Data) throws ResourceNotFoundException {

        Optional<sheetQdfir450_8DAO> DataDb = qdfir450_8Repo.findById(id);

        if (DataDb.isPresent()) {
            sheetQdfir450_8DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setAccrued_interest_payable(Data.getAccrued_interest_payable());
            DataUpdate.setAmount_invested(Data.getAmount_invested());
            DataUpdate.setImpairment(Data.getImpairment());
            DataUpdate.setInterest_rate(Data.getInterest_rate());
            DataUpdate.setInvested_certificate_number(Data.getInvested_certificate_number());
            DataUpdate.setEffective_date(Data.getEffective_date());
            DataUpdate.setMaturity_date(Data.getMaturity_date());
            DataUpdate.setPrincipal_payable(Data.getPrincipal_payable());
            DataUpdate.setTenor(Data.getTenor());
            DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
            DataUpdate.setType(Data.getType());
            DataUpdate.setUpfront_interest_paid(Data.getUpfront_interest_paid());

            qdfir450_8Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS450_8Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }    }

    @Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}

