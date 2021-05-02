package com.javaguides.csv.helper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.javaguides.csv.entities.GOTENITY;


public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "name", "year", "battle_number", "attacker_king","defender_king","attacker_outcome","battle_type"
		  ,"major_death","major_capture","attacker_size","defender_size","attacker_commander","defender_commander","summer","location","region","note"};
  
  /*
   * 
   * name, year, battle_number, attacker_king, defender_king, 
attacker_outcome, battle_type, major_death, major_capture, attacker_size, 
defender_size, attacker_commander, defender_commander, summer, location, 
region, note
   */

  public static boolean hasCSVFormat(MultipartFile file) {
    if (TYPE.equals(file.getContentType())
    		|| file.getContentType().equals("application/vnd.ms-excel")) {
      return true;
    }

    return false;
  }

  public static List<GOTENITY> csvToTutorials(InputStream is) {
	  
	  int c=0;
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
    	
    	//System.out.println("pp "+csvParser);

      List<GOTENITY> list = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
      
      
      GOTENITY got;

      for (CSVRecord csvRecord : csvRecords) {
    	  
    	  c=c+1;
    	  
    	  long a3 = 0,a8 = 0,a9=0,a10=0,a11=0,a14=0;
    	  
    	  
    	  String a1=csvRecord.get("name");
		  String a2=csvRecord.get("year");
		  
		  if(csvRecord.get("battle_number").trim().equals("")) {
			  
		  }
		  else {
		   a3=Long.parseLong(csvRecord.get("battle_number"));
		  }
		  String a4=csvRecord.get("attacker_king");
		  String a5=csvRecord.get("defender_king");
		  String a6=csvRecord.get("attacker_outcome");
		 String a7= csvRecord.get("battle_type"); 
		 
		 if(csvRecord.get("major_death").trim().equals("")) {
			 
		 }
		 else {
		  a8= Long.parseLong(csvRecord.get("major_death"));
		 }
		 
		 if(csvRecord.get("major_capture").trim().equals("")) {
			 
		 }
		 else {
		  a9= Long.parseLong(csvRecord.get("major_capture"));
		 
		 }
		 
		 
		 if(csvRecord.get("attacker_size").trim().equals("")) {
			 
			 
		 }
		 else {
		  a10= Long.parseLong(csvRecord.get("attacker_size"));
		 }
		 
		 if(csvRecord.get("defender_size").trim().equals("")) {
			 
		 }
		 else {
		  a11= Long.parseLong(csvRecord.get("defender_size")); 
		 }
		 String a12= csvRecord.get("attacker_commander"); 
		 String a13= csvRecord.get("defender_commander");
		 
		 if(csvRecord.get("summer").trim().equals("")) {
			 
		 }
		 else { 
		  a14=Long.parseLong(csvRecord.get("summer"));
		 }
		 String a15= csvRecord.get("location");
		 String a16= csvRecord.get("region"); 
		 String a17= csvRecord.get("note");
		 
		 
		got=new GOTENITY(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17);
		 
    	
    	  list.add(got);
    	  //System.out.println("Hi"+list);
    	  
    	
      }
      
      //System.out.println(c);
     
      //System.out.println("Hello"+list);
      return list;
    } catch (Exception e) {
    	//System.out.println("Excepton in helper");
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

	/*
	 * public static ByteArrayInputStream tutorialsToCSV(List<DeveloperTutorial>
	 * developerTutorialList) { final CSVFormat format =
	 * CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
	 * 
	 * try (ByteArrayOutputStream out = new ByteArrayOutputStream(); CSVPrinter
	 * csvPrinter = new CSVPrinter(new PrintWriter(out), format);) { for
	 * (DeveloperTutorial developerTutorial : developerTutorialList) { List<String>
	 * data = Arrays.asList( String.valueOf(developerTutorial.getId()),
	 * developerTutorial.getTitle(), developerTutorial.getDescription(),
	 * String.valueOf(developerTutorial.isPublished()) );
	 * 
	 * csvPrinter.printRecord(data); }
	 * 
	 * csvPrinter.flush(); return new ByteArrayInputStream(out.toByteArray()); }
	 * catch (IOException e) { throw new
	 * RuntimeException("fail to import data to CSV file: " + e.getMessage()); } }
	 */
}
