package com.dnb.devconnector.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfileRequest {
	
	@NotBlank(message="Enter professionalStatus")
	 private String professionalStatus;
	@NotBlank(message="Enter company")
	  private String company;
	@NotBlank(message="Enter website")	
	  private String website;
	 
	  private	String location;
	  private	String skills;
	  private String gitHubUserName;
	  private String bio;
	  public String SocialNetworkLinks;
//	  private String twitter;
//	  private String facebook;
//	  private 	String youTube;
//	  private String linkedIn;
//	  private String instagram;
	  
	  private String user_id;





}
