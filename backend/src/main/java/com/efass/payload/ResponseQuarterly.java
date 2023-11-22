package com.efass.payload;

import java.util.ArrayList;

import com.efass.report.ReportDAO;
import com.efass.sheet.mcfpr1.sheetQcfpr1Dao;
import com.efass.sheet.mdfir100.sheetQdfirDAO;
import com.efass.sheet.mdfir1000.sheetQdfir1000DAO;
import com.efass.sheet.mdfir101.sheetQdfir101DAO;
import com.efass.sheet.mdfir1200.sheetQdfir1200DAO;
import com.efass.sheet.mdfir122.sheetQdfir122DAO;
import com.efass.sheet.mdfir1300.sheetQdfir1300DAO;
import com.efass.sheet.mdfir1301.sheetQdfir1301DAO;
import com.efass.sheet.mdfir1400.sheetQdfir1400DAO;
import com.efass.sheet.mdfir142.sheetQdfir142DAO;
import com.efass.sheet.mdfir1500.sheetQdfir1500DAO;
import com.efass.sheet.mdfir1600.sheetQdfir1600DAO;
import com.efass.sheet.mdfir161.sheetQdfir161DAO;
import com.efass.sheet.mdfir1650.sheetQdfir1650DAO;
import com.efass.sheet.mdfir1700.sheetQdfir1700DAO;
import com.efass.sheet.mdfir172.sheetQdfir172DAO;
import com.efass.sheet.mdfir182.sheetQdfir182DAO;
import com.efass.sheet.mdfir191.sheetQdfir191DAO;
import com.efass.sheet.mdfir192.sheetQdfir192DAO;
import com.efass.sheet.mdfir193.sheetQdfir193DAO;
import com.efass.sheet.mdfir201.sheetQdfir201DAO;
import com.efass.sheet.mdfir221.sheetQdfir221DAO;
import com.efass.sheet.mdfir223.sheetQdfir223DAO;
import com.efass.sheet.mdfir250.sheetQdfir250DAO;
import com.efass.sheet.mdfir271.sheetQdfir271DAO;
import com.efass.sheet.mdfir291.sheetQdfir291DAO;
import com.efass.sheet.mdfir292_1.sheetQdfir292_1DAO;
import com.efass.sheet.mdfir292_2.sheetQdfir292_2DAO;
import com.efass.sheet.mdfir292_3.sheetQdfir292_3DAO;
import com.efass.sheet.mdfir300.sheetQdfir300DAO;
import com.efass.sheet.mdfir302.sheetQdfir302DAO;
import com.efass.sheet.mdfir304.sheetQdfir304DAO;
import com.efass.sheet.mdfir311.sheetQdfir311DAO;
import com.efass.sheet.mdfir321.sheetQdfir321DAO;
import com.efass.sheet.mdfir333.sheetQdfir333DAO;
import com.efass.sheet.mdfir363.sheetQdfir363DAO;
import com.efass.sheet.mdfir371_1.sheetQdfir371_1DAO;
import com.efass.sheet.mdfir371_2.sheetQdfir371_2DAO;
import com.efass.sheet.mdfir371_3.sheetQdfir371_3DAO;
import com.efass.sheet.mdfir372.sheetQdfir372DAO;
import com.efass.sheet.mdfir382.sheetQdfir382DAO;
import com.efass.sheet.mdfir400.sheetQdfir400_DAO;
import com.efass.sheet.mdfir400_1.sheetQdfir400_1DAO;
import com.efass.sheet.mdfir400_10.sheetQdfir400_10DAO;
import com.efass.sheet.mdfir400_11.sheetQdfir400_11DAO;
import com.efass.sheet.mdfir400_12.sheetQdfir400_12DAO;
import com.efass.sheet.mdfir400_13.sheetQdfir400_13DAO;
import com.efass.sheet.mdfir400_14.sheetQdfir400_14DAO;
import com.efass.sheet.mdfir400_15.sheetQdfir400_15DAO;
import com.efass.sheet.mdfir400_2.sheetQdfir400_2DAO;
import com.efass.sheet.mdfir400_3.sheetQdfir400_3DAO;
import com.efass.sheet.mdfir400_4.sheetQdfir400_4DAO;
import com.efass.sheet.mdfir400_5.sheetQdfir400_5DAO;
import com.efass.sheet.mdfir400_6.sheetQdfir400_6DAO;
import com.efass.sheet.mdfir400_7.sheetQdfir400_7DAO;
import com.efass.sheet.mdfir400_8.sheetQdfir400_8DAO;
import com.efass.sheet.mdfir400_9.sheetQdfir400_9DAO;
import com.efass.sheet.mdfir412.sheetQdfir412DAO;
import com.efass.sheet.mdfir422.sheetQdfir422DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.mdfir425.sheetQdfir425DAO;
import com.efass.sheet.mdfir432.sheetQdfir432DAO;
import com.efass.sheet.mdfir450.sheetQdfir450_DAO;
import com.efass.sheet.mdfir450_1.sheetQdfir450_1DAO;
import com.efass.sheet.mdfir450_10.sheetQdfir450_10DAO;
import com.efass.sheet.mdfir450_11.sheetQdfir450_11DAO;
import com.efass.sheet.mdfir450_12.sheetQdfir450_12DAO;
import com.efass.sheet.mdfir450_13.sheetQdfir450_13DAO;
import com.efass.sheet.mdfir450_14.sheetQdfir450_14DAO;
import com.efass.sheet.mdfir450_15.sheetQdfir450_15DAO;
import com.efass.sheet.mdfir450_2.sheetQdfir450_2DAO;
import com.efass.sheet.mdfir450_3.sheetQdfir450_3DAO;
import com.efass.sheet.mdfir450_4.sheetQdfir450_4DAO;
import com.efass.sheet.mdfir450_5.sheetQdfir450_5DAO;
import com.efass.sheet.mdfir450_6.sheetQdfir450_6DAO;
import com.efass.sheet.mdfir450_7.sheetQdfir450_7DAO;
import com.efass.sheet.mdfir450_8.sheetQdfir450_8DAO;
import com.efass.sheet.mdfir450_9.sheetQdfir450_9DAO;
import com.efass.sheet.mdfir453.sheetQdfir453DAO;
import com.efass.sheet.mdfir455.sheetQdfir455DAO;
import com.efass.sheet.mdfir493.sheetQdfir493DAO;
import com.efass.sheet.mdfir533.sheetQdfir533DAO;
import com.efass.sheet.mdfir600.sheetQdfir600DAO;
import com.efass.sheet.mdfir601.sheetQdfir601DAO;
import com.efass.sheet.mdfir700.sheetQdfir700DAO;
import com.efass.sheet.mdfir702.sheetQdfir702DAO;
import com.efass.sheet.mdfir800.sheetQdfir800DAO;
import com.efass.sheet.mdfir900.sheetQdfir900DAO;
import com.efass.sheet.mdfir920.sheetQdfir920DAO;
import com.efass.sheet.mdfir921.sheetQdfir921DAO;
import com.efass.sheet.mstdr1.sheetQstdr1DAO;
import com.efass.sheet.mstdr2.sheetQstdr2DAO;
import com.efass.user.UserDAO;

public class ResponseQuarterly {

	public String responseMessage;
	public int responseCode;
	public UserDAO user;
	public Iterable<UserDAO> allUsers;
	public String token;
	public String filePath;

	public String fileId;

	public Iterable<sheetQdfir221DAO> Qdfir221;
	public sheetQdfir221DAO s221Data;

	public sheetQdfir311DAO s311Data;
	public Iterable<sheetQdfir311DAO> Qdfir311;

	public sheetQdfir382DAO s382Data;
	public Iterable<sheetQdfir382DAO> Qdfir382;

