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
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.mapper.RequestToEntityMapper;
import com.dnb.devconnector.payload.request.ProfileRequest;
import com.dnb.devconnector.service.EducationService;
import com.dnb.devconnector.service.ProfileService;


import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/profile")

public class ProfileController {
	@Autowired
	ProfileService profileService;
	
	@Autowired
	RequestToEntityMapper mapper;
	
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createProfile1(@Valid @RequestBody  ProfileRequest profile) throws IdNotFoundException
	{ //method
	  Profile profile1 = mapper.getProfileEntityObject(profile);
			  Profile profile2= profileService.createProfile(profile1);
			return new ResponseEntity(profile2,HttpStatus.CREATED);
		
	}
//	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountRequest account ) { 
//		Account account1= mapper.getAccountEntityObject(account);//method
//	   try {
//		Account account2= accountService.createAccount(account1);
//		return new ResponseEntity(account2,HttpStatus.CREATED);
//		
//	} catch (IdNotFoundException e) {
//		// TODO Auto-generated catch block
//	  return ResponseEntity.badRequest().body(e.getMessage());
//	}
//	}
	
	
	
	@DeleteMapping("/{profileId}")

	public ResponseEntity<?> deleteProfileById
	(@PathVariable("profileId")String profileId)throws  IdNotFoundException{
		boolean b = profileService.checkExistenceBy(profileId);
		if(b)
		{
			profileService.deleteProfile(profileId);
			return ResponseEntity.noContent().build();
		}else
		{
			throw new IdNotFoundException("provide correct profile id to delete it");
		}
		
	}
	
	
	@GetMapping("/{profileId}")//It should help us to get the specific education details	
	public ResponseEntity<?> getProfileById
	(@PathVariable("profileId") String profileId)throws IdNotFoundException{
		Optional<Profile> optional = profileService.getProfileById(profileId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("Profile is provided is not present");
		}
	}
	   
    
}
