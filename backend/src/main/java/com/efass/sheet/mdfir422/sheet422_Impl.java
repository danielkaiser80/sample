package com.efass.sheet.mdfir422;

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
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet422_Impl implements sheet422_Service{

	@Autowired
	Qdfir422Repo qdfir422Repo;
    @Autowired
    sheet422Repository sheet422Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet422XmlList() {
		return genericXmlList;
	}

	public void setSheet422XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}


 // ############################## MDFIR422 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet422DAO data) throws ResourceNotFoundException {

		sheet422Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS422Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet422DAO> data = null;
		Iterable<sheetQdfir422DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR422";
            daoClass = sheet422DAO.class;
			data = sheet422Repository.findAll();

			data.forEach((e) -> {
						counter.getAndIncrement();
						result.add(String.valueOf(counter));
                        result.add(e.getDescription()== null ? "" :e.getDescription());
						result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
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
			setSheet422XmlList(genericXmls);
	 		Response res = new Response();
	 		res.setSheet422(data);
	 		res.setResponseMessage("Success");
	 		res.setResponseCode(00);
	 		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR422";
            daoClass = sheetQdfir422DAO.class;
			qdfirData = qdfir422Repo.findAll();
			qdfirData.forEach((e) ->
			{
				try {
						counter.getAndIncrement();
						result.add(String.valueOf(counter));
                        result.add(e.getDescription()== null ? "" :e.getDescription());
						result.add(e.getAmount().toString() == null ? ".00" : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
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
		setSheet422XmlList(genericXmls);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setQdfir422(qdfirData);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet422DAO> data = sheet422Repository.findById(dataId);

		if (data.isPresent()) {
			sheet422Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet422DAO Data) throws ResourceNotFoundException {
        Optional<sheet422DAO> DataDb = sheet422Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet422DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setDescription(Data.getDescription());
            sheet422Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS422Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet422DAO data = sheet422Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS422Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir422DAO data) throws ResourceNotFoundException
	{
		qdfir422Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		res.setS422Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir422DAO data = qdfir422Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS422Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir422DAO Data) throws ResourceNotFoundException {
	 Optional<sheetQdfir422DAO> DataDb = qdfir422Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir422DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setDescription(Data.getDescription());
			qdfir422Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS422Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
	}

}
