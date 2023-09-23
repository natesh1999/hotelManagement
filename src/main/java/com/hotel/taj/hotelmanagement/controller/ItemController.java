package com.hotel.taj.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dto.Item;
import com.hotel.taj.hotelmanagement.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<Item>> saveItem(@RequestParam int pid,@RequestParam int orderid,@RequestParam int quantity){
		return service.saveItem(pid, orderid, quantity);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Item>> findItem(@RequestParam int id){
		return service.findItem(id);
	}
}
