package com.surabhichainrestaurant.foodorder.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//
import com.surabhichainrestaurant.foodorder.entity.User;
import com.surabhichainrestaurant.foodorder.entity.UserLoginRequest;
import com.surabhichainrestaurant.foodorder.repo.UserRepo;

@Service
public class UserService {

	// @Autowired
	// private UserRepo userRepository;
	//
	// @Autowired
	// private BCryptPasswordEncoder passwordEncoder;
	//
	// public void registerUser(User user) {
	// // Encode the user's password before saving it to the database
	// user.setPassword(passwordEncoder.encode(user.getPassword()));
	// userRepository.save(user);
	// }

	@Autowired
	UserRepo repo;

	public User addUser(User user) {
		return repo.save(user);

	}
	public User findUser(UserLoginRequest request) {
		
		User userValid=repo.findByEmailAndPassword(request.getEmail(),request.getPassword());
		if(userValid==null)
		{
			return null;
		}
		else
		{
			return userValid;
		}

		
	}

}
