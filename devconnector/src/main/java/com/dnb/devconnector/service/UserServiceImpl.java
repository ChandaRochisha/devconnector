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
	public Optional<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findById(email);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public boolean deleteUser(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if(userRepository.existsById(email)==true)
		{
			userRepository.deleteById(email);
			return true;
			
		}
		else {
			throw new UserNotFoundException(" User not found");
			
		}
	}

}
