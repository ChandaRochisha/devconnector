package com.dnb.devconnector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.exceptions.UserNotFoundException;
import com.dnb.devconnector.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	
	
	
	
	@Override
	public Optional<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}
	
	
	

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}
	
	
	
	

	@Override
	public boolean deleteUser(String userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if(userRepository.existsById(userId)==true)
		{
			userRepository.deleteById(userId);
			return true;
			
		}
		else {
			throw new UserNotFoundException(" User not found");
			
		}
	}

	
	
	
	
	@Override
	public boolean checkExistenceBy(String userId) {
		// TODO Auto-generated method stub
		if(userRepository.existsById(userId))
		{
			return true;
			
		}
		else {
				
		return false;
		}
	}


}
