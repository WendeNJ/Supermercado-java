package Supermercado.Program.Entities;

import Supermercado.Program.DTO.ProdutoDTO;
import jakarta.persistence.*;

import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String codigoBarras;
    private Float preco;
    private int quantidadeEstoque;
    private LocalDate validade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private CategoriaProdutos categoria;

    private String fornecedor;
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "produtos")
    private List<EntradaEstoque> entradaEstoqueList;


    public Produtos(ProdutoDTO produtoDTO) {
        BeanUtils.copyProperties(produtoDTO, this);
        if (produtoDTO.getCategoria() != null) {
            this.categoria = new CategoriaProdutos();
            BeanUtils.copyProperties(produtoDTO.getCategoria(), this.categoria);
        }
        this.dataCadastro = LocalDateTime.now();
    }
}


