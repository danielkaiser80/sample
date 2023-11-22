package com.efass.specials;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import com.efass.payload.folderData;

public class SpecialFunction {

	private final String HOME_DIR = System.getProperty("user.home");
//	private final String UPLOAD_DIR = "./datafiles/archives/";
	private final String UPLOAD_DIR = HOME_DIR + "/" +"datafiles/archives/";

	public String createFolderDirectory(String fName,String rand) {
		// Check if folder exists/create a folder path with report_id
		String filename = null;
		//String rand = generateRandomString();
		String filePath = UPLOAD_DIR +fName+"~"+rand;
		File file = new File(filePath);
		if (!file.exists()) {
			if (file.mkdir()) {

				try {
					folderData fd = new folderData(); 
					fd.setFilepath(filename);
						filename = filePath ;
						
//						copyDirectory("./datafiles/cbn_MFB_rpt_12345m052087.xlsx",filePath);
						copyDirectory(HOME_DIR + "/datafiles/cbn_MFB_rpt_12345m052087.xlsx",filePath);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				filename= null;
			}

		}
		return filename;

	}

	public String checkCreateFolder(String filePath) {
		
		String path = filePath+"/output";
		File file = new File(path);
		if (!file.exists()) {
			if (file.mkdir()) {

				return path;
			} else {
				return null;
			}
		
	}else {
		return path;	
	}

		
	}
	
	
	
	
	
	
	

	
	
	
	
	
	public String generateRandomString() {
		
		// create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 5;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    
	    return randomString;


	  }
	
	
	

	public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation) throws IOException {
	    File sourceDirectory = new File(sourceDirectoryLocation);
	    File destinationDirectory = new File(destinationDirectoryLocation);
	    FileUtils.copyFileToDirectory(sourceDirectory, destinationDirectory);
	    
	}
	
	
	
	
//	Create file
//	try {
//		copyDirectory("./datafiles/cbn_MFB_rpt_12345m052087.xlsx",filepath);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	
}
