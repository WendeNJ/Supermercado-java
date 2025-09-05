package Supermercado.Program.Entities;

import Supermercado.Program.DTO.CategoriaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categoria_Produtos")

public class CategoriaProdutos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Produtos> produtos;

 public CategoriaProdutos (CategoriaDTO categoriaDTO){
     BeanUtils.copyProperties(categoriaDTO, this);
 }
}
