package com.efass.download.xmlModels;

import com.efass.ReportGroupEnum;
import com.efass.sheet.mdfir1300.sheet1300_Impl;
import com.efass.sheet.table.TabController;
import com.efass.sheet.table.TableImpl;
import com.efass.sheet.table.XmlHeader;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@XmlRootElement(name = "RETURN")
@XmlType(name = "", propOrder = {"HEADER", "BODY"})
@Component
public class MDFIR1300 {

    private sheet1300_Impl sheet1300_impl;
    private TableImpl table;
    XmlHeader HEADER;

    public MDFIR1300() {
    }

    public MDFIR1300(sheet1300_Impl sheet1300_impl, TableImpl table) {
        this.sheet1300_impl = sheet1300_impl;
        this.table = table;
    }

    public XmlHeader getHEADER() {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            table.getTableDataByReportName(this.getClass().getSimpleName());
        }

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            table.getTableDataByReportName("QDFIR1300");
        }
        return table.getXmlHeader();
    }

    public void setHEADER(XmlHeader HEADER) {
        this.HEADER = HEADER;
    }

    public Body getBODY() {
        sheet1300_impl.fetchAllData();
        return new Body(sheet1300_impl.getSheet1300XmlList());
    }

    public void setBODY(Body body) {
    }

    static class Header {
        XmlHeader HEADER;

        public Header(XmlHeader HEADER) {
            this.HEADER = HEADER;
        }

        public XmlHeader getHEADER() {
            return HEADER;
        }

        public void setHEADER(XmlHeader HEADER) {
            this.HEADER = HEADER;
        }
    }

    static class Body {
        List<GenericXml> ITEM;

        public Body(List<GenericXml> ITEM) {
            this.ITEM = ITEM;
        }

        public List<GenericXml> getITEM() {
            return ITEM;
        }

        public void setITEM(List<GenericXml> ITEM) {
            this.ITEM = ITEM;
        }
    }

    public void convertToXml(sheet1300_Impl sheet1300_impl, TableImpl table) throws JAXBException, IOException, ClassNotFoundException {
        Class<?> klass = Class.forName(this.getClass().getName());
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String simpleName = "";
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            simpleName = "QDFIR1300";
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            simpleName = this.getClass().getSimpleName();
        }
        marshaller.marshal(new MDFIR1300(sheet1300_impl, table), Files.newOutputStream(Paths.get(simpleName + ".xml")));
    }
}
