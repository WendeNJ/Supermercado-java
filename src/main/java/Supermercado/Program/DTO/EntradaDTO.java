package Supermercado.Program.DTO;

import Supermercado.Program.Entities.EntradaEstoque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EntradaDTO {
    private Integer id;
    private Integer produtoId;
    private int quantidade;
    private LocalDateTime dataEntrada;
    private BigDecimal precoUnidade;
    private BigDecimal total;


    public EntradaDTO (EntradaEstoque entradaEstoque){
        BeanUtils.copyProperties(entradaEstoque, this);

    }
}

