package com.hotel.taj.hotelmanagement.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
@Component
public class FoodOrder {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int foodOrderId;
	private String foodOrderLocation;
	private long foodOrderNumber;
	private double foodOrderCost;
	@OneToMany
	private List<Item> foodOrderItems;
	public int getFoodOrderId() {
		return foodOrderId;
	}
	public void setFoodOrderId(int foodOrderId) {
		this.foodOrderId = foodOrderId;
	}
	public String getFoodOrderLocation() {
		return foodOrderLocation;
	}
	public void setFoodOrderLocation(String foodOrderLocation) {
		this.foodOrderLocation = foodOrderLocation;
	}
	public long getFoodOrderNumber() {
		return foodOrderNumber;
	}
	public void setFoodOrderNumber(long foodOrderNumber) {
		this.foodOrderNumber = foodOrderNumber;
	}
	public double getFoodOrderCost() {
		return foodOrderCost;
	}
	public void setFoodOrderCost(double foodOrderCost) {
		this.foodOrderCost = foodOrderCost;
	}
	public List<Item> getFoodOrderItems() {
		return foodOrderItems;
	}
	public void setFoodOrderItems(List<Item> foodOrderItems) {
		this.foodOrderItems = foodOrderItems;
	}
}
