package org.example.avaliacao02.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.avaliacao02.config.ClimaTempoConfig;
import org.example.avaliacao02.models.Previsao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrevisaoService {

    public Previsao processarRespostaWeatherAPI(String resposta) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(resposta);
        JsonNode current = root.path("current");
        JsonNode condition = current.path("condition");

        Previsao previsao = new Previsao();
        previsao.setData(current.path("last_updated").asText());
        previsao.setDescricao(condition.path("text").asText());
        previsao.setTemperaturaMinima(current.path("temp_c").asDouble());
        previsao.setTemperaturaMaxima(current.path("temp_c").asDouble());

        return previsao;
    }

    public Previsao processarRespostaClimaTempo(String resposta) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(resposta);
        JsonNode data = root.path("data");

        Previsao previsao = new Previsao();
        previsao.setData(data.path("date").asText());
        previsao.setDescricao(data.path("text").asText());
        previsao.setTemperaturaMinima(data.path("temperature").path("min").asDouble());
        previsao.setTemperaturaMaxima(data.path("temperature").path("max").asDouble());

        return previsao;
    }
}