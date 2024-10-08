package or.example.exercicio08.controllers;

import or.example.exercicio08.models.Carro;
import or.example.exercicio08.models.ModeloDisponivel;
import or.example.exercicio08.models.ValorFipeResponse;
import or.example.exercicio08.services.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    @Autowired
    private FipeService fipeService;

    @PostMapping("/valor")
    public ResponseEntity<?> getValorFipe(@RequestBody Carro carro) throws Exception {
        String marcaId = fipeService.buscarMarcaId(carro.getMarca());
        if (marcaId == null) {
            return ResponseEntity.badRequest().body(new ValorFipeResponse("0", "Marca não encontrada"));
        }

        String modeloId = fipeService.buscarModeloId(marcaId, carro.getModelo());
        if (modeloId == null) {
            List<ModeloDisponivel> modelosDisponiveis = fipeService.buscarModelos(marcaId);
            return ResponseEntity.badRequest().body(modelosDisponiveis);
        }

        Object resultado = fipeService.buscarValorFipe(marcaId, modeloId, carro.getAno());
        if (resultado instanceof ValorFipeResponse) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body(resultado);
        }
    }

}