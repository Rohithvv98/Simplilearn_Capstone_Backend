package com.app.foodbox.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.foodbox.exception.UserCartNotFoundException;
import com.app.foodbox.model.User_Cart;
import com.app.foodbox.repo.User_CartRepo;

@Service
@Transactional
public class User_CartService {
	private final User_CartRepo userCartRepo;
	
	@Autowired
	public User_CartService(User_CartRepo userCartRepo)
	{
		this.userCartRepo=userCartRepo;
	}
	
	public User_Cart addUsertoCart(User_Cart userCart)
	{
		return userCartRepo.save(userCart);
	}
	
	public List<User_Cart> findAllUsersCart()
	{
		return userCartRepo.findAll();
	}
	
	public User_Cart updateUserCart(User_Cart userCart)
	{
		return userCartRepo.save(userCart);
	}
	
	public User_Cart findCartByUserId(Long id)
	{
		return userCartRepo.findUser_CartByUserId(id).orElseThrow(() -> new UserCartNotFoundException ("User by id "+id+"is not found or does not have a cart"));
	}
	
	public void deleteUserCart(Long id)
	{
		userCartRepo.deleteUser_CartBycartId(id);
	}
}
