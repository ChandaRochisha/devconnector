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
import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.mapper.RequestToEntityMapper;
import com.dnb.devconnector.payload.request.ExperienceRequest;
import com.dnb.devconnector.service.ExperienceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
	
	@Autowired
	ExperienceService experienceService;
		
	@Autowired
	RequestToEntityMapper mapper;
		
		
		@PostMapping("/create")
		public ResponseEntity<?> createExperience(@Valid @RequestBody ExperienceRequest experience ) { //method
		Experience experience1=mapper.getExperienceEntityObject(experience);
			Experience experience2= experienceService.createExperience(experience1);
			return new ResponseEntity(experience2,HttpStatus.CREATED);
			
		}
		
		
		
		
		@DeleteMapping("/{experinceId}")

		public ResponseEntity<?> deleteExperienceById
		(@PathVariable("experinceId")String experinceId)throws  IdNotFoundException{
			boolean b = experienceService.checkExistenceBy(experinceId);
			if(b)
			{
				experienceService.deleteExperience(experinceId);
				return ResponseEntity.noContent().build();
			}else
			{
				throw new IdNotFoundException("provide correct experinceId to delete it");
			}
			
		}
	
		
		
		@GetMapping("/{experienceId}")//It should help us to get the specific education details	
		public ResponseEntity<?> getExperienceById
		(@PathVariable("experienceId") String experienceId)throws IdNotFoundException{
			Optional<Experience> optional = experienceService.getExperienceById(experienceId);
			if(optional.isPresent()) {
				return ResponseEntity.ok(optional.get());
			}
			else {
				throw new IdNotFoundException("experience provided is not present");
			}
		}
				
}
