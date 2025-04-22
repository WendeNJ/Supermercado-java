package Supermercado.Program.Entities;

import Supermercado.Program.DTO.CategoriaDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "CategoriaProdutos")
public class CategoriaProdutos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;

 public CategoriaProdutos (CategoriaDTO categoriaDTO){
     BeanUtils.copyProperties(categoriaDTO, this);
 }
}
