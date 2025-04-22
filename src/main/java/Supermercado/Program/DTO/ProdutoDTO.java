package Supermercado.Program.DTO;

import Supermercado.Program.Entities.Produtos;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private String codigoBarras;
    private Float preco;
    private int quantidadeEstoque;
    private LocalDate validade;
    private String categoria;  // Representação da categoria como String
    private String fornecedor;
    private LocalDateTime dataCadastro;


    public ProdutoDTO(Produtos prod) {
        BeanUtils.copyProperties(prod, this);


        if (prod.getCategoria() != null) {
            this.categoria = prod.getCategoria().getNome();
        }
    }

    public ProdutoDTO() {
    }
}



