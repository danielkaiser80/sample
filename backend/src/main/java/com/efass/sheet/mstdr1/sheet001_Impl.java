package com.efass.sheet.mstdr1;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1650.sheet1650DAO;
import com.efass.sheet.mdfir1650.sheetQdfir1650DAO;
import com.efass.sheet.mdfir921.sheetQdfir921DAO;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet001_Impl implements sheet001_Service {

    @Autowired
    sheet001Repository sheet001Repository;

    @Autowired Qstdr1Repo qstdr1Repo;
    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet001XmlList() {
        return genericXmlList;
    }

    public void setSheet001XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }



    public ResponseEntity<?> createData(sheet001DAO data) throws ResourceNotFoundException {

        sheet001Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS001Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet001DAO> data = null;
        Iterable<sheetQstdr1DAO> qstdr1DAOS = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MSTDR1";
            daoClass = sheet001DAO.class;
            data = sheet001Repository.findAll();

            data.forEach((e) -> {
                counter.getAndIncrement();
                result.add(String.valueOf(counter));
                result.add(e.getCode() == null ? "" :e.getCode());
                result.add(e.getLocal_government_or_lg_code() == null ? "" :e.getLocal_government_or_lg_code());
                result.add(e.getUp_to_2_yrs().toString()== null ? ".00" : String.valueOf(e.getUp_to_2_yrs().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getSchedule_2_to_5_yrs().toString() == null ? ".00" :String.valueOf(e.getSchedule_2_to_5_yrs().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getSchedule_5_to_10_yrs().toString() == null ? ".00" :String.valueOf(e.getSchedule_5_to_10_yrs().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOver_10yrs().toString() == null ? ".00" :String.valueOf(e.getOver_10yrs().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOver_draft().toString() == null ? ".00" :String.valueOf(e.getOver_draft().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOthers().toString() == null ? ".00" :String.valueOf(e.getOthers().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getUp_to_2_yrs_1().toString()== null ? ".00" : String.valueOf(e.getUp_to_2_yrs_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getSchedule_2_to_5_yrs_1().toString() == null ? ".00" :String.valueOf(e.getSchedule_2_to_5_yrs_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getSchedule_5_to_10_yrs_1().toString()== null ? ".00" :String.valueOf(e.getSchedule_5_to_10_yrs_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOver_10yrs_1().toString()== null ? ".00" : String.valueOf(e.getOver_10yrs_1().setScale(2, RoundingMode.HALF_EVEN)));

            });
            
            Field[] declaredFields = sheetQstdr1DAO.class.getDeclaredFields();
            Field field = null;
      			try {
      			    field = sheetQstdr1DAO.class.getField("total_1");
      			   // field2 = sheetQstdr1DAO.class.getField("total_2");
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
                  .isNoneSpecialWithPrefix(true)
                  .isIdPresent(true)
                  .isSkipColumns(true)
                  .skipColumns(list)
                  .build());

            setSheet001XmlList(genericXmls);

            Response res = new Response();
            res.setSheet001(data);
            res.setResponseMessage("Success");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QSTDR1";
            daoClass = sheetQstdr1DAO.class;
            qstdr1DAOS = qstdr1Repo.findAll();

            qstdr1DAOS.forEach((e) -> 
            {
            	try {
        			
                counter.getAndIncrement();
                result.add(String.valueOf(counter));
                result.add(e.getCode() == null ? "" :e.getCode());
                result.add(e.getLocal_government_or_lg_code() == null ? "" :e.getLocal_government_or_lg_code());
                result.add(e.getUp_to_2_yrs().toString()== null ? ".00" : String.valueOf(e.getUp_to_2_yrs().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getSchedule_2_to_5_yrs().toString() == null ? ".00" :String.valueOf(e.getSchedule_2_to_5_yrs().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getSchedule_5_to_10_yrs().toString() == null ? ".00" :String.valueOf(e.getSchedule_5_to_10_yrs().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOver_10yrs().toString() == null ? ".00" :String.valueOf(e.getOver_10yrs().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOver_draft().toString() == null ? ".00" :String.valueOf(e.getOver_draft().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOthers().toString() == null ? ".00" :String.valueOf(e.getOthers().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getUp_to_2_yrs_1().toString()== null ? ".00" : String.valueOf(e.getUp_to_2_yrs_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getSchedule_2_to_5_yrs_1().toString() == null ? ".00" :String.valueOf(e.getSchedule_2_to_5_yrs_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getSchedule_5_to_10_yrs_1().toString()== null ? ".00" :String.valueOf(e.getSchedule_5_to_10_yrs_1().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getOver_10yrs_1().toString()== null ? ".00" : String.valueOf(e.getOver_10yrs_1().setScale(2, RoundingMode.HALF_EVEN)));
            }
			 catch(NullPointerException ex) 
  	            {
  	    			System.out.println("NullPointerException thrown!");
  	            }	
            });
        }
        
        Field[] declaredFields = sheetQstdr1DAO.class.getDeclaredFields();
        Field field = null;
  			try {
  			    field = sheetQstdr1DAO.class.getField("total_1");
  			   // field2 = sheetQstdr1DAO.class.getField("total_2");
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
              .isNoneSpecialWithPrefix(true)
              .isIdPresent(true)
              .isSkipColumns(true)
              .skipColumns(list)
              .build());

        setSheet001XmlList(genericXmls);

        ResponseQuarterly res = new ResponseQuarterly();
        res.setQstdr001(qstdr1DAOS);
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateData(int id, sheet001DAO Data) throws ResourceNotFoundException {
        Optional<sheet001DAO> DataDb = sheet001Repository.findByCode(Data.getCode());
        if (DataDb.isPresent()) {
            sheet001DAO DataUpdate = DataDb.get();
            DataUpdate.setUp_to_2_yrs(Data.getUp_to_2_yrs());
            DataUpdate.setSchedule_2_to_5_yrs(Data.getSchedule_2_to_5_yrs());
            DataUpdate.setSchedule_5_to_10_yrs(Data.getSchedule_5_to_10_yrs());
            DataUpdate.setOver_10yrs(Data.getOver_10yrs());
            DataUpdate.setOver_draft(Data.getOver_draft());
            DataUpdate.setOthers(Data.getOthers());
            DataUpdate.setUp_to_2_yrs_1(Data.getUp_to_2_yrs_1());
            DataUpdate.setSchedule_2_to_5_yrs_1(Data.getSchedule_2_to_5_yrs_1());
            DataUpdate.setSchedule_5_to_10_yrs_1(Data.getSchedule_5_to_10_yrs_1());
            DataUpdate.setOver_10yrs_1(Data.getOver_10yrs_1());
           // DataUpdate.setSchedule_2_to_5_yrs(Data.getSchedule_2_to_5_yrs());
          sheet001Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS001Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet001DAO data = sheet001Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS001Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
      }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQstdr1DAO data) throws ResourceNotFoundException {
		 qstdr1Repo.save(data);
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Success");
	        res.setResponseCode(00);
	        res.setS001Data(data);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQstdr1DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQstdr1DAO> DataDb = qstdr1Repo.findByCode(Data.getCode());
	        if (DataDb.isPresent()) {
	        	sheetQstdr1DAO DataUpdate = DataDb.get();
	            DataUpdate.setUp_to_2_yrs(Data.getUp_to_2_yrs());
	            DataUpdate.setSchedule_2_to_5_yrs(Data.getSchedule_2_to_5_yrs());
	            DataUpdate.setSchedule_5_to_10_yrs(Data.getSchedule_5_to_10_yrs());
	            DataUpdate.setOver_10yrs(Data.getOver_10yrs());
	            DataUpdate.setOver_draft(Data.getOver_draft());
	            DataUpdate.setOthers(Data.getOthers());
	            DataUpdate.setUp_to_2_yrs_1(Data.getUp_to_2_yrs_1());
	            DataUpdate.setSchedule_2_to_5_yrs_1(Data.getSchedule_2_to_5_yrs_1());
	            DataUpdate.setSchedule_5_to_10_yrs_1(Data.getSchedule_5_to_10_yrs_1());
	            DataUpdate.setOver_10yrs_1(Data.getOver_10yrs_1());
	           // DataUpdate.setSchedule_2_to_5_yrs(Data.getSchedule_2_to_5_yrs());
	            qstdr1Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS001Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQstdr1DAO data = qstdr1Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS001Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}
  }

