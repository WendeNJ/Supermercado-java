package Supermercado.Program.Entities;

import Supermercado.Program.DTO.CategoriaDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "CategoriaProdutos")
public class CategoriaProdutos implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "categoria")  // A propriedade no lado do produto que mapeia a relação
    private List<Produtos> produtos = new ArrayList<>();
 public CategoriaProdutos (CategoriaDTO categoriaDTO){
     BeanUtils.copyProperties(categoriaDTO, this);
 }
}
