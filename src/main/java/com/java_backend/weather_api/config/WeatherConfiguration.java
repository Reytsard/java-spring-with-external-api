package com.java_backend.weather_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WeatherConfiguration {

    @Value("${weather.base-api}")
    private String baseUrl;

    @Bean
    public RestClient weatherConfiguration(RestClient.Builder builder){
        return builder.baseUrl(baseUrl)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
