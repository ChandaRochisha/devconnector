package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.exceptions.UserNotFoundException;
import com.dnb.devconnector.repo.ProfileRepository;
import com.dnb.devconnector.repo.UserRepository;


@Service
public class ProfileServiceImpl implements ProfileService {

	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public Profile createProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profileRepository.save(profile);
	}
	@Override
	public Optional<Profile> getProfilesByProfileId(String profileId) {
		// TODO Auto-generated method stub
		return profileRepository.findById(profileId);
	}

	@Override
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return (List<Profile>) profileRepository.findAll();
	}

	@Override
	public boolean deleteProfile(String profileId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(profileRepository.existsById(profileId)==true)
		{
			profileRepository.deleteById(profileId);
			return true;
			
		}
		else {
			throw new IdNotFoundException(" id not found");
			
		}
	}

}
