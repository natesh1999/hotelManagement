package com.hotel.taj.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dao.MenuDao;
import com.hotel.taj.hotelmanagement.dto.Menu;

@Service
public class MenuService {
	
	@Autowired
	MenuDao dao;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu){
		ResponseStructure<Menu> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("menu has been saved");
		structure.setData(dao.saveMenu(menu));
		
		return new  ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Menu>> findMenu(int id){
		ResponseStructure<Menu> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("menu has been found");
		structure.setData(dao.findMenu(id));
		return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.FOUND);
	}
	
	
}
