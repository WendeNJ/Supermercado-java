package Supermercado.Program.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter

public class EntradaDTO {
    private Integer id;
    private Integer produtoId;
    private int quantidade;
    private LocalDateTime dataEntrada;
    private BigDecimal precoUnidade;
    private BigDecimal total;
}

