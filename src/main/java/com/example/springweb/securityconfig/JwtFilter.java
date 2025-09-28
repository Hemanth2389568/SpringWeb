package com.example.springweb.securityconfig;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springweb.service.JwtService;
import com.example.springweb.service.MyUserDetailService;
import com.example.springweb.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private MyUserDetailService userDetailService;
	


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		// TODO Auto-generated method stub
		

		String path = request.getRequestURI();

		// Skip JWT validation for public endpoints
		if (path.equals("/user/**")) {
			filterChain.doFilter(request, response);
			return ;
		}

		
		String authheader=request.getHeader("Authorization");
		String token=null;
		String username=null;
		
		if(authheader !=null && authheader.startsWith("Bearer ")) {
			token=authheader.substring(7);
			username=jwtService.extractUserName(token);
		}
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userDetails=userDetailService.loadUserByUsername(username);
			
			if(jwtService.validateToken(token, userDetails)){
				
				UsernamePasswordAuthenticationToken authtoken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authtoken);
				
			}
		}
		filterChain.doFilter(request, response);
		
	}
	
	

}
