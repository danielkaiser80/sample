package com.efass.sheet.mcfpr1;

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

@Service
public class sheetMcfpr1_Impl implements sheetMcfpr1_Service {

    @Autowired
    sheetMcfpr1Repository _Mcfpr1Repository;

    @Autowired
    sheetQcfpr1Repository sheetQcfpr1Repository;

    @Autowired
    TabController tabController;

    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheetMcfpr1XmlList() {
        return genericXmlList;
    }

    public void setSheetMcfpr1XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBRMcfpr1 CRUD OPERATIONS #################################


    public ResponseEntity<?> createData(sheetMcfpr1DAO data) throws ResourceNotFoundException {

        _Mcfpr1Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setSMcfpr1Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> createDataQ(sheetQcfpr1Dao data) throws ResourceNotFoundException {
		sheetQcfpr1Repository.save(data);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setsQcfpr1Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
	}


    public ResponseEntity<?> fetchAllData() {

        String reportName = "";
        Class<?> daoClass = null;
        Iterable<sheetMcfpr1DAO> data = null;
        Iterable<sheetQcfpr1Dao> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MCFPR1";
            daoClass = sheetMcfpr1DAO.class;
            data = _Mcfpr1Repository.findAll();


            data.forEach((e) -> {
                result.add(e.getComplaint_ref_number() == null ? "" :e.getComplaint_ref_number());
                result.add(e.getName_of_petitioner()== null ? "" :e.getName_of_petitioner());
                result.add(e.getAddress()== null ? "" : e.getAddress());
                result.add(e.getSubject()== null ? "" :e.getSubject());
                result.add(e.getCategory() == null ? "" : e.getCategory());
                result.add(e.getDate_received().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_received().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                result.add(e.getDate_resolved().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_resolved().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                result.add(e.getResolution_efforts_made()== null ? "" :e.getResolution_efforts_made());
                result.add(e.getMajor_areas_of_disagreement()== null ? "" : e.getMajor_areas_of_disagreement());
                result.add(e.getAmount_claimed_1().toString() == null ? ".00" : String.valueOf(e.getAmount_claimed_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAmount_refunded_1().toString() == null ? ".00": String.valueOf(e.getAmount_refunded_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAmount_claimed_2().toString() == null ?".00" : String.valueOf(e.getAmount_claimed_2().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAmount_refunded_2().toString() == null ? ".00" : String.valueOf(e.getAmount_refunded_2().setScale(2, RoundingMode.HALF_EVEN)));
                }
            );
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix("")
                    .result(result)
                    .daoClass(daoClass)
                    .reportName(reportName)
                    .isNoneSpecialWithPrefix(true)
                    .build());

            setSheetMcfpr1XmlList(genericXmls);
            Response res = new Response();
            res.setSheetMcfpr1(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QCFPR1";
            daoClass = sheetQcfpr1Dao.class;
            qdfirData = sheetQcfpr1Repository.findAll();

            qdfirData.forEach((e) -> {
                result.add(e.getComplaint_ref_number() == null ? "" :e.getComplaint_ref_number());
                result.add(e.getName_of_petitioner()== null ? "" :e.getName_of_petitioner());
                result.add(e.getAddress()== null ? "" : e.getAddress());
                result.add(e.getSubject()== null ? "" :e.getSubject());
                result.add(e.getCategory() == null ? "" : e.getCategory());
                result.add(e.getDate_received().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_received().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                result.add(e.getDate_resolved().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_resolved().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                result.add(e.getResolution_efforts_made()== null ? "" :e.getResolution_efforts_made());
                result.add(e.getMajor_areas_of_disagreement()== null ? "" : e.getMajor_areas_of_disagreement());
                result.add(e.getAmount_claimed_1().toString() == null ? ".00" : String.valueOf(e.getAmount_claimed_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAmount_refunded_1().toString() == null ? ".00": String.valueOf(e.getAmount_refunded_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAmount_claimed_2().toString() == null ?".00" : String.valueOf(e.getAmount_claimed_2().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAmount_refunded_2().toString() == null ? ".00" : String.valueOf(e.getAmount_refunded_2().setScale(2, RoundingMode.HALF_EVEN)));
                }
            );
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix("")
                    .result(result)
                    .daoClass(daoClass)
                    .reportName(reportName)
                    .isNoneSpecialWithPrefix(true)
                    .build());

            setSheetMcfpr1XmlList(genericXmls);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setQcfpr1(qdfirData);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
		return null;


    }

    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheetMcfpr1DAO data = _Mcfpr1Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setSMcfpr1Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
    	sheetQcfpr1Dao data = sheetQcfpr1Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setsQcfpr1Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
	}

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheetMcfpr1DAO> data = _Mcfpr1Repository.findById(dataId);

        if (data.isPresent()) {
            _Mcfpr1Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		Optional<sheetQcfpr1Dao> data = sheetQcfpr1Repository.findById(dataId);

        if (data.isPresent()) {
        	sheetQcfpr1Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
	}

    public ResponseEntity<?> updateData(int id , sheetMcfpr1DAO Data) throws ResourceNotFoundException {

        Optional<sheetMcfpr1DAO> DataDb = _Mcfpr1Repository.findById(id);

        if (DataDb.isPresent()) {
            sheetMcfpr1DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setAddress(Data.getAddress());
            DataUpdate.setAmount_claimed_1(Data.getAmount_claimed_1());
            DataUpdate.setAmount_claimed_2(Data.getAmount_claimed_2());
            DataUpdate.setAmount_refunded_1(Data.getAmount_refunded_1());
            DataUpdate.setAmount_refunded_2(Data.getAmount_refunded_2());
            DataUpdate.setCategory(Data.getCategory());
            DataUpdate.setComplaint_ref_number(Data.getComplaint_ref_number());
            DataUpdate.setDate_received(Data.getDate_received());
            DataUpdate.setDate_resolved(Data.getDate_resolved());
            DataUpdate.setMajor_areas_of_disagreement(Data.getMajor_areas_of_disagreement());
            DataUpdate.setName_of_petitioner(Data.getName_of_petitioner());
            DataUpdate.setResolution_efforts_made(Data.getResolution_efforts_made());
            DataUpdate.setSubject(Data.getSubject());

            _Mcfpr1Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setSMcfpr1Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQcfpr1Dao Data) throws ResourceNotFoundException {
		Optional<sheetQcfpr1Dao> DataDb = sheetQcfpr1Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheetQcfpr1Dao DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setAddress(Data.getAddress());
            DataUpdate.setAmount_claimed_1(Data.getAmount_claimed_1());
            DataUpdate.setAmount_claimed_2(Data.getAmount_claimed_2());
            DataUpdate.setAmount_refunded_1(Data.getAmount_refunded_1());
            DataUpdate.setAmount_refunded_2(Data.getAmount_refunded_2());
            DataUpdate.setCategory(Data.getCategory());
            DataUpdate.setComplaint_ref_number(Data.getComplaint_ref_number());
            DataUpdate.setDate_received(Data.getDate_received());
            DataUpdate.setDate_resolved(Data.getDate_resolved());
            DataUpdate.setMajor_areas_of_disagreement(Data.getMajor_areas_of_disagreement());
            DataUpdate.setName_of_petitioner(Data.getName_of_petitioner());
            DataUpdate.setResolution_efforts_made(Data.getResolution_efforts_made());
            DataUpdate.setSubject(Data.getSubject());

            sheetQcfpr1Repository.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setsQcfpr1Data(DataUpdate);
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