	public sheetQdfir321DAO s321Data;
	public Iterable<sheetQdfir321DAO> Qdfir321;

	public sheetQdfir101DAO s101Data;
	public Iterable<sheetQdfir101DAO> Qdfir101;

	public sheetQdfir372DAO s372Data;
	public Iterable<sheetQdfir372DAO> Qdfir372;

	public sheetQdfir302DAO s302Data;
	public Iterable<sheetQdfir302DAO> Qdfir302;

	public sheetQdfir412DAO s412Data;
	public Iterable<sheetQdfir412DAO> Qdfir412;

	public sheetQdfir422DAO s422Data;
	public Iterable<sheetQdfir422DAO> Qdfir422;

	public sheetQdfir425DAO s425Data;
	public Iterable<sheetQdfir425DAO> Qdfir425;

	public sheetQdfir432DAO s432Data;
	public Iterable<sheetQdfir432DAO> Qdfir432;

	public sheetQdfir271DAO s271Data;
	public Iterable<sheetQdfir271DAO> Qdfir271;

	public sheetQdfir122DAO s122Data;
	public Iterable<sheetQdfir122DAO> Qdfir122;

	public sheetQdfir423DAO s423Data;
	public Iterable<sheetQdfir423DAO> Qdfir423;

	public sheetQdfir1200DAO s1200Data;
	public Iterable<sheetQdfir1200DAO> Qdfir1200;

	public sheetQdfir533DAO s533Data;
	public Iterable<sheetQdfir533DAO> Qdfir533;

	public sheetQdfir201DAO s201Data;
	public Iterable<sheetQdfir201DAO> Qdfir201;

	public sheetQdfir300DAO s300Data;
	public Iterable<sheetQdfir300DAO> Qdfir300;

	public sheetQdfir191DAO s191Data;
	public Iterable<sheetQdfir191DAO> Qdfir191;

	public sheetQdfir192DAO s192Data;
	public Iterable<sheetQdfir192DAO> Qdfir192;

	public sheetQdfirDAO s100Data;
	public Iterable<sheetQdfirDAO> Qdfir100;

	public sheetQdfir142DAO s142Data;
	public Iterable<sheetQdfir142DAO> Qdfir142;

	public sheetQdfir172DAO s172Data;
	public Iterable<sheetQdfir172DAO> Qdfir172;

	public sheetQdfir250DAO s250Data;
	public Iterable<sheetQdfir250DAO> Qdfir250;

	public sheetQdfir161DAO s161Data;
	public Iterable<sheetQdfir161DAO> Qdfir161;

	public sheetQdfir182DAO s182Data;
	public Iterable<sheetQdfir182DAO> Qdfir182;

	public sheetQdfir193DAO s193Data;
	public Iterable<sheetQdfir193DAO> Qdfir193;

	public sheetQdfir304DAO s304Data;
	public Iterable<sheetQdfir304DAO> Qdfir304;

	public sheetQdfir600DAO s600Data;
	public Iterable<sheetQdfir600DAO> Qdfir600;

	public sheetQdfir601DAO s601Data;
	public Iterable<sheetQdfir601DAO> Qdfir601;

	public sheetQdfir400_DAO s400_Data;
	public Iterable<sheetQdfir400_DAO> Qdfir400;

	public sheetQdfir400_1DAO s400_1Data;
	public Iterable<sheetQdfir400_1DAO> Qdfir400_1;

	public sheetQdfir400_2DAO s400_2Data;
	public Iterable<sheetQdfir400_2DAO> Qdfir400_2;

	public sheetQdfir400_3DAO s400_3Data;
	public Iterable<sheetQdfir400_3DAO> Qdfir400_3;

	public sheetQdfir400_4DAO s400_4Data;
	public Iterable<sheetQdfir400_4DAO> Qdfir400_4;

	public sheetQdfir400_5DAO s400_5Data;
	public Iterable<sheetQdfir400_5DAO> Qdfir400_5;

	public sheetQdfir400_6DAO s400_6Data;
	public Iterable<sheetQdfir400_6DAO> Qdfir400_6;

	public sheetQdfir400_7DAO s400_7Data;
	public Iterable<sheetQdfir400_7DAO> Qdfir400_7;

	public sheetQdfir400_8DAO s400_8Data;
	public Iterable<sheetQdfir400_8DAO> Qdfir400_8;

	public sheetQdfir400_9DAO s400_9Data;
	public Iterable<sheetQdfir400_9DAO> Qdfir400_9;

	public sheetQdfir400_10DAO s400_10Data;
	public Iterable<sheetQdfir400_10DAO> Qdfir400_10;

	public sheetQdfir400_11DAO s400_11Data;
	public Iterable<sheetQdfir400_11DAO> Qdfir400_11;

	public sheetQdfir400_12DAO s400_12Data;
	public Iterable<sheetQdfir400_12DAO> Qdfir400_12;

	public sheetQdfir400_13DAO s400_13Data;
	public Iterable<sheetQdfir400_13DAO> Qdfir400_13;

	public sheetQdfir400_14DAO s400_14Data;
	public Iterable<sheetQdfir400_14DAO> Qdfir400_14;

	public sheetQdfir400_15DAO s400_15Data;
	public Iterable<sheetQdfir400_15DAO> Qdfir400_15;

	public sheetQdfir450_DAO s450_Data;
	public Iterable<sheetQdfir450_DAO> Qdfir450;

	public sheetQdfir450_1DAO s450_1Data;
	public Iterable<sheetQdfir450_1DAO> Qdfir450_1;

	public sheetQdfir450_2DAO s450_2Data;
	public Iterable<sheetQdfir450_2DAO> Qdfir450_2;

	public sheetQdfir450_3DAO s450_3Data;
	public Iterable<sheetQdfir450_3DAO> Qdfir450_3;

	public sheetQdfir450_4DAO s450_4Data;
	public Iterable<sheetQdfir450_4DAO> Qdfir450_4;

	public sheetQdfir450_5DAO s450_5Data;
	public Iterable<sheetQdfir450_5DAO> Qdfir450_5;

	public sheetQdfir450_6DAO s450_6Data;
	public Iterable<sheetQdfir450_6DAO> Qdfir450_6;

	public sheetQdfir450_7DAO s450_7Data;
	public Iterable<sheetQdfir450_7DAO> Qdfir450_7;

	public sheetQdfir450_8DAO s450_8Data;
	public Iterable<sheetQdfir450_8DAO> Qdfir450_8;

	public sheetQdfir450_9DAO s450_9Data;
	public Iterable<sheetQdfir450_9DAO> Qdfir450_9;

	public sheetQdfir450_10DAO s450_10Data;
	public Iterable<sheetQdfir450_10DAO> Qdfir450_10;

	public sheetQdfir450_11DAO s450_11Data;
	public Iterable<sheetQdfir450_11DAO> Qdfir450_11;

	public sheetQdfir450_12DAO s450_12Data;
	public Iterable<sheetQdfir450_12DAO> Qdfir450_12;

	public sheetQdfir450_13DAO s450_13Data;
	public Iterable<sheetQdfir450_13DAO> Qdfir450_13;

	public sheetQdfir450_14DAO s450_14Data;
	public Iterable<sheetQdfir450_14DAO> Qdfir450_14;

	public sheetQdfir450_15DAO s450_15Data;
	public Iterable<sheetQdfir450_15DAO> Qdfir450_15;

	public sheetQdfir493DAO s493Data;
	public Iterable<sheetQdfir493DAO> Qdfir493;

	public sheetQdfir291DAO s291Data;
	public Iterable<sheetQdfir291DAO> Qdfir291;

	public sheetQdfir292_1DAO s292_1Data;
	public Iterable<sheetQdfir292_1DAO> Qdfir292_1;

