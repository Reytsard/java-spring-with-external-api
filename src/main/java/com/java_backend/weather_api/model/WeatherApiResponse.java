package com.java_backend.weather_api.model;

public record WeatherApiResponse(
    Location location,
    Current current
) {
    public record Location(String name, String country, double lat, double lon){}

    public record Current(
        double temp_c,
        double temp_f,
        int humidity,
        double wind_kph,
        String wind_dir,
        double feelslike_c,
        double uv,
        Condition condition
    ) {}

    public record Condition(String text, String icon, int code) {}

    
}
