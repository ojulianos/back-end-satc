package br.com.ojulianos.exemplo_semana05;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/mundo") //cria um grupo de rotas

public class OlaController {

    @GetMapping("/ola")
    public String olaMundo(
            @RequestParam String aluno,
            @RequestParam(value = "") String sobrenome
            ) {
        // uso de query string
        return "Ola " +aluno+"!";
//        return "Ola Mundo";
    }
}
