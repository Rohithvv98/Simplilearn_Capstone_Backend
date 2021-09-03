package com.app.foodbox.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.foodbox.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findUserByName(String name);
	Optional<User> findUserById(Long id);
	void deleteUserById(Long id);

}
