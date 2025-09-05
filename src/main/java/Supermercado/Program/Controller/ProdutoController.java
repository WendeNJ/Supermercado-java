package Supermercado.Program.Controller;

import Supermercado.Program.DTO.ProdutoDTO;
<<<<<<< HEAD
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
=======
import Supermercado.Program.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4

@RestController
@RequestMapping (value = "/p")

public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

<<<<<<< HEAD
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable("id") Integer id) {
        Optional<ProdutoDTO> dto = produtoService.buscarProduto(id);

        return dto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    @GetMapping
    public List<ProdutoDTO> listartodods() {
        return produtoService.listarTodos();
    }

<<<<<<< HEAD

    @PostMapping("/p")
    public ResponseEntity<ProdutoDTO> inserir(@RequestBody ProdutoDTO pDTO) {
        ProdutoDTO salvo = produtoService.inserir(pDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);


    }


    @PutMapping("/{id}")
    public ProdutoDTO alterar(@PathVariable Integer id, @RequestBody Produtos produtos) {
=======
    @PostMapping
    public void inserir(@RequestBody ProdutoDTO pDTO) {
        produtoService.inserir(pDTO);
    }

    @PutMapping("/{id}")
    public ProdutoDTO alterar(@PathVariable Integer id, @RequestBody ProdutoDTO produtos) {
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
        return produtoService.atualizar(id, produtos)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir( @PathVariable ("id") Integer id){
        produtoService.deletar(id);
        return  ResponseEntity.ok().build();
    }
<<<<<<< HEAD

=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
}