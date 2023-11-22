package com.efass.payload;

import java.util.ArrayList;

import com.efass.auth.jwt.user.DAOUser;
import com.efass.report.ReportDAO;
import com.efass.sheet.mcfpr1.sheetMcfpr1DAO;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import com.efass.sheet.mdfir101.sheet101DAO;
import com.efass.sheet.mdfir1200.sheet1200DAO;
import com.efass.sheet.mdfir122.sheet122DAO;
import com.efass.sheet.mdfir1300.sheet1300DAO;
import com.efass.sheet.mdfir1301.sheet1301DAO;
import com.efass.sheet.mdfir1400.sheet1400DAO;
import com.efass.sheet.mdfir142.sheet142DAO;
import com.efass.sheet.mdfir1500.sheet1500DAO;
import com.efass.sheet.mdfir1600.sheet1600DAO;
import com.efass.sheet.mdfir161.sheet161DAO;
import com.efass.sheet.mdfir1650.sheet1650DAO;
import com.efass.sheet.mdfir1700.sheet1700DAO;
import com.efass.sheet.mdfir172.sheet172DAO;
import com.efass.sheet.mdfir182.sheet182DAO;
import com.efass.sheet.mdfir191.sheet191DAO;
import com.efass.sheet.mdfir192.sheet192DAO;
import com.efass.sheet.mdfir193.sheet193DAO;
import com.efass.sheet.mdfir201.sheet201DAO;
import com.efass.sheet.mdfir221.sheet221DAO;
import com.efass.sheet.mdfir223.sheet223DAO;
import com.efass.sheet.mdfir250.sheet250DAO;
import com.efass.sheet.mdfir271.sheet271DAO;
import com.efass.sheet.mdfir291.sheet291DAO;
import com.efass.sheet.mdfir292_1.sheet292_1DAO;
import com.efass.sheet.mdfir292_2.sheet292_2DAO;
import com.efass.sheet.mdfir292_3.sheet292_3DAO;
import com.efass.sheet.mdfir300.sheet300DAO;
import com.efass.sheet.mdfir302.sheet302DAO;
import com.efass.sheet.mdfir304.sheet304DAO;
import com.efass.sheet.mdfir311.sheet311DAO;
import com.efass.sheet.mdfir321.sheet321DAO;
import com.efass.sheet.mdfir333.sheet333DAO;
import com.efass.sheet.mdfir363.sheet363DAO;
import com.efass.sheet.mdfir371_1.sheet371_1DAO;
import com.efass.sheet.mdfir371_2.sheet371_2DAO;
import com.efass.sheet.mdfir371_3.sheet371_3DAO;
import com.efass.sheet.mdfir372.sheet372DAO;
import com.efass.sheet.mdfir382.sheet382DAO;
import com.efass.sheet.mdfir400.sheet400_DAO;
import com.efass.sheet.mdfir400_1.sheet400_1DAO;
import com.efass.sheet.mdfir400_10.sheet400_10DAO;
import com.efass.sheet.mdfir400_11.sheet400_11DAO;
import com.efass.sheet.mdfir400_12.sheet400_12DAO;
import com.efass.sheet.mdfir400_13.sheet400_13DAO;
import com.efass.sheet.mdfir400_14.sheet400_14DAO;
import com.efass.sheet.mdfir400_15.sheet400_15DAO;
import com.efass.sheet.mdfir400_2.sheet400_2DAO;
import com.efass.sheet.mdfir400_3.sheet400_3DAO;
import com.efass.sheet.mdfir400_4.sheet400_4DAO;
import com.efass.sheet.mdfir400_5.sheet400_5DAO;
import com.efass.sheet.mdfir400_6.sheet400_6DAO;
import com.efass.sheet.mdfir400_7.sheet400_7DAO;
import com.efass.sheet.mdfir400_8.sheet400_8DAO;
import com.efass.sheet.mdfir400_9.sheet400_9DAO;
import com.efass.sheet.mdfir412.sheet412DAO;
import com.efass.sheet.mdfir422.sheet422DAO;
import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir425.sheet425DAO;
import com.efass.sheet.mdfir432.sheet432DAO;
import com.efass.sheet.mdfir450.sheet450_DAO;
import com.efass.sheet.mdfir450_1.sheet450_1DAO;
import com.efass.sheet.mdfir450_10.sheet450_10DAO;
import com.efass.sheet.mdfir450_11.sheet450_11DAO;
import com.efass.sheet.mdfir450_12.sheet450_12DAO;
import com.efass.sheet.mdfir450_13.sheet450_13DAO;
import com.efass.sheet.mdfir450_14.sheet450_14DAO;
import com.efass.sheet.mdfir450_15.sheet450_15DAO;
import com.efass.sheet.mdfir450_2.sheet450_2DAO;
import com.efass.sheet.mdfir450_3.sheet450_3DAO;
import com.efass.sheet.mdfir450_4.sheet450_4DAO;
import com.efass.sheet.mdfir450_5.sheet450_5DAO;
import com.efass.sheet.mdfir450_6.sheet450_6DAO;
import com.efass.sheet.mdfir450_7.sheet450_7DAO;
import com.efass.sheet.mdfir450_8.sheet450_8DAO;
import com.efass.sheet.mdfir450_9.sheet450_9DAO;
import com.efass.sheet.mdfir453.sheet453DAO;
import com.efass.sheet.mdfir455.sheet455DAO;
import com.efass.sheet.mdfir493.sheet493DAO;
import com.efass.sheet.mdfir533.sheet533DAO;
import com.efass.sheet.mdfir600.sheet600DAO;
import com.efass.sheet.mdfir601.sheet601DAO;
import com.efass.sheet.mdfir700.sheet700DAO;
import com.efass.sheet.mdfir702.sheet702DAO;
import com.efass.sheet.mdfir800.sheet800DAO;
import com.efass.sheet.mdfir900.sheet900DAO;
import com.efass.sheet.mdfir920.sheet920DAO;
import com.efass.sheet.mdfir921.sheet921DAO;
import com.efass.sheet.mdfir921.sheetQdfir921DAO;
import com.efass.sheet.mstdr1.sheet001DAO;
import com.efass.sheet.mstdr2.sheet002DAO;
import com.efass.sheet.table.TabSheet;
import com.efass.user.UserDAO;

public class Response {

	public String responseMessage;
	public int responseCode;
	public UserDAO user;
	public DAOUser daoUser;
	public Iterable<UserDAO> allUsers;
	public String token;
	public String filePath;

	public String fileId;

	public Iterable<sheet221DAO> sheet221;
	public sheet221DAO s221Data;

	public sheet311DAO s311Data;
	public Iterable<sheet311DAO> sheet311;

	public sheet382DAO s382Data;
	public Iterable<sheet382DAO> sheet382;

	public sheet321DAO s321Data;
	public Iterable<sheet321DAO> sheet321;

