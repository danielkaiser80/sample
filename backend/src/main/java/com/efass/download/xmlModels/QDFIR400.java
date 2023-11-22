package com.efass.download.xmlModels;


import com.efass.ReportGroupEnum;
import com.efass.sheet.mdfir400.sheet400_Impl;
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
public class QDFIR400 {

   // public static final String REPORT_NAME = "MDFIR400.1";
    public static final String REPORT_NAME = "QDFIR400";
    private sheet400_Impl sheet400_impl;
    private TableImpl table;
    XmlHeader HEADER;

    public QDFIR400() {
    }

    public QDFIR400(sheet400_Impl sheet400_impl, TableImpl table) {
        this.sheet400_impl = sheet400_impl;
        this.table = table;
    }

    public XmlHeader getHEADER() {       
            table.getTableDataByReportName("QDFIR400");
        return table.getXmlHeader();

    }

    public void setHEADER(XmlHeader HEADER) {
        this.HEADER = HEADER;
    }

    public Body getBODY() {    	
    		sheet400_impl.fetchAllData();
            return new Body(sheet400_impl.getSheet400_XmlList());     
        
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

    public void convertToXml(sheet400_Impl sheet400_impl, TableImpl table) throws JAXBException, IOException, ClassNotFoundException {
        Class<?> klass = Class.forName(this.getClass().getName());
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String simpleName = "";
       
            simpleName = "QDFIR400";
       
        marshaller.marshal(new QDFIR400(sheet400_impl, table), Files.newOutputStream(Paths.get(simpleName + ".xml")));
    }}
