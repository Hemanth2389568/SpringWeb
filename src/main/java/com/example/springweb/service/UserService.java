package com.example.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springweb.dto.UserDto;
import com.example.springweb.exception.InvalidCredentialsException;
import com.example.springweb.model.User;
import com.example.springweb.repository.UserDao;

@Service
public class UserService {
	

	
	@Autowired
	private UserDao userdao;
	
	
	@Autowired
	private AuthenticationManager authmanger;
	
	@Autowired
	private JwtService jwtservice;
	

	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

	public void addUser(UserDto userdto) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setPassword(encoder.encode(userdto.getPassword()));
		user.setUserName(userdto.getUserName());
		userdao.save(user);
		
	}
	
	public List<User> getusers(){
		
		List<User> users=userdao.findAll();
		
		return users;
	}
	public String verify(User user) {
		
		Authentication authentication=authmanger.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		
		if(authentication.isAuthenticated()==true) {
			return jwtservice.generatetoken(user.getUserName());
		}
		else {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		
	}
}

	

