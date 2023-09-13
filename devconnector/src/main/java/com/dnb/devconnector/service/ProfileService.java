package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.exceptions.UserNotFoundException;
@Service
public interface ProfileService {
	public   Profile createProfile(Profile profile) ;
	// TODO Auto-generated method stub

public Optional<Profile> getProfilesByProfileId(String profileId);
public List<Profile> getAllProfiles();

public boolean deleteProfile(String profileId) throws IdNotFoundException ;

}
