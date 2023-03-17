package com.example.weatherapp.service;

import com.example.weatherapp.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Import(TestConfig.class)
//@SpringJUnitConfig(classes = TestConfig.class)
//@ContextConfiguration(classes = TestConfig.class)
class WeatherServiceTest {

	@Autowired
	private WeatherService weatherService;

	@MockBean
	private RestTemplate restTemplate;

	@Test
	void getWeatherByCityTest() {
		when(restTemplate.getForObject(any(String.class), eq(String.class)))
				.thenReturn("{\"list\":[{\"main\":{\"temp\":14.58,\"feels_like\":13.87},\"weather\":[{\"description\":\"overcast clouds\"}]}]}");

		String expected = "Temperature: 14,58 degrees C, Feels Like: 13,87 degrees C, Weather: overcast clouds";
		String actual = weatherService.getWeatherByCity("Nijmegen");
		assertEquals(expected, actual);
	}

	@Test
	void getWeatherByCityErrorTest() {
		when(restTemplate.getForObject(any(String.class), eq(String.class)))
				.thenThrow(HttpClientErrorException.class);

		String expected = "Error fetching weather data. Please check the input parameters and try again.";
		String actual = weatherService.getWeatherByCity("InvalidCity");
		assertEquals(expected, actual);
	}

}
