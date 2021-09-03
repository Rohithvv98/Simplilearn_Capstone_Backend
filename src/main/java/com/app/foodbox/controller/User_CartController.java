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

import com.app.foodbox.model.User_Cart;
import com.app.foodbox.service.User_CartService;



@RestController
@RequestMapping("/usercart")
public class User_CartController {

	@Autowired
	private final User_CartService usercartService;

	public User_CartController(User_CartService usercartService) {
		this.usercartService=usercartService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User_Cart>> getAllUserCarts()
	{
		List<User_Cart> usercarts=usercartService.findAllUsersCart();
		return new ResponseEntity<>(usercarts,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<User_Cart> getUserCart(@PathVariable("id") Long id)
	{
		User_Cart usercart=usercartService.findCartByUserId(id);
		return new ResponseEntity<>(usercart,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User_Cart> addUserCart(@RequestBody User_Cart usercart)
	{
		User_Cart addusercart=usercartService.addUsertoCart(usercart);
		return new ResponseEntity<>(addusercart,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User_Cart> updateUserCart(@RequestBody User_Cart User_Cart)
	{
		User_Cart updateusercart=usercartService.updateUserCart(User_Cart);
		return new ResponseEntity<>(updateusercart,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserCart(@PathVariable("id") Long id)
	{
		usercartService.deleteUserCart(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
