package com.efass.sheet.mstdr2;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1200.sheet1200DAO;
import com.efass.sheet.mdfir900.sheetQdfir900DAO;
import com.efass.sheet.mdfir921.sheetQdfir921DAO;
import com.efass.sheet.mstdr1.sheet001DAO;
import com.efass.sheet.mstdr1.sheetQstdr1DAO;
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

@Service
public class sheet002_Impl implements sheet002_Service{

    @Autowired
   sheet002Repository sheet002Repository;

    @Autowired Qstdr2Repo qstdr2Repo;

    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet002XmlList() {
        return genericXmlList;
    }

    public void setSheet002XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }


    @Override
    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet002DAO> data = null;
        Iterable<sheetQstdr2DAO> qstdr2DAOS;

        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> codes = new ArrayList<>();
        List<String> result = new ArrayList<>();


        String reportName = "";
        Class<?> daoClass = null;

//        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
//            reportName = "MSTDR2";
//            daoClass = sheet002DAO.class;
//            data = sheet002Repository.findAll();
//
//            data.forEach((e) ->
//            {
//
//                result.add(e.getId() +"");
//                result.add(e.getState());
//                result.add(e.getState_code());
//                result.add(e.getUp_to_2_yrs() == null ? "" : e.getUp_to_2_yrs());
//                result.add(e.getSchedule_2_to_5_yrs()== null ? "": e.getSchedule_2_to_5_yrs());
//                result.add(e.getSchedule_5_to_10_yrs()== null ? "": e.getSchedule_5_to_10_yrs());
//                result.add(e.getOver_10yrs()== null ? "": e.getOver_10yrs());
//                result.add(e.getSubtotal_1()== null ? "": e.getSubtotal_1());
//                result.add(e.getOver_draft_1()== null ? "": e.getOver_draft_1());
//                result.add(e.getOthers()== null ? "": e.getOthers());
//                result.add(e.getTotal_1()== null ? "": e.getTotal_1());
//                result.add(e.getUp_to_2_yrs_1()== null ?"": e.getUp_to_2_yrs_1());
//                result.add(e.getSchedule_2_to_5_yrs_1()== null ? "": e.getSchedule_2_to_5_yrs_1());
//                result.add(e.getSchedule_5_to_10_yrs_1()== null ? "": e.getSchedule_5_to_10_yrs_1());
//                result.add(e.getOver_10yrs_1()== null ?"": e.getOver_10yrs_1());
//                result.add(e.getSubtotal_2()== null ? "" :e.getSubtotal_2());
//                result.add(e.getOver_draft_2()== null ? "": e.getOver_draft_2());
//                result.add(e.getOthers_1()== null ? "": e.getOthers_1());
//                result.add(e.getTotal_2()== null ? "" :e.getTotal_2());
//                result.add(e.getUp_to_2_yrs_2()== null ? "": e.getUp_to_2_yrs_2());
//                result.add(e.getSchedule_2_to_5_yrs_2()== null ? "": e.getSchedule_2_to_5_yrs_2());
//                result.add(e.getSchedule_5_to_10_yrs_2()== null ? "": e.getSchedule_5_to_10_yrs_2());
//                result.add(e.getOver_10yrs_2()== null ? "": e.getOver_10yrs_2());
//                result.add(e.getTotal_3()== null ? "" : e.getTotal_3());
//            });
//
//
//            List<Integer> skipCodes = Arrays.asList(0, 1, 2, 7, 10, 15, 18, 23, 24, 25, 26, 31, 34, 39, 42, 47, 48, 49, 50, 55, 58,63, 66, 71,
//            										72, 73, 74, 79, 82, 87, 90, 95,
//            										96, 97, 98, 103, 106, 111, 114, 119 ,
//            										120, 121, 122, 127, 130, 135, 138, 143,
//            										144, 145, 146, 151, 154, 159, 162, 167,
//            										168, 169, 170, 175, 178, 183, 186, 191,
//            										192, 193, 194, 199, 202, 207, 210, 215,
//            										216, 217, 218, 223, 226, 231, 234, 239,
//            										240, 241, 242, 247, 250, 255, 258, 263,
//            										264, 265, 266, 271, 274, 279, 282, 287,
//            										288, 289, 290, 295, 298, 303, 306, 311,
//            										312, 313, 314, 319, 322, 327, 330, 335,
//            										336, 337, 338, 343, 346, 351, 354, 359,
//            										360, 361, 362, 367, 370, 375, 378, 383,
//            										384, 385, 386, 391, 394, 399, 402, 407,
//            										408, 409, 410, 415, 418, 423, 426, 431,
//            										432, 433, 434, 439, 442, 447, 450, 455,
//            										456, 457, 458, 463, 466, 471, 474, 479,
//            										480, 481, 482, 487, 490, 495, 498, 503,
//            										504, 505, 506, 511, 514, 519, 522, 527,
//            										528, 529, 530, 535, 538, 543, 546, 551,
//            										552, 553, 554, 559, 562, 567, 570, 575,
//            										576, 577, 578, 583, 586, 591, 594, 599,
//            										600, 601, 602, 607, 610, 615, 618, 623,
//            										624, 625, 626, 631, 634, 639, 642, 647,
//            										648, 649, 650, 655, 658, 663, 666, 671, 672, 673, 674, 679, 682, 687, 690, 695, 696, 697, 698, 703, 706, 711, 714, 719,
//            										720, 721, 722, 727, 730, 735, 738, 743, 744, 745, 746, 751, 754, 759, 762, 767, 768, 769, 770, 775, 778, 783, 786, 791,
//            										792, 793, 794, 799, 802, 807, 810, 815, 816, 817, 818, 823, 826, 831, 834, 839, 840, 841, 842, 847, 850, 855, 858, 863,
//            										864, 865, 866, 871, 874, 879, 882, 887);
//			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
//					.isSpecialQstdr2(true)
//					.prefix(".T0")
//					.daoClass(daoClass)
//					.reportName(reportName)
//					.result(result)
//					.genericXmls(genericXmls)
//					.isSkipRows(true)
//					.isSkipColumns(true)
//		            .skipColumns(skipCodes)
//					.codes(codes)
//					.build());
//
//			setSheet002XmlList(genericXmls);
//
//			Response res = new Response();
//			res.setSheet002(data);
//			res.setResponseMessage("Success");
//			res.setResponseCode(00);
//			return new ResponseEntity<>(res, HttpStatus.OK);
//
//        }


        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MSTDR2";
            daoClass = sheet002DAO.class;
            data = sheet002Repository.findAll();

            data.forEach((e) ->
            {

                result.add(e.getId() +"");
                result.add(e.getState());
                result.add(e.getState_code());
                result.add(e.getUp_to_2_yrs() == null ? "" : e.getUp_to_2_yrs());
                result.add(e.getSchedule_2_to_5_yrs()== null ? "": e.getSchedule_2_to_5_yrs());
                result.add(e.getSchedule_5_to_10_yrs()== null ? "": e.getSchedule_5_to_10_yrs());
                result.add(e.getOver_10yrs()== null ? "": e.getOver_10yrs());
                result.add(e.getSubtotal_1()== null ? "": e.getSubtotal_1());
                result.add(e.getOver_draft_1()== null ? "": e.getOver_draft_1());
                result.add(e.getOthers()== null ? "": e.getOthers());
                result.add(e.getTotal_1()== null ? "": e.getTotal_1());
                result.add(e.getUp_to_2_yrs_1()== null ?"": e.getUp_to_2_yrs_1());
                result.add(e.getSchedule_2_to_5_yrs_1()== null ? "": e.getSchedule_2_to_5_yrs_1());
                result.add(e.getSchedule_5_to_10_yrs_1()== null ? "": e.getSchedule_5_to_10_yrs_1());
                result.add(e.getOver_10yrs_1()== null ?"": e.getOver_10yrs_1());
                result.add(e.getSubtotal_2()== null ? "" :e.getSubtotal_2());
                result.add(e.getOver_draft_2()== null ? "": e.getOver_draft_2());
                result.add(e.getOthers_1()== null ? "": e.getOthers_1());
                result.add(e.getTotal_2()== null ? "" :e.getTotal_2());
                result.add(e.getUp_to_2_yrs_2()== null ? "": e.getUp_to_2_yrs_2());
                result.add(e.getSchedule_2_to_5_yrs_2()== null ? "": e.getSchedule_2_to_5_yrs_2());
                result.add(e.getSchedule_5_to_10_yrs_2()== null ? "": e.getSchedule_5_to_10_yrs_2());
                result.add(e.getOver_10yrs_2()== null ? "": e.getOver_10yrs_2());
                result.add(e.getTotal_3()== null ? "" : e.getTotal_3());
            });


            List<Integer> skipCodes = Arrays.asList(0, 1, 2, 7, 10, 15, 18, 23, 24, 25, 26, 31, 34, 39, 42, 47, 48, 49, 50, 55, 58,63, 66, 71,
                72, 73, 74, 79, 82, 87, 90, 95,
                96, 97, 98, 103, 106, 111, 114, 119 ,
                120, 121, 122, 127, 130, 135, 138, 143,
                144, 145, 146, 151, 154, 159, 162, 167,
                168, 169, 170, 175, 178, 183, 186, 191,
                192, 193, 194, 199, 202, 207, 210, 215,
                216, 217, 218, 223, 226, 231, 234, 239,
                240, 241, 242, 247, 250, 255, 258, 263,
                264, 265, 266, 271, 274, 279, 282, 287,
                288, 289, 290, 295, 298, 303, 306, 311,
                312, 313, 314, 319, 322, 327, 330, 335,
                336, 337, 338, 343, 346, 351, 354, 359,
                360, 361, 362, 367, 370, 375, 378, 383,
                384, 385, 386, 391, 394, 399, 402, 407,
                408, 409, 410, 415, 418, 423, 426, 431,
                432, 433, 434, 439, 442, 447, 450, 455,
                456, 457, 458, 463, 466, 471, 474, 479,
                480, 481, 482, 487, 490, 495, 498, 503,
                504, 505, 506, 511, 514, 519, 522, 527,
                528, 529, 530, 535, 538, 543, 546, 551,
                552, 553, 554, 559, 562, 567, 570, 575,
                576, 577, 578, 583, 586, 591, 594, 599,
                600, 601, 602, 607, 610, 615, 618, 623,
                624, 625, 626, 631, 634, 639, 642, 647,
                648, 649, 650, 655, 658, 663, 666, 671, 672, 673, 674, 679, 682, 687, 690, 695, 696, 697, 698, 703, 706, 711, 714, 719,
                720, 721, 722, 727, 730, 735, 738, 743, 744, 745, 746, 751, 754, 759, 762, 767, 768, 769, 770, 775, 778, 783, 786, 791,
                792, 793, 794, 799, 802, 807, 810, 815, 816, 817, 818, 823, 826, 831, 834, 839, 840, 841, 842, 847, 850, 855, 858, 863,
                864, 865, 866, 871, 874, 879, 882, 887);
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .isSpecialMstdr2(true)
                .prefix(".T0")
                .daoClass(daoClass)
                .reportName(reportName)
                .result(result)
                .genericXmls(genericXmls)
                .isSkipRows(true)
                .isSkipColumns(true)
                .skipColumns(skipCodes)
                .codes(codes)
                .build());

            setSheet002XmlList(genericXmls);

            Response res = new Response();
            res.setSheet002(data);
            res.setResponseMessage("Success");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QSTDR2";
            daoClass = sheetQstdr2DAO.class;
            qstdr2DAOS = qstdr2Repo.findAll();

            qstdr2DAOS.forEach((e) ->
            {
            	try {
            		result.add(e.getId() +"");
            		result.add(e.getState());
            		result.add(e.getState_code());
                    result.add(e.getUp_to_2_yrs() == null ? "" : e.getUp_to_2_yrs());
                    result.add(e.getSchedule_2_to_5_yrs()== null ? "": e.getSchedule_2_to_5_yrs());
                    result.add(e.getSchedule_5_to_10_yrs()== null ? "": e.getSchedule_5_to_10_yrs());
                    result.add(e.getOver_10yrs()== null ? "": e.getOver_10yrs());
                    result.add(e.getSubtotal_1()== null ? "": e.getSubtotal_1());
                    result.add(e.getOver_draft_1()== null ? "": e.getOver_draft_1());
                    result.add(e.getOthers()== null ? "": e.getOthers());
                    result.add(e.getTotal_1()== null ? "": e.getTotal_1());
                    result.add(e.getUp_to_2_yrs_1()== null ?"": e.getUp_to_2_yrs_1());
                    result.add(e.getSchedule_2_to_5_yrs_1()== null ? "": e.getSchedule_2_to_5_yrs_1());
                    result.add(e.getSchedule_5_to_10_yrs_1()== null ? "": e.getSchedule_5_to_10_yrs_1());
                    result.add(e.getOver_10yrs_1()== null ?"": e.getOver_10yrs_1());
                    result.add(e.getSubtotal_2()== null ? "" :e.getSubtotal_2());
                    result.add(e.getOver_draft_2()== null ? "": e.getOver_draft_2());
                    result.add(e.getOthers_1()== null ? "": e.getOthers_1());
                    result.add(e.getTotal_2()== null ? "" :e.getTotal_2());
                    result.add(e.getUp_to_2_yrs_2()== null ? "": e.getUp_to_2_yrs_2());
                    result.add(e.getSchedule_2_to_5_yrs_2()== null ? "": e.getSchedule_2_to_5_yrs_2());
                    result.add(e.getSchedule_5_to_10_yrs_2()== null ? "": e.getSchedule_5_to_10_yrs_2());
                    result.add(e.getOver_10yrs_2()== null ? "": e.getOver_10yrs_2());
                    result.add(e.getTotal_3()== null ? "" : e.getTotal_3());
                }
   			 catch(NullPointerException ex)
      	            {
      	    			System.out.println("NullPointerException thrown!");
      	            }
            });

            List<Integer> skipCodes = Arrays.asList(0, 1, 2, 7, 10, 15, 18, 23, 24, 25, 26, 31, 34, 39, 42, 47, 48, 49, 50, 55, 58,63, 66, 71,
            										72, 73, 74, 79, 82, 87, 90, 95,
            										96, 97, 98, 103, 106, 111, 114, 119 ,
            										120, 121, 122, 127, 130, 135, 138, 143,
            										144, 145, 146, 151, 154, 159, 162, 167,
            										168, 169, 170, 175, 178, 183, 186, 191,
            										192, 193, 194, 199, 202, 207, 210, 215,
            										216, 217, 218, 223, 226, 231, 234, 239,
            										240, 241, 242, 247, 250, 255, 258, 263,
            										264, 265, 266, 271, 274, 279, 282, 287,
            										288, 289, 290, 295, 298, 303, 306, 311,
            										312, 313, 314, 319, 322, 327, 330, 335,
            										336, 337, 338, 343, 346, 351, 354, 359,
            										360, 361, 362, 367, 370, 375, 378, 383,
            										384, 385, 386, 391, 394, 399, 402, 407,
            										408, 409, 410, 415, 418, 423, 426, 431,
            										432, 433, 434, 439, 442, 447, 450, 455,
            										456, 457, 458, 463, 466, 471, 474, 479,
            										480, 481, 482, 487, 490, 495, 498, 503,
            										504, 505, 506, 511, 514, 519, 522, 527,
            										528, 529, 530, 535, 538, 543, 546, 551,
            										552, 553, 554, 559, 562, 567, 570, 575,
            										576, 577, 578, 583, 586, 591, 594, 599,
            										600, 601, 602, 607, 610, 615, 618, 623,
            										624, 625, 626, 631, 634, 639, 642, 647,
            										648, 649, 650, 655, 658, 663, 666, 671, 672, 673, 674, 679, 682, 687, 690, 695, 696, 697, 698, 703, 706, 711, 714, 719,
            										720, 721, 722, 727, 730, 735, 738, 743, 744, 745, 746, 751, 754, 759, 762, 767, 768, 769, 770, 775, 778, 783, 786, 791,
            										792, 793, 794, 799, 802, 807, 810, 815, 816, 817, 818, 823, 826, 831, 834, 839, 840, 841, 842, 847, 850, 855, 858, 863,
            										864, 865, 866, 871, 874, 879, 882, 887);
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.isSpecialQstdr2(true)
					.prefix(".T0")
					.daoClass(daoClass)
					.reportName(reportName)
					.result(result)
					.genericXmls(genericXmls)
					.isSkipRows(true)
					.isSkipColumns(true)
		            .skipColumns(skipCodes)
					.codes(codes)
					.build());

			setSheet002XmlList(genericXmls);

			ResponseQuarterly res = new ResponseQuarterly();
			res.setQstdr002(qstdr2DAOS);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

        }
		return null;

       /* Field[] declaredFields = sheetQstdr2DAO.class.getDeclaredFields();
        List filedList = new ArrayList();
        Field field = null;
        Field field1 = null;
        Field field2 = null;
        Field field3 = null;
        Field field4 = null;
  			try {
  			    field = sheetQstdr2DAO.class.getField("subtotal_1");
  			    field1 = sheetQstdr2DAO.class.getField("total_1");
  			    field2 = sheetQstdr2DAO.class.getField("subtotal_2");
  				field3 = sheetQstdr2DAO.class.getField("total_2");
			    field4 = sheetQstdr2DAO.class.getField("total_3");
  			} catch (NoSuchFieldException e) {
  			    e.printStackTrace();
  			}
  			filedList.add(0, field);
  			filedList.add(1, field1);
  			filedList.add(2, field2);
  			filedList.add(3, field3);
  			filedList.add(4, field4);
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
        */

       /* GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .isSpecialQstdr2(true)
                .prefix(".T0")
                .daoClass(daoClass)
                .reportName(reportName)
                .result(result)
                .genericXmls(genericXmls)
                .codes(codes)
                .build()); */

    }

    @Override
    public ResponseEntity<?> updateData(int id, sheet002DAO Data) throws ResourceNotFoundException {
        Optional<sheet002DAO> DataDb = sheet002Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet002DAO DataUpdate = DataDb.get();
            DataUpdate.setUp_to_2_yrs(Data.getUp_to_2_yrs());
            DataUpdate.setSchedule_2_to_5_yrs(Data.getSchedule_2_to_5_yrs());
            DataUpdate.setSchedule_5_to_10_yrs(Data.getSchedule_5_to_10_yrs());
            DataUpdate.setOver_10yrs(Data.getOver_10yrs());
            DataUpdate.setOver_draft_1(Data.getOver_draft_1());
            DataUpdate.setOthers(Data.getOthers());
            DataUpdate.setUp_to_2_yrs_1(Data.getUp_to_2_yrs_1());
            DataUpdate.setSchedule_2_to_5_yrs_1(Data.getSchedule_2_to_5_yrs_1());
            DataUpdate.setSchedule_5_to_10_yrs_1(Data.getSchedule_5_to_10_yrs_1());
            DataUpdate.setOver_10yrs_1(Data.getOver_10yrs_1());
            DataUpdate.setUp_to_2_yrs_2(Data.getUp_to_2_yrs_2());
            DataUpdate.setSchedule_2_to_5_yrs_2(Data.getSchedule_2_to_5_yrs_2());
            DataUpdate.setSchedule_2_to_5_yrs(Data.getSchedule_5_to_10_yrs_2());
            DataUpdate.setOver_10yrs_2(Data.getOver_10yrs_2());

            sheet002Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS002Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet002DAO data = sheet002Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS002Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQstdr2DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQstdr2DAO> DataDb = qstdr2Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQstdr2DAO DataUpdate = DataDb.get();
	            DataUpdate.setUp_to_2_yrs(Data.getUp_to_2_yrs());
	            DataUpdate.setSchedule_2_to_5_yrs(Data.getSchedule_2_to_5_yrs());
	            DataUpdate.setSchedule_5_to_10_yrs(Data.getSchedule_5_to_10_yrs());
	            DataUpdate.setOver_10yrs(Data.getOver_10yrs());
	            DataUpdate.setOver_draft_1(Data.getOver_draft_1());
	            DataUpdate.setOthers(Data.getOthers());
	            DataUpdate.setUp_to_2_yrs_1(Data.getUp_to_2_yrs_1());
	            DataUpdate.setSchedule_2_to_5_yrs_1(Data.getSchedule_2_to_5_yrs_1());
	            DataUpdate.setSchedule_5_to_10_yrs_1(Data.getSchedule_5_to_10_yrs_1());
	            DataUpdate.setOver_10yrs_1(Data.getOver_10yrs_1());
	            DataUpdate.setUp_to_2_yrs_2(Data.getUp_to_2_yrs_2());
	            DataUpdate.setSchedule_2_to_5_yrs_2(Data.getSchedule_2_to_5_yrs_2());
	            DataUpdate.setSchedule_2_to_5_yrs(Data.getSchedule_5_to_10_yrs_2());
	            DataUpdate.setOver_10yrs_2(Data.getOver_10yrs_2());

	            qstdr2Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS002Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQstdr2DAO data = qstdr2Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS002Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	  }
   }

