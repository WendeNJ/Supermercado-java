package Supermercado.Program.Controller;

import Supermercado.Program.DTO.ProdutoDTO;
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
@RequestMapping (value = "/p")

public class ProdutoController {
    @Configuration
    public class CorsConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE");
        }
    }
    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public List<ProdutoDTO> listartodods() {
        return produtoService.listarTodos();
    }

    @PostMapping("/p")
    public void inserir(@RequestBody ProdutoDTO pDTO) {
        produtoService.inserir(pDTO);
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