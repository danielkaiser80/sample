package com.efass.download.xmlModels;

import com.efass.ReportGroupEnum;
import com.efass.sheet.mdfir292_1.sheet292_1_Impl;
import com.efass.sheet.mdfir292_1.sheet292_1_Impl;
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
public class MDFIR292_1
{
	public static final String REPORT_NAME = "MDFIR292.1";
    private sheet292_1_Impl sheet292_1_impl;
    private TableImpl table;
    XmlHeader HEADER;

    public MDFIR292_1() {
    }

    public MDFIR292_1(sheet292_1_Impl sheet292_1_impl, TableImpl table) {
        this.sheet292_1_impl = sheet292_1_impl;
        this.table = table;
    }

    public XmlHeader getHEADER() {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            table.getTableDataByReportName("MDFIR292.1");
        }

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            table.getTableDataByReportName("QDFIR292.1");
        }
        return table.getXmlHeader();
    }

    public void setHEADER(XmlHeader HEADER) {
        this.HEADER = HEADER;
    }

    public MDFIR292_1.Body getBODY() {
        sheet292_1_impl.fetchAllData();
        return new MDFIR292_1.Body(sheet292_1_impl.getSheet292_1XmlList());
    }

    public void setBODY(MDFIR292_1.Body body) {
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

    public void convertToXml(sheet292_1_Impl sheet292_1_impl, TableImpl table) throws JAXBException, IOException, ClassNotFoundException {
        Class<?> klass = Class.forName(this.getClass().getName());
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String simpleName = "";

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            simpleName = "QDFIR292.1";
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            simpleName = "MDFIR292.1";
        }
        marshaller.marshal(new MDFIR292_1(sheet292_1_impl, table), Files.newOutputStream(Paths.get(simpleName + ".xml")));

    }
}
