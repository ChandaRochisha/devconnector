package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.exceptions.UserNotFoundException;
import com.dnb.devconnector.repo.EducationRepository;
import com.dnb.devconnector.repo.ProfileRepository;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;
	
	
	
	
	
	@Override
	public Education createEducation(Education education) {
		// TODO Auto-generated method stub
		return educationRepository.save(education);
	}

	
	
	
	@Override
	public Optional<Education> getEducationById(String educationId) {
		// TODO Auto-generated method stub
		return educationRepository.findById(educationId);
	}

	
	
	
	
	@Override
	public List<Education> getAllEducations() {
		// TODO Auto-generated method stub
		return (List<Education>) educationRepository.findAll();
	}

	
	
	
	
	@Override
	public boolean deleteEducation(String educationId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(educationRepository.existsById(educationId)==true)
		{
			educationRepository.deleteById(educationId);
			return true;
			
		}
		else {
			throw new IdNotFoundException(" Education not found");
			
		}
	}

	@Override
	public boolean checkExistenceBy(String educationId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(educationRepository.existsById(educationId))
		{
			return true;
			
		}
		else {
		
			return false;
		}
		
	}



}
