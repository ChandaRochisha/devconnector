package com.dnb.devconnector.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.mapper.RequestToEntityMapper;
import com.dnb.devconnector.payload.request.EducationRequest;
import com.dnb.devconnector.service.EducationService;


import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/education")
public class EducationController {
	
	@Autowired
	EducationService educationService;
	
	@Autowired
	RequestToEntityMapper mapper;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createEducation(@Valid @RequestBody EducationRequest education ) { //method
	Education education1= mapper.getEducationEntityObject(education);
		Education education2= educationService.createEducation(education1);
		return new ResponseEntity(education2,HttpStatus.CREATED);
		
	}
	
	
	
	
	@DeleteMapping("/{accountId}")

	public ResponseEntity<?> deleteEducationById
	(@PathVariable("educationId")String educationId)throws  IdNotFoundException{
		boolean b = educationService.checkExistenceBy(educationId);
		if(b)
		{
			educationService.deleteEducation(educationId);
			return ResponseEntity.noContent().build();
		}else
		{
			throw new IdNotFoundException("provide correct account id to delete it");
		}
		
	}
	
	
	@GetMapping("/{educationId}")//It should help us to get the specific education details	
	public ResponseEntity<?> getEducationById
	(@PathVariable("educationId") String educationId)throws IdNotFoundException{
		Optional<Education> optional = educationService.getEducationById(educationId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("education is provided is not present");
		}
	}
			
	
//	@PostMapping("/create")
//	public ResponseEntity<?> createAccount(@Valid @RequestBody EducationRequest education ) { 
//		Education education1= mapper.getAccountEntityObject(education);//method
//	   try {
//		   Education education2= educationService.createEducation(education1);
//		return new ResponseEntity(education2,HttpStatus.CREATED);
//		
//	} catch (IdNotFoundException e) {
//		// TODO Auto-generated catch block
//	  return ResponseEntity.badRequest().body(e.getMessage());
//	}
//	}
	
	
	
	
}
