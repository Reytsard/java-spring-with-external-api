package com.java_backend.weather_api.weather;

import org.springframework.stereotype.Service;

import com.java_backend.weather_api.model.WeatherApiResponse;

@Service
public class WeatherService {

    public WeatherApiResponse getLatestWeather(String location){
        return new WeatherApiResponse(null,null);
    }
}
   
