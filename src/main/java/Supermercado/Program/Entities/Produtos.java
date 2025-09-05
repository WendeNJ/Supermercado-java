package Supermercado.Program.Entities;

import Supermercado.Program.DTO.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "product")
public class Produtos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique=true)
    private String codigoBarras;
    private Float preco;
    private int quantidadeEstoque;
    private LocalDate validade;


    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Categoria_id")
    private CategoriaProdutos categoria;


    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    private LocalDateTime dataCadastro;
    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<EntradaEstoque> entradaEstoqueList;
    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<ItemVenda> itensVenda;
    public void atualizarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    public Produtos(ProdutoDTO produtoDTO) {
        BeanUtils.copyProperties(produtoDTO, this);


        if (produtoDTO.getCategoria() != null) {
            this.categoria = new CategoriaProdutos();
            BeanUtils.copyProperties(produtoDTO.getCategoria(), this.categoria);
        }


        this.dataCadastro = LocalDateTime.now();
    }

    public Produtos() {

    }
}