	public sheetQdfir292_2DAO s292_2Data;
	public Iterable<sheetQdfir292_2DAO> Qdfir292_2;

	public sheetQdfir292_3DAO s292_3Data;
	public Iterable<sheetQdfir292_3DAO> Qdfir292_3;

	public sheetQdfir363DAO s363Data;
	public Iterable<sheetQdfir363DAO> Qdfir363;

	public sheetQdfir371_1DAO s371_1Data;
	public Iterable<sheetQdfir371_1DAO> Qdfir371_1;

	public sheetQdfir371_2DAO s371_2Data;
	public Iterable<sheetQdfir371_2DAO> Qdfir371_2;

	public sheetQdfir371_3DAO s371_3Data;
	public Iterable<sheetQdfir371_3DAO> Qdfir371_3;

	public sheetQdfir453DAO s453Data;
	public Iterable<sheetQdfir453DAO> Qdfir453;

	public sheetQdfir700DAO s700Data;
	public Iterable<sheetQdfir700DAO> Qdfir700;

	public sheetQdfir702DAO s702Data;
	public Iterable<sheetQdfir702DAO> Qdfir702;

	public sheetQdfir800DAO s800Data;
	public Iterable<sheetQdfir800DAO> Qdfir800;

	public sheetQdfir900DAO s900Data;
	public Iterable<sheetQdfir900DAO> Qdfir900;

	public sheetQdfir920DAO s920Data;
	public Iterable<sheetQdfir920DAO> Qdfir920;

	public sheetQdfir921DAO s921Data;
	public Iterable<sheetQdfir921DAO> Qdfir921;

	public sheetQcfpr1Dao sQcfpr1Data;
	public Iterable<sheetQcfpr1Dao> Qcfpr1;

	public sheetQdfir1300DAO s1300Data;
	public Iterable<sheetQdfir1300DAO> Qdfir1300;

	public sheetQdfir1301DAO s1301Data;
	public Iterable<sheetQdfir1301DAO> Qdfir1301;

	public sheetQdfir1400DAO s1400Data;
	public Iterable<sheetQdfir1400DAO> Qdfir1400;

	public sheetQdfir1500DAO s1500Data;
	public Iterable<sheetQdfir1500DAO> Qdfir1500;

	public sheetQdfir1600DAO s1600Data;
	public Iterable<sheetQdfir1600DAO> Qdfir1600;

	public sheetQdfir1650DAO s1650Data;
	public Iterable<sheetQdfir1650DAO> Qdfir1650;

	public sheetQdfir1700DAO s1700Data;
	public Iterable<sheetQdfir1700DAO> Qdfir1700;

	public sheetQdfir223DAO s223Data;
	public Iterable<sheetQdfir223DAO> Qdfir223;

	public sheetQdfir333DAO s333Data;
	public Iterable<sheetQdfir333DAO> Qdfir333;

	public sheetQdfir455DAO s455Data;
	public Iterable<sheetQdfir455DAO> Qdfir455;

	public sheetQstdr1DAO s001Data;
	public Iterable<sheetQstdr1DAO> Qstdr001;

	public sheetQstdr2DAO s002Data;
	public Iterable<sheetQstdr2DAO> Qstdr002;

	public sheetQdfir1000DAO s1000Data;
	public Iterable<sheetQdfir1000DAO> Qdfir1000;

	public ArrayList<ReportDAO> ReportData;
	public ArrayList<String> columnNames;

	@Override
	public String toString() {
		return "Response [Sheet321Data=" + s321Data + "]";
	}

	public ResponseQuarterly() {

	}

