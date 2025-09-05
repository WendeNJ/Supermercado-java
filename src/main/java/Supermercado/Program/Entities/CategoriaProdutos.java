package Supermercado.Program.Entities;

import Supermercado.Program.DTO.CategoriaDTO;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

<<<<<<< HEAD
=======
import java.io.Serializable;
import java.util.ArrayList;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
<<<<<<< HEAD
@Table(name = "Categoria_Produtos")

public class CategoriaProdutos {
=======
@Table( name = "CategoriaProdutos")
public class CategoriaProdutos implements Serializable {
    private static final long SerialVersionUID = 1L;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
<<<<<<< HEAD
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Produtos> produtos;

=======
    @OneToMany(mappedBy = "categoria")  // A propriedade no lado do produto que mapeia a relação
    private List<Produtos> produtos = new ArrayList<>();
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
 public CategoriaProdutos (CategoriaDTO categoriaDTO){
     BeanUtils.copyProperties(categoriaDTO, this);
 }
}
