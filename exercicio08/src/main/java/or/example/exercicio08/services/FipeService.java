package or.example.exercicio08.services;

import or.example.exercicio08.models.ModeloDisponivel;
import or.example.exercicio08.models.ValorFipeResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

@Service
public class FipeService {

    private static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/carros";
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    public FipeService() {
        this.restTemplate = new RestTemplate();
        this.mapper = new ObjectMapper();
    }

    public String buscarMarcaId(String marca) throws Exception {
        String url = BASE_URL + "/marcas";
        JsonNode root = fazerRequisicaoHttp(url);

        for (JsonNode node : root) {
            if (node.path("nome").asText().equalsIgnoreCase(marca)) {
                return node.path("codigo").asText();
            }
        }
        return null;
    }

    public List<ModeloDisponivel> buscarModelos(String marcaId) throws Exception {
        String url = BASE_URL + "/marcas/" + marcaId + "/modelos";
        JsonNode root = fazerRequisicaoHttp(url).path("modelos");

        List<ModeloDisponivel> modelos = new ArrayList<>();
        for (JsonNode node : root) {
            String nomeModelo = node.path("nome").asText();
            String codigoModelo = node.path("codigo").asText();
            List<Integer> anosDisponiveis = buscarAnosDisponiveis(marcaId, codigoModelo);
            modelos.add(new ModeloDisponivel(nomeModelo, codigoModelo, anosDisponiveis));
        }
        return modelos;
    }

    public String buscarModeloId(String marcaId, String modelo) throws Exception {
        String url = BASE_URL + "/marcas/" + marcaId + "/modelos";
        JsonNode root = fazerRequisicaoHttp(url).path("modelos");

        for (JsonNode node : root) {
            if (node.path("nome").asText().equalsIgnoreCase(modelo)) {
                return node.path("codigo").asText();
            }
        }

        // Se o modelo não for encontrado, retornar null
        return null;
    }

    public List<Integer> buscarAnosDisponiveis(String marcaId, String modeloId) throws Exception {
        String url = BASE_URL + "/marcas/" + marcaId + "/modelos/" + modeloId + "/anos";
        JsonNode root = fazerRequisicaoHttp(url);

        List<Integer> anos = new ArrayList<>();
        for (JsonNode node : root) {
            anos.add(node.path("codigo").asInt());
        }
        return anos;
    }

    public Object buscarValorFipe(String marcaId, String modeloId, int ano) throws Exception {
        String url = BASE_URL + "/marcas/" + marcaId + "/modelos/" + modeloId + "/anos/" + ano + "-1";
        JsonNode root;

        try {
            root = fazerRequisicaoHttp(url);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                throw new Exception("Erro ao processar a requisição: formato de ano esperado é AAAA-1");
            } else {
                throw e;
            }
        }

        if (root.has("Valor") && root.has("MesReferencia")) {
            String valor = root.path("Valor").asText();
            String mes = root.path("MesReferencia").asText();
            return new ValorFipeResponse(valor, mes);
        } else {
            // Se não encontrar o valor, retornar a lista de anos disponíveis
            return buscarAnosDisponiveis(marcaId, modeloId);
        }
    }

    private JsonNode fazerRequisicaoHttp(String url) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // headers.set("X-Subscription-Token", "");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        return mapper.readTree(response.getBody());
    }

}
