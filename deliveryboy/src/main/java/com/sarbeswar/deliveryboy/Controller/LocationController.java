package com.sarbeswar.deliveryboy.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sarbeswar.deliveryboy.service.Kafkaservice;

@Controller
@RequestMapping("/Location")
public class LocationController {
	@Autowired
	private Kafkaservice kafkaservice;
// url for publishing message will be http://localhost:8080/Location/update
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() {
		String location="";
		for (int i = 1; i < 1000000; i++) {
			Random random = new Random();
			int randomLocation1 = random.nextInt(100);
			int randomLocation2 = random.nextInt(100);
			location = ("(" +randomLocation1 + "," + randomLocation2 +")");
			kafkaservice.updateLocation(location);

		}

		return ResponseEntity.ok("Location updated to: " + location);

	}

}
