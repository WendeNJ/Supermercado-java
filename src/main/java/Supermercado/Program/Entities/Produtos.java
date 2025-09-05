package Supermercado.Program.Entities;

import Supermercado.Program.DTO.ProdutoDTO;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
=======
import jakarta.persistence.*;

import lombok.*;
import org.springframework.beans.BeanUtils;

>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
<<<<<<< HEAD
@Entity
@Table(name = "product")
public class Produtos implements Serializable {

=======
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Produtos {
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
<<<<<<< HEAD
    @Column(unique=true)
=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    private String codigoBarras;
    private Float preco;
    private int quantidadeEstoque;
    private LocalDate validade;

<<<<<<< HEAD

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


=======
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private CategoriaProdutos categoria;

    private String fornecedor;
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "produtos")
    private List<EntradaEstoque> entradaEstoqueList;


    public Produtos(ProdutoDTO produtoDTO) {
        BeanUtils.copyProperties(produtoDTO, this);
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
        if (produtoDTO.getCategoria() != null) {
            this.categoria = new CategoriaProdutos();
            BeanUtils.copyProperties(produtoDTO.getCategoria(), this.categoria);
        }
<<<<<<< HEAD


        this.dataCadastro = LocalDateTime.now();
    }

    public Produtos() {

    }
=======
        this.dataCadastro = LocalDateTime.now();
    }
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
}


