package Supermercado.Program.Controller;

import Supermercado.Program.DTO.VendaDTO;
import Supermercado.Program.Services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    // POST - Criar nova venda
    @PostMapping
    public ResponseEntity<VendaDTO> realizarVenda(@RequestBody VendaDTO vendaDTO) {
        VendaDTO novaVenda = vendaService.realizarVenda(vendaDTO);
        return ResponseEntity.ok(novaVenda);
    }

    // GET - Listar todas as vendas
    @GetMapping
    public ResponseEntity<List<VendaDTO>> listarVendas() {
        return ResponseEntity.ok(vendaService.listarVendas());
    }

    // GET - Buscar venda por ID
    @GetMapping("/{id}")
    public ResponseEntity<VendaDTO> buscarPorId(@PathVariable Integer id) {
        return vendaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Deletar venda por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Integer id) {
        vendaService.deletarVenda(id);
        return ResponseEntity.noContent().build();
    }
}
