package com.cs.SpringSecurityWithJWT.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.SpringSecurityWithJWT.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUserName(String username);

}
