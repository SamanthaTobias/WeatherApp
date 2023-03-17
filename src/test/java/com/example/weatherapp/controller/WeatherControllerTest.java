package com.example.weatherapp.controller;

import com.example.weatherapp.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WeatherService weatherService;

	@Test
	void getWeatherByCityNameTest() throws Exception {
		String city = "Amsterdam";
		String expectedResult = "Sample weather data for " + city;

		when(weatherService.getWeatherByCity(city)).thenReturn(expectedResult);

		mockMvc.perform(get("/weather/{city}", city))
				.andExpect(status().isOk())
				.andExpect(content().string(expectedResult));
	}

}
