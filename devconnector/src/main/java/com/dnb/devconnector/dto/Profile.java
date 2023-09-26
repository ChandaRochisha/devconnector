package com.dnb.devconnector.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import com.dnb.devconnector.utils.CustomUserIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Profile {
  
	
	@Id
	//@NotBlank(message= "user id should not be blank")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="profile_seq")
	
	@GenericGenerator(name = "profile_seq",strategy = "com.dnb.devconnector.utils.CustomProfileIdGenerator",
			parameters = {
					@Parameter(name = CustomUserIdGenerator.INCREMENT_PARAM, value="50"),
					@Parameter(name= CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value="Pro_"),
					@Parameter(name=CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")
					
					}
					)
	private String profileId;

  @Enumerated(EnumType.STRING)
  private String professionalStatus;
  
  private String company;
	
  private String website;
 
  private	String location;
  private	String skills;
  private String gitHubUserName;
  private String bio;
  private String socialNetworkLinks;
//  private String twitter;
//  private String facebook;
//  private 	String youTube;6y 
//  private String linkedIn;
//  private String instagram;
//  
  
  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinColumn(name = "user_id", referencedColumnName = "userId")
  private User user;



  
  
  
  @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="profile")
	private List<Education> educationList = new ArrayList<>();
  
  
  @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="profile")
  private List<Experience> experienceList= new ArrayList<>();
  

  
	
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

	
	
	

