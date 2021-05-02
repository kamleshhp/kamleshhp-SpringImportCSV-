package com.javaguides.csv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javaguides.csv.entities.GOTENITY;
import com.javaguides.csv.helper.CSVHelper;
import com.javaguides.csv.responsemessage.ResponseMessage;
import com.javaguides.csv.service.CSVService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/csv")
public class CSVController {

  @Autowired
  CSVService fileService;

  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (CSVHelper.hasCSVFormat(file)) {
    	
      try {
    	  
    	
    	
        fileService.save(file);
        
        System.out.println("Hello");
        
        

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/csv/download/")
                .path(file.getOriginalFilename())
                .toUriString();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
      }
    }

    message = "Please upload a csv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
  }

  @GetMapping("/tutorials")
  public ResponseEntity<List<GOTENITY>> getAllTutorials() {
    try {
      List<GOTENITY> tutorials = fileService.getAllTutorials();

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  
  @GetMapping("/Details")
  public ResponseEntity<List<Object []>> getDetails(){
	  try {
	  List<Object []> g= fileService.getDetailsLoc();
	  
	  if (g.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(g, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
  }
  
  @GetMapping("/count")
  
  public ResponseEntity<Long> getCounts(){
	  try {
		  
		  Long c=fileService.getCount();
		  if (c.equals(null)) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(c,HttpStatus.OK);
		  
		  
		  
	  }
	  catch(Exception e) {
		  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }

  
  @GetMapping("/battles/{a}")
  public ResponseEntity<List<GOTENITY>> getAllBattle(@PathVariable("a") long a) {
    try {
      List<GOTENITY> battle= fileService.getBattles(a);

      if (battle==null) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(battle, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
 
  

	/*
	 * @GetMapping("/download/{fileName:.+}") public ResponseEntity<Resource>
	 * downloadFile(@PathVariable String fileName) { InputStreamResource file = new
	 * InputStreamResource(fileService.load());
	 * 
	 * return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
	 * "attachment; filename=" + fileName)
	 * .contentType(MediaType.parseMediaType("application/csv")) .body(file); }
	 */
}