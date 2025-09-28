package com.example.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springweb.model.User;
import com.example.springweb.model.UserPrincipal;
import com.example.springweb.repository.UserDao;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userdao.findByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException(username+":"+"User not found");
		}
		return new UserPrincipal(user);
	}

}
