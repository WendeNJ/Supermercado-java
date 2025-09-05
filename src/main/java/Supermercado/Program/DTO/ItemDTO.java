package Supermercado.Program.DTO;

import Supermercado.Program.Entities.ItemVenda;
import Supermercado.Program.Entities.Produtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class ItemDTO {
        private Integer id;
        private Integer produtoId;
        private int quantidade;
        private BigDecimal precoUnitario;
        private BigDecimal subtotal;

        public ItemDTO(ItemVenda itemVenda) {
            BeanUtils.copyProperties(itemVenda, this);
        }
    }

