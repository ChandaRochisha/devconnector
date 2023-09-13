package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.UserNotFoundException;

@Service
public interface UserService {
	public   User createUser(User user) ;
		// TODO Auto-generated method stub
	
    public Optional<User> getUserByEmail(String email);
    public List<User> getAllUsers();

	public boolean deleteUser(String email) throws UserNotFoundException;


}
