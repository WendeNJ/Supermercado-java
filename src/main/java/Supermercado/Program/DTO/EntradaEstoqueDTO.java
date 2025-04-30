package Supermercado.Program.DTO;

import Supermercado.Program.Entities.EntradaEstoque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaEstoqueDTO {
    private Integer produtoId;
    private int quantidade;

    public EntradaEstoqueDTO (EntradaEstoque entradaEstoque){
        BeanUtils.copyProperties(entradaEstoque,this);
    }
}