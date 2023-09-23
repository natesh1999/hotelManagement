package com.hotel.taj.hotelmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.taj.hotelmanagement.dto.FoodOrder;
import com.hotel.taj.hotelmanagement.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {
	@Autowired
	FoodOrderRepo repo;
	
	public FoodOrder saveOrder(FoodOrder order) {
		return repo.save(order);
	}
	
	public FoodOrder findOrder(int id) {
		Optional<FoodOrder> exorder = repo.findById(id);
		if(exorder.isPresent()) {
		return exorder.get();
		}
		else {
			return null;
		}
	}
	
	public FoodOrder updateOrder(FoodOrder order , int id) {
		Optional<FoodOrder> oporder = repo.findById(id);
		if(oporder.isPresent()) {
			order.setFoodOrderId(id);
			return repo.save(order);
		}
		return null;
	}
	
}
