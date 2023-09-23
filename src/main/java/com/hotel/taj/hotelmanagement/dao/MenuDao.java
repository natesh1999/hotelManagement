package com.hotel.taj.hotelmanagement.dao;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.taj.hotelmanagement.dto.Menu;
import com.hotel.taj.hotelmanagement.repo.MenuRepo;

@Repository
public class MenuDao {
	
	@Autowired
	MenuRepo repo;
	
	public Menu saveMenu(Menu menu) {
		 return repo.save(menu);
	}
	
	public Menu findMenu(int id) {
		Optional<Menu> optionalMenu =repo.findById(id);
		if(optionalMenu.isPresent()) {
			return optionalMenu.get();
		}
		return null;
	}
	
	public Menu updateMenu(Menu menu, int id) {
		Optional<Menu> optionalMenu =repo.findById(id);
		if(optionalMenu.isPresent()) {
			menu.setMenuId(id);
			return repo.save(menu);
		}
		return null;
	}
	
}
