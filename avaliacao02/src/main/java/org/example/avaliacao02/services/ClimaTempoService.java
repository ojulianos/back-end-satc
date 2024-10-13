package org.example.avaliacao02.services;

import org.example.avaliacao02.config.ClimaTempoConfig;
import org.example.avaliacao02.models.Previsao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaTempoService {

    @Autowired
    private ClimaTempoConfig climatempoConfig;

    @Autowired
    private PrevisaoService previsaoService;

    public Previsao obterPrevisao(String cidadeId) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = climatempoConfig.getApiUrl() + "/weather/locale/" + cidadeId + "/current?token=" + climatempoConfig.getApiToken();
        String resposta = restTemplate.getForObject(url, String.class);

        return previsaoService.processarRespostaClimaTempo(resposta);
    }

    public Previsao obterPrevisaoPorCidadeEstado(String cidadeNome, String estado) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = climatempoConfig.getApiUrl() + "/weather?city=" + cidadeNome + "&state=" + estado + "&token=" + climatempoConfig.getApiToken();
        String resposta = restTemplate.getForObject(url, String.class);

        return previsaoService.processarRespostaClimaTempo(resposta);
    }
}

