package com.hotel.taj.hotelmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.taj.hotelmanagement.dto.User;
import com.hotel.taj.hotelmanagement.repo.UserRepo;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepo userrepo;
	
	
	// save user
	public User saveUser(User u) {
//		User savedUser =  repo.save(u);
//		return savedUser;
		
		return userrepo.save(u);
		
	}
	
	// find user
	public User findUser(int userId) {
		 Optional<User> optionalUser=userrepo.findById(userId);
		
		 if(optionalUser.isPresent()) {
			 return optionalUser.get();
		 }else
			 return null;
	}
	
	public User deleteUser(int id) {
		Optional<User> optionalUser=userrepo.findById(id);
		if(optionalUser.isPresent()) {
			userrepo.delete(optionalUser.get());
			return optionalUser.get();	
		}
		return null;
	}
	public User updateUser(User u, int id) {
		Optional<User> optionalUser=userrepo.findById(id);
		if(optionalUser.isPresent()) {
			u.setUserId(id);
			return userrepo.save(u);
			
		}
		return null;
	}
	
	public User findByEmail(String email) {
		User exUser = userrepo.findByEmail(email);
		
		
		
		
		if(exUser!=null) {
			return exUser;
		}
		return null;
	}

	
	
}
