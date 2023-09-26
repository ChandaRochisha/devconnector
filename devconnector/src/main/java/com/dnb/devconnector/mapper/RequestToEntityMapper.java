package com.dnb.devconnector.mapper;

import org.springframework.stereotype.Component;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.payload.request.EducationRequest;
import com.dnb.devconnector.payload.request.ExperienceRequest;
import com.dnb.devconnector.payload.request.ProfileRequest;
import com.dnb.devconnector.payload.request.UserRequest;


@Component
public class RequestToEntityMapper {

	
	public User getUserEntityObject (UserRequest userRequest) {
		User user = new User();
		
		user.setUserName(userRequest.getUserName());
		user.setPassword(userRequest.getPassword());;
		user.setEmail(userRequest.getEmail());
		
//	    Profile profile1= new Profile();
//	    profile1.setProfileId(userRequest.getProfileId());
//		user.setProfile(profile1);

		return user;
		
	}
	
	public Profile getProfileEntityObject(ProfileRequest profileRequest) {
		
		
		Profile profile= new Profile();
		
		profile.setCompany(profileRequest.getCompany());

		profile.setLocation(profileRequest.getLocation());

		profile.setWebsite(profileRequest.getWebsite());

		profile.setGitHubUserName(profileRequest.getGitHubUserName());

		profile.setBio(profileRequest.getBio());

		profile.setSkills(profileRequest.getSkills());

		profile.setSocialNetworkLinks(profileRequest.getSocialNetworkLinks());

		
		User user1=new User();
		user1.setUserId(profileRequest.getUser_id());
		profile.setUser(user1);
		
		return profile;
		
	}
	
	
	public Experience getExperienceEntityObject(ExperienceRequest experienceRequest) {
		Experience experience = new Experience();
		experience.setCompany(experienceRequest.getCompany());
		experience.setDescription(experienceRequest.getDescription());
		experience.setFromDate(experienceRequest.getFromDate());
		experience.setToDate(experienceRequest.getToDate());
		experience.setJobTitle(experienceRequest.getJobTitle());
		experience.setLocation(experienceRequest.getLocation());
		
		  Profile profile1= new Profile();
		  profile1.setProfileId(experienceRequest.getProfileId());
		  experience.setProfile(profile1);
		
		return experience;
		
		
	}
	public Education getEducationEntityObject(EducationRequest educationRequest) {
		Education education = new Education();
		
		education.setDegree(educationRequest.getDegree());
		education.setDescription(educationRequest.getDescription());
		education.setFieldOfStudy(educationRequest.getFieldOfStudy());
		education.setFromDate(educationRequest.getFromDate());
		education.setSchool(educationRequest.getSchool());
		education.setToDate(educationRequest.getToDate());
		
		Profile profile2= new Profile();
	  profile2.setProfileId(educationRequest.getProfileId());
	  education.setProfile(profile2);

		
		return education;
	}
	
	
}
