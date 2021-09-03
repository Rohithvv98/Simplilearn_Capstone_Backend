package com.app.foodbox.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.foodbox.exception.UserNotFoundException;
import com.app.foodbox.model.User;
import com.app.foodbox.repo.UserRepo;

@Service
@Transactional
public class UserService {
	private final UserRepo userRepo;
	
	@Autowired
	public UserService(UserRepo userRepo)
	{
		this.userRepo=userRepo;
	}
	
	public User addUser(User user)
	{
		return userRepo.save(user);
	}
	
	public List<User> findAllUser()
	{
		return userRepo.findAll();
	}
	
	public User updateUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User findUserByName(String name)
	{
		return userRepo.findUserByName(name).orElseThrow(() -> new UserNotFoundException ("User by name "+name+" was not found"));
	}
	
	public User findUserById(Long id)
	{
		return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException ("User by id "+id+" was not found"));
	}
	
	public void deleteUser(Long id)
	{
		userRepo.deleteUserById(id);
	}
}
