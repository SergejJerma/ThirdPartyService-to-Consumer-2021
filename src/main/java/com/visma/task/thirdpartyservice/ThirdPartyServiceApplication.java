package com.visma.task.thirdpartyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThirdPartyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdPartyServiceApplication.class, args);
	}

}
