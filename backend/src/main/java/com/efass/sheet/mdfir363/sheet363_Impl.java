package com.efass.sheet.mdfir363;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir291.sheet291DAO;
import com.efass.sheet.mdfir291.sheetQdfir291DAO;
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
public class sheet363_Impl implements sheet363_Service {

    @Autowired
    sheet363Repository _363Repository;

    @Autowired
    Qdfir363Repo qdfir363Repo;
    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet363XmlList() {
        return genericXmlList;
    }
    public void setSheet363XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR363 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet363DAO data) throws ResourceNotFoundException {

    	int length = _363Repository.getid();
 		length = length + 1;
 		data.setId(length);
        _363Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS363Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet363DAO> data = null;
        Iterable<sheetQdfir363DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR363";
            daoClass = sheet363DAO.class;
            data = _363Repository.findAll();

            data.forEach((e) ->
            {
            	try {
        			 counter.getAndIncrement();
                        result.add(String.valueOf(counter));

                        result.add(e.getType_of_investment() == null ? "" :e.getType_of_investment());
                        result.add(e.getQuoted_1().toString() == null ? ".00" : String.valueOf(e.getQuoted_1().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnquoted_1().toString() == null ? ".00" : String.valueOf(e.getUnquoted_1().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getPercentage_2().toString() == null ? ".00" : String.valueOf(e.getPercentage_2().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getQuoted_2().toString() == null ? ".00" : String.valueOf(e.getQuoted_2().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnquoted_2().toString() == null ? ".00" : String.valueOf(e.getUnquoted_2().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getQuoted_3().toString() == null ? ".00" : String.valueOf(e.getQuoted_3().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnquoted_3().toString() == null ? ".00" : String.valueOf(e.getUnquoted_3().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getImpairment().toString() == null ? ".00" : String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
                       result.add(e.getNet_amount().toString() == null ? ".00" : String.valueOf(e.getNet_amount().setScale(2, RoundingMode.HALF_EVEN)));
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

            setSheet363XmlList(genericXmls);
            Response res = new Response();
            res.setSheet363(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR363";
            daoClass = sheetQdfir363DAO.class;
            qdfirData = qdfir363Repo.findAll();

            qdfirData.forEach((e) -> {

            	try {

                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));

                        result.add(e.getType_of_investment() == null ? "" :e.getType_of_investment());
                        result.add(e.getQuoted_1().toString() == null ? ".00" : String.valueOf(e.getQuoted_1().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnquoted_1().toString() == null ? ".00" : String.valueOf(e.getUnquoted_1().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getPercentage_2().toString() == null ? ".00" : String.valueOf(e.getPercentage_2().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getQuoted_2().toString() == null ? ".00" : String.valueOf(e.getQuoted_2().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnquoted_2().toString() == null ? ".00" : String.valueOf(e.getUnquoted_2().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getQuoted_3().toString() == null ? ".00" : String.valueOf(e.getQuoted_3().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnquoted_3().toString() == null ? ".00" : String.valueOf(e.getUnquoted_3().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getImpairment().toString() == null ? ".00" : String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getNet_amount().toString() == null ? ".00" : String.valueOf(e.getNet_amount().setScale(2, RoundingMode.HALF_EVEN)));
      	}
   			 catch(NullPointerException ex)
   	            {
   	    			System.out.println("NullPointerException thrown!");
   	            }
            	});

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

        setSheet363XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir363(qdfirData);
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet363DAO data = _363Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS363Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheet363DAO> data = _363Repository.findById(dataId);

        if (data.isPresent()) {
            _363Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    public ResponseEntity<?> updateData(int id , sheet363DAO Data) throws ResourceNotFoundException {

        Optional<sheet363DAO> DataDb = _363Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet363DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setType_of_investment(Data.getType_of_investment());
            DataUpdate.setPercentage_1(Data.getPercentage_1());
            DataUpdate.setQuoted_1(Data.getQuoted_1());
            DataUpdate.setUnquoted_1(Data.getUnquoted_1());
            DataUpdate.setPercentage_2(Data.getPercentage_2());
            DataUpdate.setQuoted_2(Data.getQuoted_2());
            DataUpdate.setUnquoted_2(Data.getUnquoted_2());
            DataUpdate.setQuoted_3(Data.getQuoted_3());
            DataUpdate.setUnquoted_3(Data.getUnquoted_3());
            DataUpdate.setImpairment(Data.getImpairment());

            _363Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS363Data(DataUpdate);
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
	public ResponseEntity<?> createDataQ(sheetQdfir363DAO data) throws ResourceNotFoundException {
		int length = qdfir363Repo.getid();
 		length = length + 1;
 		data.setId(length);
 		qdfir363Repo.save(data);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS363Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir363DAO data = qdfir363Repo.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS363Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir363DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir363DAO> DataDb = qdfir363Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir363DAO DataUpdate = DataDb.get();
	            DataUpdate.setId(Data.getId());
	            DataUpdate.setType_of_investment(Data.getType_of_investment());
	            DataUpdate.setPercentage_1(Data.getPercentage_1());
	            DataUpdate.setQuoted_1(Data.getQuoted_1());
	            DataUpdate.setUnquoted_1(Data.getUnquoted_1());
	            DataUpdate.setPercentage_2(Data.getPercentage_2());
	            DataUpdate.setQuoted_2(Data.getQuoted_2());
	            DataUpdate.setUnquoted_2(Data.getUnquoted_2());
	            DataUpdate.setQuoted_3(Data.getQuoted_3());
	            DataUpdate.setUnquoted_3(Data.getUnquoted_3());
	            DataUpdate.setImpairment(Data.getImpairment());

	            qdfir363Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS363Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
	        }
	    }
	}


