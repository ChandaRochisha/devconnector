package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.repo.EducationRepository;
import com.dnb.devconnector.repo.ExperienceRepository;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepository experienceRepository;

	
	
	
	
	@Override
	public Experience createExperience(Experience experience) {
		// TODO Auto-generated method stub
		return experienceRepository.save(experience);
	}

	
	
	

	
	
	
	
	@Override
	public List<Experience> getAllExperiences() {
		// TODO Auto-generated method stub
		return  (List<Experience>) experienceRepository.findAll();
	}

	
	
	
	
	
	@Override
	public boolean deleteExperience(String experienceId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(experienceRepository.existsById(experienceId)==true)
		{
			experienceRepository.deleteById(experienceId);
			return true;
			
		}
		else {
			throw new IdNotFoundException(" experience not found");
			
		}
	}


	
	
	
	@Override
	public boolean checkExistenceBy(String experienceId) {
		// TODO Auto-generated method stub
		if(experienceRepository.existsById(experienceId))
		{
			return true;
			
		}
		else {		
		return false;
		}
	}









	@Override
	public Optional<Experience> getExperienceById(String experienceId) {
		// TODO Auto-generated method stub
		return experienceRepository.findById(experienceId);
	}

}
