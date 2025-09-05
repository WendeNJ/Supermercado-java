package Supermercado.Program.DTO;

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
