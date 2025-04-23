package Supermercado.Program.DTO;

import Supermercado.Program.Entities.Produtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private String codigoBarras;
    private Float preco;
    private int quantidadeEstoque;
    private LocalDate validade;
    private String categoria;
    private String fornecedor;
    private LocalDateTime dataCadastro;


    public ProdutoDTO(Produtos prod) {
        BeanUtils.copyProperties(prod, this);

    }
}






