package com.app.foodbox.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sNo;
	private Long id;
	private Long productId;
	private Integer quantity;
	private Integer total;
	
	
	public Cart() {}


	public Cart(Long sNo, Long id, Long productId, Integer quantity, Integer total) {
		this.sNo = sNo;
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.total = total;
	}


	public Long getsNo() {
		return sNo;
	}


	public void setsNo(Long sNo) {
		this.sNo = sNo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Cart [sNo=" + sNo + ", id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", total="
				+ total + "]";
	}
	
	
	
	
	
}
