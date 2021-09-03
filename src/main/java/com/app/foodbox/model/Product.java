package com.app.foodbox.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private String category;
	private Integer quantity;
	private Float price;
	private String disabled;
	private String ImagePath;
	
	
	public Product() {}


	public Product(Long id, String name, String category, Integer quantity, Float price, String disabled,
			String imagePath) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.disabled = disabled;
		ImagePath = imagePath;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public String getDisabled() {
		return disabled;
	}


	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}


	public String getImagePath() {
		return ImagePath;
	}


	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", quantity=" + quantity + ", price="
				+ price + ", disabled=" + disabled + ", ImagePath=" + ImagePath + "]";
	}
	
	
}
