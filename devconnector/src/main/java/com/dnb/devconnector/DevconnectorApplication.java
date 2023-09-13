package com.dnb.devconnector;
import java.util.Optional;

import java.util.Scanner;


 

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

 

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.InvalidEmailException;
import com.dnb.devconnector.exceptions.InvalidPasswordException;
import com.dnb.devconnector.exceptions.InvalidUserNameException;
import com.dnb.devconnector.service.UserService;



@SpringBootApplication

public class DevconnectorApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(DevconnectorApplication.class, args);
		
		UserService userService = applicationContext.getBean(UserService.class);
		
		User user= new User();
		user.setUserId("2330015");
		user.setUserName("Rochishaa");
		user.setEmail("rochisha2gmail.com");
		user.setPassword("rochi123");
		
		//user.setContactNumber("722782");
		userService.createUser(user);
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
