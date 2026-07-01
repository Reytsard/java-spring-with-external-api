package com.java_backend.weather_api.exception;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(){
        super("Location not found");
    }
}
