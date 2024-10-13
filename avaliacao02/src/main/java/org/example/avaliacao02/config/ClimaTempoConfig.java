package org.example.avaliacao02.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClimaTempoConfig {

    @Value("${climatempo.api.url}")
    private String apiUrl;

    @Value("${climatempo.api.token}")
    private String apiToken;

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiToken() {
        return apiToken;
    }
}