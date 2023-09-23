package com.hotel.taj.hotelmanagement.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.taj.hotelmanagement.dto.Product;


public interface ProductRepo extends JpaRepository<Product,Integer> {
	
	
}
