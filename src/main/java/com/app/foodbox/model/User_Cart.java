package com.app.foodbox.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class User_Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	private Long userId;
	private Long grandTotal;
	
	
	public User_Cart() {}


	public User_Cart(Long cartId, Long userId, Long grandTotal) {
		this.cartId = cartId;
		this.userId = userId;
		this.grandTotal = grandTotal;
	}


	public Long getCartId() {
		return cartId;
	}


	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(Long grandTotal) {
		this.grandTotal = grandTotal;
	}


	@Override
	public String toString() {
		return "User_Cart [cartId=" + cartId + ", userId=" + userId + ", grandTotal=" + grandTotal + "]";
	}
	
	
}
