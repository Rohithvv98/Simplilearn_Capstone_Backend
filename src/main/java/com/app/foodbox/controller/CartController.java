package com.app.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.foodbox.model.Cart;
import com.app.foodbox.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private final CartService cartService;

	public CartController(CartService cartService) {
		this.cartService=cartService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Cart>> getAllCarts()
	{
		List<Cart> carts=cartService.findAllCarts();
		return new ResponseEntity<>(carts,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable("id") Long id)
	{
		Cart cart=cartService.findCartbyId(id);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart)
	{
		Cart addcart=cartService.addCart(cart);
		return new ResponseEntity<>(addcart,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart)
	{
		Cart updatecart=cartService.updateCart(cart);
		return new ResponseEntity<>(updatecart,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable("id") Long id)
	{
		cartService.deleteCart(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
