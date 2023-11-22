package com.efass.sheet.table;


public class XmlHeader {

 public String BANKCODE;
 public String BANKNAME;
 public String RETURNCODE;
 public String RETURNNAME;
 public String PERIODFROM;
 public String PERIODEND;
 public String REPORTGROUP;

 public String VER;

 public String SIGNED;

 public String LNG;

 public XmlHeader(String BANKCODE, String BANKNAME, String RETURNCODE, String RETURNNAME, String PERIODFROM,
                  String PERIODEND, String REPORTGROUP, String VER, String SIGNED, String LNG) {
  this.BANKCODE = BANKCODE;
  this.BANKNAME = BANKNAME;
  this.RETURNCODE = RETURNCODE;
  this.RETURNNAME = RETURNNAME;
  this.PERIODFROM = PERIODFROM;
  this.PERIODEND = PERIODEND;
  this.REPORTGROUP = REPORTGROUP;
  this.VER = VER;
 this.SIGNED = SIGNED;
  this.LNG = LNG;
 }
}
