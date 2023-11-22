package com.efass.download;

import com.efass.ReportGroupEnum;
import com.efass.activity.ActivityController;
import com.efass.activity.ActivityDAO;
import com.efass.download.xmlModels.*;
import com.efass.sheet.mcfpr1.sheetMcfpr1_Impl;
import com.efass.sheet.mdfir100.sheet100_Impl;
import com.efass.sheet.mdfir1000.sheet1000_Impl;
import com.efass.sheet.mdfir101.sheet101_Impl;
import com.efass.sheet.mdfir1200.sheet1200_Impl;
import com.efass.sheet.mdfir122.sheet122_Impl;
import com.efass.sheet.mdfir1300.sheet1300_Impl;
import com.efass.sheet.mdfir1301.sheet1301_Impl;
import com.efass.sheet.mdfir1400.sheet1400_Impl;
import com.efass.sheet.mdfir142.sheet142_Impl;
import com.efass.sheet.mdfir1500.sheet1500_Impl;
import com.efass.sheet.mdfir1600.sheet1600_Impl;
import com.efass.sheet.mdfir161.sheet161_Impl;
import com.efass.sheet.mdfir1650.sheet1650_Impl;
import com.efass.sheet.mdfir1700.sheet1700_Impl;
import com.efass.sheet.mdfir172.sheet172_Impl;
import com.efass.sheet.mdfir182.sheet182_Impl;
import com.efass.sheet.mdfir191.sheet191_Impl;
import com.efass.sheet.mdfir192.sheet192_Impl;
import com.efass.sheet.mdfir193.sheet193_Impl;
import com.efass.sheet.mdfir201.sheet201_Impl;
import com.efass.sheet.mdfir221.sheet221_Impl;
import com.efass.sheet.mdfir223.sheet223_Impl;
import com.efass.sheet.mdfir250.sheet250_Impl;
import com.efass.sheet.mdfir271.sheet271_Impl;
import com.efass.sheet.mdfir291.sheet291_Impl;
import com.efass.sheet.mdfir292_1.sheet292_1_Impl;
import com.efass.sheet.mdfir292_2.sheet292_2_Impl;
import com.efass.sheet.mdfir292_3.sheet292_3_Impl;
import com.efass.sheet.mdfir300.sheet300_Impl;
import com.efass.sheet.mdfir302.sheet302_Impl;
import com.efass.sheet.mdfir304.sheet304_Impl;
import com.efass.sheet.mdfir311.sheet311_Impl;
import com.efass.sheet.mdfir321.sheet321_Impl;
import com.efass.sheet.mdfir333.sheet333_Impl;
import com.efass.sheet.mdfir363.sheet363_Impl;
import com.efass.sheet.mdfir371_1.sheet371_1_Impl;
import com.efass.sheet.mdfir371_2.sheet371_2_Impl;
import com.efass.sheet.mdfir371_3.sheet371_3_Impl;
import com.efass.sheet.mdfir372.sheet372_Impl;
import com.efass.sheet.mdfir382.sheet382_Impl;
import com.efass.sheet.mdfir400.sheet400_Impl;
import com.efass.sheet.mdfir400_10.sheet400_10_Impl;
import com.efass.sheet.mdfir400_11.sheet400_11_Impl;
import com.efass.sheet.mdfir400_12.sheet400_12_Impl;
import com.efass.sheet.mdfir400_13.sheet400_13_Impl;
import com.efass.sheet.mdfir400_14.sheet400_14_Impl;
import com.efass.sheet.mdfir400_15.sheet400_15_Impl;
import com.efass.sheet.mdfir400_2.sheet400_2_Impl;
import com.efass.sheet.mdfir400_3.sheet400_3_Impl;
import com.efass.sheet.mdfir400_4.sheet400_4_Impl;
import com.efass.sheet.mdfir400_5.sheet400_5_Impl;
import com.efass.sheet.mdfir400_6.sheet400_6_Impl;
import com.efass.sheet.mdfir400_7.sheet400_7_Impl;
import com.efass.sheet.mdfir400_8.sheet400_8_Impl;
import com.efass.sheet.mdfir400_9.sheet400_9_Impl;
import com.efass.sheet.mdfir412.sheet412_Impl;
import com.efass.sheet.mdfir422.sheet422_Impl;
import com.efass.sheet.mdfir423.sheet423_Impl;
import com.efass.sheet.mdfir425.sheet425_Impl;
import com.efass.sheet.mdfir432.sheet432_Impl;
import com.efass.sheet.mdfir450.sheet450_Impl;
import com.efass.sheet.mdfir450_1.sheet450_1_Impl;
import com.efass.sheet.mdfir450_10.sheet450_10_Impl;
import com.efass.sheet.mdfir450_11.sheet450_11_Impl;
import com.efass.sheet.mdfir450_12.sheet450_12_Impl;
import com.efass.sheet.mdfir450_13.sheet450_13_Impl;
import com.efass.sheet.mdfir450_14.sheet450_14_Impl;
import com.efass.sheet.mdfir450_15.sheet450_15_Impl;
import com.efass.sheet.mdfir450_2.sheet450_2_Impl;
import com.efass.sheet.mdfir450_3.sheet450_3_Impl;
import com.efass.sheet.mdfir450_4.sheet450_4_Impl;
import com.efass.sheet.mdfir450_5.sheet450_5_Impl;
import com.efass.sheet.mdfir450_6.sheet450_6_Impl;
import com.efass.sheet.mdfir450_7.sheet450_7_Impl;
import com.efass.sheet.mdfir450_8.sheet450_8_Impl;
import com.efass.sheet.mdfir450_9.sheet450_9_Impl;
import com.efass.sheet.mdfir453.sheet453_Impl;
import com.efass.sheet.mdfir455.sheet455_Impl;
import com.efass.sheet.mdfir493.sheet493_Impl;
import com.efass.sheet.mdfir533.sheet533_Impl;
import com.efass.sheet.mdfir600.sheet600_Impl;
import com.efass.sheet.mdfir601.sheet601_Impl;
import com.efass.sheet.mdfir700.sheet700_Impl;
import com.efass.sheet.mdfir702.sheet702_Impl;
import com.efass.sheet.mdfir800.sheet800_Impl;
import com.efass.sheet.mdfir900.sheet900_Impl;
import com.efass.sheet.mdfir920.sheet920_Impl;
import com.efass.sheet.mdfir921.sheet921_Impl;
import com.efass.sheet.mstdr1.sheet001_Impl;
import com.efass.sheet.mstdr2.sheet002_Impl;
import com.efass.sheet.table.TabController;
import com.efass.sheet.table.TableImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class DownloadServiceImpl implements DownloadService {

    private Logger logger = LoggerFactory.getLogger(DownloadServiceImpl.class);
    @Autowired
    private sheet300_Impl sheet300_impl;
    @Autowired  TableImpl table;
    @Autowired
    private sheet1000_Impl sheet1000_impl;
    @Autowired
    sheet321_Impl sheet321_impl;
    @Autowired
    private sheet100_Impl sheet100_impl;


    @Autowired
    private sheet333_Impl sheet333_impl;
    @Autowired
    private sheet363_Impl sheet363_impl;
    @Autowired
    private sheet371_1_Impl sheet371_1_impl;
    @Autowired
    private sheet371_2_Impl sheet371_2_impl;
    @Autowired
    private sheet371_3_Impl sheet371_3_impl;
    @Autowired
    private sheet372_Impl sheet372_impl;
    @Autowired
    private sheet382_Impl sheet382_impl;
    @Autowired
    private sheet400_Impl sheet400_impl;
    @Autowired private  MDFIR400 mdfir400;
    @Autowired private  QDFIR400 qdfir400;


    @Autowired
    private sheet450_Impl sheet450_impl;
    @Autowired private  MDFIR450 mdfir450;
    @Autowired private  QDFIR450 qdfir450;

    @Autowired
    private sheet400_2_Impl sheet400_2_impl;
    @Autowired
    private sheet400_3_Impl sheet400_3_impl;
    @Autowired
    private sheet400_4_Impl sheet400_4_impl;
    @Autowired
    private sheet400_5_Impl sheet400_5_impl;
    @Autowired
    private sheet400_6_Impl sheet400_6_impl;
    @Autowired
    private sheet400_7_Impl sheet400_7_impl;
    @Autowired
    private sheet400_8_Impl sheet400_8_impl;
    @Autowired
    private sheet400_9_Impl sheet400_9_impl;
    @Autowired
    private sheet400_10_Impl sheet400_10_impl;
    @Autowired
    private sheet400_11_Impl sheet400_11_impl;
    @Autowired
    private sheet400_12_Impl sheet400_12_impl;
    @Autowired
    private sheet400_13_Impl sheet400_13_impl;
    @Autowired
    private sheet400_14_Impl sheet400_14_impl;
    @Autowired
    private sheet400_15_Impl sheet400_15_impl;
    @Autowired
    private sheet450_1_Impl sheet450_1_impl;
    @Autowired
    private sheet450_2_Impl sheet450_2_impl;
    @Autowired
    private sheet450_3_Impl sheet450_3_impl;
    @Autowired
    private sheet450_4_Impl sheet450_4_impl;
    @Autowired
    private sheet450_5_Impl sheet450_5_impl;
    @Autowired
    private sheet450_6_Impl sheet450_6_impl;
    @Autowired
    private sheet450_7_Impl sheet450_7_impl;
    @Autowired
    private sheet450_8_Impl sheet450_8_impl;
    @Autowired
    private sheet450_9_Impl sheet450_9_impl;
    @Autowired
    private sheet450_10_Impl sheet450_10_impl;
    @Autowired
    private sheet450_11_Impl sheet450_11_impl;
    @Autowired
    private sheet450_12_Impl sheet450_12_impl;
    @Autowired
    private sheet450_13_Impl sheet450_13_impl;
    @Autowired
    private sheet450_14_Impl sheet450_14_impl;
    @Autowired
    private sheet450_15_Impl sheet450_15_impl;
    @Autowired
    private sheet1650_Impl sheet1650_impl;
    @Autowired
    private sheet1700_Impl sheet1700_impl;
    @Autowired
    private sheet193_Impl sheet193_impl;
    @Autowired
    private sheet201_Impl sheet201_impl;
    @Autowired
    private sheet221_Impl sheet221_impl;

    @Autowired
    private sheet1200_Impl sheet1200_Impl;
    @Autowired private MDFIR1200 mdfir1200;
    @Autowired private sheet533_Impl sheet533_impl;
    @Autowired private MDFIR533 mdfir533;
    @Autowired private sheet423_Impl sheet423_impl;
    @Autowired private MDFIR423 mdfir423;
    @Autowired private sheet600_Impl sheet600;
    @Autowired private MDFIR600 mdfir600;

    @Autowired private sheet700_Impl sheet700;
    @Autowired private MDFIR700 mdfir700;

    @Autowired private sheet800_Impl sheet800_impl;
    @Autowired private MDFIR800 mdfir800;

    @Autowired private sheet302_Impl sheet302_impl;
    @Autowired private MDFIR302 mdfir302;

    @Autowired private sheet453_Impl sheet453_impl;
    @Autowired private MDFIR453 mdfir453;

    @Autowired private sheet250_Impl sheet250_impl;
    @Autowired private MDFIR250 mdfir250;

    @Autowired private sheet002_Impl sheet002_impl;
    @Autowired private MSTDR2 mstdr2;

    @Autowired private sheet161_Impl sheet161_impl;
    @Autowired private MDFIR161 mdfir161;

    @Autowired private sheet1300_Impl sheet1300_impl;
    @Autowired private MDFIR1300 mdfir1300;

    @Autowired private sheet1301_Impl sheet1301_impl;
    @Autowired private MDFIR1301 mdfir1301;

    @Autowired private sheet1400_Impl sheet1400_impl;

    @Autowired private sheet1500_Impl sheet1500_impl;
    @Autowired private MDFIR1500 mdfir1500;

    @Autowired private sheet1600_Impl sheet1600_impl;
    @Autowired private MDFIR1600 mdfir1600;

    @Autowired private sheet223_Impl sheet223_impl;
    @Autowired private MDFIR223 mdfir223;

    @Autowired private sheet271_Impl sheet271_impl;
    @Autowired private MDFIR271 mdfir271;

    @Autowired private sheet291_Impl sheet291_impl;
    @Autowired private MDFIR291 mdfir291;

    @Autowired private sheet292_1_Impl sheet292_1_impl;
    @Autowired private MDFIR292_1 mdfir292_1;

    @Autowired private sheet292_2_Impl sheet292_2_impl;
    @Autowired private MDFIR292_2 mdfir292_2;

    @Autowired private sheet304_Impl sheet304_impl;
    @Autowired private MDFIR304 mdfir304;

    @Autowired private sheet292_3_Impl sheet292_3_impl;
    @Autowired private MDFIR292_3 mdfir292_3;

    @Autowired private sheet311_Impl sheet311_impl;
    @Autowired private MDFIR311 mdfir311;

    @Autowired private sheet412_Impl sheet412_impl;
    @Autowired private MDFIR412 mdfir412;

    @Autowired private sheet422_Impl sheet422_impl;
    @Autowired private MDFIR422 mdfir422;
    @Autowired private sheet425_Impl sheet425_impl;
    @Autowired private MDFIR425 mdfir425;

    @Autowired private sheet432_Impl sheet432_impl;
    @Autowired private MDFIR432 mdfir432;

    @Autowired private sheet455_Impl sheet455_impl;
    @Autowired private MDFIR455 mdfir455;

    @Autowired private sheet493_Impl sheet493_impl;
    @Autowired private MDFIR493 mdfir493;

    @Autowired private sheet601_Impl sheet601_impl;
    @Autowired private MDFIR601 mdfir601;

    @Autowired private sheet702_Impl sheet702_impl;
    @Autowired private MDFIR702 mdfir702;

    @Autowired private sheet900_Impl sheet900_impl;
    @Autowired private MDFIR900 mdfir900;

    @Autowired private sheet920_Impl sheet920_impl;
    @Autowired private MDFIR920 mdfir920;

    @Autowired private sheet921_Impl sheet921_impl;
    @Autowired private MDFIR921 mdfir921;

    @Autowired private sheet101_Impl sheet101_impl;
    @Autowired private MDFIR101 mdfir101;

    @Autowired private sheet122_Impl sheet122_impl;
    @Autowired private MDFIR122 mdfir122;

    @Autowired private sheet142_Impl sheet142_impl;
    @Autowired private MDFIR142 mdfir142;

    @Autowired private sheet172_Impl sheet172_impl;
    @Autowired private MDFIR172 mdfir172;

    @Autowired private sheet182_Impl sheet182_impl;
    @Autowired private MDFIR182 mdfir182;

    @Autowired private sheet191_Impl sheet191_impl;
    @Autowired private MDFIR191 mdfir191;

    @Autowired private sheet192_Impl sheet192_impl;
    @Autowired private MDFIR192 mdfir192;

    @Autowired private sheet001_Impl sheet001_impl;
    @Autowired private MSTDR1 mstdr1;

    @Autowired
    private sheetMcfpr1_Impl sheetMcfpr1_impl;
    @Autowired private MCFPR1 MCFPR1;


    @Autowired private MDFIR1000 mdfir1000;
    @Autowired private  MDFIR300 mdfir300;
    @Autowired private MDFIR321 mdfir321;
    @Autowired private MDFIR333 mdfir333;
    @Autowired private MDFIR100 mdfir100;
    @Autowired private MDFIR363 mdfir363;
    @Autowired private MDFIR371_1 mdfir371_1;
    @Autowired private MDFIR371_2 mdfir371_2;
    @Autowired private MDFIR371_3 mdfir371_3;
    @Autowired private  MDFIR372 mdfir372;
    @Autowired private  MDFIR382 mdfir382;

    @Autowired private  MDFIR400_1 mdfir400_1;
    @Autowired private  MDFIR400_2 mdfir400_2;
    @Autowired private  MDFIR400_3 mdfir400_3;
    @Autowired private  MDFIR400_4 mdfir400_4;
    @Autowired private  MDFIR400_5 mdfir400_5;
    @Autowired private  MDFIR400_6 mdfir400_6;
    @Autowired private  MDFIR400_7 mdfir400_7;
    @Autowired private  MDFIR400_8 mdfir400_8;
    @Autowired private  MDFIR400_9 mdfir400_9;
    @Autowired private  MDFIR400_10 mdfir400_10;
    @Autowired private  MDFIR400_11 mdfir400_11;
    @Autowired private  MDFIR400_12 mdfir400_12;
    @Autowired private  MDFIR400_13 mdfir400_13;
    @Autowired private  MDFIR400_14 mdfir400_14;
    @Autowired private  MDFIR400_15 mdfir400_15;
    @Autowired private  MDFIR450_1 mdfir450_1;
    @Autowired private  MDFIR450_2 mdfir450_2;
    @Autowired private  MDFIR450_3 mdfir450_3;
    @Autowired private  MDFIR450_4 mdfir450_4;
    @Autowired private  MDFIR450_5 mdfir450_5;
    @Autowired private  MDFIR450_6 mdfir450_6;
    @Autowired private  MDFIR450_7 mdfir450_7;
    @Autowired private  MDFIR450_8 mdfir450_8;
    @Autowired private  MDFIR450_9 mdfir450_9;
    @Autowired private  MDFIR450_10 mdfir450_10;
    @Autowired private  MDFIR450_11 mdfir450_11;
    @Autowired private  MDFIR450_12 mdfir450_12;
    @Autowired private  MDFIR450_13 mdfir450_13;
    @Autowired private  MDFIR450_14 mdfir450_14;
    @Autowired private  MDFIR450_15 mdfir450_15;

    @Autowired private  MDFIR1650 mdfir1650;
    @Autowired private  MDFIR1400 mdfir1400;
    @Autowired private  MDFIR1700 mdfir1700;
    @Autowired private  MDFIR201 mdfir201;
    @Autowired private  MDFIR193 mdfir193;
    @Autowired private  MDFIR221 mdfir221;

    @Autowired private ActivityController activityController;

    @Override
    public void downloadZipFile(HttpServletResponse response, List<String> listOfFileNames) {

        logger.info("GENERATING ZIPPED XMLs FOR REPORTS : " + listOfFileNames.toString());
       // System.out.println("fILE COUNT: " + listOfFileNames.size());
       // System.out.println( listOfFileNames.toString());
        LocalDate date = LocalDate.now();
        response.setContentType("application/zip");
        String s1 = "attachment; filename=" + "Reports for " + date.getYear() + "-" + date.getMonth() + ".zip";
        response.setHeader("Content-Disposition", s1);


        try (ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream())) {
            for (String fileName : listOfFileNames) {
            	//System.out.println("fileName : "+ fileName);
                fileName = fileName.trim().toUpperCase();
                xmlFactory(fileName);
                FileSystemResource fileSystemResource = new FileSystemResource(fileName + ".xml");
                ZipEntry zipEntry = new ZipEntry(Objects.requireNonNull(fileSystemResource.getFilename()));
                zipEntry.setSize(fileSystemResource.contentLength());

                zipEntry.setTime(System.currentTimeMillis());
                zipOutputStream.putNextEntry(zipEntry);
                StreamUtils.copy(fileSystemResource.getInputStream(), zipOutputStream);
                zipOutputStream.closeEntry();

                File file = new File(fileName + ".xml");
                file.delete();

            }
            zipOutputStream.finish();
        } catch (IOException | JAXBException | RuntimeException | ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        } finally {
            saveDownloadActivity();
        }
    }

    private void xmlFactory(String className) throws JAXBException, IOException, ClassNotFoundException {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            monthly(className);
        }

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            quaterly(className);
        }

    }

    private void quaterly(String className) throws JAXBException, IOException, ClassNotFoundException {
        switch (className.trim()) {
            case "QCFPR1":
                MCFPR1.convertToXml(sheetMcfpr1_impl, table);break;
            case "QDFIR100":
                mdfir100.convertToXml(sheet100_impl, table);break;
            case "QDFIR101":
                mdfir101.convertToXml(sheet101_impl, table);break;
            case "QDFIR1000":
                mdfir1000.convertToXml(sheet1000_impl, table);break;
            case "QDFIR1200":
                mdfir1200.convertToXml(sheet1200_Impl, table);break;
            case "QDFIR122":
                mdfir122.convertToXml(sheet122_impl, table);break;
            case "QDFIR142":
                mdfir142.convertToXml(sheet142_impl, table);break;
            case "QDFIR161":
                mdfir161.convertToXml(sheet161_impl, table);break;
            case "QDFIR172":
                mdfir172.convertToXml(sheet172_impl, table);break;
            case "QDFIR182":
                mdfir182.convertToXml(sheet182_impl, table);break;

            case "QDFIR191":
                mdfir191.convertToXml(sheet191_impl, table);break;
            case "QDFIR192":
                mdfir192.convertToXml(sheet192_impl, table);break;
            case "QDFIR193":
                mdfir193.convertToXml(sheet193_impl, table);break;
            case "QDFIR201":
                mdfir201.convertToXml(sheet201_impl, table);break;
            case "QDFIR221":
                mdfir221.convertToXml(sheet221_impl, table);break;
            case "QDFIR223":
                mdfir223.convertToXml(sheet223_impl, table);break;
            case "QDFIR250":
                mdfir250.convertToXml(sheet250_impl, table);break;
            case "QDFIR271":
                mdfir271.convertToXml(sheet271_impl, table);break;
            case "QDFIR291":
                mdfir291.convertToXml(sheet291_impl, table);break;
            case "QDFIR292.1":
                mdfir292_1.convertToXml(sheet292_1_impl, table);break;
            case "QDFIR292.2":
                mdfir292_2.convertToXml(sheet292_2_impl, table);break;
            case "QDFIR292.3":
                mdfir292_3.convertToXml(sheet292_3_impl, table);break;
            case "QDFIR300":
                mdfir300.convertToXml(sheet300_impl, table);break;
            case "QDFIR302":
                mdfir302.convertToXml(sheet302_impl, table);break;
            case "QDFIR304":
                mdfir304.convertToXml(sheet304_impl, table);break;
            case "QDFIR311":
                mdfir311.convertToXml(sheet311_impl, table);break;
            case "QDFIR321":
                mdfir321.convertToXml(sheet321_impl, table);break;
            case "QDFIR333":
                mdfir333.convertToXml(sheet333_impl, table);break;
            case "QDFIR363":
                mdfir363.convertToXml(sheet363_impl, table);break;
            case "QDFIR371.1":
                mdfir371_1.convertToXml(sheet371_1_impl, table);break;
            case "QDFIR371.2":
                mdfir371_2.convertToXml(sheet371_2_impl, table);break;
            case "QDFIR371.3":
                mdfir371_3.convertToXml(sheet371_3_impl, table);break;
            case "QDFIR372":
                mdfir372.convertToXml(sheet372_impl, table);break;
            case "QDFIR382":
                mdfir382.convertToXml(sheet382_impl, table);break;
            case "QDFIR400":
            	qdfir400.convertToXml(sheet400_impl, table);break;
           /* case "QDFIR400.2": mdfir400_2.convertToXml(sheet400_2_impl, table);break;
            case "QDFIR400.3": mdfir400_3.convertToXml(sheet400_3_impl, table);break;
            case "QDFIR400.4": mdfir400_4.convertToXml(sheet400_4_impl, table);break;
            case "QDFIR400.5": mdfir400_5.convertToXml(sheet400_5_impl, table);break;
            case "QDFIR400.6": mdfir400_6.convertToXml(sheet400_6_impl, table);break;
            case "QDFIR400.7": mdfir400_7.convertToXml(sheet400_7_impl, table);break;
            case "QDFIR400.8": mdfir400_8.convertToXml(sheet400_8_impl, table);break;
            case "QDFIR400.9": mdfir400_9.convertToXml(sheet400_9_impl, table);break;
            case "QDFIR400.10": mdfir400_10.convertToXml(sheet400_10_impl, table);break;
            case "QDFIR400.11": mdfir400_11.convertToXml(sheet400_11_impl, table);break;
            case "QDFIR400.12": mdfir400_12.convertToXml(sheet400_12_impl, table);break;
            case "QDFIR400.13": mdfir400_13.convertToXml(sheet400_13_impl, table);break;
            case "QDFIR400.14": mdfir400_14.convertToXml(sheet400_14_impl, table);break;
            case "QDFIR400.15": mdfir400_15.convertToXml(sheet400_15_impl, table);break;*/
            case "QDFIR412": mdfir412.convertToXml(sheet412_impl, table);break;
            case "QDFIR422": mdfir422.convertToXml(sheet422_impl, table);break;
            case "QDFIR423": mdfir423.convertToXml(sheet423_impl, table);break;
            case "QDFIR425": mdfir425.convertToXml(sheet425_impl, table);break;
            case "QDFIR432": mdfir432.convertToXml(sheet432_impl, table);break;

            case "QDFIR450": qdfir450.convertToXml(sheet450_impl, table);break;
           /* case "QDFIR450.2": mdfir450_2.convertToXml(sheet450_2_impl, table);break;
            case "QDFIR450.3": mdfir450_3.convertToXml(sheet450_3_impl, table);break;
            case "QDFIR450.4": mdfir450_4.convertToXml(sheet450_4_impl, table);break;
            case "QDFIR450.5": mdfir450_5.convertToXml(sheet450_5_impl, table);break;
            case "QDFIR450.6": mdfir450_6.convertToXml(sheet450_6_impl, table);break;
            case "QDFIR450.7": mdfir450_7.convertToXml(sheet450_7_impl, table);break;
            case "QDFIR450.8": mdfir450_8.convertToXml(sheet450_8_impl, table);break;
            case "QDFIR450.9": mdfir450_9.convertToXml(sheet450_9_impl, table);break;
            case "QDFIR450.10": mdfir450_10.convertToXml(sheet450_10_impl, table);break;
            case "QDFIR450.11": mdfir450_11.convertToXml(sheet450_11_impl, table);break;
            case "QDFIR450.12": mdfir450_12.convertToXml(sheet450_12_impl, table);break;
            case "QDFIR450.13": mdfir450_13.convertToXml(sheet450_13_impl, table);break;
            case "QDFIR450.14": mdfir450_14.convertToXml(sheet450_14_impl, table);break;
            case "QDFIR450.15": mdfir450_15.convertToXml(sheet450_15_impl, table);break;*/
            case "QDFIR453": mdfir453.convertToXml(sheet453_impl, table);break;
            case "QDFIR455": mdfir455.convertToXml(sheet455_impl, table);break;
            case "QDFIR493": mdfir493.convertToXml(sheet493_impl, table);break;
            case "QDFIR533": mdfir533.convertToXml(sheet533_impl, table);break;
            case "QDFIR600": mdfir600.convertToXml(sheet600, table);break;
            case "QDFIR601": mdfir601.convertToXml(sheet601_impl, table);break;
            case "QDFIR700": mdfir700.convertToXml(sheet700, table);break;
            case "QDFIR702": mdfir702.convertToXml(sheet702_impl, table);break;
            case "QDFIR800": mdfir800.convertToXml(sheet800_impl, table);break;
            case "QDFIR900": mdfir900.convertToXml(sheet900_impl, table);break;
            case "QDFIR920": mdfir920.convertToXml(sheet920_impl, table);break;
            case "QDFIR921": mdfir921.convertToXml(sheet921_impl, table);break;
            case "QDFIR1300": mdfir1300.convertToXml(sheet1300_impl, table);break;
            case "QDFIR1301": mdfir1301.convertToXml(sheet1301_impl, table);break;
            case "QDFIR1400": mdfir1400.convertToXml(sheet1400_impl, table);break;
            case "QDFIR1500": mdfir1500.convertToXml(sheet1500_impl, table);break;
            case "QDFIR1600": mdfir1600.convertToXml(sheet1600_impl, table);break;
            case "QDFIR1650": mdfir1650.convertToXml(sheet1650_impl, table);break;
            case "QDFIR1700": mdfir1700.convertToXml(sheet1700_impl, table);break;
            case "QSTDR1": mstdr1.convertToXml(sheet001_impl, table);break;
            case "QSTDR2": mstdr2.convertToXml(sheet002_impl, table);break;

        }
    }

    private void monthly(String className) throws JAXBException, IOException, ClassNotFoundException {
        switch (className.trim()) {
            case "MDFIR101":
                mdfir101.convertToXml(sheet101_impl, table);break;

            case "MDFIR122":
                mdfir122.convertToXml(sheet122_impl, table);break;

            case "MDFIR142":
                mdfir142.convertToXml(sheet142_impl, table);break;

            case "MDFIR172":
                mdfir172.convertToXml(sheet172_impl, table);break;

            case "MDFIR182":
                mdfir182.convertToXml(sheet182_impl, table);break;
            case "MDFIR191":
                mdfir191.convertToXml(sheet191_impl, table);break;

            case "MDFIR192":
                mdfir192.convertToXml(sheet192_impl, table);break;
            case "MSTDR1":
                mstdr1.convertToXml(sheet001_impl, table);break;
            case "MDFIR921":
                mdfir921.convertToXml(sheet921_impl, table);break;
            case "MDFIR900":
                mdfir900.convertToXml(sheet900_impl, table);break;
            case "MDFIR920":
                mdfir920.convertToXml(sheet920_impl, table);break;
            case "MDFIR702":
                mdfir702.convertToXml(sheet702_impl, table);break;
            case "MDFIR601":
                mdfir601.convertToXml(sheet601_impl, table);break;
            case "MDFIR493":
                mdfir493.convertToXml(sheet493_impl, table);break;
            case "MSTDR2":
                mstdr2.convertToXml(sheet002_impl, table);break;
            case "MDFIR412":
                mdfir412.convertToXml(sheet412_impl, table);break;
            case "MDFIR455":
                mdfir455.convertToXml(sheet455_impl, table);break;
            case "MDFIR432":
                mdfir432.convertToXml(sheet432_impl, table);break;
            case "MDFIR422":
                mdfir422.convertToXml(sheet422_impl, table);break;
            case "MDFIR425":
                mdfir425.convertToXml(sheet425_impl, table);break;
            case "MDFIR311":
                mdfir311.convertToXml(sheet311_impl, table);break;
            case "MDFIR292.3":
                mdfir292_3.convertToXml(sheet292_3_impl, table);break;
            case "MDFIR304":
                mdfir304.convertToXml(sheet304_impl, table);break;
            case "MDFIR292.2":
                mdfir292_2.convertToXml(sheet292_2_impl, table);break;
            case "MDFIR292.1":
                mdfir292_1.convertToXml(sheet292_1_impl, table);break;
            case "MDFIR291":
                mdfir291.convertToXml(sheet291_impl, table);break;
            case "MDFIR271":
                mdfir271.convertToXml(sheet271_impl, table);break;
            case "MDFIR223":
                mdfir223.convertToXml(sheet223_impl, table);break;
            case "MDFIR1600":
                mdfir1600.convertToXml(sheet1600_impl, table);break;
            case "MDFIR1500":
                mdfir1500.convertToXml(sheet1500_impl, table);break;
            case "MDFIR1400":
                mdfir1400.convertToXml(sheet1400_impl, table);break;
            case "MDFIR1301":
                mdfir1301.convertToXml(sheet1301_impl, table);break;
            case "MDFIR161":
                mdfir161.convertToXml(sheet161_impl, table);break;
            case "MDFIR1300":
                mdfir1300.convertToXml(sheet1300_impl, table);break;
            case "MDFIR250":
                mdfir250.convertToXml(sheet250_impl, table);break;
            case "MDFIR453":
                mdfir453.convertToXml(sheet453_impl, table);break;
            case "MDFIR302":
                mdfir302.convertToXml(sheet302_impl, table);break;
            case "MDFIR800":
                mdfir800.convertToXml(sheet800_impl, table);break;
            case "MDFIR700":
                mdfir700.convertToXml(sheet700, table);break;
            case "MDFIR600":
                mdfir600.convertToXml(sheet600, table);break;
            case "MDFIR533":
                mdfir533.convertToXml(sheet533_impl, table);break;
            case "MDFIR423":
                mdfir423.convertToXml(sheet423_impl, table);break;
            case "MDFIR100":
                mdfir100.convertToXml(sheet100_impl, table);break;
            case "MDFIR1200":
                mdfir1200.convertToXml(sheet1200_Impl, table);break;
            case "MDFIR1000":
                mdfir1000.convertToXml(sheet1000_impl, table);break;
            case "MDFIR300":
                mdfir300.convertToXml(sheet300_impl, table); break;
            case "MDFIR321":
                mdfir321.convertToXml(sheet321_impl, table); break;
            case "MCFPR1":
                MCFPR1.convertToXml(sheetMcfpr1_impl, table); break;
            case "MDFIR333":
                mdfir333.convertToXml(sheet333_impl, table); break;
            case  "MDFIR363":
                mdfir363.convertToXml(sheet363_impl, table);break;
            case  "MDFIR371.1":
                mdfir371_1.convertToXml(sheet371_1_impl, table);break;
            case  "MDFIR371.2":
                mdfir371_2.convertToXml(sheet371_2_impl, table);break;
            case  "MDFIR371.3":
                mdfir371_3.convertToXml(sheet371_3_impl, table);break;
            case  "MDFIR372":
                mdfir372.convertToXml(sheet372_impl, table);break;
            case  "MDFIR382":
                mdfir382.convertToXml(sheet382_impl, table);break;
            case  "MDFIR400":
                mdfir400.convertToXml(sheet400_impl, table);break;
           /* case  "MDFIR400.2":
                mdfir400_2.convertToXml(sheet400_2_impl, table);break;
            case  "MDFIR400.3":
                mdfir400_3.convertToXml(sheet400_3_impl, table);break;
            case  "MDFIR400.4":
                mdfir400_4.convertToXml(sheet400_4_impl, table);break;
            case  "MDFIR400.5":
                mdfir400_5.convertToXml(sheet400_5_impl, table);break;
            case  "MDFIR400.6":
                mdfir400_6.convertToXml(sheet400_6_impl, table);break;
            case  "MDFIR400.7":
                mdfir400_7.convertToXml(sheet400_7_impl, table);break;
            case  "MDFIR400.8":
                mdfir400_8.convertToXml(sheet400_8_impl, table);break;
            case  "MDFIR400.9":
                mdfir400_9.convertToXml(sheet400_9_impl, table);break;
            case  "MDFIR400.10":
                mdfir400_10.convertToXml(sheet400_10_impl, table);break;
            case  "MDFIR400.11":
                mdfir400_11.convertToXml(sheet400_11_impl, table);break;
            case  "MDFIR400.12":
                mdfir400_12.convertToXml(sheet400_12_impl, table);break;
            case  "MDFIR400.13":
                mdfir400_13.convertToXml(sheet400_13_impl, table);break;
            case  "MDFIR400.14":
                mdfir400_14.convertToXml(sheet400_14_impl, table);break;
            case  "MDFIR400.15":
                mdfir400_15.convertToXml(sheet400_15_impl, table);break;*/
            case  "MDFIR450":
                mdfir450.convertToXml(sheet450_impl, table);break;
           /* case  "MDFIR450.2":
                mdfir450_2.convertToXml(sheet450_2_impl, table);break;
            case  "MDFIR450.3":
                mdfir450_3.convertToXml(sheet450_3_impl, table);break;
            case  "MDFIR450.4":
                mdfir450_4.convertToXml(sheet450_4_impl, table);break;
            case  "MDFIR450.5":
                mdfir450_5.convertToXml(sheet450_5_impl, table);break;
            case  "MDFIR450.6":
                mdfir450_6.convertToXml(sheet450_6_impl, table);break;
            case  "MDFIR450.7":
                mdfir450_7.convertToXml(sheet450_7_impl, table);break;
            case  "MDFIR450.8":
                mdfir450_8.convertToXml(sheet450_8_impl, table);break;
            case  "MDFIR450.9":
                mdfir450_9.convertToXml(sheet450_9_impl, table);break;
            case  "MDFIR450.10":
                mdfir450_10.convertToXml(sheet450_10_impl, table);break;
            case  "MDFIR450.11":
                mdfir450_11.convertToXml(sheet450_11_impl, table);break;
            case  "MDFIR450.12":
                mdfir450_12.convertToXml(sheet450_12_impl, table);break;
            case  "MDFIR450.13":
                mdfir450_13.convertToXml(sheet450_13_impl, table);break;
            case  "MDFIR450.14":
                mdfir450_14.convertToXml(sheet450_14_impl, table);break;
            case  "MDFIR450.15":
                mdfir450_15.convertToXml(sheet450_15_impl, table);break;*/
            case  "MDFIR1650":
                mdfir1650.convertToXml(sheet1650_impl, table);break;
            case  "MDFIR1700":
                mdfir1700.convertToXml(sheet1700_impl, table);break;
            case  "MDFIR201":
                mdfir201.convertToXml(sheet201_impl, table);break;
            case  "MDFIR193":
                mdfir193.convertToXml(sheet193_impl, table);break;
            case  "MDFIR221":
                mdfir221.convertToXml(sheet221_impl, table);break;
        }
    }

    private void saveDownloadActivity() {
            UUID randomUUID = UUID.randomUUID();
            int id = (int) randomUUID.getLeastSignificantBits();

            ActivityDAO activityDAO = new ActivityDAO();
            activityDAO.setId(id);
            activityDAO.setReportDescription("Reports generated for " + activityController.getDate());
            activityDAO.setDateDescription(Calendar.getInstance().getTime().toString());
            activityDAO.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
            activityController.saveActivity(activityDAO);
    }
}
