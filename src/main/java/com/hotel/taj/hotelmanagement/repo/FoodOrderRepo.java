package com.hotel.taj.hotelmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.taj.hotelmanagement.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer>{
	
}
