package com.example.springweb.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Kafkaproducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkatempplate;
	
	public void sendmessage(String message) {
		
		kafkatempplate.send("User Creation",message);
		
	}
}
