package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Education;

import com.dnb.devconnector.exceptions.IdNotFoundException;


@Service
public interface EducationService {
	public   Education createEducation(Education education) ;
	// TODO Auto-generated method stub

public Optional<Education> getEducationById(String educationId);
public List<Education> getAllEducations();

public boolean deleteEducation(String educationId) throws IdNotFoundException ;

public boolean checkExistenceBy(String educationId) throws IdNotFoundException;




}
