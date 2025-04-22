package Supermercado.Program.Controller;

import Supermercado.Program.DTO.CategoriaDTO;
import Supermercado.Program.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarTodos() {
        List<CategoriaDTO> categorias = categoriaService.listaTodos();
        return ResponseEntity.ok(categorias);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Integer id) {
        CategoriaDTO categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.ok(categoria);
    }


    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.inserir(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        categoriaService.excluir(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> alterar(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO categoriaAlterada = categoriaService.alterar(id, categoriaDTO);
        return ResponseEntity.ok(categoriaAlterada);
    }
}