	public sheet101DAO s101Data;
	public Iterable<sheet101DAO> sheet101;

	public sheet372DAO s372Data;
	public Iterable<sheet372DAO> sheet372;

	public sheet302DAO s302Data;

	public sheet412DAO s412Data;
	public Iterable<sheet412DAO> sheet412;

	public sheet422DAO s422Data;
	public Iterable<sheet422DAO> sheet422;

	public sheet425DAO s425Data;
	public Iterable<sheet425DAO> sheet425;

	public sheet432DAO s432Data;
	public Iterable<sheet432DAO> sheet432;

	public sheet271DAO s271Data;
	public Iterable<sheet271DAO> sheet271;

	public sheet122DAO s122Data;
	public Iterable<sheet122DAO> sheet122;

	public sheet423DAO s423Data;
	public Iterable<sheet423DAO> sheet423;

	public sheet1200DAO s1200Data;
	public Iterable<sheet1200DAO> sheet1200;

	public sheet533DAO s533Data;
	public Iterable<sheet533DAO> sheet533;

	public sheet201DAO s201Data;
	public Iterable<sheet201DAO> sheet201;

	public sheet300DAO s300Data;
	public Iterable<sheet300DAO> sheet300;

	public sheet191DAO s191Data;
	public Iterable<sheet191DAO> sheet191;

	public sheet192DAO s192Data;
	public Iterable<sheet192DAO> sheet192;

	public sheet100DAO s100Data;
	public Iterable<sheet100DAO> sheet100;

	public sheet142DAO s142Data;
	public Iterable<sheet142DAO> sheet142;

	public sheet172DAO s172Data;
	public Iterable<sheet172DAO> sheet172;

	public sheet250DAO s250Data;
	public Iterable<sheet250DAO> sheet250;

	public sheet161DAO s161Data;
	public Iterable<sheet161DAO> sheet161;

	public sheet182DAO s182Data;
	public Iterable<sheet182DAO> sheet182;

	public sheet193DAO s193Data;
	public Iterable<sheet193DAO> sheet193;

	public sheet304DAO s304Data;
	public Iterable<sheet304DAO> sheet304;

	public sheet600DAO s600Data;
	public Iterable<sheet600DAO> sheet600;

	public sheet601DAO s601Data;
	public Iterable<sheet601DAO> sheet601;

	public sheet400_DAO s400_Data;
	public Iterable<sheet400_DAO> sheet400;

	public sheet450_DAO s450_Data;
	public Iterable<sheet450_DAO> sheet450;

	public sheet400_1DAO s400_1Data;
	public Iterable<sheet400_1DAO> sheet400_1;

	public sheet400_2DAO s400_2Data;
	public Iterable<sheet400_2DAO> sheet400_2;

	public sheet400_3DAO s400_3Data;
	public Iterable<sheet400_3DAO> sheet400_3;

	public sheet400_4DAO s400_4Data;
	public Iterable<sheet400_4DAO> sheet400_4;

	public sheet400_5DAO s400_5Data;
	public Iterable<sheet400_5DAO> sheet400_5;

	public sheet400_6DAO s400_6Data;
	public Iterable<sheet400_6DAO> sheet400_6;

	public sheet400_7DAO s400_7Data;
	public Iterable<sheet400_7DAO> sheet400_7;

	public sheet400_8DAO s400_8Data;
	public Iterable<sheet400_8DAO> sheet400_8;

	public sheet400_9DAO s400_9Data;
	public Iterable<sheet400_9DAO> sheet400_9;

	public sheet400_10DAO s400_10Data;
	public Iterable<sheet400_10DAO> sheet400_10;

	public sheet400_11DAO s400_11Data;
	public Iterable<sheet400_11DAO> sheet400_11;

	public sheet400_12DAO s400_12Data;
	public Iterable<sheet400_12DAO> sheet400_12;

	public sheet400_13DAO s400_13Data;
	public Iterable<sheet400_13DAO> sheet400_13;

	public sheet400_14DAO s400_14Data;
	public Iterable<sheet400_14DAO> sheet400_14;

	public sheet400_15DAO s400_15Data;
	public Iterable<sheet400_15DAO> sheet400_15;

	public sheet450_1DAO s450_1Data;
	public Iterable<sheet450_1DAO> sheet450_1;

	public sheet450_2DAO s450_2Data;
	public Iterable<sheet450_2DAO> sheet450_2;

	public sheet450_3DAO s450_3Data;
	public Iterable<sheet450_3DAO> sheet450_3;

	public sheet450_4DAO s450_4Data;
	public Iterable<sheet450_4DAO> sheet450_4;

	public sheet450_5DAO s450_5Data;
	public Iterable<sheet450_5DAO> sheet450_5;

	public sheet450_6DAO s450_6Data;
	public Iterable<sheet450_6DAO> sheet450_6;

	public sheet450_7DAO s450_7Data;
	public Iterable<sheet450_7DAO> sheet450_7;

	public sheet450_8DAO s450_8Data;
	public Iterable<sheet450_8DAO> sheet450_8;

	public sheet450_9DAO s450_9Data;
	public Iterable<sheet450_9DAO> sheet450_9;

	public sheet450_10DAO s450_10Data;
	public Iterable<sheet450_10DAO> sheet450_10;

	public sheet450_11DAO s450_11Data;
	public Iterable<sheet450_11DAO> sheet450_11;

	public sheet450_12DAO s450_12Data;
	public Iterable<sheet450_12DAO> sheet450_12;

	public sheet450_13DAO s450_13Data;
	public Iterable<sheet450_13DAO> sheet450_13;

	public sheet450_14DAO s450_14Data;
	public Iterable<sheet450_14DAO> sheet450_14;

	public sheet450_15DAO s450_15Data;
	public Iterable<sheet450_15DAO> sheet450_15;

	public sheet493DAO s493Data;
	public Iterable<sheet493DAO> sheet493;

	public sheet291DAO s291Data;
	public Iterable<sheet291DAO> sheet291;

	public sheet292_1DAO s292_1Data;
	public Iterable<sheet292_1DAO> sheet292_1;

	public sheet292_2DAO s292_2Data;
	public Iterable<sheet292_2DAO> sheet292_2;

	public sheet292_3DAO s292_3Data;
	public Iterable<sheet292_3DAO> sheet292_3;

	public sheet363DAO s363Data;
	public Iterable<sheet363DAO> sheet363;

	public sheet371_1DAO s371_1Data;
	public Iterable<sheet371_1DAO> sheet371_1;

	public sheet371_2DAO s371_2Data;
	public Iterable<sheet371_2DAO> sheet371_2;

	public sheet371_3DAO s371_3Data;
	public Iterable<sheet371_3DAO> sheet371_3;

	public sheet453DAO s453Data;
	public Iterable<sheet453DAO> sheet453;

