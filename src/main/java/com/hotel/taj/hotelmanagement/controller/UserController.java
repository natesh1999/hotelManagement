package com.hotel.taj.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dto.User;
import com.hotel.taj.hotelmanagement.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u) {
		return uservice.saveUser(u);
	}
	
	
	
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam int id){
		return uservice.findUser(id);
	}
	
	

	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id){
		return uservice.deleteUser(id);
	}
	
	
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User u,@RequestParam int id){
		return uservice.updateUser(u, id);
	}
	
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestParam String email,@RequestParam String password){
		return uservice.login(email, password);
	}
	
	
}
