package com.example.weatherapp;

import com.example.weatherapp.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {WeatherAppApplication.class, TestConfig.class})
@ActiveProfiles("test")
class WeatherAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
