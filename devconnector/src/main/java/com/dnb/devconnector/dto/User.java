package com.dnb.devconnector.dto;
import java.time.LocalDate;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.exceptions.InvalidEmailException;
import com.dnb.devconnector.exceptions.InvalidPasswordException;
import com.dnb.devconnector.exceptions.InvalidUserNameException;
import com.dnb.devconnector.utils.CustomUserIdGenerator;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity


public class User {
	
	@Id
	//@NotBlank(message= "user id should not be blank")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	
	@GenericGenerator(name = "user_seq",strategy = "com.dnb.devconnector.utils.CustomUserIdGenerator",
			parameters = {
					@Parameter(name = CustomUserIdGenerator.INCREMENT_PARAM, value="50"),
					@Parameter(name= CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value="A_"),
					@Parameter(name=CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")
					
					}
					)
	private String userId;
	//@Column(nullable =false)
 //@NotBlank(message="username is needed")
  private String userName;
  
  private String email;
	//@NotBlank(message =" date should not be null")
  private String password;
 
}
  
//public User(String userName, String email, String password, String confirmPassword) {
//	super();
//	this.userName = userName;
//	this.email = email;
//	this.password = password;
//	this.confirmPassword = confirmPassword;
//}
//  
//public void setUserName(String userName) throws InvalidUserNameException {
//	
//	  String regEx= "^.{2,}$";
//	  //Pattern.compile(regEx).matcher(userName).matches()
//	
//		if(userName.length()>=2){
//			this.userName=userName;}
//		else
//				{throw new InvalidUserNameException("Usernam is not vaild");	
//	   
//	}
//}
//
//public void setPassword(String password) throws InvalidPasswordException {
//	
//	  String regEx= "^.{2,}$";
//	
//		if(Pattern.compile(regEx).matcher(password).matches()){
//			this.password=password;}
//		else
//				{throw new InvalidPasswordException("Enter strong Password");	
//	   
//	}
//}
//
//public void setEmail(String email) throws InvalidEmailException {
//	
//	  String regEx= "^.{2,}$";
//	
//		if(Pattern.compile(regEx).matcher(email).matches()){
//			this.email=email;}
//		else
//				{throw new InvalidEmailException("Invalid EmailId");	
//	   
//	}
//}
//




