package com.hotel.taj.hotelmanagement.dto;

import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
@Entity
@Component
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuId;
	private int menusections;
	@OneToMany
	private List<Product> menuProducts;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getMenusections() {
		return menusections;
	}
	public void setMenusections(int menusections) {
		this.menusections = menusections;
	}
	public List<Product> getMenuProducts() {
		return menuProducts;
	}
	public void setMenuProducts(List<Product> menuProducts) {
		this.menuProducts = menuProducts;
	}	
}
