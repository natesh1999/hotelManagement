package com.hotel.taj.hotelmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.taj.hotelmanagement.dto.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	@Query("select u from User u where u.userEmail=?1")
	public User findByEmail(String email);
	
	
}
