package com.java_backend.weather_api.weather;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.java_backend.weather_api.model.WeatherApiResponse;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private RestClient restClient;

    public WeatherService(RestClient restClient){
        this.restClient = restClient;
    }

    public WeatherApiResponse getLatestWeather(String location){
        return restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("current.json")
                                .queryParam("q",location)
                                .build()
                )
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }
}
   
