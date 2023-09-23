package com.hotel.taj.hotelmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.taj.hotelmanagement.dto.Product;
import com.hotel.taj.hotelmanagement.repo.ProductRepo;

@Repository
public class ProductDao {
	@Autowired
	ProductRepo repo;

	public Product saveProduct(Product p) {
		return repo.save(p);
	}

	public Product findProduct(int id) {
		Optional<Product> optionalProduct = repo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public Product updateProduct(Product p, int id) {
		Optional<Product> optionalProduct = repo.findById(id);
		if(optionalProduct.isPresent()) {
			p.setProductId(id);
			return repo.save(p);
		}
		return null;
	}
	
	public Product deleteProduct(int id) {
		Optional<Product> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return optional.get();
		}
		return null;
	}
	
	public List<Product> getallproduct(){
		return repo.findAll();
	}
	
}
