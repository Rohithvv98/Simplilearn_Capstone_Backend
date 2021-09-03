package com.app.foodbox.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.foodbox.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	Optional<Product> findProductById(Long id);

	void deleteProductById(Long id);

}
