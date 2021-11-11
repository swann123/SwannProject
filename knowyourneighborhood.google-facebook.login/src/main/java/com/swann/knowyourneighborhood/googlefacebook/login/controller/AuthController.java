package com.swann.knowyourneighborhood.googlefacebook.login.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.swann.knowyourneighborhood.googlefacebook.login.dao.AuthProvider;
import com.swann.knowyourneighborhood.googlefacebook.login.dao.Users;
import com.swann.knowyourneighborhood.googlefacebook.login.exception.BadRequestException;
import com.swann.knowyourneighborhood.googlefacebook.login.jwtsecurity.TokenProvider;
import com.swann.knowyourneighborhood.googlefacebook.login.payload.Login;
import com.swann.knowyourneighborhood.googlefacebook.login.payload.LoginResponse;
import com.swann.knowyourneighborhood.googlefacebook.login.payload.Register;
import com.swann.knowyourneighborhood.googlefacebook.login.payload.RegisterResponse;
import com.swann.knowyourneighborhood.googlefacebook.login.repository.UsersRepository;

@RestController
@RequestMapping("/knowyourneighborhood")
public class AuthController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//Register User for Local 
	@PostMapping(value = "/register")
	public ResponseEntity<?> registerUser(@RequestBody Register register){
		
		//Checking duplicate email
		if(usersRepository.existsByEmail(register.getEmail())) {
			throw new BadRequestException("Email has already registered before so kindly try anthoner email");
		}
		
		//Create new register user
		Users users = new Users();
		users.setUserName(register.getUserName());
		users.setEmail(register.getEmail());
		users.setPassword(register.getPassword());
		users.setProvider(AuthProvider.local);
		
		//Encode Password
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		
		//Save new user in the database
		Users newUser = usersRepository.save(users);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentContextPath().path("/user/me")
						.buildAndExpand(newUser.getUserId()).toUri();
		
		//Return to RegisterResponse Payload
		return ResponseEntity.created(location)
				.body(new RegisterResponse(true, "User has successfully registered!!!"));
		
	}
		
		//Local Login
		@PostMapping("/login")
		public ResponseEntity<?> loginUser(@RequestBody Login login){
			
			//Checking Authentication 
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
										login.getEmail(),
										login.getPassword()
							)
					);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			 //If authorized user, create token
			String token = tokenProvider.createToken(authentication);
			
			//Return to LoginResponse Payload
			return ResponseEntity.ok(new LoginResponse(token));
			
		}
}
