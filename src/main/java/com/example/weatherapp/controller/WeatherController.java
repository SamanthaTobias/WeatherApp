package com.example.weatherapp.controller;

import com.example.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/weather/{city}")
	public ResponseEntity<String> getWeather(@PathVariable(value = "city") String city) {

		String weatherData = weatherService.getWeatherByCity(city);

		return ResponseEntity.ok(weatherData);
	}

}
