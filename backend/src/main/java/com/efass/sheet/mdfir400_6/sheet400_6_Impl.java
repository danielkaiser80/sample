package com.efass.sheet.mdfir400_6;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir400_1.sheet400_1DAO;
import com.efass.sheet.mdfir400_1.sheetQdfir400_1DAO;
import com.efass.sheet.mdfir400_2.sheet400_2DAO;
import com.efass.sheet.mdfir400_2.sheet400_2Repository;
import com.efass.sheet.mdfir400_2.sheet400_2_Service;
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
public class sheet400_6_Impl implements sheet400_6_Service {

    @Autowired
    Qdfir400_6Repo qdfir400_6Repo;

    @Autowired
    sheet400_6Repository _400_6Repository;

    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet400_6XmlList() {
        return genericXmlList;
    }
    public void setSheet400_6XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR400_6 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet400_6DAO data) throws ResourceNotFoundException {

        _400_6Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS400_6Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createDataQ(sheetQdfir400_6DAO data) throws ResourceNotFoundException {
        qdfir400_6Repo.save(data);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS400_6Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet400_6DAO> data = null;
        Iterable<sheetQdfir400_6DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR400";
            daoClass = sheet400_6DAO.class;
            data = _400_6Repository.findAll();

            data.forEach((e) -> {
                    counter.getAndIncrement();
                    result.add(String.valueOf(counter));
                    result.add(e.getType() == null ? "" : e.getType());
                    result.add(e.getAmount_invested().toString() == null ? ".00" : String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getInvested_certificate_number().toString() == null ? ".00" : String.valueOf(e.getInvested_certificate_number().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTenor().toString() == null ? ".00" : String.valueOf(e.getTenor().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getEffective_date().toString() == null ? "" : e.getEffective_date().toString());
                    result.add(e.getMaturity_date().toString() == null ? "" : e.getMaturity_date().toString());
                    result.add(e.getInterest_rate().toString() == null ? ".00" : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getUpfront_interest_paid().toString() == null ? ".00" : String.valueOf(e.getUpfront_interest_paid().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getAccrued_interest_payable().toString() == null ? ".00" : String.valueOf(e.getAccrued_interest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTimes_rolled_over().toString() == null ? ".00" : String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getPrincipal_payable().toString() == null ? ".00" : String.valueOf(e.getPrincipal_payable().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getImpairment().toString() == null ? ".00" : String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));

                }
            );
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .genericXmls(genericXmls)
                .prefix("")
                .result(result)
                .daoClass(daoClass)
                .reportName(reportName)
                .isNoneSpecialWithPrefix(true)
                .isIdPresent(true)
                .build());

            setSheet400_6XmlList(genericXmls);
            Response res = new Response();
            res.setSheet400_6(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR400";
            daoClass = sheetQdfir400_6DAO.class;
            qdfirData = qdfir400_6Repo.findAll();

            qdfirData.forEach((e) -> {
                    counter.getAndIncrement();
                    result.add(String.valueOf(counter));
                    result.add(e.getType() == null ? "" : e.getType());
                    result.add(e.getAmount_invested() == null ? ".00" : String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getInvested_certificate_number() == null ? ".00" : String.valueOf(e.getInvested_certificate_number().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTenor() == null ? ".00" : String.valueOf(e.getTenor().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) : e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) : e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getInterest_rate() == null ? ".00" : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getUpfront_interest_paid() == null ? ".00" : String.valueOf(e.getUpfront_interest_paid().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getAccrued_interest_payable() == null ? ".00" : String.valueOf(e.getAccrued_interest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTimes_rolled_over() == null ? ".00" : String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getPrincipal_payable() == null ? ".00" : String.valueOf(e.getPrincipal_payable().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getImpairment() == null ? ".00" : String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
                }
            );
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .genericXmls(genericXmls)
                .prefix("")
                .result(result)
                .daoClass(daoClass)
                .reportName(reportName)
                .isNoneSpecialWithPrefix(true)
                .isIdPresent(true)
                .build());

            setSheet400_6XmlList(genericXmls);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setQdfir400_6(qdfirData);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return null;
    }


    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            sheet400_6DAO data = _400_6Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
            Response res = new Response();
            res.setResponseMessage("Record Found");
            res.setResponseCode(00);
            res.setS400_6Data(data);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            sheetQdfir400_6DAO data = qdfir400_6Repo.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Found");
            res.setResponseCode(00);
            res.setS400_6Data(data);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            Optional<sheet400_6DAO> data = _400_6Repository.findById(dataId);

            if (data.isPresent()) {
                _400_6Repository.delete(data.get());
            } else {
                throw new ResourceNotFoundException("Record not found with id : " + dataId);
            }
            Response res = new Response();
            res.setResponseMessage("Record Deleted");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            Optional<sheetQdfir400_6DAO> data = qdfir400_6Repo.findById(dataId);

            if (data.isPresent()) {
                qdfir400_6Repo.delete(data.get());
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
    public ResponseEntity<?> updateData(int id , sheet400_6DAO Data) throws ResourceNotFoundException {

        Optional<sheet400_6DAO> DataDb = _400_6Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet400_6DAO DataUpdate = DataDb.get();
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

            _400_6Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS400_6Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> updateDataQ(int id, sheetQdfir400_6DAO Data) throws ResourceNotFoundException {
        Optional<sheetQdfir400_6DAO> DataDb = qdfir400_6Repo.findById(id);

        if (DataDb.isPresent()) {
            sheetQdfir400_6DAO DataUpdate = DataDb.get();
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

            qdfir400_6Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS400_6Data(DataUpdate);
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

