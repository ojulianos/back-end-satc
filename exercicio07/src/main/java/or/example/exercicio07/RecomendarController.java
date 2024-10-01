package or.example.exercicio07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/mundo") //cria um grupo de rotas

public class RecomendarController {

    @GetMapping("/recomendar")
    public String recomendar(
            @RequestParam(value = "") String genero,
            @RequestParam(value = "") String ambiente
    ) {

        String[] suggests = { "Homens de Preto", "Arrival", "Shrek", "Gladiador" };
        String[] questions = { "Pergunta 1: Que ambientação você prefere?", "Pergunta 2: Que gênero você prefere?" };
        String[][] options = { {"  1. Sci-fi", "  2. Medieval"}, {"  1. Comédia", "  2. Drama"} };
        String response;

        if (genero.isEmpty()) {
            return "Que ambientação você prefere? 1. Sci-fi; 2. Medieval";
        }

        if (ambiente.isEmpty()) {
            return "Que gênero você prefere? 1. Comédia; 2. Drama";
        }

        response = ambiente+genero;
        if (!response.matches("(11|12|21|22)")) {
            return "Resposta inválida " + response;
        }

        switch (response) {
            case "11": response = suggests[0]; break;
            case "12": response = suggests[1]; break;
            case "21": response = suggests[2]; break;
            case "22": response = suggests[3]; break;
        }

        return "Recomendação: " + response;
    }
}
