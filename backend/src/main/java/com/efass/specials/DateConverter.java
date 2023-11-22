package com.efass.specials;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class DateConverter {
	
	
  
    
    //For Procedure
    public Date changeDateToGregorian(String strDate) {
    	  Date newDate=null;
    	  
        try {            
            Date date = new SimpleDateFormat("d-MMM-yy").parse(strDate);

            newDate = date;
        } catch (ParseException e) {
            System.out.println("ParseException occured: " + e.getMessage());
        }
		return newDate;  
        
    	}
    
    public String changeDateToGregorian2(String dateStr, String format) throws ParseException{

    	String newDate=null;
    	
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	try {
    	Date date = sdf.parse(dateStr);
    	sdf = new SimpleDateFormat("dd/mm/yyyy");
    	newDate = sdf.format(date);
    	System.out.println(sdf.format(date));


    	} catch (ParseException e) {


    	try {
    	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/mm/yyyy");
    	Date date = sdf2.parse(dateStr);
    	sdf2 = new SimpleDateFormat("dd/mm/yyyy");
    	newDate = sdf2.format(date);
    	System.out.println(sdf2.format(date));

    	}catch(ParseException ex) {

    	try {
    	//SimpleDateFormat sdf3 = new SimpleDateFormat("dd-mm-yyyy");
    	SimpleDateFormat sdf3 = new SimpleDateFormat("dd/mm/yyyy");
    	Date date = sdf3.parse(dateStr);
    	sdf3 = new SimpleDateFormat("dd/mm/yyyy");
    	newDate = sdf3.format(date);
    	System.out.println(sdf3.format(date));

    	}
    	catch(ParseException ex3) {

    	//SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-mm-dd");
    	SimpleDateFormat sdf3 = new SimpleDateFormat("dd/mm/yyyy");
    	Date date = sdf3.parse(dateStr);
    	sdf3 = new SimpleDateFormat("dd/mm/yyyy");
    	newDate = sdf3.format(date);
    	System.out.println(sdf3.format(date));

    	}

    	}

    	// e.printStackTrace();
    	}
    	return newDate;
    	}

    public  static String changeDateToFrontGregorian(String dateStr, String format) throws ParseException{
     
   	 String newDate=null;
   	 SimpleDateFormat sdf = new SimpleDateFormat(format);
   	 try {
   	  Date date = sdf.parse(dateStr);
   	  sdf = new SimpleDateFormat("dd/mm/yyyy");
   	  newDate = sdf.format(date);
   	  System.out.println(sdf.format(date));
   	  
   	  
   	 } catch (ParseException e) {
   		 
   		
   	 }
		return newDate;
   }
    
    
    
    public static boolean isValidFormat(String format, String value, Locale locale) {
        LocalDateTime ldt = null;
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

        try {
            ldt = LocalDateTime.parse(value, fomatter);
            String result = ldt.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, fomatter);
                String result = ld.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, fomatter);
                    String result = lt.format(fomatter);
                    return result.equals(value);
                } catch (DateTimeParseException e2) {
                    // Debugging purposes
                    //e2.printStackTrace();
                }
            }
        }

        return false;
    }
    
    public String changeDateTime(String dateStr){
        
   	 String newDate=null;
   	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
   	 try {
   	  Date date = sdf.parse(dateStr);
   	  sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss a");
   	  newDate = sdf.format(date);
   	  System.out.println(sdf.format(date));
   	  
   	  
   	 } catch (ParseException e) {
   	  e.printStackTrace();
   	 }
		return newDate;
   }
    
}
