package Supermercado.Program.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

    @Getter
    @Setter
    public class ItemDTO {
        private Integer id;
        private Integer produtoId;
        private int quantidade;
        private BigDecimal precoUnitario;
        private BigDecimal subtotal;
    }

