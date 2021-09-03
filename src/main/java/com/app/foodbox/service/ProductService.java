package com.app.foodbox.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.foodbox.exception.ProductNotFoundException;
import com.app.foodbox.model.Product;
import com.app.foodbox.repo.ProductRepo;

@Service
@Transactional
public class ProductService {

	private final ProductRepo productRepo;
	
	@Autowired
	public ProductService(ProductRepo productRepo)
	{
		this.productRepo=productRepo;
	}
	
	public Product addProduct(Product product)
	{
		return productRepo.save(product);
	}
	
	public List<Product> findAllProducts()
	{
		return productRepo.findAll();
	}
	
	
	
	public Product updateProduct(Product product)
	{
		return productRepo.save(product);
	}
	
	public Product findProductbyId(Long id)
	{
		return productRepo.findProductById(id).orElseThrow(() -> new ProductNotFoundException ("Product by id "+id+" was not found"));
	}
	
	public void deleteProduct(Long id)
	{
		productRepo.deleteProductById(id);
	}
}
