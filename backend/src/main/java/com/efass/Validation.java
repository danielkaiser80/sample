package com.efass;

import org.springframework.stereotype.Service;

@Service
public class Validation {

	
	public String checkDataType(String value) {
		
	Boolean date = isDate(value);
	Boolean alpha = isAlpha(value);
	Boolean num = isNum(value);
	Boolean alphaNum = isAlphaNumeric(value);
	String 	data=null;
	
if (alpha) {
		data= "Alpha";
	}else if(num) {
		
		data= "Num";
	}else if(date) {
		data= "Date";
	}
	else if(date) {
		data= "Date";
	}
	else if(alphaNum) {
		data = "alphaNum";
	}

	return data;
		
	}
	
	public boolean isAlphaNumeric(String Value){
		if (Value.matches("^[a-zA-Z0-9]+$")) {
			return true;
		}else {
			return false;
		}
	   
	}
	
	
	public Boolean isAlpha(String Value) {
		
		if (Value.matches(".*[a-zA-Z]+.*")) {
			
			return true;
		}else {
			return false;
		}	
	}
	
	public Boolean isDate(String Value) {
		
		if (Value.matches("^([1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/([12][0-9]{3})$")) {
			
			return true;
		}else {
			return false;
		}	
	}
	
	public Boolean isNum(String strNum) {
		
		if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	public int roundUP(double d){
		double dAbs = Math.abs(d);
		int i = (int) dAbs;
		double result = dAbs - (double) i;
		if(result==0.0){
		return (int) d;
		}else{
		return (int) d<0 ? -(i+1) : i+1;
		}
	}
}
