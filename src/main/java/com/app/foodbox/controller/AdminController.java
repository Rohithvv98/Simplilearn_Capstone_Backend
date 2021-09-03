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
@RequestMapping("/admin")
public class AdminController {

		@Autowired
		private final ProductService productService;
		private final UserService userService;
		
		public AdminController(ProductService productService,UserService userService)
		{
			this.productService=productService;
			this.userService=userService;
		}
		
		
		// admin -Product Controls
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
		
		@PostMapping("/addProduct")
		public ResponseEntity<Product> addProduct(@RequestBody Product product)
		{
			Product addproduct=productService.addProduct(product);
			return new ResponseEntity<>(addproduct,HttpStatus.CREATED);
		}
		
		@PutMapping("/updateProduct")
		public ResponseEntity<Product> updateProduct(@RequestBody Product product)
		{
			Product updateproduct=productService.updateProduct(product);
			return new ResponseEntity<>(updateproduct,HttpStatus.OK);
		}
		
		@DeleteMapping("/deleteProduct/{id}")
		public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id)
		{
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
		
		
		
		//admin-User Controls
		@GetMapping("/allUsers")
		public ResponseEntity<List<User>> getAllUsers()
		{
			List<User> users=userService.findAllUser();
			return new ResponseEntity<>(users,HttpStatus.OK);
		}
		
		@GetMapping("/findUser/{name}")
		public ResponseEntity<User> getUser(@PathVariable("name") String name)
		{
			User user=userService.findUserByName(name);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		
		@GetMapping("/findUserById/{id}")
		public ResponseEntity<User> getUser(@PathVariable("id") Long id)
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
}
