package com.efass.sheet.table;

import java.util.List;

public class TableResponse {

public String responseMessage;
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

public int responseCode;
	
	List<TabSheet>  Data;

	public List<TabSheet> getData() {
		return Data;
	}

	public void setData(List<TabSheet> data) {
		Data = data;
	}
	





	
	
	
}