	public sheet700DAO s700Data;
	public Iterable<sheet700DAO> sheet700;

	public sheet702DAO s702Data;
	public Iterable<sheet702DAO> sheet702;

	public sheet800DAO s800Data;
	public Iterable<sheet800DAO> sheet800;

	public sheet900DAO s900Data;
	public Iterable<sheet900DAO> sheet900;

	public sheet920DAO s920Data;
	public Iterable<sheet920DAO> sheet920;

	public sheet921DAO s921Data;
	public Iterable<sheet921DAO> sheet921;

	public sheetQdfir921DAO s921QDFIRData;
	public Iterable<sheetQdfir921DAO> sheetQDFIR921;

	public sheetMcfpr1DAO sMcfpr1Data;
	public Iterable<sheetMcfpr1DAO> sheetMcfpr1;

	public sheet1300DAO s1300Data;
	public Iterable<sheet1300DAO> sheet1300;

	public sheet1301DAO s1301Data;
	public Iterable<sheet1301DAO> sheet1301;

	public sheet1400DAO s1400Data;
	public Iterable<sheet1400DAO> sheet1400;

	public sheet1500DAO s1500Data;
	public Iterable<sheet1500DAO> sheet1500;

	public sheet1600DAO s1600Data;
	public Iterable<sheet1600DAO> sheet1600;

	public sheet1650DAO s1650Data;
	public Iterable<sheet1650DAO> sheet1650;

	public sheet1700DAO s1700Data;
	public Iterable<sheet1700DAO> sheet1700;

	public sheet223DAO s223Data;
	public Iterable<sheet223DAO> sheet223;

	public sheet333DAO s333Data;
	public Iterable<sheet333DAO> sheet333;

	public sheet455DAO s455Data;
	public Iterable<sheet455DAO> sheet455;

	public sheet001DAO s001Data;
	public Iterable<sheet001DAO> sheet001;

	public sheet002DAO s002Data;
	public Iterable<sheet002DAO> sheet002;

	public Iterable<sheet1000DAO> sheet1000;

	public sheet100DAO getS100Data() {
		return s100Data;
	}

	public void setS100Data(sheet100DAO s100Data) {
		this.s100Data = s100Data;
	}

	public sheet1200DAO getS1200Data() {
		return s1200Data;
	}

	public void setS1200Data(sheet1200DAO s1200Data) {
		this.s1200Data = s1200Data;
	}

	public sheet302DAO getS302Data() {
		return s302Data;
	}

	public void setS302Data(sheet302DAO s302Data) {
		this.s302Data = s302Data;
	}

	public Iterable<sheet302DAO> getSheet302() {
		return sheet302;
	}

	public void setSheet302(Iterable<sheet302DAO> sheet302) {
		this.sheet302 = sheet302;
	}

	public void setSheet1200(Iterable<sheet1200DAO> sheet1200) {
		this.sheet1200 = sheet1200;
	}

	public sheet423DAO getS423Data() {
		return s423Data;
	}

	public void setS423Data(sheet423DAO s423Data) {
		this.s423Data = s423Data;
	}

	public Iterable<sheet423DAO> getSheet423() {
		return sheet423;
	}

	public void setSheet423(Iterable<sheet423DAO> sheet423) {
		this.sheet423 = sheet423;
	}

	public sheet533DAO getS533Data() {
		return s533Data;
	}

	public void setS533Data(sheet533DAO s533Data) {
		this.s533Data = s533Data;
	}

	public Iterable<sheet533DAO> getSheet533() {
		return sheet533;
	}

	public void setSheet533(Iterable<sheet533DAO> sheet533) {
		this.sheet533 = sheet533;
	}

	public Iterable<sheet302DAO> sheet302;

	public ArrayList<ReportDAO> ReportData;

	public sheet1000DAO s1000Data;

	public sheet1000DAO getS1000Data() {
		return s1000Data;
	}

	public void setS1000Data(sheet1000DAO s1000Data) {
		this.s1000Data = s1000Data;
	}

	public sheet300DAO getS300Data() {
		return s300Data;
	}

	public void setS300Data(sheet300DAO s300Data) {
		this.s300Data = s300Data;
	}

	public Iterable<sheet300DAO> getSheet300() {
		return sheet300;
	}

	public void setSheet300(Iterable<sheet300DAO> sheet300) {
		this.sheet300 = sheet300;
	}

	public ArrayList<ReportDAO> getReportData() {
		return ReportData;
	}

	public void setReportData(ArrayList<ReportDAO> reportData) {
		ReportData = reportData;
	}

