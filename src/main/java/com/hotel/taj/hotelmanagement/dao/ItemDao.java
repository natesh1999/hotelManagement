package com.hotel.taj.hotelmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.taj.hotelmanagement.dto.Item;
import com.hotel.taj.hotelmanagement.repo.ItemRepo;

@Repository
public class ItemDao {
	@Autowired
	ItemRepo repo;
	
	public Item saveItem(Item i) {
		return repo.save(i);
	}
	
	public Item findItem(int id) {
		Optional<Item> i = repo.findById(id);
		if(i.isPresent()) {
			return i.get();
		}
		else {
			return null;
		}
	}
}
