package com.efass.report;

import java.util.ArrayList;

import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir100.sheetQdfirDAO;
import com.efass.sheet.mdfir1200.sheet1200DAO;
import com.efass.sheet.mdfir1200.sheetQdfir1200DAO;
import com.efass.sheet.mdfir302.sheet302DAO;
import com.efass.sheet.mdfir302.sheetQdfir302DAO;
import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.mdfir533.sheet533DAO;
import com.efass.sheet.mdfir533.sheetQdfir533DAO;

public class ReportResponse {

	public String responseMessage;
	public int responseCode;
	
	ArrayList<ReportDAO> reportData;

    public sheet100DAO sheet100Data;
    public Iterable<sheet100DAO> mdfir100;
    
    public sheet1200DAO sheet1200Data;
    public Iterable<sheet1200DAO> mdfir1200;
    
    public sheet302DAO sheet302Data;
    public Iterable<sheet302DAO> mdfir302;
    
    public sheet423DAO sheet423Data;
    public Iterable<sheet423DAO> mdfir423;
    
    public sheet533DAO sheet533Data;
    public Iterable<sheet533DAO> mdfir533;
    
    public sheetQdfirDAO qdfir100Data;
    public Iterable<sheetQdfirDAO> Qdfir100;
    
    public sheetQdfir1200DAO qdfir1200Data;
    public Iterable<sheetQdfir1200DAO> Qdfir1200;
    
    public sheetQdfir302DAO qdfir302Data;
    public Iterable<sheetQdfir302DAO> Qdfir302;
    
    public sheetQdfir423DAO qdfir423Data;
    public Iterable<sheetQdfir423DAO> Qdfir423;
    
    public sheetQdfir533DAO qdfir533Data;
    public Iterable<sheetQdfir533DAO> Qdfir533;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public ArrayList<ReportDAO> getReportData() {
		return reportData;
	}

	public void setReportData(ArrayList<ReportDAO> reportData) {
		this.reportData = reportData;    
	}

	public sheet100DAO getSheet100Data() {
		return sheet100Data;
	}

	public void setSheet100Data(sheet100DAO sheet100Data) {
		this.sheet100Data = sheet100Data;
	}

	public Iterable<sheet100DAO> getMdfir100() {
		return mdfir100;
	}

	public void setMdfir100(Iterable<sheet100DAO> mdfir100) {
		this.mdfir100 = mdfir100;
	}

	public sheet1200DAO getSheet1200Data() {
		return sheet1200Data;
	}

	public void setSheet1200Data(sheet1200DAO sheet1200Data) {
		this.sheet1200Data = sheet1200Data;
	}

	public Iterable<sheet1200DAO> getMdfir1200() {
		return mdfir1200;
	}

	public void setMdfir1200(Iterable<sheet1200DAO> mdfir1200) {
		this.mdfir1200 = mdfir1200;
	}

	public sheet302DAO getSheet302Data() {
		return sheet302Data;
	}

	public void setSheet302Data(sheet302DAO sheet302Data) {
		this.sheet302Data = sheet302Data;
	}

	public Iterable<sheet302DAO> getMdfir302() {
		return mdfir302;
	}

	public void setMdfir302(Iterable<sheet302DAO> mdfir302) {
		this.mdfir302 = mdfir302;
	}

	public sheet423DAO getSheet423Data() {
		return sheet423Data;
	}

	public void setSheet423Data(sheet423DAO sheet423Data) {
		this.sheet423Data = sheet423Data;
	}

	public Iterable<sheet423DAO> getMdfir423() {
		return mdfir423;
	}

	public void setMdfir423(Iterable<sheet423DAO> mdfir423) {
		this.mdfir423 = mdfir423;
	}

	public sheet533DAO getSheet533Data() {
		return sheet533Data;
	}

	public void setSheet533Data(sheet533DAO sheet533Data) {
		this.sheet533Data = sheet533Data;
	}

	public Iterable<sheet533DAO> getMdfir533() {
		return mdfir533;
	}

	public void setMdfir533(Iterable<sheet533DAO> mdfir533) {
		this.mdfir533 = mdfir533;
	}

	public sheetQdfirDAO getQdfir100Data() {
		return qdfir100Data;
	}

	public void setQdfir100Data(sheetQdfirDAO qdfir100Data) {
		this.qdfir100Data = qdfir100Data;
	}

	public Iterable<sheetQdfirDAO> getQdfir100() {
		return Qdfir100;
	}

	public void setQdfir100(Iterable<sheetQdfirDAO> qdfir100) {
		Qdfir100 = qdfir100;
	}

	public sheetQdfir1200DAO getQdfir1200Data() {
		return qdfir1200Data;
	}

	public void setQdfir1200Data(sheetQdfir1200DAO qdfir1200Data) {
		this.qdfir1200Data = qdfir1200Data;
	}

	public Iterable<sheetQdfir1200DAO> getQdfir1200() {
		return Qdfir1200;
	}

	public void setQdfir1200(Iterable<sheetQdfir1200DAO> qdfir1200) {
		Qdfir1200 = qdfir1200;
	}

	public sheetQdfir302DAO getQdfir302Data() {
		return qdfir302Data;
	}

	public void setQdfir302Data(sheetQdfir302DAO qdfir302Data) {
		this.qdfir302Data = qdfir302Data;
	}

	public Iterable<sheetQdfir302DAO> getQdfir302() {
		return Qdfir302;
	}

	public void setQdfir302(Iterable<sheetQdfir302DAO> qdfir302) {
		Qdfir302 = qdfir302;
	}

	public sheetQdfir423DAO getQdfir423Data() {
		return qdfir423Data;
	}

	public void setQdfir423Data(sheetQdfir423DAO qdfir423Data) {
		this.qdfir423Data = qdfir423Data;
	}

	public Iterable<sheetQdfir423DAO> getQdfir423() {
		return Qdfir423;
	}

	public void setQdfir423(Iterable<sheetQdfir423DAO> qdfir423) {
		Qdfir423 = qdfir423;
	}

	public sheetQdfir533DAO getQdfir533Data() {
		return qdfir533Data;
	}

	public void setQdfir533Data(sheetQdfir533DAO qdfir533Data) {
		this.qdfir533Data = qdfir533Data;
	}

	public Iterable<sheetQdfir533DAO> getQdfir533() {
		return Qdfir533;
	}

	public void setQdfir533(Iterable<sheetQdfir533DAO> qdfir533) {
		Qdfir533 = qdfir533;
	}

	
	
	
}
