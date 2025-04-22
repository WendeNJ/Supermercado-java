package Supermercado.Program.DTO;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

    @Getter
    @Setter
    public class VendaDTO {
        private Integer id;
        private LocalDateTime dataVenda;
        private List<ItemDTO> itensVenda;
        private Integer clienteId;
        private BigDecimal total;

    }

