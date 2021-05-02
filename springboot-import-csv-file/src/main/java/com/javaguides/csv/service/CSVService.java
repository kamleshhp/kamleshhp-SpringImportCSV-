package com.javaguides.csv.service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaguides.csv.entities.GOTENITY;
import com.javaguides.csv.helper.CSVHelper;
import com.javaguides.csv.repository.GotRepository;

@Service
public class CSVService {
  @Autowired
  GotRepository repository;
   
  public void save(MultipartFile file) {
    try {
      List<GOTENITY> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      
      System.out.println("service"+tutorials);
      
      
      
      repository.saveAll(tutorials);
      
    } catch (Exception e) {
    	
     
    	System.out.println("Ex in services");
    	
    	//System.out.println(e.getMessage());
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

	/*
	 * public ByteArrayInputStream load() { List<GOTENITY> tutorials =
	 * repository.findAll();
	 * 
	 * ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials); return in; }
	 */

  public List<GOTENITY> getAllTutorials() {
    return repository.findAll();
  }
  
  public List<Object []> getDetailsLoc(){
	  return repository.getDetails();
  }
  
  public long getCount() {
	  return repository.count();
  }
  
  public List<GOTENITY> getBattles(long a){
	  System.out.println(repository.getBattleByNumber(a));
	  return repository.getBattleByNumber(a);
  }
}