package com.app.foodbox.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.foodbox.model.User_Cart;

@Repository
public interface User_CartRepo extends JpaRepository<User_Cart, Long>{

	void deleteUser_CartBycartId(Long id);

	Optional<User_Cart> findUser_CartByUserId(Long id);
}
