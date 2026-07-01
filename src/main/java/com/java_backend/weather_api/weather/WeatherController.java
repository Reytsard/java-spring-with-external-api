package com.java_backend.weather_api.weather;

import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java_backend.weather_api.model.WeatherApiResponse;


@RestController
@RequestMapping("weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("latest")
    public WeatherApiResponse getMethodName(@RequestParam("lat") @Nullable Double lat, @RequestParam("lon") @Nullable Double lon, @Nullable @RequestParam("location") String location) {
        if (location != null) {
            return weatherService.getLatestWeatherByLocation(location);
        } else {
            return weatherService.getLatestWeatherByDegree(lat, lon);
        }
    }


}
