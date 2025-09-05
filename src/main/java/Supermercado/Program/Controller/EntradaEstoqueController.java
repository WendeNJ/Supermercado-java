package Supermercado.Program.Controller;

import Supermercado.Program.DTO.EntradaDTO;
import Supermercado.Program.Entities.EntradaEstoque;
import Supermercado.Program.Services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrada-estoque")
public class EntradaEstoqueController {

    @Autowired
    private EntradaService entradaService;


    @GetMapping
    public ResponseEntity<List<EntradaEstoque>> listarTodos() {
        List<EntradaEstoque> entradas = entradaService.listarTodos();
        return ResponseEntity.ok(entradas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EntradaEstoque> buscarPorId(@PathVariable Integer id) {
        EntradaEstoque entrada = entradaService.buscarPorId(id);
        return ResponseEntity.ok(entrada);
    }

    @PostMapping
    public ResponseEntity<EntradaEstoque> criar(@RequestBody EntradaDTO dto) {
        EntradaEstoque entrada = entradaService.criar(dto);
        return new ResponseEntity<>(entrada, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EntradaEstoque> atualizar(@PathVariable Integer id, @RequestBody EntradaDTO dto) {
        EntradaEstoque entradaAtualizada = entradaService.atualizar(id, dto);
        return ResponseEntity.ok(entradaAtualizada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        entradaService.deletar(id);
        return ResponseEntity.noContent().build(); //
    }
}
