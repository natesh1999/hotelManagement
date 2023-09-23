package com.hotel.taj.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dao.FoodOrderDao;
import com.hotel.taj.hotelmanagement.dto.FoodOrder;
import com.hotel.taj.hotelmanagement.exception.OrderNotFound;

@Service
public class FoodOrderService {
	
	@Autowired
	FoodOrderDao dao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveOrder(FoodOrder order){
		ResponseStructure<FoodOrder> structure = new ResponseStructure<>();
		structure.setData(dao.saveOrder(order));
		structure.setMessage("order taken");
		structure.setStatus(HttpStatus.CREATED.value());
		
		return new  ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> findOrder(int id){
		FoodOrder order = dao.findOrder(id);
		if(order!=null) {
		ResponseStructure<FoodOrder> structure = new ResponseStructure<>();
		structure.setData(order);
		structure.setMessage("order found");
		structure.setStatus(HttpStatus.FOUND.value());
		
		return new  ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.FOUND);
		}
		throw new OrderNotFound("food order id is wrong");
	}
}
