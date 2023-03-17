package com.example.weatherapp.config;

import com.example.weatherapp.service.WeatherService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@TestConfiguration
@Profile("test")
@Import(WeatherService.class)
public class TestConfig {

	@Bean
	public String apiKey() {
		return "test-api-key";
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public WeatherService weatherService(RestTemplate restTemplate, String apiKey) {
		return new WeatherService(restTemplate, apiKey);
	}

}
