package com.example.springweb.exception;

public class InvalidCredentialsException extends RuntimeException{
	
	public InvalidCredentialsException(String msg) {
		super(msg);
	}

}
