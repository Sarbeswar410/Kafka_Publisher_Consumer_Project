package com.sarbeswar.enduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfiguration {
	@KafkaListener(topics = AppConstants.LOCATION_TOPIC_NAME, groupId = AppConstants.GROUP_ID)
	public void updateedLocation(String value) {
		System.out.println(value);

	}

}
