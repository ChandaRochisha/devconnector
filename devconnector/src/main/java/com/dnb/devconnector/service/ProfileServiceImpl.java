package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.repo.ProfileRepository;
import com.dnb.devconnector.repo.UserRepository;


@Service
public class ProfileServiceImpl implements ProfileService {

	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Profile createProfile(Profile profile) throws IdNotFoundException {
	
		Optional<User> user= userRepository.findById(profile.getUser().getUserId());
				
				if(user.isPresent()) {

					profile.setUser(user.get());

					return profileRepository.save(profile);

				}

				else

					user.orElseThrow(()->new IdNotFoundException("profile id not found"));

				return null;
		
	}
	
	
	
	
	
	@Override
	public Optional<Profile> getProfileById(String profileId) {
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
	
	
	
	
	
	
	
	@Override
	public boolean checkExistenceBy(String profileId) {
		// TODO Auto-generated method stub
		if(profileRepository.existsById(profileId))
		{
			return true;
			
		}
		else {
			
		return false;
		}
	}

}
