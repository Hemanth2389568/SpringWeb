package com.example.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springweb.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

}
