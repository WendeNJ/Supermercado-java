package Supermercado.Program.Controller;

import Supermercado.Program.DTO.ProdutoDTO;
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping (value = "/p")

public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable("id") Integer id) {
        Optional<ProdutoDTO> dto = produtoService.buscarProduto(id);

        return dto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ProdutoDTO> listartodods() {
        return produtoService.listarTodos();
    }


    @PostMapping("/p")
    public ResponseEntity<ProdutoDTO> inserir(@RequestBody ProdutoDTO pDTO) {
        ProdutoDTO salvo = produtoService.inserir(pDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);


    }


    @PutMapping("/{id}")
    public ProdutoDTO alterar(@PathVariable Integer id, @RequestBody Produtos produtos) {
        return produtoService.atualizar(id, produtos)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir( @PathVariable ("id") Integer id){
        produtoService.deletar(id);
        return  ResponseEntity.ok().build();
    }

}