package com.swann.knowyourneighborhood.googlefacebook.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swann.knowyourneighborhood.googlefacebook.login.dao.Users;
import com.swann.knowyourneighborhood.googlefacebook.login.exception.ResourceNotFoundException;
import com.swann.knowyourneighborhood.googlefacebook.login.repository.UsersRepository;
import com.swann.knowyourneighborhood.googlefacebook.login.service.UsersPrincipal;

@RestController
@RequestMapping(value ="/knowyourneighborhood")
public class UsersController {
	
	@Autowired
	private UsersRepository userRepository;
	
	//Profile API <<Get Current User Profile>>
	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public Users getUser(@CurrentUser UsersPrincipal usersPrincipal) {
		return userRepository.findById(usersPrincipal.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("Users", "userId", usersPrincipal.getUserId()));
		
	}

}



