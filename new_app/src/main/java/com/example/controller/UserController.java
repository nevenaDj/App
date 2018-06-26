package com.example.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserCredentialsDTO;
import com.example.dto.UserDTO;
import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> login(@RequestBody UserCredentialsDTO credentials) {
		try {
			String jwt = userService.signin(credentials.getUsername(), credentials.getPassword());
			return new ResponseEntity<>(jwt, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Neispravno korisnicko ime ili lozinka.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@PostMapping("/signup")
	public String signup(@RequestBody UserDTO user) {
		return userService.signup(modelMapper.map(user, User.class));
	}

}
