package com.example.weatherapp.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

	@Bean
	public String apiKey() {
		return "test-api-key";
	}

}
