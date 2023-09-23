package com.hotel.taj.hotelmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.taj.hotelmanagement.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu,Integer> {

}
