package com.example.weatherapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("!test")
@ComponentScan("com.example.weatherapp")
public class AppConfig {

	@Value("${openweathermap.api.key}")
	private String apiKey;

	@Bean
	public String apiKey() {
		return apiKey;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
