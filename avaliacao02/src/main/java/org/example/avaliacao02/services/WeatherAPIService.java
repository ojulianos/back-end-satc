package org.example.avaliacao02.services;

import org.example.avaliacao02.config.WeatherAPIConfig;
import org.example.avaliacao02.models.Previsao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherAPIService {

    @Autowired
    private WeatherAPIConfig weatherAPIConfig;

    @Autowired
    private PrevisaoService previsaoService;

    public Previsao obterPrevisao(String cidadeNome) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = weatherAPIConfig.getApiUrl() + "/current.json?key=" + weatherAPIConfig.getApiKey() + "&q=" + cidadeNome + "&aqi=no";
        String resposta = restTemplate.getForObject(url, String.class);

        return previsaoService.processarRespostaWeatherAPI(resposta);
    }
}

