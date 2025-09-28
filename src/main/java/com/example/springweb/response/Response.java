package com.example.springweb.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class Response<T> {
	
	private T data;
	private Boolean success;
	private HttpStatus httpstatus;

}
