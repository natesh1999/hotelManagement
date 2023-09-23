package com.hotel.taj.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.taj.hotelmanagement.config.ResponseStructure;
import com.hotel.taj.hotelmanagement.dao.FoodOrderDao;
import com.hotel.taj.hotelmanagement.dao.ItemDao;
import com.hotel.taj.hotelmanagement.dao.ProductDao;
import com.hotel.taj.hotelmanagement.dto.FoodOrder;
import com.hotel.taj.hotelmanagement.dto.Item;
import com.hotel.taj.hotelmanagement.dto.Product;
import com.hotel.taj.hotelmanagement.exception.ItemNotFound;

@Service
public class ItemService {

	@Autowired
	ItemDao idao;
	@Autowired
	ProductDao pdao;
	@Autowired
	FoodOrderDao odao;

	public ResponseEntity<ResponseStructure<Item>> saveItem(int pid, int orderid, int quantity) {
		Product p = pdao.findProduct(pid);
		FoodOrder o = odao.findOrder(orderid);

		Item i = new Item();
		i.setItemName(p.getProductName());
		i.setItemQuantity(quantity);
		i.setItemCost(p.getProductPrice());
		i.setOrder(o);

		ResponseStructure<Item> structure = new ResponseStructure<>();
		structure.setData(idao.saveItem(i));
		structure.setMessage("item has been saved");
		structure.setStatus(HttpStatus.CREATED.value());

		List<Item> items = o.getFoodOrderItems();
		items.add(i);
		double total = 0;
		for (Item item : items) {
			total = total + item.getItemCost() * item.getItemQuantity();
		}

		o.setFoodOrderCost(total);
		odao.updateOrder(o, orderid);

		return new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Item>> findItem(int id){
		Item existingitem = idao.findItem(id);
		if(existingitem!=null) {
			ResponseStructure<Item> structure = new ResponseStructure<>();
			structure.setData(existingitem);
			structure.setMessage("item found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Item>>(structure,HttpStatus.FOUND);
		}else {
			throw new ItemNotFound("item id is wrong");
	}
	
	}
	
}

