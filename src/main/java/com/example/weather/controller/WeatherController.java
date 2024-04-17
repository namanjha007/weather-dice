package com.example.weather.controller;

import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    public WeatherService weatherService;

    @GetMapping(value="/forecastSummary/{cityName}", produces = "application/json")
    public ResponseEntity<String> getForecastSummary(@PathVariable String cityName) throws Exception {
        String response = weatherService.getForecastSummary(cityName);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value="/hourlyForecast", produces = "application/json")
    public ResponseEntity<String> getHourlyForecast(@PathVariable String cityName) throws Exception {
        String response = weatherService.getHourlyForecast(cityName);
        return ResponseEntity.ok(response);
    }
}

