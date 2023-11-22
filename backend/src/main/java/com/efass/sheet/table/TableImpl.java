package com.efass.sheet.table;

import com.efass.ReportGroupEnum;
import com.efass.activity.ActivityController;
import com.efass.activity.ActivityDAO;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TableImpl implements TableService {

    @Autowired private ActivityController activityController;

    @Value("${app.bank_name}")
	private String bank_name;
	@Value("${app.bank_code}")
	private String bank_code;
	@Value("${app.return_code}")
	private String return_code;
    private Iterable<TabSheet> tableData;

    public Iterable<TabSheet> getTableData() {
        return tableData;
    }

    public void setTableData(Iterable<TabSheet> tableData) {
        this.tableData = tableData;
    }

    private  XmlHeader xmlHeader;

    public XmlHeader getXmlHeader() {
        return xmlHeader;
    }

    public void setXmlHeader(XmlHeader xmlHeader) {
        this.xmlHeader = xmlHeader;
    }

    @Autowired
    tableRepository tableRepo;
    @Autowired
     ReportDbService reportDbService;

    @Override
    public ResponseEntity<?> AssetsTableData() {
        return null;
    }


    @Override
    public ResponseEntity<?> getDataByMonths(String report_group) throws ResourceNotFoundException {
        Iterable<TabSheet> data = reportDbService.queryReportGroup(report_group);

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        setTableData(data);
       // res.setTableSheet(data);
        res.setData(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

  /*  @Override
    public XmlHeader getTableDataByReportName(String reportName) {

        LocalDateTime date;
//        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();
        LocalDateTime dateTime = LocalDateTime.parse(activityController.getDate(), formatter);
//        date = LocalDateTime.parse(activityController.getDate(), formatter);

        LocalDateTime finalDate = dateTime;
        getTableData().forEach((e) -> {
            if (reportName.equals(e.getReturn_code())) {
               Month month = finalDate.getMonth();
                Year year = Year.of(finalDate.getYear());
               int start = 1;
               int end = month.maxLength();
               e.setPERIODFROM("0" + start + "/" + month.getValue() +  "/" + year);
               e.setPERIODEND(end + "/" + month.getValue() + "/" + year);
                XmlHeader xmlHeader = new XmlHeader(e.getBank_code(), e.getBank_name(),
                        e.getReturn_code(), e.getReturn_name(), e.getPERIODFROM(), e.getPERIODEND(),
                        e.getReport_group(), "ORIG", "", "en_US");
                setXmlHeader(xmlHeader);
            }
        });
        System.out.println(getXmlHeader());
        return getXmlHeader();
    }*/

    @Override
    public XmlHeader getTableDataByReportName(String reportName)
    {
     LocalDateTime date;

     DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd")
    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
    .toFormatter();
LocalDate dateTime = LocalDate.parse(activityController.getDate(), formatter);
if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {

    //LocalDate finalDate = dateTime;
    getTableData().forEach((e) -> {
            if (reportName.equals(e.getReturn_code())) {
                Month month = dateTime.getMonth();
                Year year = Year.of(dateTime.getYear());

                int start = 1;
                int end = month.maxLength();
                if (month == Month.FEBRUARY && !year.isLeap()) {
                    end = 28;
                }

                e.setPERIODFROM("0" + start + "/" + month.getValue() + "/" + year);
                e.setPERIODEND(end + "/" + month.getValue() + "/" + year);

                XmlHeader xmlHeader = new XmlHeader(e.getBank_code(), e.getBank_name(),
                    e.getReturn_code(), e.getReturn_name(), e.getPERIODFROM(), e.getPERIODEND(),
                    e.getReport_group(), "ORIG", "", "en_US");
                setXmlHeader(xmlHeader);
            }
        }
    );
    System.out.println(getXmlHeader());
}
if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
    getTableData().forEach((e) -> {
            if (reportName.equals(e.getReturn_code())) {
                Month month = dateTime.getMonth();
                Month month1;
                Month month2;
                String display ;
                String display1 ;
                if (month.getValue() < 4){
                    month1 =  Month.valueOf(String.valueOf(Month.JANUARY));
                    month2 = Month.valueOf(String.valueOf(Month.MARCH));
                    display = "0" + month1.getValue();
                    display1 = "0" + month2.getValue();
                } else if (month.getValue() < 7){
                    month1 =  Month.valueOf(String.valueOf(Month.APRIL));
                    month2 = Month.valueOf(String.valueOf(Month.JUNE));
                    display = "0" + month1.getValue();
                    display1 = "0" + month2.getValue();
                }else if (month.getValue() < 10){
                    month1 =  Month.valueOf(String.valueOf(Month.JULY));
                    month2 =  Month.valueOf(String.valueOf(Month.SEPTEMBER));
                    display = "0" + month1.getValue();
                    display1 = "0" + month2.getValue();
                }else {
                    month1 =  Month.valueOf(String.valueOf(Month.OCTOBER));
                    month2 =  Month.valueOf(String.valueOf(Month.DECEMBER));
                    display = "" + month1.getValue();
                    display1 = "" + month2.getValue();
                }


                Year year = Year.of(dateTime.getYear());

                int start = 1;
                int end = month2.maxLength();
//                if (month == Month.FEBRUARY && !year.isLeap()) {
//                    end = 28;
//                }
                e.setPERIODFROM("0" + start + "/" + display + "/" + year);
                e.setPERIODEND(end + "/" + display1 + "/" + year);


                XmlHeader xmlHeader = new XmlHeader(e.getBank_code(), e.getBank_name(),
                    e.getReturn_code(), e.getReturn_name(), e.getPERIODFROM(), e.getPERIODEND(),
                    e.getReport_group(), "ORIG", "", "en_US");
                setXmlHeader(xmlHeader);
            }
        }
    );
}
        return getXmlHeader();
    }


}
