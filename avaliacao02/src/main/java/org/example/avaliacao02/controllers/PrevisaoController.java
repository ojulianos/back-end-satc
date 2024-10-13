package org.example.avaliacao02.controllers;

import org.example.avaliacao02.models.Previsao;
import org.example.avaliacao02.services.ClimaTempoService;
import org.example.avaliacao02.services.WeatherAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/previsao")
public class PrevisaoController {

    @Autowired
    private ClimaTempoService climaTempoService;

    @Autowired
    private WeatherAPIService weatherAPIService;

    @GetMapping("/climatempo/{cidadeNome}/{estadoNome}")
    public ResponseEntity<?> getPrevisaoClimatempo(@PathVariable String cidadeNome, @PathVariable String estadoNome) {
        if (cidadeNome == null || cidadeNome.isEmpty()) {
            return ResponseEntity.badRequest().body("O parâmetro 'cidadeNome' é obrigatório.");
        }
        if (estadoNome == null || estadoNome.isEmpty()) {
            return ResponseEntity.badRequest().body("O parâmetro 'estadoNome' é obrigatório.");
        }

        try {
            Previsao previsao = climaTempoService.obterPrevisaoPorCidadeEstado(cidadeNome, estadoNome);
            return ResponseEntity.ok(previsao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao obter dados da ClimaTempo: " + e.getMessage());
        }
    }

    @GetMapping("/weatherapi/{cidadeNome}")
    public ResponseEntity<?> getPrevisaoWeatherAPI(@PathVariable String cidadeNome) {
        if (cidadeNome == null || cidadeNome.isEmpty()) {
            return ResponseEntity.badRequest().body("O parâmetro 'cidadeNome' é obrigatório.");
        }

        try {
            Previsao previsao = weatherAPIService.obterPrevisao(cidadeNome);
            return ResponseEntity.ok(previsao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao obter dados da WeatherAPI: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> postPrevisao(@RequestBody Previsao dados) {
        Map<String, Object> response = new HashMap<>();

        if (dados.getCidade() == null || dados.getEstado() == null) {
            response.put("erro", "JSON deve conter 'cidade' e 'estado'");
            return ResponseEntity.badRequest().body(response);
        }

        try {
            Previsao previsaoWeatherAPI = weatherAPIService.obterPrevisao(dados.getCidade());
            response.put("WeatherAPI", previsaoWeatherAPI);
        } catch (Exception e) {
            response.put("WeatherAPI", "Falha ao obter dados da WeatherAPI");
        }

        try {
            Previsao previsaoClimaTempo = climaTempoService.obterPrevisaoPorCidadeEstado(dados.getCidade(), dados.getEstado());
            response.put("ClimaTempo", previsaoClimaTempo);
        } catch (Exception e) {
            response.put("ClimaTempo", "Falha ao obter dados da ClimaTempo");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/sobre")
    public Map<String, String> getSobre() {
        Map<String, String> sobre = new HashMap<>();
        sobre.put("estudante", "Juliano Silva");
        sobre.put("projeto", "Servico de Meteorologia");
        return sobre;
    }
}
