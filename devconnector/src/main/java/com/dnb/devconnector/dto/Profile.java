package com.dnb.devconnector.dto;

import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.exceptions.InvalidCompanyNameException;
import com.dnb.devconnector.exceptions.InvalidProStatusException;
import com.dnb.devconnector.exceptions.InvalidUserNameException;
import com.dnb.devconnector.utils.CustomUserIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Profile {
  
	
	@Id
	//@NotBlank(message= "user id should not be blank")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	
	@GenericGenerator(name = "user_seq",strategy = "com.dnb.devconnector.utils.CustomProfileIdGenerator",
			parameters = {
					@Parameter(name = CustomUserIdGenerator.INCREMENT_PARAM, value="50"),
					@Parameter(name= CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value="A_"),
					@Parameter(name=CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")
					
					}
					)
	private String profileId;

  private String professionalStatus;
  
  private String company;
	
  private String website;
 
  private	String location;
  private	String skills;
  private String gitHubUserName;
  private String bio;
  private String twitter;
  private String facebook;
  private 	String youTube;
  private String linkedIn;
  private String instagram;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
//	public void setCompany(String company) throws InvalidCompanyNameException {
//		
//		  String regEx= "^.{2,}$";
//		
//			if(Pattern.compile(regEx).matcher(company).matches()){
//				this.company=company;}
//			else
//					{throw new InvalidCompanyNameException("Company name is not correct");	
//		   
//		}
//	}
//	
//	public void setProfessionalStatus(String professionalStatus) throws InvalidProStatusException  {
//		
//		  String regEx= "^.{2,}$";
//		
//			if(Pattern.compile(regEx).matcher(company).matches()){
//				this.professionalStatus=professionalStatus;}
//			else
//					{throw new InvalidProStatusException("pro status is not correct");	
//		   
//		}
//	}

	
	
	

