package com.sarbeswar.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sarbeswar.deliveryboy.config.AppConstants;

@Service
public class Kafkaservice {
	@Autowired
	private KafkaTemplate<String,String> kafkatemplate;
	Logger logger =  LoggerFactory.getLogger(Kafkaservice.class);

	
	public boolean updateLocation(String location) {
		
		this.kafkatemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
		logger.info("Location Produced");
		return true;
		
	}

}
