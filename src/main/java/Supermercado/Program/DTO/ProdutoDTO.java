package Supermercado.Program.DTO;

import Supermercado.Program.Entities.Produtos;
<<<<<<< HEAD
import lombok.Getter;
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
<<<<<<< HEAD

@Getter
@Setter
=======
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private String codigoBarras;
    private Float preco;
    private int quantidadeEstoque;
    private LocalDate validade;
    private String categoria;
<<<<<<< HEAD
    private Integer fornecedorId;
=======
    private String fornecedor;
    private LocalDateTime dataCadastro;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4


    public ProdutoDTO(Produtos prod) {
        BeanUtils.copyProperties(prod, this);

<<<<<<< HEAD

        if (prod.getCategoria() != null) {
            this.categoria = prod.getCategoria().getNome();
        }
        if (prod.getFornecedor() != null) {

            this.fornecedorId = prod.getFornecedor().getId();
        }

    }

    public ProdutoDTO() {
=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    }
}



<<<<<<< HEAD
=======



>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
