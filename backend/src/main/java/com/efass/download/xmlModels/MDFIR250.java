package com.efass.download.xmlModels;

import com.efass.ReportGroupEnum;
import com.efass.sheet.mdfir250.sheet250_Impl;

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
public class MDFIR250 {
    private sheet250_Impl sheet250_impl;
    private TableImpl table;
    XmlHeader HEADER;

    public MDFIR250() {
    }

    public MDFIR250(sheet250_Impl sheet250_impl, TableImpl table) {
        this.sheet250_impl = sheet250_impl;
        this.table = table;
    }

    public XmlHeader getHEADER() {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            table.getTableDataByReportName(this.getClass().getSimpleName());
        }

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            table.getTableDataByReportName("QDFIR250");
        }
        return table.getXmlHeader();
    }

    public void setHEADER(XmlHeader HEADER) {
        this.HEADER = HEADER;
    }

    public MDFIR250.Body getBODY() {
        sheet250_impl.fetchAllData();
        return new MDFIR250.Body(sheet250_impl.getSheet250XmlList());
    }

    public void setBODY(MDFIR250.Body body) {
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

    public void convertToXml(sheet250_Impl sheet250_impl, TableImpl table) throws JAXBException, IOException, ClassNotFoundException {
        Class<?> klass = Class.forName(this.getClass().getName());
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String simpleName = "";
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            simpleName = "QDFIR250";
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            simpleName = this.getClass().getSimpleName();
        }
        marshaller.marshal(new MDFIR250(sheet250_impl, table), Files.newOutputStream(Paths.get(simpleName + ".xml")));
    }

}
