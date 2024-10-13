package org.example.avaliacao02.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherAPIConfig {

    @Value("${weatherapi.api.url}")
    private String apiUrl;

    @Value("${weatherapi.api.key}")
    private String apiKey;

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}