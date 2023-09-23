package com.hotel.taj.hotelmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.taj.hotelmanagement.dto.Item;

public interface ItemRepo extends JpaRepository<Item,Integer>{

}
