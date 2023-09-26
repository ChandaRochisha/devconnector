package com.dnb.devconnector.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devconnector.dto.Education;
import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.IdNotFoundException;
import com.dnb.devconnector.exceptions.UserNotFoundException;
import com.dnb.devconnector.mapper.RequestToEntityMapper;
import com.dnb.devconnector.payload.request.UserRequest;
import com.dnb.devconnector.service.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RequestToEntityMapper mapper;	
	

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody  UserRequest user ) { //method
	User user1=mapper.getUserEntityObject(user);
		User user2= userService.createUser(user1);
		
		return new ResponseEntity(user2,HttpStatus.CREATED);
		
	}
	
	
	
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserById
	(@PathVariable("userId")String userId)throws  IdNotFoundException, UserNotFoundException{
		boolean b = userService.checkExistenceBy(userId);
		if(b)
		{
			userService.deleteUser(userId);
			return ResponseEntity.noContent().build();
		}else
		{
			throw new UserNotFoundException("provide correct account id to delete it");
		}
		
	}
	
	
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getEducationById
	(@PathVariable("userId") String userId)throws IdNotFoundException{
		Optional<User> optional = userService.getUserById(userId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("education is provided is not present");
		}
	}
	

}