	public UserDAO getUser() {
		return user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
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

	public Iterable<UserDAO> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(Iterable<UserDAO> allUsers) {
		this.allUsers = allUsers;
	}

	public sheetQcfpr1Dao getsQcfpr1Data() {
		return sQcfpr1Data;
	}

	public void setsQcfpr1Data(sheetQcfpr1Dao sQcfpr1Data) {
		this.sQcfpr1Data = sQcfpr1Data;
	}

	public Iterable<sheetQcfpr1Dao> getQcfpr1() {
		return Qcfpr1;
	}

	public void setQcfpr1(Iterable<sheetQcfpr1Dao> qcfpr1) {
		Qcfpr1 = qcfpr1;
	}

	public Iterable<sheetQdfir221DAO> getQdfir221() {
		return Qdfir221;
	}

	public void setQdfir221(Iterable<sheetQdfir221DAO> qdfir221) {
		Qdfir221 = qdfir221;
	}

	public sheetQdfir221DAO getS221Data() {
		return s221Data;
	}

	public void setS221Data(sheetQdfir221DAO s221Data) {
		this.s221Data = s221Data;
	}

	public sheetQdfir311DAO getS311Data() {
		return s311Data;
	}

	public void setS311Data(sheetQdfir311DAO s311Data) {
		this.s311Data = s311Data;
	}

	public Iterable<sheetQdfir311DAO> getQdfir311() {
		return Qdfir311;
	}

	public void setQdfir311(Iterable<sheetQdfir311DAO> qdfir311) {
		Qdfir311 = qdfir311;
	}

	public sheetQdfir382DAO getS382Data() {
		return s382Data;
	}

	public void setS382Data(sheetQdfir382DAO s382Data) {
		this.s382Data = s382Data;
	}

	public Iterable<sheetQdfir382DAO> getQdfir382() {
		return Qdfir382;
	}

	public void setQdfir382(Iterable<sheetQdfir382DAO> qdfir382) {
		Qdfir382 = qdfir382;
	}

	public sheetQdfir321DAO getS321Data() {
		return s321Data;
	}

	public void setS321Data(sheetQdfir321DAO s321Data) {
		this.s321Data = s321Data;
	}

	public Iterable<sheetQdfir321DAO> getQdfir321() {
		return Qdfir321;
	}

	public void setQdfir321(Iterable<sheetQdfir321DAO> qdfir321) {
		Qdfir321 = qdfir321;
	}

	public sheetQdfir101DAO getS101Data() {
		return s101Data;
	}

	public void setS101Data(sheetQdfir101DAO s101Data) {
		this.s101Data = s101Data;
	}

	public Iterable<sheetQdfir101DAO> getQdfir101() {
		return Qdfir101;
	}

	public void setQdfir101(Iterable<sheetQdfir101DAO> qdfir101) {
		Qdfir101 = qdfir101;
	}

	public sheetQdfir372DAO getS372Data() {
		return s372Data;
	}

	public void setS372Data(sheetQdfir372DAO s372Data) {
		this.s372Data = s372Data;
	}

	public Iterable<sheetQdfir372DAO> getQdfir372() {
		return Qdfir372;
	}

	public void setQdfir372(Iterable<sheetQdfir372DAO> qdfir372) {
		Qdfir372 = qdfir372;
	}

	public sheetQdfir302DAO getS302Data() {
		return s302Data;
	}

	public void setS302Data(sheetQdfir302DAO s302Data) {
		this.s302Data = s302Data;
	}

	public Iterable<sheetQdfir302DAO> getQdfir302() {
		return Qdfir302;
	}

	public void setQdfir302(Iterable<sheetQdfir302DAO> qdfir302) {
		Qdfir302 = qdfir302;
	}

	public sheetQdfir412DAO getS412Data() {
		return s412Data;
	}

	public void setS412Data(sheetQdfir412DAO s412Data) {
		this.s412Data = s412Data;
	}

	public Iterable<sheetQdfir412DAO> getQdfir412() {
		return Qdfir412;
	}

	public void setQdfir412(Iterable<sheetQdfir412DAO> qdfir412) {
		Qdfir412 = qdfir412;
	}

	public sheetQdfir422DAO getS422Data() {
		return s422Data;
	}

	public void setS422Data(sheetQdfir422DAO s422Data) {
		this.s422Data = s422Data;
	}

	public Iterable<sheetQdfir422DAO> getQdfir422() {
		return Qdfir422;
	}

	public void setQdfir422(Iterable<sheetQdfir422DAO> qdfir422) {
		Qdfir422 = qdfir422;
	}

	public sheetQdfir425DAO getS425Data() {
		return s425Data;
	}

	public void setS425Data(sheetQdfir425DAO s425Data) {
		this.s425Data = s425Data;
	}

	public Iterable<sheetQdfir425DAO> getQdfir425() {
		return Qdfir425;
	}

	public void setQdfir425(Iterable<sheetQdfir425DAO> qdfir425) {
		Qdfir425 = qdfir425;
	}

	public sheetQdfir432DAO getS432Data() {
		return s432Data;
	}

	public void setS432Data(sheetQdfir432DAO s432Data) {
		this.s432Data = s432Data;
	}

	public Iterable<sheetQdfir432DAO> getQdfir432() {
		return Qdfir432;
	}

	public void setQdfir432(Iterable<sheetQdfir432DAO> qdfir432) {
		Qdfir432 = qdfir432;
	}

	public sheetQdfir271DAO getS271Data() {
		return s271Data;
	}

	public void setS271Data(sheetQdfir271DAO s271Data) {
		this.s271Data = s271Data;
	}

	public Iterable<sheetQdfir271DAO> getQdfir271() {
		return Qdfir271;
	}

	public void setQdfir271(Iterable<sheetQdfir271DAO> qdfir271) {
		Qdfir271 = qdfir271;
	}

	public sheetQdfir122DAO getS122Data() {
		return s122Data;
	}

	public void setS122Data(sheetQdfir122DAO s122Data) {
		this.s122Data = s122Data;
	}

	public Iterable<sheetQdfir122DAO> getQdfir122() {
		return Qdfir122;
	}

	public void setQdfir122(Iterable<sheetQdfir122DAO> qdfir122) {
		Qdfir122 = qdfir122;
	}

	public sheetQdfir423DAO getS423Data() {
		return s423Data;
	}

	public void setS423Data(sheetQdfir423DAO s423Data) {
		this.s423Data = s423Data;
	}

	public Iterable<sheetQdfir423DAO> getQdfir423() {
		return Qdfir423;
	}

	public void setQdfir423(Iterable<sheetQdfir423DAO> qdfir423) {
		Qdfir423 = qdfir423;
	}

	public sheetQdfir1200DAO getS1200Data() {
		return s1200Data;
	}

	public void setS1200Data(sheetQdfir1200DAO s1200Data) {
		this.s1200Data = s1200Data;
	}

	public Iterable<sheetQdfir1200DAO> getQdfir1200() {
		return Qdfir1200;
	}

	public void setQdfir1200(Iterable<sheetQdfir1200DAO> qdfir1200) {
		Qdfir1200 = qdfir1200;
	}

	public sheetQdfir533DAO getS533Data() {
		return s533Data;
	}

	public void setS533Data(sheetQdfir533DAO s533Data) {
		this.s533Data = s533Data;
	}

	public Iterable<sheetQdfir533DAO> getQdfir533() {
		return Qdfir533;
	}

	public void setQdfir533(Iterable<sheetQdfir533DAO> qdfir533) {
		Qdfir533 = qdfir533;
	}

	public sheetQdfir201DAO getS201Data() {
		return s201Data;
	}

	public void setS201Data(sheetQdfir201DAO s201Data) {
		this.s201Data = s201Data;
	}

	public Iterable<sheetQdfir201DAO> getQdfir201() {
		return Qdfir201;
	}

	public void setQdfir201(Iterable<sheetQdfir201DAO> qdfir201) {
		Qdfir201 = qdfir201;
	}

	public sheetQdfir300DAO getS300Data() {
		return s300Data;
	}

	public void setS300Data(sheetQdfir300DAO s300Data) {
		this.s300Data = s300Data;
	}

	public Iterable<sheetQdfir300DAO> getQdfir300() {
		return Qdfir300;
	}

	public void setQdfir300(Iterable<sheetQdfir300DAO> qdfir300) {
		Qdfir300 = qdfir300;
	}

	public sheetQdfir191DAO getS191Data() {
		return s191Data;
	}

	public void setS191Data(sheetQdfir191DAO s191Data) {
		this.s191Data = s191Data;
	}

	public Iterable<sheetQdfir191DAO> getQdfir191() {
		return Qdfir191;
	}

	public void setQdfir191(Iterable<sheetQdfir191DAO> qdfir191) {
		Qdfir191 = qdfir191;
	}

	public sheetQdfir192DAO getS192Data() {
		return s192Data;
	}

	public void setS192Data(sheetQdfir192DAO s192Data) {
		this.s192Data = s192Data;
	}

	public Iterable<sheetQdfir192DAO> getQdfir192() {
		return Qdfir192;
	}

	public void setQdfir192(Iterable<sheetQdfir192DAO> qdfir192) {
		Qdfir192 = qdfir192;
	}

	public sheetQdfirDAO getS100Data() {
		return s100Data;
	}

	public void setS100Data(sheetQdfirDAO s100Data) {
		this.s100Data = s100Data;
	}

	public Iterable<sheetQdfirDAO> getQdfir100() {
		return Qdfir100;
	}

	public void setQdfir100(Iterable<sheetQdfirDAO> qdfir100) {
		Qdfir100 = qdfir100;
	}

	public sheetQdfir142DAO getS142Data() {
		return s142Data;
	}

	public void setS142Data(sheetQdfir142DAO s142Data) {
		this.s142Data = s142Data;
	}

	public Iterable<sheetQdfir142DAO> getQdfir142() {
		return Qdfir142;
	}

	public void setQdfir142(Iterable<sheetQdfir142DAO> qdfir142) {
		Qdfir142 = qdfir142;
	}

	public sheetQdfir172DAO getS172Data() {
		return s172Data;
	}

	public void setS172Data(sheetQdfir172DAO s172Data) {
		this.s172Data = s172Data;
	}

	public Iterable<sheetQdfir172DAO> getQdfir172() {
		return Qdfir172;
	}

	public void setQdfir172(Iterable<sheetQdfir172DAO> qdfir172) {
		Qdfir172 = qdfir172;
	}

	public sheetQdfir250DAO getS250Data() {
		return s250Data;
	}

	public void setS250Data(sheetQdfir250DAO s250Data) {
		this.s250Data = s250Data;
	}

	public Iterable<sheetQdfir250DAO> getQdfir250() {
		return Qdfir250;
	}

	public void setQdfir250(Iterable<sheetQdfir250DAO> qdfir250) {
		Qdfir250 = qdfir250;
	}

	public sheetQdfir161DAO getS161Data() {
		return s161Data;
	}

	public void setS161Data(sheetQdfir161DAO s161Data) {
		this.s161Data = s161Data;
	}

	public Iterable<sheetQdfir161DAO> getQdfir161() {
		return Qdfir161;
	}

	public void setQdfir161(Iterable<sheetQdfir161DAO> qdfir161) {
		Qdfir161 = qdfir161;
	}

	public sheetQdfir182DAO getS182Data() {
		return s182Data;
	}

	public void setS182Data(sheetQdfir182DAO s182Data) {
		this.s182Data = s182Data;
	}

	public Iterable<sheetQdfir182DAO> getQdfir182() {
		return Qdfir182;
	}

	public void setQdfir182(Iterable<sheetQdfir182DAO> qdfir182) {
		Qdfir182 = qdfir182;
	}

	public sheetQdfir193DAO getS193Data() {
		return s193Data;
	}

	public void setS193Data(sheetQdfir193DAO s193Data) {
		this.s193Data = s193Data;
	}

	public Iterable<sheetQdfir193DAO> getQdfir193() {
		return Qdfir193;
	}

	public void setQdfir193(Iterable<sheetQdfir193DAO> qdfir193) {
		Qdfir193 = qdfir193;
	}

	public sheetQdfir304DAO getS304Data() {
		return s304Data;
	}

	public void setS304Data(sheetQdfir304DAO s304Data) {
		this.s304Data = s304Data;
	}

	public Iterable<sheetQdfir304DAO> getQdfir304() {
		return Qdfir304;
	}

	public void setQdfir304(Iterable<sheetQdfir304DAO> qdfir304) {
		Qdfir304 = qdfir304;
	}

	public sheetQdfir600DAO getS600Data() {
		return s600Data;
	}

	public void setS600Data(sheetQdfir600DAO s600Data) {
		this.s600Data = s600Data;
	}

	public Iterable<sheetQdfir600DAO> getQdfir600() {
		return Qdfir600;
	}

	public void setQdfir600(Iterable<sheetQdfir600DAO> qdfir600) {
		Qdfir600 = qdfir600;
	}

	public sheetQdfir601DAO getS601Data() {
		return s601Data;
	}

	public void setS601Data(sheetQdfir601DAO s601Data) {
		this.s601Data = s601Data;
	}

	public Iterable<sheetQdfir601DAO> getQdfir601() {
		return Qdfir601;
	}

	public void setQdfir601(Iterable<sheetQdfir601DAO> qdfir601) {
		Qdfir601 = qdfir601;
	}

	public sheetQdfir400_DAO getS400_Data() {
		return s400_Data;
	}

	public void setS400_Data(sheetQdfir400_DAO s400_Data) {
		this.s400_Data = s400_Data;
	}

	public Iterable<sheetQdfir400_DAO> getQdfir400() {
		return Qdfir400;
	}

	public void setQdfir400(Iterable<sheetQdfir400_DAO> qdfir400) {
		Qdfir400 = qdfir400;
	}

	public sheetQdfir400_1DAO getS400_1Data() {
		return s400_1Data;
	}

	public void setS400_1Data(sheetQdfir400_1DAO s400_1Data) {
		this.s400_1Data = s400_1Data;
	}

	public Iterable<sheetQdfir400_1DAO> getQdfir400_1() {
		return Qdfir400_1;
	}

	public void setQdfir400_1(Iterable<sheetQdfir400_1DAO> qdfir400_1) {
		Qdfir400_1 = qdfir400_1;
	}

	public sheetQdfir400_2DAO getS400_2Data() {
		return s400_2Data;
	}

	public void setS400_2Data(sheetQdfir400_2DAO s400_2Data) {
		this.s400_2Data = s400_2Data;
	}

	public Iterable<sheetQdfir400_2DAO> getQdfir400_2() {
		return Qdfir400_2;
	}

	public void setQdfir400_2(Iterable<sheetQdfir400_2DAO> qdfir400_2) {
		Qdfir400_2 = qdfir400_2;
	}

	public sheetQdfir400_3DAO getS400_3Data() {
		return s400_3Data;
	}

	public void setS400_3Data(sheetQdfir400_3DAO s400_3Data) {
		this.s400_3Data = s400_3Data;
	}

	public Iterable<sheetQdfir400_3DAO> getQdfir400_3() {
		return Qdfir400_3;
	}

	public void setQdfir400_3(Iterable<sheetQdfir400_3DAO> qdfir400_3) {
		Qdfir400_3 = qdfir400_3;
	}

	public sheetQdfir400_4DAO getS400_4Data() {
		return s400_4Data;
	}

	public void setS400_4Data(sheetQdfir400_4DAO s400_4Data) {
		this.s400_4Data = s400_4Data;
	}

	public Iterable<sheetQdfir400_4DAO> getQdfir400_4() {
		return Qdfir400_4;
	}

	public void setQdfir400_4(Iterable<sheetQdfir400_4DAO> qdfir400_4) {
		Qdfir400_4 = qdfir400_4;
	}

	public sheetQdfir400_5DAO getS400_5Data() {
		return s400_5Data;
	}

	public void setS400_5Data(sheetQdfir400_5DAO s400_5Data) {
		this.s400_5Data = s400_5Data;
	}

	public Iterable<sheetQdfir400_5DAO> getQdfir400_5() {
		return Qdfir400_5;
	}

	public void setQdfir400_5(Iterable<sheetQdfir400_5DAO> qdfir400_5) {
		Qdfir400_5 = qdfir400_5;
	}

	public sheetQdfir400_6DAO getS400_6Data() {
		return s400_6Data;
	}

	public void setS400_6Data(sheetQdfir400_6DAO s400_6Data) {
		this.s400_6Data = s400_6Data;
	}

	public Iterable<sheetQdfir400_6DAO> getQdfir400_6() {
		return Qdfir400_6;
	}

	public void setQdfir400_6(Iterable<sheetQdfir400_6DAO> qdfir400_6) {
		Qdfir400_6 = qdfir400_6;
	}

	public sheetQdfir400_7DAO getS400_7Data() {
		return s400_7Data;
	}

	public void setS400_7Data(sheetQdfir400_7DAO s400_7Data) {
		this.s400_7Data = s400_7Data;
	}

	public Iterable<sheetQdfir400_7DAO> getQdfir400_7() {
		return Qdfir400_7;
	}

	public void setQdfir400_7(Iterable<sheetQdfir400_7DAO> qdfir400_7) {
		Qdfir400_7 = qdfir400_7;
	}

	public sheetQdfir400_8DAO getS400_8Data() {
		return s400_8Data;
	}

	public void setS400_8Data(sheetQdfir400_8DAO s400_8Data) {
		this.s400_8Data = s400_8Data;
	}

	public Iterable<sheetQdfir400_8DAO> getQdfir400_8() {
		return Qdfir400_8;
	}

	public void setQdfir400_8(Iterable<sheetQdfir400_8DAO> qdfir400_8) {
		Qdfir400_8 = qdfir400_8;
	}

	public sheetQdfir400_9DAO getS400_9Data() {
		return s400_9Data;
	}

	public void setS400_9Data(sheetQdfir400_9DAO s400_9Data) {
		this.s400_9Data = s400_9Data;
	}

	public Iterable<sheetQdfir400_9DAO> getQdfir400_9() {
		return Qdfir400_9;
	}

	public void setQdfir400_9(Iterable<sheetQdfir400_9DAO> qdfir400_9) {
		Qdfir400_9 = qdfir400_9;
	}

	public sheetQdfir400_10DAO getS400_10Data() {
		return s400_10Data;
	}

	public void setS400_10Data(sheetQdfir400_10DAO s400_10Data) {
		this.s400_10Data = s400_10Data;
	}

	public Iterable<sheetQdfir400_10DAO> getQdfir400_10() {
		return Qdfir400_10;
	}

	public void setQdfir400_10(Iterable<sheetQdfir400_10DAO> qdfir400_10) {
		Qdfir400_10 = qdfir400_10;
	}

	public sheetQdfir400_11DAO getS400_11Data() {
		return s400_11Data;
	}

	public void setS400_11Data(sheetQdfir400_11DAO s400_11Data) {
		this.s400_11Data = s400_11Data;
	}

	public Iterable<sheetQdfir400_11DAO> getQdfir400_11() {
		return Qdfir400_11;
	}

	public void setQdfir400_11(Iterable<sheetQdfir400_11DAO> qdfir400_11) {
		Qdfir400_11 = qdfir400_11;
	}

	public sheetQdfir400_12DAO getS400_12Data() {
		return s400_12Data;
	}

	public void setS400_12Data(sheetQdfir400_12DAO s400_12Data) {
		this.s400_12Data = s400_12Data;
	}

	public Iterable<sheetQdfir400_12DAO> getQdfir400_12() {
		return Qdfir400_12;
	}

	public void setQdfir400_12(Iterable<sheetQdfir400_12DAO> qdfir400_12) {
		Qdfir400_12 = qdfir400_12;
	}

	public sheetQdfir400_13DAO getS400_13Data() {
		return s400_13Data;
	}

	public void setS400_13Data(sheetQdfir400_13DAO s400_13Data) {
		this.s400_13Data = s400_13Data;
	}

	public Iterable<sheetQdfir400_13DAO> getQdfir400_13() {
		return Qdfir400_13;
	}

	public void setQdfir400_13(Iterable<sheetQdfir400_13DAO> qdfir400_13) {
		Qdfir400_13 = qdfir400_13;
	}

	public sheetQdfir400_14DAO getS400_14Data() {
		return s400_14Data;
	}

	public void setS400_14Data(sheetQdfir400_14DAO s400_14Data) {
		this.s400_14Data = s400_14Data;
	}

	public Iterable<sheetQdfir400_14DAO> getQdfir400_14() {
		return Qdfir400_14;
	}

	public void setQdfir400_14(Iterable<sheetQdfir400_14DAO> qdfir400_14) {
		Qdfir400_14 = qdfir400_14;
	}

	public sheetQdfir400_15DAO getS400_15Data() {
		return s400_15Data;
	}

	public void setS400_15Data(sheetQdfir400_15DAO s400_15Data) {
		this.s400_15Data = s400_15Data;
	}

	public Iterable<sheetQdfir400_15DAO> getQdfir400_15() {
		return Qdfir400_15;
	}

	public void setQdfir400_15(Iterable<sheetQdfir400_15DAO> qdfir400_15) {
		Qdfir400_15 = qdfir400_15;
	}

	public sheetQdfir450_DAO getS450_Data() {
		return s450_Data;
	}

	public void setS450_Data(sheetQdfir450_DAO s450_Data) {
		this.s450_Data = s450_Data;
	}

	public Iterable<sheetQdfir450_DAO> getQdfir450() {
		return Qdfir450;
	}

	public void setQdfir450(Iterable<sheetQdfir450_DAO> qdfir450) {
		Qdfir450 = qdfir450;
	}

	public sheetQdfir450_1DAO getS450_1Data() {
		return s450_1Data;
	}

	public void setS450_1Data(sheetQdfir450_1DAO s450_1Data) {
		this.s450_1Data = s450_1Data;
	}

	public Iterable<sheetQdfir450_1DAO> getQdfir450_1() {
		return Qdfir450_1;
	}

	public void setQdfir450_1(Iterable<sheetQdfir450_1DAO> qdfir450_1) {
		Qdfir450_1 = qdfir450_1;
	}

	public sheetQdfir450_2DAO getS450_2Data() {
		return s450_2Data;
	}

	public void setS450_2Data(sheetQdfir450_2DAO s450_2Data) {
		this.s450_2Data = s450_2Data;
	}

	public Iterable<sheetQdfir450_2DAO> getQdfir450_2() {
		return Qdfir450_2;
	}

	public void setQdfir450_2(Iterable<sheetQdfir450_2DAO> qdfir450_2) {
		Qdfir450_2 = qdfir450_2;
	}

	public sheetQdfir450_3DAO getS450_3Data() {
		return s450_3Data;
	}

	public void setS450_3Data(sheetQdfir450_3DAO s450_3Data) {
		this.s450_3Data = s450_3Data;
	}

	public Iterable<sheetQdfir450_3DAO> getQdfir450_3() {
		return Qdfir450_3;
	}

	public void setQdfir450_3(Iterable<sheetQdfir450_3DAO> qdfir450_3) {
		Qdfir450_3 = qdfir450_3;
	}

	public sheetQdfir450_4DAO getS450_4Data() {
		return s450_4Data;
	}

	public void setS450_4Data(sheetQdfir450_4DAO s450_4Data) {
		this.s450_4Data = s450_4Data;
	}

	public Iterable<sheetQdfir450_4DAO> getQdfir450_4() {
		return Qdfir450_4;
	}

	public void setQdfir450_4(Iterable<sheetQdfir450_4DAO> qdfir450_4) {
		Qdfir450_4 = qdfir450_4;
	}

	public sheetQdfir450_5DAO getS450_5Data() {
		return s450_5Data;
	}

	public void setS450_5Data(sheetQdfir450_5DAO s450_5Data) {
		this.s450_5Data = s450_5Data;
	}

	public Iterable<sheetQdfir450_5DAO> getQdfir450_5() {
		return Qdfir450_5;
	}

	public void setQdfir450_5(Iterable<sheetQdfir450_5DAO> qdfir450_5) {
		Qdfir450_5 = qdfir450_5;
	}

	public sheetQdfir450_6DAO getS450_6Data() {
		return s450_6Data;
	}

	public void setS450_6Data(sheetQdfir450_6DAO s450_6Data) {
		this.s450_6Data = s450_6Data;
	}

	public Iterable<sheetQdfir450_6DAO> getQdfir450_6() {
		return Qdfir450_6;
	}

	public void setQdfir450_6(Iterable<sheetQdfir450_6DAO> qdfir450_6) {
		Qdfir450_6 = qdfir450_6;
	}

	public sheetQdfir450_7DAO getS450_7Data() {
		return s450_7Data;
	}

	public void setS450_7Data(sheetQdfir450_7DAO s450_7Data) {
		this.s450_7Data = s450_7Data;
	}

	public Iterable<sheetQdfir450_7DAO> getQdfir450_7() {
		return Qdfir450_7;
	}

	public void setQdfir450_7(Iterable<sheetQdfir450_7DAO> qdfir450_7) {
		Qdfir450_7 = qdfir450_7;
	}

	public sheetQdfir450_8DAO getS450_8Data() {
		return s450_8Data;
	}

	public void setS450_8Data(sheetQdfir450_8DAO s450_8Data) {
		this.s450_8Data = s450_8Data;
	}

	public Iterable<sheetQdfir450_8DAO> getQdfir450_8() {
		return Qdfir450_8;
	}

	public void setQdfir450_8(Iterable<sheetQdfir450_8DAO> qdfir450_8) {
		Qdfir450_8 = qdfir450_8;
	}

	public sheetQdfir450_9DAO getS450_9Data() {
		return s450_9Data;
	}

	public void setS450_9Data(sheetQdfir450_9DAO s450_9Data) {
		this.s450_9Data = s450_9Data;
	}

	public Iterable<sheetQdfir450_9DAO> getQdfir450_9() {
		return Qdfir450_9;
	}

	public void setQdfir450_9(Iterable<sheetQdfir450_9DAO> qdfir450_9) {
		Qdfir450_9 = qdfir450_9;
	}

	public sheetQdfir450_10DAO getS450_10Data() {
		return s450_10Data;
	}

	public void setS450_10Data(sheetQdfir450_10DAO s450_10Data) {
		this.s450_10Data = s450_10Data;
	}

	public Iterable<sheetQdfir450_10DAO> getQdfir450_10() {
		return Qdfir450_10;
	}

	public void setQdfir450_10(Iterable<sheetQdfir450_10DAO> qdfir450_10) {
		Qdfir450_10 = qdfir450_10;
	}

	public sheetQdfir450_11DAO getS450_11Data() {
		return s450_11Data;
	}

	public void setS450_11Data(sheetQdfir450_11DAO s450_11Data) {
		this.s450_11Data = s450_11Data;
	}

	public Iterable<sheetQdfir450_11DAO> getQdfir450_11() {
		return Qdfir450_11;
	}

	public void setQdfir450_11(Iterable<sheetQdfir450_11DAO> qdfir450_11) {
		Qdfir450_11 = qdfir450_11;
	}

	public sheetQdfir450_12DAO getS450_12Data() {
		return s450_12Data;
	}

	public void setS450_12Data(sheetQdfir450_12DAO s450_12Data) {
		this.s450_12Data = s450_12Data;
	}

	public Iterable<sheetQdfir450_12DAO> getQdfir450_12() {
		return Qdfir450_12;
	}

	public void setQdfir450_12(Iterable<sheetQdfir450_12DAO> qdfir450_12) {
		Qdfir450_12 = qdfir450_12;
	}

	public sheetQdfir450_13DAO getS450_13Data() {
		return s450_13Data;
	}

	public void setS450_13Data(sheetQdfir450_13DAO s450_13Data) {
		this.s450_13Data = s450_13Data;
	}

	public Iterable<sheetQdfir450_13DAO> getQdfir450_13() {
		return Qdfir450_13;
	}

	public void setQdfir450_13(Iterable<sheetQdfir450_13DAO> qdfir450_13) {
		Qdfir450_13 = qdfir450_13;
	}

	public sheetQdfir450_14DAO getS450_14Data() {
		return s450_14Data;
	}

	public void setS450_14Data(sheetQdfir450_14DAO s450_14Data) {
		this.s450_14Data = s450_14Data;
	}

	public Iterable<sheetQdfir450_14DAO> getQdfir450_14() {
		return Qdfir450_14;
	}

	public void setQdfir450_14(Iterable<sheetQdfir450_14DAO> qdfir450_14) {
		Qdfir450_14 = qdfir450_14;
	}

	public sheetQdfir450_15DAO getS450_15Data() {
		return s450_15Data;
	}

	public void setS450_15Data(sheetQdfir450_15DAO s450_15Data) {
		this.s450_15Data = s450_15Data;
	}

	public Iterable<sheetQdfir450_15DAO> getQdfir450_15() {
		return Qdfir450_15;
	}

	public void setQdfir450_15(Iterable<sheetQdfir450_15DAO> qdfir450_15) {
		Qdfir450_15 = qdfir450_15;
	}

	public sheetQdfir493DAO getS493Data() {
		return s493Data;
	}

	public void setS493Data(sheetQdfir493DAO s493Data) {
		this.s493Data = s493Data;
	}

	public Iterable<sheetQdfir493DAO> getQdfir493() {
		return Qdfir493;
	}

	public void setQdfir493(Iterable<sheetQdfir493DAO> qdfir493) {
		Qdfir493 = qdfir493;
	}

	public sheetQdfir291DAO getS291Data() {
		return s291Data;
	}

	public void setS291Data(sheetQdfir291DAO s291Data) {
		this.s291Data = s291Data;
	}

	public Iterable<sheetQdfir291DAO> getQdfir291() {
		return Qdfir291;
	}

	public void setQdfir291(Iterable<sheetQdfir291DAO> qdfir291) {
		Qdfir291 = qdfir291;
	}

	public sheetQdfir292_1DAO getS292_1Data() {
		return s292_1Data;
	}

	public void setS292_1Data(sheetQdfir292_1DAO s292_1Data) {
		this.s292_1Data = s292_1Data;
	}

	public Iterable<sheetQdfir292_1DAO> getQdfir292_1() {
		return Qdfir292_1;
	}

	public void setQdfir292_1(Iterable<sheetQdfir292_1DAO> qdfir292_1) {
		Qdfir292_1 = qdfir292_1;
	}

	public sheetQdfir292_2DAO getS292_2Data() {
		return s292_2Data;
	}

	public void setS292_2Data(sheetQdfir292_2DAO s292_2Data) {
		this.s292_2Data = s292_2Data;
	}

	public Iterable<sheetQdfir292_2DAO> getQdfir292_2() {
		return Qdfir292_2;
	}

	public void setQdfir292_2(Iterable<sheetQdfir292_2DAO> qdfir292_2) {
		Qdfir292_2 = qdfir292_2;
	}

	public sheetQdfir292_3DAO getS292_3Data() {
		return s292_3Data;
	}

	public void setS292_3Data(sheetQdfir292_3DAO s292_3Data) {
		this.s292_3Data = s292_3Data;
	}

	public Iterable<sheetQdfir292_3DAO> getQdfir292_3() {
		return Qdfir292_3;
	}

	public void setQdfir292_3(Iterable<sheetQdfir292_3DAO> qdfir292_3) {
		Qdfir292_3 = qdfir292_3;
	}

	public sheetQdfir363DAO getS363Data() {
		return s363Data;
	}

	public void setS363Data(sheetQdfir363DAO s363Data) {
		this.s363Data = s363Data;
	}

	public Iterable<sheetQdfir363DAO> getQdfir363() {
		return Qdfir363;
	}

	public void setQdfir363(Iterable<sheetQdfir363DAO> qdfir363) {
		Qdfir363 = qdfir363;
	}

	public sheetQdfir371_1DAO getS371_1Data() {
		return s371_1Data;
	}

	public void setS371_1Data(sheetQdfir371_1DAO s371_1Data) {
		this.s371_1Data = s371_1Data;
	}

	public Iterable<sheetQdfir371_1DAO> getQdfir371_1() {
		return Qdfir371_1;
	}

	public void setQdfir371_1(Iterable<sheetQdfir371_1DAO> qdfir371_1) {
		Qdfir371_1 = qdfir371_1;
	}

	public sheetQdfir371_2DAO getS371_2Data() {
		return s371_2Data;
	}

	public void setS371_2Data(sheetQdfir371_2DAO s371_2Data) {
		this.s371_2Data = s371_2Data;
	}

	public Iterable<sheetQdfir371_2DAO> getQdfir371_2() {
		return Qdfir371_2;
	}

	public void setQdfir371_2(Iterable<sheetQdfir371_2DAO> qdfir371_2) {
		Qdfir371_2 = qdfir371_2;
	}

	public sheetQdfir371_3DAO getS371_3Data() {
		return s371_3Data;
	}

	public void setS371_3Data(sheetQdfir371_3DAO s371_3Data) {
		this.s371_3Data = s371_3Data;
	}

	public Iterable<sheetQdfir371_3DAO> getQdfir371_3() {
		return Qdfir371_3;
	}

	public void setQdfir371_3(Iterable<sheetQdfir371_3DAO> qdfir371_3) {
		Qdfir371_3 = qdfir371_3;
	}

	public sheetQdfir453DAO getS453Data() {
		return s453Data;
	}

	public void setS453Data(sheetQdfir453DAO s453Data) {
		this.s453Data = s453Data;
	}

	public Iterable<sheetQdfir453DAO> getQdfir453() {
		return Qdfir453;
	}

	public void setQdfir453(Iterable<sheetQdfir453DAO> qdfir453) {
		Qdfir453 = qdfir453;
	}

	public sheetQdfir700DAO getS700Data() {
		return s700Data;
	}

	public void setS700Data(sheetQdfir700DAO s700Data) {
		this.s700Data = s700Data;
	}

	public Iterable<sheetQdfir700DAO> getQdfir700() {
		return Qdfir700;
	}

	public void setQdfir700(Iterable<sheetQdfir700DAO> qdfir700) {
		Qdfir700 = qdfir700;
	}

	public sheetQdfir702DAO getS702Data() {
		return s702Data;
	}

	public void setS702Data(sheetQdfir702DAO s702Data) {
		this.s702Data = s702Data;
	}

	public Iterable<sheetQdfir702DAO> getQdfir702() {
		return Qdfir702;
	}

	public void setQdfir702(Iterable<sheetQdfir702DAO> qdfir702) {
		Qdfir702 = qdfir702;
	}

	public sheetQdfir800DAO getS800Data() {
		return s800Data;
	}

	public void setS800Data(sheetQdfir800DAO s800Data) {
		this.s800Data = s800Data;
	}

	public Iterable<sheetQdfir800DAO> getQdfir800() {
		return Qdfir800;
	}

	public void setQdfir800(Iterable<sheetQdfir800DAO> qdfir800) {
		Qdfir800 = qdfir800;
	}

	public sheetQdfir900DAO getS900Data() {
		return s900Data;
	}

	public void setS900Data(sheetQdfir900DAO s900Data) {
		this.s900Data = s900Data;
	}

	public Iterable<sheetQdfir900DAO> getQdfir900() {
		return Qdfir900;
	}

	public void setQdfir900(Iterable<sheetQdfir900DAO> qdfir900) {
		Qdfir900 = qdfir900;
	}

	public sheetQdfir920DAO getS920Data() {
		return s920Data;
	}

	public void setS920Data(sheetQdfir920DAO s920Data) {
		this.s920Data = s920Data;
	}

	public Iterable<sheetQdfir920DAO> getQdfir920() {
		return Qdfir920;
	}

	public void setQdfir920(Iterable<sheetQdfir920DAO> qdfir920) {
		Qdfir920 = qdfir920;
	}

	public sheetQdfir921DAO getS921Data() {
		return s921Data;
	}

	public void setS921Data(sheetQdfir921DAO s921Data) {
		s921Data = s921Data;
	}

	public Iterable<sheetQdfir921DAO> getQdfir921() {
		return Qdfir921;
	}

	public void setQdfir921(Iterable<sheetQdfir921DAO> qdfir921) {
		Qdfir921 = qdfir921;
	}



	public sheetQdfir1300DAO getS1300Data() {
		return s1300Data;
	}

	public void setS1300Data(sheetQdfir1300DAO s1300Data) {
		this.s1300Data = s1300Data;
	}

	public Iterable<sheetQdfir1300DAO> getQdfir1300() {
		return Qdfir1300;
	}

	public void setQdfir1300(Iterable<sheetQdfir1300DAO> qdfir1300) {
		Qdfir1300 = qdfir1300;
	}

	public sheetQdfir1301DAO getS1301Data() {
		return s1301Data;
	}

	public void setS1301Data(sheetQdfir1301DAO s1301Data) {
		this.s1301Data = s1301Data;
	}

	public Iterable<sheetQdfir1301DAO> getQdfir1301() {
		return Qdfir1301;
	}

	public void setQdfir1301(Iterable<sheetQdfir1301DAO> qdfir1301) {
		Qdfir1301 = qdfir1301;
	}

	public sheetQdfir1400DAO getS1400Data() {
		return s1400Data;
	}

	public void setS1400Data(sheetQdfir1400DAO s1400Data) {
		this.s1400Data = s1400Data;
	}

	public Iterable<sheetQdfir1400DAO> getQdfir1400() {
		return Qdfir1400;
	}

	public void setQdfir1400(Iterable<sheetQdfir1400DAO> qdfir1400) {
		Qdfir1400 = qdfir1400;
	}

	public sheetQdfir1500DAO getS1500Data() {
		return s1500Data;
	}

	public void setS1500Data(sheetQdfir1500DAO s1500Data) {
		this.s1500Data = s1500Data;
	}

	public Iterable<sheetQdfir1500DAO> getQdfir1500() {
		return Qdfir1500;
	}

	public void setQdfir1500(Iterable<sheetQdfir1500DAO> qdfir1500) {
		Qdfir1500 = qdfir1500;
	}

	public sheetQdfir1600DAO getS1600Data() {
		return s1600Data;
	}

	public void setS1600Data(sheetQdfir1600DAO s1600Data) {
		this.s1600Data = s1600Data;
	}

	public Iterable<sheetQdfir1600DAO> getQdfir1600() {
		return Qdfir1600;
	}

	public void setQdfir1600(Iterable<sheetQdfir1600DAO> qdfir1600) {
		Qdfir1600 = qdfir1600;
	}

	public sheetQdfir1650DAO getS1650Data() {
		return s1650Data;
	}

	public void setS1650Data(sheetQdfir1650DAO s1650Data) {
		this.s1650Data = s1650Data;
	}

	public Iterable<sheetQdfir1650DAO> getQdfir1650() {
		return Qdfir1650;
	}

	public void setQdfir1650(Iterable<sheetQdfir1650DAO> qdfir1650) {
		Qdfir1650 = qdfir1650;
	}

	public sheetQdfir1700DAO getS1700Data() {
		return s1700Data;
	}

	public void setS1700Data(sheetQdfir1700DAO s1700Data) {
		this.s1700Data = s1700Data;
	}

	public Iterable<sheetQdfir1700DAO> getQdfir1700() {
		return Qdfir1700;
	}

	public void setQdfir1700(Iterable<sheetQdfir1700DAO> qdfir1700) {
		Qdfir1700 = qdfir1700;
	}

	public sheetQdfir223DAO getS223Data() {
		return s223Data;
	}

	public void setS223Data(sheetQdfir223DAO s223Data) {
		this.s223Data = s223Data;
	}

	public Iterable<sheetQdfir223DAO> getQdfir223() {
		return Qdfir223;
	}

	public void setQdfir223(Iterable<sheetQdfir223DAO> qdfir223) {
		Qdfir223 = qdfir223;
	}

	public sheetQdfir333DAO getS333Data() {
		return s333Data;
	}

	public void setS333Data(sheetQdfir333DAO s333Data) {
		this.s333Data = s333Data;
	}

	public Iterable<sheetQdfir333DAO> getQdfir333() {
		return Qdfir333;
	}

	public void setQdfir333(Iterable<sheetQdfir333DAO> qdfir333) {
		Qdfir333 = qdfir333;
	}

	public sheetQdfir455DAO getS455Data() {
		return s455Data;
	}

	public void setS455Data(sheetQdfir455DAO s455Data) {
		this.s455Data = s455Data;
	}

	public Iterable<sheetQdfir455DAO> getQdfir455() {
		return Qdfir455;
	}

	public void setQdfir455(Iterable<sheetQdfir455DAO> qdfir455) {
		Qdfir455 = qdfir455;
	}

	public sheetQstdr1DAO getS001Data() {
		return s001Data;
	}

	public void setS001Data(sheetQstdr1DAO s001Data) {
		this.s001Data = s001Data;
	}

	public Iterable<sheetQstdr1DAO> getQstdr001() {
		return Qstdr001;
	}

	public void setQstdr001(Iterable<sheetQstdr1DAO> qstdr001) {
		Qstdr001 = qstdr001;
	}

	public sheetQstdr2DAO getS002Data() {
		return s002Data;
	}

	public void setS002Data(sheetQstdr2DAO s002Data) {
		this.s002Data = s002Data;
	}

	public Iterable<sheetQstdr2DAO> getQstdr002() {
		return Qstdr002;
	}

	public void setQstdr002(Iterable<sheetQstdr2DAO> qstdr002) {
		Qstdr002 = qstdr002;
	}

	public sheetQdfir1000DAO getS1000Data() {
		return s1000Data;
	}

	public void setS1000Data(sheetQdfir1000DAO s1000Data) {
		this.s1000Data = s1000Data;
	}

	public Iterable<sheetQdfir1000DAO> getQdfir1000() {
		return Qdfir1000;
	}

	public void setQdfir1000(Iterable<sheetQdfir1000DAO> qdfir1000) {
		Qdfir1000 = qdfir1000;
	}

	public ArrayList<ReportDAO> getReportData() {
		return ReportData;
	}

	public void setReportData(ArrayList<ReportDAO> reportData) {
		ReportData = reportData;
	}

	public ArrayList<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}





}
