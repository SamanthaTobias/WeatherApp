package com.example.weatherapp;

import com.example.weatherapp.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AppConfig.class})
@EnableAspectJAutoProxy
@PropertySource(value = {"classpath:application.properties", "classpath:application-secrets.properties"})
public class WeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}

}
