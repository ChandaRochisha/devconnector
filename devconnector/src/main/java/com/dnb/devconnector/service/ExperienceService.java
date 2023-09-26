package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Experience;

import com.dnb.devconnector.exceptions.IdNotFoundException;

@Service
public interface ExperienceService {
	public   Experience createExperience(Experience experience) ;
	// TODO Auto-generated method stub

public Optional<Experience> getExperienceById(String experienceId);
public List<Experience> getAllExperiences();

public boolean deleteExperience(String experienceId) throws IdNotFoundException ;


public boolean checkExistenceBy(String experienceId);


}
