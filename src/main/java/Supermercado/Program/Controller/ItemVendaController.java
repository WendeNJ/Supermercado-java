package Supermercado.Program.Controller;

import Supermercado.Program.DTO.ItemDTO;
import Supermercado.Program.Services.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item-venda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    // Listar todos
    @GetMapping
    public ResponseEntity<List<ItemDTO>> listarTodos() {
        return ResponseEntity.ok(itemVendaService.ListarTodos());
    }

    // Inserir novo item
    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody ItemDTO itemDTO) {
        itemVendaService.inserir(itemDTO);
        return ResponseEntity.ok().build();
    }

    // Alterar item
    @PutMapping
    public ResponseEntity<ItemDTO> alterar(@RequestBody ItemDTO itemDTO) {
        ItemDTO atualizado = itemVendaService.alterar(itemDTO);
        return ResponseEntity.ok(atualizado);
    }

    // Excluir por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        itemVendaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
