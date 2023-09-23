package com.hotel.taj.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dto.Product;
import com.hotel.taj.hotelmanagement.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService service;
		
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product p,@RequestParam int menuId){
		return service.saveProdcut(p, menuId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Product>> findProduct(@RequestParam int id){
		return service.findProduct(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product p, @RequestParam int id){
		return service.updateProdcut(p, id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int pid,@RequestParam int mid){
		return service.deleteProduct(pid, mid);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct(){
		return service.allproducts();
	}
}
