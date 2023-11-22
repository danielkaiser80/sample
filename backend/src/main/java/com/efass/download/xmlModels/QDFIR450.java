package com.efass.download.xmlModels;


import com.efass.ReportGroupEnum;
import com.efass.sheet.mdfir450.sheet450_Impl;
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
public class QDFIR450 {

   // public static final String REPORT_NAME = "MDFIR450.1";
    public static final String REPORT_NAME = "QDFIR450";
    private sheet450_Impl sheet450_impl;
    private TableImpl table;
    XmlHeader HEADER;

    public QDFIR450() {
    }

    public QDFIR450(sheet450_Impl sheet450_impl, TableImpl table) {
        this.sheet450_impl = sheet450_impl;
        this.table = table;
    }

    public XmlHeader getHEADER() {       
            table.getTableDataByReportName("QDFIR450");
        return table.getXmlHeader();

    }

    public void setHEADER(XmlHeader HEADER) {
        this.HEADER = HEADER;
    }

    public Body getBODY() {    	
    		sheet450_impl.fetchAllData();
            return new Body(sheet450_impl.getSheet450_XmlList());     
        
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

    public void convertToXml(sheet450_Impl sheet450_impl, TableImpl table) throws JAXBException, IOException, ClassNotFoundException {
        Class<?> klass = Class.forName(this.getClass().getName());
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String simpleName = "";
       
            simpleName = "QDFIR450";
       
        marshaller.marshal(new QDFIR450(sheet450_impl, table), Files.newOutputStream(Paths.get(simpleName + ".xml")));
    }}
