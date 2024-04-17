package com.example.weather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
public class WeatherService {

    public static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${myapp.rapidapi.host}")
    private String host;

    @Value("${myapp.rapidapi.key}")
    private String key;

    /**
     * Get forecast summary
     * @param cityName
     * @return response
     */
    public String getForecastSummary(String cityName) throws Exception {
        try {
            logger.info("Getting forecast summary for city :{}", cityName);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://forecast9.p.rapidapi.com/rapidapi/forecast/" +
                            cityName + "/summary/"))
                    .header("X-RapidAPI-Key", key)
                    .header("X-RapidAPI-Host", host)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            logger.error("Error in WeatherService.getForecastSummary", e);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Get hourly forecast
     * @param cityName
     * @return response
     */
    public String getHourlyForecast(String cityName) throws Exception {
        try {
            logger.info("Getting hourly forecast for city : {}", cityName);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://forecast9.p.rapidapi.com/rapidapi/forecast/" +
                            cityName + "/hourly/"))
                    .header("X-RapidAPI-Key", key)
                    .header("X-RapidAPI-Host", host)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body();
        } catch (Exception e) {
            logger.error("Error in WeatherService.getHourlyForecast", e);
            throw new Exception(e.getMessage());
        }
    }

}
