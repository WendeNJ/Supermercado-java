package Supermercado.Program.Controller;

import Supermercado.Program.DTO.EntradaEstoqueDTO;
import Supermercado.Program.Services.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    public ResponseEntity<String> registrarEntrada(@RequestBody EntradaEstoqueDTO dto) {
        estoqueService.registrarEntrada(dto);
        return ResponseEntity.ok("Entrada de estoque registrada com sucesso");
    }
}