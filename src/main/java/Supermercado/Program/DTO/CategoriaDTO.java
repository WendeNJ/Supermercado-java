package Supermercado.Program.DTO;
import Supermercado.Program.Entities.CategoriaProdutos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
        private Integer id;
        private String nome;
        private String descricao;

        public CategoriaDTO (CategoriaProdutos categoriaProdutos){
            BeanUtils.copyProperties(categoriaProdutos, this);
        }
    }