	public ArrayList<String> columnNames;

	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}

	public sheet201DAO getS201Data() {
		return s201Data;
	}

	public void setS201Data(sheet201DAO s201Data) {
		this.s201Data = s201Data;
	}

	public Iterable<sheet201DAO> getSheet201() {
		return sheet201;
	}

	public void setSheet201(Iterable<sheet201DAO> sheet201) {
		this.sheet201 = sheet201;
	}

	public sheet191DAO getS191Data() {
		return s191Data;
	}

	public void setS191Data(sheet191DAO s191Data) {
		this.s191Data = s191Data;
	}

	public Iterable<sheet191DAO> getSheet191() {
		return sheet191;
	}

	public void setSheet191(Iterable<sheet191DAO> sheet191) {
		this.sheet191 = sheet191;
	}

	public sheet192DAO getS192Data() {
		return s192Data;
	}

	public void setS192Data(sheet192DAO s192Data) {
		this.s192Data = s192Data;
	}

	public Iterable<sheet192DAO> getSheet192() {
		return sheet192;
	}

	public void setSheet192(Iterable<sheet192DAO> sheet192) {
		this.sheet192 = sheet192;
	}

	@Override
	public String toString() {
		return "Response [Sheet321Data=" + s321Data + "]";
	}

	public Response() {

	}

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

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public DAOUser getDaoUser() {return daoUser;}
	public void setDaoUser(DAOUser daoUser) {this.daoUser = daoUser;}

	public Iterable<UserDAO> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(Iterable<UserDAO> allUsers) {
		this.allUsers = allUsers;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Iterable<sheet221DAO> getSheet221() {
		return sheet221;
	}

	public void setSheet221(Iterable<sheet221DAO> sheet221) {
		this.sheet221 = sheet221;
	}

	public sheet221DAO getS221Data() {
		return s221Data;
	}

	public void setS221Data(sheet221DAO s221Data) {
		this.s221Data = s221Data;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Iterable<sheet311DAO> getSheet311() {
		return sheet311;
	}

	public void setSheet311(Iterable<sheet311DAO> sheet311) {
		this.sheet311 = sheet311;
	}

	public sheet311DAO getS311Data() {
		return s311Data;
	}

	public void setS311Data(sheet311DAO s311Data) {
		this.s311Data = s311Data;
	}

	public sheet321DAO getS321Data() {
		return s321Data;
	}

	public void setS321Data(sheet321DAO s321Data) {
		this.s321Data = s321Data;
	}

	public Iterable<sheet321DAO> getSheet321() {
		return sheet321;
	}

	public void setSheet321(Iterable<sheet321DAO> sheet321) {
		this.sheet321 = sheet321;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public sheet101DAO getS101Data() {
		return s101Data;
	}

	public void setS101Data(sheet101DAO s101Data) {
		this.s101Data = s101Data;
	}

	public Iterable<sheet101DAO> getSheet101() {
		return sheet101;
	}

	public void setSheet101(Iterable<sheet101DAO> sheet101) {
		this.sheet101 = sheet101;
	}

	public sheet382DAO getS382Data() {
		return s382Data;
	}

	public void setS382Data(sheet382DAO s382Data) {
		this.s382Data = s382Data;
	}

	public Iterable<sheet382DAO> getSheet382() {
		return sheet382;
	}

	public void setSheet382(Iterable<sheet382DAO> sheet382) {
		this.sheet382 = sheet382;
	}

	public sheet372DAO getS372Data() {
		return s372Data;
	}

	public void setS372Data(sheet372DAO s372Data) {
		this.s372Data = s372Data;
	}

	public Iterable<sheet372DAO> getSheet372() {
		return sheet372;
	}

	public void setSheet372(Iterable<sheet372DAO> sheet372) {
		this.sheet372 = sheet372;
	}

	public sheet412DAO getS412Data() {
		return s412Data;
	}

	public void setS412Data(sheet412DAO s412Data) {
		this.s412Data = s412Data;
	}

	public Iterable<sheet412DAO> getSheet412() {
		return sheet412;
	}

	public void setSheet412(Iterable<sheet412DAO> sheet412) {
		this.sheet412 = sheet412;
	}

	public sheet422DAO getS422Data() {
		return s422Data;
	}

	public void setS422Data(sheet422DAO s422Data) {
		this.s422Data = s422Data;
	}

	public Iterable<sheet422DAO> getSheet422() {
		return sheet422;
	}

	public void setSheet422(Iterable<sheet422DAO> sheet422) {
		this.sheet422 = sheet422;
	}

	public sheet425DAO getS425Data() {
		return s425Data;
	}

	public void setS425Data(sheet425DAO s425Data) {
		this.s425Data = s425Data;
	}

	public Iterable<sheet425DAO> getSheet425() {
		return sheet425;
	}

	public void setSheet425(Iterable<sheet425DAO> sheet425) {
		this.sheet425 = sheet425;
	}

	public sheet432DAO getS432Data() {
		return s432Data;
	}

	public void setS432Data(sheet432DAO s432Data) {
		this.s432Data = s432Data;
	}

	public Iterable<sheet432DAO> getSheet432() {
		return sheet432;
	}

	public void setSheet432(Iterable<sheet432DAO> sheet432) {
		this.sheet432 = sheet432;
	}

	public sheet250DAO getS250Data() {
		return s250Data;
	}

	public void setS250Data(sheet250DAO s250Data) {
		this.s250Data = s250Data;
	}

	public Iterable<sheet250DAO> getSheet250() {
		return sheet250;
	}

	public void setSheet250(Iterable<sheet250DAO> sheet250) {
		this.sheet250 = sheet250;
	}

	public sheet271DAO getS271Data() {
		return s271Data;
	}

	public void setS271Data(sheet271DAO s271Data) {
		this.s271Data = s271Data;
	}

	public Iterable<sheet271DAO> getSheet271() {
		return sheet271;
	}

	public void setSheet271(Iterable<sheet271DAO> sheet271) {
		this.sheet271 = sheet271;
	}

	public sheet122DAO getS122Data() {
		return s122Data;
	}

	public void setS122Data(sheet122DAO s122Data) {
		this.s122Data = s122Data;
	}

	public Iterable<sheet122DAO> getSheet122() {
		return sheet122;
	}

	public void setSheet122(Iterable<sheet122DAO> sheet122) {
		this.sheet122 = sheet122;
	}

	public sheet142DAO getS142Data() {
		return s142Data;
	}

	public void setS142Data(sheet142DAO s142Data) {
		this.s142Data = s142Data;
	}

	public Iterable<sheet142DAO> getSheet142() {
		return sheet142;
	}

	public void setSheet142(Iterable<sheet142DAO> sheet142) {
		this.sheet142 = sheet142;
	}

	public sheet161DAO getS161Data() {
		return s161Data;
	}

	public void setS161Data(sheet161DAO s161Data) {
		this.s161Data = s161Data;
	}

	public Iterable<sheet161DAO> getSheet161() {
		return sheet161;
	}

	public void setSheet161(Iterable<sheet161DAO> sheet161) {
		this.sheet161 = sheet161;
	}

	public sheet172DAO getS172Data() {
		return s172Data;
	}

	public void setS172Data(sheet172DAO s172Data) {
		this.s172Data = s172Data;
	}

	public Iterable<sheet172DAO> getSheet172() {
		return sheet172;
	}

	public void setSheet172(Iterable<sheet172DAO> sheet172) {
		this.sheet172 = sheet172;
	}

	public sheet182DAO getS182Data() {
		return s182Data;
	}

	public void setS182Data(sheet182DAO s182Data) {
		this.s182Data = s182Data;
	}

	public Iterable<sheet182DAO> getSheet182() {
		return sheet182;
	}

	public void setSheet182(Iterable<sheet182DAO> sheet182) {
		this.sheet182 = sheet182;
	}

	public sheet193DAO getS193Data() {
		return s193Data;
	}

	public void setS193Data(sheet193DAO s193Data) {
		this.s193Data = s193Data;
	}

	public Iterable<sheet193DAO> getSheet193() {
		return sheet193;
	}

	public void setSheet193(Iterable<sheet193DAO> sheet193) {
		this.sheet193 = sheet193;
	}

	public sheet291DAO getS291Data() {
		return s291Data;
	}

	public void setS291Data(sheet291DAO s291Data) {
		this.s291Data = s291Data;
	}

	public Iterable<sheet291DAO> getSheet291() {
		return sheet291;
	}

	public void setSheet291(Iterable<sheet291DAO> sheet291) {
		this.sheet291 = sheet291;
	}

	public sheet304DAO getS304Data() {
		return s304Data;
	}

	public void setS304Data(sheet304DAO s304Data) {
		this.s304Data = s304Data;
	}

	public Iterable<sheet304DAO> getSheet304() {
		return sheet304;
	}

	public void setSheet304(Iterable<sheet304DAO> sheet304) {
		this.sheet304 = sheet304;
	}

	public sheet600DAO getS600Data() {
		return s600Data;
	}

	public void setS600Data(sheet600DAO s600Data) {
		this.s600Data = s600Data;
	}

	public Iterable<sheet600DAO> getSheet600() {
		return sheet600;
	}

	public void setSheet600(Iterable<sheet600DAO> sheet600) {
		this.sheet600 = sheet600;
	}

	public sheet601DAO getS601Data() {
		return s601Data;
	}

	public void setS601Data(sheet601DAO s601Data) {
		this.s601Data = s601Data;
	}

	public Iterable<sheet601DAO> getSheet601() {
		return sheet601;
	}

	public void setSheet601(Iterable<sheet601DAO> sheet601) {
		this.sheet601 = sheet601;
	}

	public sheet400_DAO getS400_Data() {
		return s400_Data;
	}

	public void setS400_Data(sheet400_DAO s400_Data) {
		this.s400_Data = s400_Data;
	}

	public Iterable<sheet400_DAO> getSheet400() {
		return sheet400;
	}

	public void setSheet400(Iterable<sheet400_DAO> sheet400) {
		this.sheet400 = sheet400;
	}

	public sheet450_DAO getS450_Data() {
		return s450_Data;
	}

	public void setS450_Data(sheet450_DAO s450_Data) {
		this.s450_Data = s450_Data;
	}

	public Iterable<sheet450_DAO> getSheet450() {
		return sheet450;
	}

	public void setSheet450(Iterable<sheet450_DAO> sheet450) {
		this.sheet450 = sheet450;
	}

	public sheet400_1DAO getS400_1Data() {
		return s400_1Data;
	}

	public void setS400_1Data(sheet400_1DAO s400_1Data) {
		this.s400_1Data = s400_1Data;
	}

	public Iterable<sheet400_1DAO> getSheet400_1() {
		return sheet400_1;
	}

	public void setSheet400_1(Iterable<sheet400_1DAO> sheet400_1) {
		this.sheet400_1 = sheet400_1;
	}

	public sheet400_2DAO getS400_2Data() {
		return s400_2Data;
	}

	public void setS400_2Data(sheet400_2DAO s400_2Data) {
		this.s400_2Data = s400_2Data;
	}

	public Iterable<sheet400_2DAO> getSheet400_2() {
		return sheet400_2;
	}

	public void setSheet400_2(Iterable<sheet400_2DAO> sheet400_2) {
		this.sheet400_2 = sheet400_2;
	}

	public sheet400_3DAO getS400_3Data() {
		return s400_3Data;
	}

	public void setS400_3Data(sheet400_3DAO s400_3Data) {
		this.s400_3Data = s400_3Data;
	}

	public Iterable<sheet400_3DAO> getSheet400_3() {
		return sheet400_3;
	}

	public void setSheet400_3(Iterable<sheet400_3DAO> sheet400_3) {
		this.sheet400_3 = sheet400_3;
	}

	public sheet400_4DAO getS400_4Data() {
		return s400_4Data;
	}

	public void setS400_4Data(sheet400_4DAO s400_4Data) {
		this.s400_4Data = s400_4Data;
	}

	public Iterable<sheet400_4DAO> getSheet400_4() {
		return sheet400_4;
	}

	public void setSheet400_4(Iterable<sheet400_4DAO> sheet400_4) {
		this.sheet400_4 = sheet400_4;
	}

	public sheet400_5DAO getS400_5Data() {
		return s400_5Data;
	}

	public void setS400_5Data(sheet400_5DAO s400_5Data) {
		this.s400_5Data = s400_5Data;
	}

	public Iterable<sheet400_5DAO> getSheet400_5() {
		return sheet400_5;
	}

	public void setSheet400_5(Iterable<sheet400_5DAO> sheet400_5) {
		this.sheet400_5 = sheet400_5;
	}

	public sheet400_6DAO getS400_6Data() {
		return s400_6Data;
	}

	public void setS400_6Data(sheet400_6DAO s400_6Data) {
		this.s400_6Data = s400_6Data;
	}

	public Iterable<sheet400_6DAO> getSheet400_6() {
		return sheet400_6;
	}

	public void setSheet400_6(Iterable<sheet400_6DAO> sheet400_6) {
		this.sheet400_6 = sheet400_6;
	}

	public sheet400_7DAO getS400_7Data() {
		return s400_7Data;
	}

	public void setS400_7Data(sheet400_7DAO s400_7Data) {
		this.s400_7Data = s400_7Data;
	}

	public Iterable<sheet400_7DAO> getSheet400_7() {
		return sheet400_7;
	}

	public void setSheet400_7(Iterable<sheet400_7DAO> sheet400_7) {
		this.sheet400_7 = sheet400_7;
	}

	public sheet400_8DAO getS400_8Data() {
		return s400_8Data;
	}

	public void setS400_8Data(sheet400_8DAO s400_8Data) {
		this.s400_8Data = s400_8Data;
	}

	public Iterable<sheet400_8DAO> getSheet400_8() {
		return sheet400_8;
	}

	public void setSheet400_8(Iterable<sheet400_8DAO> sheet400_8) {
		this.sheet400_8 = sheet400_8;
	}

	public sheet400_9DAO getS400_9Data() {
		return s400_9Data;
	}

	public void setS400_9Data(sheet400_9DAO s400_9Data) {
		this.s400_9Data = s400_9Data;
	}

	public Iterable<sheet400_9DAO> getSheet400_9() {
		return sheet400_9;
	}

	public void setSheet400_9(Iterable<sheet400_9DAO> sheet400_9) {
		this.sheet400_9 = sheet400_9;
	}

	public sheet400_10DAO getS400_10Data() {
		return s400_10Data;
	}

	public void setS400_10Data(sheet400_10DAO s400_10Data) {
		this.s400_10Data = s400_10Data;
	}

	public Iterable<sheet400_10DAO> getSheet400_10() {
		return sheet400_10;
	}

	public void setSheet400_10(Iterable<sheet400_10DAO> sheet400_10) {
		this.sheet400_10 = sheet400_10;
	}

	public sheet400_11DAO getS400_11Data() {
		return s400_11Data;
	}

	public void setS400_11Data(sheet400_11DAO s400_11Data) {
		this.s400_11Data = s400_11Data;
	}

	public Iterable<sheet400_11DAO> getSheet400_11() {
		return sheet400_11;
	}

	public void setSheet400_11(Iterable<sheet400_11DAO> sheet400_11) {
		this.sheet400_11 = sheet400_11;
	}

	public sheet400_12DAO getS400_12Data() {
		return s400_12Data;
	}

	public void setS400_12Data(sheet400_12DAO s400_12Data) {
		this.s400_12Data = s400_12Data;
	}

	public Iterable<sheet400_12DAO> getSheet400_12() {
		return sheet400_12;
	}

	public void setSheet400_12(Iterable<sheet400_12DAO> sheet400_12) {
		this.sheet400_12 = sheet400_12;
	}

	public sheet400_13DAO getS400_13Data() {
		return s400_13Data;
	}

	public void setS400_13Data(sheet400_13DAO s400_13Data) {
		this.s400_13Data = s400_13Data;
	}

	public Iterable<sheet400_13DAO> getSheet400_13() {
		return sheet400_13;
	}

	public void setSheet400_13(Iterable<sheet400_13DAO> sheet400_13) {
		this.sheet400_13 = sheet400_13;
	}

	public sheet400_14DAO getS400_14Data() {
		return s400_14Data;
	}

	public void setS400_14Data(sheet400_14DAO s400_14Data) {
		this.s400_14Data = s400_14Data;
	}

	public Iterable<sheet400_14DAO> getSheet400_14() {
		return sheet400_14;
	}

	public void setSheet400_14(Iterable<sheet400_14DAO> sheet400_14) {
		this.sheet400_14 = sheet400_14;
	}

	public sheet400_15DAO getS400_15Data() {
		return s400_15Data;
	}

	public void setS400_15Data(sheet400_15DAO s400_15Data) {
		this.s400_15Data = s400_15Data;
	}

	public Iterable<sheet400_15DAO> getSheet400_15() {
		return sheet400_15;
	}

	public void setSheet400_15(Iterable<sheet400_15DAO> sheet400_15) {
		this.sheet400_15 = sheet400_15;
	}

	public sheetMcfpr1DAO getSMcfpr1Data() {
		return sMcfpr1Data;
	}

	public void setSMcfpr1Data(sheetMcfpr1DAO sMcfpr1Data) {
		this.sMcfpr1Data = sMcfpr1Data;
	}

	public Iterable<sheetMcfpr1DAO> getSheetMcfpr1() {
		return sheetMcfpr1;
	}

	public void setSheetMcfpr1(Iterable<sheetMcfpr1DAO> sheetMcfpr1) {
		this.sheetMcfpr1 = sheetMcfpr1;
	}

	public sheet1300DAO getS1300Data() {
		return s1300Data;
	}

	public void setS1300Data(sheet1300DAO s1300Data) {
		this.s1300Data = s1300Data;
	}

	public Iterable<sheet1300DAO> getSheet1300() {
		return sheet1300;
	}

	public void setSheet1300(Iterable<sheet1300DAO> sheet1300) {
		this.sheet1300 = sheet1300;
	}

	public sheet1301DAO getS1301Data() {
		return s1301Data;
	}

	public void setS1301Data(sheet1301DAO s1301Data) {
		this.s1301Data = s1301Data;
	}

	public Iterable<sheet1301DAO> getSheet1301() {
		return sheet1301;
	}

	public void setSheet1301(Iterable<sheet1301DAO> sheet1301) {
		this.sheet1301 = sheet1301;
	}

	public sheet1400DAO getS1400Data() {
		return s1400Data;
	}

	public void setS1400Data(sheet1400DAO s1400Data) {
		this.s1400Data = s1400Data;
	}

	public Iterable<sheet1400DAO> getSheet1400() {
		return sheet1400;
	}

	public void setSheet1400(Iterable<sheet1400DAO> sheet1400) {
		this.sheet1400 = sheet1400;
	}

	public sheet1500DAO getS1500Data() {
		return s1500Data;
	}

	public void setS1500Data(sheet1500DAO s1500Data) {
		this.s1500Data = s1500Data;
	}

	public Iterable<sheet1500DAO> getSheet1500() {
		return sheet1500;
	}

	public void setSheet1500(Iterable<sheet1500DAO> sheet1500) {
		this.sheet1500 = sheet1500;
	}

	public sheet1600DAO getS1600Data() {
		return s1600Data;
	}

	public void setS1600Data(sheet1600DAO s1600Data) {
		this.s1600Data = s1600Data;
	}

	public Iterable<sheet1600DAO> getSheet1600() {
		return sheet1600;
	}

	public void setSheet1600(Iterable<sheet1600DAO> sheet1600) {
		this.sheet1600 = sheet1600;
	}

	public sheet1650DAO getS1650Data() {
		return s1650Data;
	}

	public void setS1650Data(sheet1650DAO s1650Data) {
		this.s1650Data = s1650Data;
	}

	public Iterable<sheet1650DAO> getSheet1650() {
		return sheet1650;
	}

	public void setSheet1650(Iterable<sheet1650DAO> sheet1650) {
		this.sheet1650 = sheet1650;
	}

	public sheet1700DAO getS1700Data() {
		return s1700Data;
	}

	public void setS1700Data(sheet1700DAO s1700Data) {
		this.s1700Data = s1700Data;
	}

	public Iterable<sheet1700DAO> getSheet1700() {
		return sheet1700;
	}

	public void setSheet1700(Iterable<sheet1700DAO> sheet1700) {
		this.sheet1700 = sheet1700;
	}

	public sheet223DAO getS223Data() {
		return s223Data;
	}

	public void setS223Data(sheet223DAO s223Data) {
		this.s223Data = s223Data;
	}

	public Iterable<sheet223DAO> getSheet223() {
		return sheet223;
	}

	public void setSheet223(Iterable<sheet223DAO> sheet223) {
		this.sheet223 = sheet223;
	}

	public sheet292_1DAO getS292_1Data() {
		return s292_1Data;
	}

	public void setS292_1Data(sheet292_1DAO s292_1Data) {
		this.s292_1Data = s292_1Data;
	}

	public Iterable<sheet292_1DAO> getSheet292_1() {
		return sheet292_1;
	}

	public void setSheet292_1(Iterable<sheet292_1DAO> sheet292_1) {
		this.sheet292_1 = sheet292_1;
	}

	public sheet292_2DAO getS292_2Data() {
		return s292_2Data;
	}

	public void setS292_2Data(sheet292_2DAO s292_2Data) {
		this.s292_2Data = s292_2Data;
	}

	public Iterable<sheet292_2DAO> getSheet292_2() {
		return sheet292_2;
	}

	public void setSheet292_2(Iterable<sheet292_2DAO> sheet292_2) {
		this.sheet292_2 = sheet292_2;
	}

	public sheet292_3DAO getS292_3Data() {
		return s292_3Data;
	}

	public void setS292_3Data(sheet292_3DAO s292_3Data) {
		this.s292_3Data = s292_3Data;
	}

	public Iterable<sheet292_3DAO> getSheet292_3() {
		return sheet292_3;
	}

	public void setSheet292_3(Iterable<sheet292_3DAO> sheet292_3) {
		this.sheet292_3 = sheet292_3;
	}

	public sheet333DAO getS333Data() {
		return s333Data;
	}

	public void setS333Data(sheet333DAO s333Data) {
		this.s333Data = s333Data;
	}

	public Iterable<sheet333DAO> getSheet333() {
		return sheet333;
	}

	public void setSheet333(Iterable<sheet333DAO> sheet333) {
		this.sheet333 = sheet333;
	}

	public sheet363DAO getS363Data() {
		return s363Data;
	}

	public void setS363Data(sheet363DAO s363Data) {
		this.s363Data = s363Data;
	}

	public Iterable<sheet363DAO> getSheet363() {
		return sheet363;
	}

	public void setSheet363(Iterable<sheet363DAO> sheet363) {
		this.sheet363 = sheet363;
	}

	public sheet371_1DAO getS371_1Data() {
		return s371_1Data;
	}

	public void setS371_1Data(sheet371_1DAO s371_1Data) {
		this.s371_1Data = s371_1Data;
	}

	public Iterable<sheet371_1DAO> getSheet371_1() {
		return sheet371_1;
	}

	public void setSheet371_1(Iterable<sheet371_1DAO> sheet371_1) {
		this.sheet371_1 = sheet371_1;
	}

	public sheet371_2DAO getS371_2Data() {
		return s371_2Data;
	}

	public void setS371_2Data(sheet371_2DAO s371_2Data) {
		this.s371_2Data = s371_2Data;
	}

	public Iterable<sheet371_2DAO> getSheet371_2() {
		return sheet371_2;
	}

	public void setSheet371_2(Iterable<sheet371_2DAO> sheet371_2) {
		this.sheet371_2 = sheet371_2;
	}

	public sheet371_3DAO getS371_3Data() {
		return s371_3Data;
	}

	public void setS371_3Data(sheet371_3DAO s371_3Data) {
		this.s371_3Data = s371_3Data;
	}

	public Iterable<sheet371_3DAO> getSheet371_3() {
		return sheet371_3;
	}

	public void setSheet371_3(Iterable<sheet371_3DAO> sheet371_3) {
		this.sheet371_3 = sheet371_3;
	}

	public sheet450_1DAO getS450_1Data() {
		return s450_1Data;
	}

	public void setS450_1Data(sheet450_1DAO s450_1Data) {
		this.s450_1Data = s450_1Data;
	}

	public Iterable<sheet450_1DAO> getSheet450_1() {
		return sheet450_1;
	}

	public void setSheet450_1(Iterable<sheet450_1DAO> sheet450_1) {
		this.sheet450_1 = sheet450_1;
	}

	public sheet450_2DAO getS450_2Data() {
		return s450_2Data;
	}

	public void setS450_2Data(sheet450_2DAO s450_2Data) {
		this.s450_2Data = s450_2Data;
	}

	public Iterable<sheet450_2DAO> getSheet450_2() {
		return sheet450_2;
	}

	public void setSheet450_2(Iterable<sheet450_2DAO> sheet450_2) {
		this.sheet450_2 = sheet450_2;
	}

	public sheet450_3DAO getS450_3Data() {
		return s450_3Data;
	}

	public void setS450_3Data(sheet450_3DAO s450_3Data) {
		this.s450_3Data = s450_3Data;
	}

	public Iterable<sheet450_3DAO> getSheet450_3() {
		return sheet450_3;
	}

	public void setSheet450_3(Iterable<sheet450_3DAO> sheet450_3) {
		this.sheet450_3 = sheet450_3;
	}

	public sheet450_4DAO getS450_4Data() {
		return s450_4Data;
	}

	public void setS450_4Data(sheet450_4DAO s450_4Data) {
		this.s450_4Data = s450_4Data;
	}

	public Iterable<sheet450_4DAO> getSheet450_4() {
		return sheet450_4;
	}

	public void setSheet450_4(Iterable<sheet450_4DAO> sheet450_4) {
		this.sheet450_4 = sheet450_4;
	}

	public sheet450_5DAO getS450_5Data() {
		return s450_5Data;
	}

	public void setS450_5Data(sheet450_5DAO s450_5Data) {
		this.s450_5Data = s450_5Data;
	}

	public Iterable<sheet450_5DAO> getSheet450_5() {
		return sheet450_5;
	}

	public void setSheet450_5(Iterable<sheet450_5DAO> sheet450_5) {
		this.sheet450_5 = sheet450_5;
	}

	public sheet450_6DAO getS450_6Data() {
		return s450_6Data;
	}

	public void setS450_6Data(sheet450_6DAO s450_6Data) {
		this.s450_6Data = s450_6Data;
	}

	public Iterable<sheet450_6DAO> getSheet450_6() {
		return sheet450_6;
	}

	public void setSheet450_6(Iterable<sheet450_6DAO> sheet450_6) {
		this.sheet450_6 = sheet450_6;
	}

	public sheet450_7DAO getS450_7Data() {
		return s450_7Data;
	}

	public void setS450_7Data(sheet450_7DAO s450_7Data) {
		this.s450_7Data = s450_7Data;
	}

	public Iterable<sheet450_7DAO> getSheet450_7() {
		return sheet450_7;
	}

	public void setSheet450_7(Iterable<sheet450_7DAO> sheet450_7) {
		this.sheet450_7 = sheet450_7;
	}

	public sheet450_8DAO getS450_8Data() {
		return s450_8Data;
	}

	public void setS450_8Data(sheet450_8DAO s450_8Data) {
		this.s450_8Data = s450_8Data;
	}

	public Iterable<sheet450_8DAO> getSheet450_8() {
		return sheet450_8;
	}

	public void setSheet450_8(Iterable<sheet450_8DAO> sheet450_8) {
		this.sheet450_8 = sheet450_8;
	}

	public sheet450_9DAO getS450_9Data() {
		return s450_9Data;
	}

	public void setS450_9Data(sheet450_9DAO s450_9Data) {
		this.s450_9Data = s450_9Data;
	}

	public Iterable<sheet450_9DAO> getSheet450_9() {
		return sheet450_9;
	}

	public void setSheet450_9(Iterable<sheet450_9DAO> sheet450_9) {
		this.sheet450_9 = sheet450_9;
	}

	public sheet450_10DAO getS450_10Data() {
		return s450_10Data;
	}

	public void setS450_10Data(sheet450_10DAO s450_10Data) {
		this.s450_10Data = s450_10Data;
	}

	public Iterable<sheet450_10DAO> getSheet450_10() {
		return sheet450_10;
	}

	public void setSheet450_10(Iterable<sheet450_10DAO> sheet450_10) {
		this.sheet450_10 = sheet450_10;
	}

	public sheet450_11DAO getS450_11Data() {
		return s450_11Data;
	}

	public void setS450_11Data(sheet450_11DAO s450_11Data) {
		this.s450_11Data = s450_11Data;
	}

	public Iterable<sheet450_11DAO> getSheet450_11() {
		return sheet450_11;
	}

	public void setSheet450_11(Iterable<sheet450_11DAO> sheet450_11) {
		this.sheet450_11 = sheet450_11;
	}

	public sheet450_12DAO getS450_12Data() {
		return s450_12Data;
	}

	public void setS450_12Data(sheet450_12DAO s450_12Data) {
		this.s450_12Data = s450_12Data;
	}

	public Iterable<sheet450_12DAO> getSheet450_12() {
		return sheet450_12;
	}

	public void setSheet450_12(Iterable<sheet450_12DAO> sheet450_12) {
		this.sheet450_12 = sheet450_12;
	}

	public sheet450_13DAO getS450_13Data() {
		return s450_13Data;
	}

	public void setS450_13Data(sheet450_13DAO s450_13Data) {
		this.s450_13Data = s450_13Data;
	}

	public Iterable<sheet450_13DAO> getSheet450_13() {
		return sheet450_13;
	}

	public void setSheet450_13(Iterable<sheet450_13DAO> sheet450_13) {
		this.sheet450_13 = sheet450_13;
	}

	public sheet450_14DAO getS450_14Data() {
		return s450_14Data;
	}

	public void setS450_14Data(sheet450_14DAO s450_14Data) {
		this.s450_14Data = s450_14Data;
	}

	public Iterable<sheet450_14DAO> getSheet450_14() {
		return sheet450_14;
	}

	public void setSheet450_14(Iterable<sheet450_14DAO> sheet450_14) {
		this.sheet450_14 = sheet450_14;
	}

	public sheet450_15DAO getS450_15Data() {
		return s450_15Data;
	}

	public void setS450_15Data(sheet450_15DAO s450_15Data) {
		this.s450_15Data = s450_15Data;
	}

	public Iterable<sheet450_15DAO> getSheet450_15() {
		return sheet450_15;
	}

	public void setSheet450_15(Iterable<sheet450_15DAO> sheet450_15) {
		this.sheet450_15 = sheet450_15;
	}

	public sheet453DAO getS453Data() {
		return s453Data;
	}

	public void setS453Data(sheet453DAO s453Data) {
		this.s453Data = s453Data;
	}

	public Iterable<sheet453DAO> getSheet453() {
		return sheet453;
	}

	public void setSheet453(Iterable<sheet453DAO> sheet453) {
		this.sheet453 = sheet453;
	}

	public sheet455DAO getS455Data() {
		return s455Data;
	}

	public void setS455Data(sheet455DAO s455Data) {
		this.s455Data = s455Data;
	}

	public Iterable<sheet455DAO> getSheet455() {
		return sheet455;
	}

	public void setSheet455(Iterable<sheet455DAO> sheet455) {
		this.sheet455 = sheet455;
	}

	public sheet493DAO getS493Data() {
		return s493Data;
	}

	public void setS493Data(sheet493DAO s493Data) {
		this.s493Data = s493Data;
	}

	public Iterable<sheet493DAO> getSheet493() {
		return sheet493;
	}

	public void setSheet493(Iterable<sheet493DAO> sheet493) {
		this.sheet493 = sheet493;
	}

	public sheet700DAO getS700Data() {
		return s700Data;
	}

	public void setS700Data(sheet700DAO s700Data) {
		this.s700Data = s700Data;
	}

	public Iterable<sheet700DAO> getSheet700() {
		return sheet700;
	}

	public void setSheet700(Iterable<sheet700DAO> sheet700) {
		this.sheet700 = sheet700;
	}

	public sheet702DAO getS702Data() {
		return s702Data;
	}

	public void setS702Data(sheet702DAO s702Data) {
		this.s702Data = s702Data;
	}

	public Iterable<sheet702DAO> getSheet702() {
		return sheet702;
	}

	public void setSheet702(Iterable<sheet702DAO> sheet702) {
		this.sheet702 = sheet702;
	}

	public sheet800DAO getS800Data() {
		return s800Data;
	}

	public void setS800Data(sheet800DAO s800Data) {
		this.s800Data = s800Data;
	}

	public Iterable<sheet800DAO> getSheet800() {
		return sheet800;
	}

	public void setSheet800(Iterable<sheet800DAO> sheet800) {
		this.sheet800 = sheet800;
	}

	public sheet900DAO getS900Data() {
		return s900Data;
	}

	public void setS900Data(sheet900DAO s900Data) {
		this.s900Data = s900Data;
	}

	public Iterable<sheet900DAO> getSheet900() {
		return sheet900;
	}

	public void setSheet900(Iterable<sheet900DAO> sheet900) {
		this.sheet900 = sheet900;
	}

	public sheet920DAO getS920Data() {
		return s920Data;
	}

	public void setS920Data(sheet920DAO s920Data) {
		this.s920Data = s920Data;
	}

	public Iterable<sheet920DAO> getSheet920() {
		return sheet920;
	}

	public void setSheet920(Iterable<sheet920DAO> sheet920) {
		this.sheet920 = sheet920;
	}

	public sheet921DAO getS921Data() {
		return s921Data;
	}

	public void setS921Data(sheet921DAO s921Data) {
		this.s921Data = s921Data;
	}

	public Iterable<sheet921DAO> getSheet921() {
		return sheet921;
	}

	public void setSheet921(Iterable<sheet921DAO> sheet921) {
		this.sheet921 = sheet921;
	}

	public sheetQdfir921DAO getS921QDFIRData() {
		return s921QDFIRData;
	}

	public void s921QDFIRData(sheetQdfir921DAO s921QDFIRData) {
		this.s921QDFIRData = s921QDFIRData;
	}

	public Iterable<sheetQdfir921DAO> getSheetQDFIR921() {
		return sheetQDFIR921;
	}

	public void setSheetQDFIR921(Iterable<sheetQdfir921DAO> sheetQDFIR921) {
		this.sheetQDFIR921 = sheetQDFIR921;
	}

	public TabSheet tabData;
	public Iterable<TabSheet> data;

	public TabSheet getTabData() {
		return tabData;
	}

	public void setTabData(TabSheet tabData) {
		this.tabData = tabData;
	}

	public Iterable<TabSheet> getTableSheet() {
		return data;
	}

	public void setData(Iterable<TabSheet> data) {
		this.data = data;
	}

	public sheet001DAO getS001Data() {
		return s001Data;
	}

	public void setS001Data(sheet001DAO s001Data) {
		this.s001Data = s001Data;
	}

	public Iterable<sheet001DAO> getSheet001() {
		return sheet001;
	}

	public void setSheet001(Iterable<sheet001DAO> sheet001) {
		this.sheet001 = sheet001;
	}

	public sheet002DAO getS002Data() {
		return s002Data;
	}

	public void setS002Data(sheet002DAO s002Data) {
		this.s002Data = s002Data;
	}

	public Iterable<sheet002DAO> getSheet002() {
		return sheet002;
	}

	public void setSheet002(Iterable<sheet002DAO> sheet002) {
		this.sheet002 = sheet002;
	}

	public void setSheet1000(Iterable<sheet1000DAO> data) {
		this.sheet1000 = data;
	}

	public void setSheet100(Iterable<sheet100DAO> data) {
		this.sheet100 = data;
	}
}
