package com.surabhichainrestaurant.foodorder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//
import com.surabhichainrestaurant.foodorder.entity.User;
import com.surabhichainrestaurant.foodorder.entity.UserLoginRequest;
//import com.surabhichainrestaurant.foodorder.entity.UserLoginRequest;
//import com.surabhichainrestaurant.foodorder.jwttokenutil.JwtTokenUtil;
//import com.surabhichainrestaurant.foodorder.repo.UserRepo;
import com.surabhichainrestaurant.foodorder.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<User>addUser(@RequestBody User user){
		User responseUser=service.addUser(user);
		return ResponseEntity.ok(responseUser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User>validate(@RequestBody UserLoginRequest request){
		User res=service.findUser(request);
		return ResponseEntity.ok(res);
	}
	
}
	

//    @Autowired
//    private UserRepo userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//    
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public String login(@RequestBody UserLoginRequest loginRequest) {
//        User user = userRepository.findByEmail(loginRequest.getEmail());
//
//        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            // Authentication successful, generate JWT token
//            String token = jwtTokenUtil.generateToken(loginRequest.getEmail());
//            return token;
//        } else {
//            // Authentication failed
//            return "Invalid email or password.";
//        }
//    }
//    
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody User user) {
//        // Perform validation on the user data if necessary
//        userService.registerUser(user);
//        return ResponseEntity.ok("User registered successfully!");
//    }
	


