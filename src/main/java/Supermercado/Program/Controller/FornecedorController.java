package Supermercado.Program.Controller;

import Supermercado.Program.DTO.FornecedorDTO;
import Supermercado.Program.Services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fornecedores")

public class FornecedorController {
    @Autowired

    private FornecedorService fornecedorService;
    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> buscarPorId(@PathVariable("id") Integer id) {
        FornecedorDTO dto = fornecedorService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<FornecedorDTO > ListarTodos(){
        return fornecedorService.listarTodos();
    }
    @PostMapping
    public ResponseEntity<FornecedorDTO> inserir (@RequestBody FornecedorDTO fornecedorDTO){
        fornecedorService.inserir(fornecedorDTO);
        return ResponseEntity.status(201).body(fornecedorDTO);
    }
    @PutMapping
    public FornecedorDTO alterar ( @RequestBody  FornecedorDTO fornecedorDTO){
        return fornecedorService.alterar(fornecedorDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir ( @PathVariable ("id") Integer id){
        fornecedorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
