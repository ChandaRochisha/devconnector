package com.dnb.devconnector;
import java.time.LocalDate;
import java.util.Optional;

import java.util.Scanner;


 

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.data.convert.Jsr310Converters.StringToLocalDateTimeConverter;

import com.dnb.devconnector.dto.Experience;
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.InvalidEmailException;
import com.dnb.devconnector.exceptions.InvalidPasswordException;
import com.dnb.devconnector.exceptions.InvalidUserNameException;
import com.dnb.devconnector.service.ExperienceService;
import com.dnb.devconnector.service.ProfileService;
import com.dnb.devconnector.service.UserService;



@SpringBootApplication

public class DevconnectorApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(DevconnectorApplication.class, args);
		System.out.println("hello");

//		ExperienceService experienceService = applicationContext.getBean(ExperienceService.class);
		//ProfileService profileService = applicationContext.getBean(ProfileService.class);
		//UserService userService = applicationContext.getBean(UserService.class);
		
//		User user= new User();
//		user.setUserId("905");
//		user.setUserName("tanusree");
//		user.setEmail("aaa.com");
//		user.setPassword("123@@@");
		
		//user.setContactNumber("722782");
//		userService.createUser(user);
		
//		Profile profile = new Profile();
//		profile.setProfileId("1235");
//		profile.setProfessionalStatus("false");
//		profile.setCompany("dnb");
//		profile.setWebsite("www.website23.com");
//		profile.setLocation("Mumbai");
//		profile.setSkills("spring, java");
//		profile.setGitHubUserName("nameram");
//		profile.setBio("Book Reader");
//		profile.setTwitter("twitter.com");
//		profile.setFacebook("rochii.com");
//		profile.setYouTube("youtube.com");
//		profile.setLinkedIn("linkedin.com");
//		profile.setInstagram("ram.insta");
//		
//		profileService.createProfile(profile);
//	
//		Experience experience = new Experience();
//		
//		experience.setExperienceId("1234");
//		experience.setJobTitle("developer");
//		experience.setCompany("dnb");
//		experience.setLocation("hyd");
//		experience.setFromDate(LocalDate.of(23, 3, 4));		
//		experience.setToDate(LocalDate.of(24,4, 8));
//		experience.setDescription("i have 2 years experience");
//		
//		Experience exp= experienceService.createExperience(experience);
//		
//		System.out.println(exp);
//		
//		
				
		
		}
	}
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) 
//		{
//			System.out.println(" 1.Create User  2.Delete User By Username  3. Get user by username 4.Get all users  5.exit ");
//			System.out.println(" Enter your Choice: ");
//			
//			int c = sc.nextInt();
//			
//		
//			switch(c){
//			case 1 :
//            
//				try {
//					
//					System.out.println("Enter your UserName: ");
//	                String userName = sc.next();
//	                System.out.println("Enter your email: ");
//	                String email = sc.next();
//	                System.out.println("Enter your password ");
//	                String password = sc.next();
//	                user.setUserName(userName);
//	                user.setEmail(email);
//	                user.setPassword(password);
//	                System.out.println(user);
//	                user = userService.createUser(user);
//					System.out.println(user);
//	                
//		
//	                }catch(InvalidEmailException | InvalidPasswordException |InvalidUserNameException|NullPointerException e ) {  
//	                	e.printStackTrace();  }
//				    break;
//			case 2:
//				break;
//			default:
//				sc.close();
//				System.exit(c);
//			
//		}
//	}
