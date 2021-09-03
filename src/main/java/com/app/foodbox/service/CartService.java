package com.app.foodbox.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.foodbox.exception.CartNotFoundException;
import com.app.foodbox.model.Cart;
import com.app.foodbox.repo.CartRepo;

@Service
@Transactional
public class CartService {

		private CartRepo cartRepo;
		
		@Autowired
		public CartService(CartRepo cartRepo)
		{
			this.cartRepo=cartRepo;
		}
		
		public Cart addCart(Cart cart)
		{
			return cartRepo.save(cart);
		}
		
		public List<Cart> findAllCarts()
		{
			return cartRepo.findAll();
		}
		
		public Cart updateCart(Cart cart)
		{
			return cartRepo.save(cart);
		}
		
		public Cart findCartbyId(Long id)
		{
			return cartRepo.findCartBysNo(id).orElseThrow(() -> new CartNotFoundException ("Cart by id "+id+" was not found"));
		}
		
		public void deleteCart(Long id)
		{
			cartRepo.deleteCartBysNo(id);
		}
}
