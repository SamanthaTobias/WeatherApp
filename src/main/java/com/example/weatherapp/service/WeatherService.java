package com.example.weatherapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.DecimalFormat;


@Service
public class WeatherService {

	private static final Logger log = LogManager.getLogger(WeatherService.class);

	@Value("${openweathermap.api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	public WeatherService(RestTemplate restTemplate, String apiKey) {
		this.restTemplate = restTemplate;
		this.apiKey = apiKey;
	}

	public String getWeatherByCity(String city) {
		String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/forecast")
				.queryParam("q", city)
				.queryParam("appid", apiKey)
				.queryParam("units", "metric")
				.toUriString();

		return getWeatherData(url);
	}

	private String getWeatherData(String url) {
		try {
			return parseWeatherResponse(restTemplate.getForObject(url, String.class));
		} catch (HttpClientErrorException | JSONException e) {
			log.error("Error fetching weather data.", e);
			return "Error fetching weather data. Please check the input parameters and try again.";
		}
	}

	private String parseWeatherResponse(String json) throws JSONException {
		JSONObject jsonObject = new JSONObject(json);
		JSONObject daily = jsonObject.getJSONArray("list").getJSONObject(0);
		JSONObject main = daily.getJSONObject("main");
		JSONObject weather = daily.getJSONArray("weather").getJSONObject(0);

		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		double temp = main.getDouble("temp");
		double feelsLike = main.getDouble("feels_like");
		String description = weather.getString("description");

		return String.format("Temperature: %s degrees C, Feels Like: %s degrees C, Weather: %s",
				decimalFormat.format(temp), decimalFormat.format(feelsLike), description);
	}

}
