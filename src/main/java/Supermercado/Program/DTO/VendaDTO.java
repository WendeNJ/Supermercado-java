package Supermercado.Program.DTO;

<<<<<<< HEAD
import Supermercado.Program.Entities.Venda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private Integer id;
    private LocalDate dataVenda;
    private List<ItemDTO> itemVenda;
    private Integer clienteId;
    private BigDecimal total;

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.dataVenda = LocalDate.from(venda.getDataVenda());
        this.total = venda.getTotal();

        if (venda.getCliente() != null) {
            this.clienteId = venda.getCliente().getId();
        }

        if (venda.getItemVenda() != null) {
            this.itemVenda = venda.getItemVenda().stream()
                    .map(ItemDTO::new)
                    .toList();
        }
    }
}
=======

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

>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
