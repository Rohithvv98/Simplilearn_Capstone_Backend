package com.app.foodbox.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.foodbox.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long>{

	Optional<Cart> findCartBysNo(Long id);

	void deleteCartBysNo(Long id);

}
