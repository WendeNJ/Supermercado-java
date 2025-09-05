package Supermercado.Program.DTO;

import Supermercado.Program.Entities.Produtos;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Getter
@Setter
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private String codigoBarras;
    private Float preco;
    private int quantidadeEstoque;
    private LocalDate validade;
    private String categoria;
    private Integer fornecedorId;


    public ProdutoDTO(Produtos prod) {
        BeanUtils.copyProperties(prod, this);


        if (prod.getCategoria() != null) {
            this.categoria = prod.getCategoria().getNome();
        }
        if (prod.getFornecedor() != null) {

            this.fornecedorId = prod.getFornecedor().getId();
        }

    }

    public ProdutoDTO() {
    }
}



