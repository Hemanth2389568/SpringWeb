package com.example.springweb.kafka;

import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	
//	@KafkaListener(topics = " ",groupId = " ")
//	public void consume(String message) {
//		System.out.println("Received message: "+message);
//	}

}
