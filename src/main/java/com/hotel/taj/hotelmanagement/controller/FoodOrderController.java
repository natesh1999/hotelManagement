package com.hotel.taj.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dto.FoodOrder;
import com.hotel.taj.hotelmanagement.service.FoodOrderService;

@RestController
@RequestMapping("/order")
public class FoodOrderController {
	@Autowired
	FoodOrderService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> saveOrder(@RequestBody FoodOrder order){
		return service.saveOrder(order);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> saveOrder(@RequestParam int id){
		return service.findOrder(id);
	}
}
