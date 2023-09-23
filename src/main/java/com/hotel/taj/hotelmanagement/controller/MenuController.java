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
import com.hotel.taj.hotelmanagement.dto.Menu;
import com.hotel.taj.hotelmanagement.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	MenuService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu){
		return service.saveMenu(menu);
	}  
	@GetMapping
	public ResponseEntity<ResponseStructure<Menu>> findMenu(@RequestParam int id){
		return service.findMenu(id);
	}
}
