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

import com.app.foodbox.model.Product;
import com.app.foodbox.model.User;
import com.app.foodbox.service.ProductService;
import com.app.foodbox.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private final UserService userService;
	private final ProductService productService;
	
	
	// user
	public UserController(UserService userService,ProductService productService)
	{
		this.userService=userService;
		this.productService=productService;
	}
	
	@GetMapping("/findUser/{name}")
	public ResponseEntity<User> getUser(@PathVariable("name") String name)
	{
		User user=userService.findUserByName(name);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/findUserbyId/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
	{
		User user=userService.findUserById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		User adduser=userService.addUser(user);
		return new ResponseEntity<>(adduser,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		User updateuser=userService.updateUser(user);
		return new ResponseEntity<>(updateuser,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id)
	{
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// product
	@GetMapping("/allProduct")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> products=productService.findAllProducts();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	
	@GetMapping("/findProduct/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id)
	{
		Product product=productService.findProductbyId(id);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
}
