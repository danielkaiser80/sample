package com.efass.download.xmlModels;

import com.efass.ReportGroupEnum;
import com.efass.sheet.mdfir601.sheet601_Impl;
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
public class MDFIR601 {
    private sheet601_Impl sheet601_impl;
    private TableImpl table;
    XmlHeader HEADER;

    public MDFIR601() {
    }

    public MDFIR601(sheet601_Impl sheet601_impl, TableImpl table) {
        this.sheet601_impl = sheet601_impl;
        this.table = table;
    }

    public XmlHeader getHEADER() {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            table.getTableDataByReportName(this.getClass().getSimpleName());
        }

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            table.getTableDataByReportName("QDFIR601");
        }
        return table.getXmlHeader();
    }

    public void setHEADER(XmlHeader HEADER) {
        this.HEADER = HEADER;
    }

    public MDFIR601.Body getBODY() {
        sheet601_impl.fetchAllData();
        return new MDFIR601.Body(sheet601_impl.getSheet601XmlList());
    }

    public void setBODY(MDFIR601.Body body) {
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

    public void convertToXml(sheet601_Impl sheet601_impl, TableImpl table) throws JAXBException, IOException, ClassNotFoundException {
        Class<?> klass = Class.forName(this.getClass().getName());
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String simpleName = "";
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            simpleName = "QDFIR601";
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            simpleName = this.getClass().getSimpleName();
        }
        marshaller.marshal(new MDFIR601(sheet601_impl, table), Files.newOutputStream(Paths.get(simpleName + ".xml")));
    }
}
