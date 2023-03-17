package com.example.weatherapp.integration;

import com.example.weatherapp.WeatherAppApplication;
import com.example.weatherapp.config.TestConfig;
import com.example.weatherapp.controller.WeatherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {WeatherAppApplication.class, TestConfig.class})
@Import(WeatherController.class)
public class WeatherIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getWeatherByCityIntegrationTest() {
		String response = restTemplate.getForObject("http://localhost:" + port + "/weather/Nijmegen", String.class);
		assertThat(response).isNotNull();
		assertThat(response).contains("Temperature:", "Feels Like:", "Weather:");
		System.out.println(response);
	}
}
