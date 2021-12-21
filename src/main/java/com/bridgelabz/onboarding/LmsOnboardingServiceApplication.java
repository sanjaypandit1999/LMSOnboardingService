package com.bridgelabz.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LmsOnboardingServiceApplication {

	public static void main(String[] args) {
			ApplicationContext context = SpringApplication.run(LmsOnboardingServiceApplication.class, args);
			log.info("LMS Cndidate App Started in {} Environment", context.getEnvironment().getProperty("environment"));
			log.info("lms DB User is {}", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
