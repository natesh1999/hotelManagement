package com.hotel.taj.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dao.MenuDao;
import com.hotel.taj.hotelmanagement.dao.ProductDao;
import com.hotel.taj.hotelmanagement.dto.Menu;
import com.hotel.taj.hotelmanagement.dto.Product;

@Service
public class ProductService {

	@Autowired
	MenuDao mdao;
	@Autowired
	ProductDao pdao;

	public ResponseEntity<ResponseStructure<Product>> saveProdcut(Product p, int menuId) {
		Menu existingMenu = mdao.findMenu(menuId);
		p.setMenu(existingMenu);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setData(pdao.saveProduct(p));
		structure.setMessage("product has been saved");
		structure.setStatus(HttpStatus.CREATED.value());

		List<Product> existingMenuProducts = existingMenu.getMenuProducts();
		existingMenuProducts.add(p);
		existingMenu.setMenuProducts(existingMenuProducts);
		mdao.updateMenu(existingMenu, menuId);

		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);

	}
	
	
	
	public ResponseEntity<ResponseStructure<Product>> findProduct(int id) {
		Product existingprProduct = pdao.findProduct(id);
		if(existingprProduct!=null) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setData(existingprProduct);
		structure.setMessage("product has been found");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.FOUND);
		}
		return null; 
	}

	public ResponseEntity<ResponseStructure<Product>> updateProdcut(Product updatedproduct, int id){
		Product existingProduct = pdao.findProduct(id);
		if(existingProduct!=null) {
			if(updatedproduct.getMenu() == null) {
				updatedproduct.setMenu(existingProduct.getMenu());
			}
			if(updatedproduct.getProductCatagory()==null) {
				updatedproduct.setProductCatagory(existingProduct.getProductCatagory());
			}
			if(updatedproduct.getProductDescription()==null) {
				updatedproduct.setProductDescription(existingProduct.getProductDescription());
			}
			if(updatedproduct.getProductName()==null) {
				updatedproduct.setProductName(existingProduct.getProductName());
			}
			if(updatedproduct.getProductPrice() <= 0 ) {
				updatedproduct.setProductPrice(existingProduct.getProductPrice());
			}
			
			ResponseStructure<Product> structure = new ResponseStructure<>();
			structure.setData(pdao.updateProduct(updatedproduct, id));
			structure.setMessage("product has been updated");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
			
		}
		else {
			return null;
		}	
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productid, int menuid){
		Product tobedeleted = pdao.findProduct(productid);
		Menu promenu = mdao.findMenu(menuid);
		List<Product> allproducts = promenu.getMenuProducts();
		allproducts.remove(tobedeleted);
		promenu.setMenuProducts(allproducts);
		mdao.updateMenu(promenu, promenu.getMenuId());
		
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setData(pdao.deleteProduct(productid));
		structure.setMessage("product has been deleted");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
	
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> allproducts(){
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setData(pdao.getallproduct());
		structure.setMessage("list of all the products");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.FOUND);
	}
	
}
