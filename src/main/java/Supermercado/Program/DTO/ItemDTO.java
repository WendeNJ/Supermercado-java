package Supermercado.Program.DTO;

<<<<<<< HEAD
import Supermercado.Program.Entities.ItemVenda;
import Supermercado.Program.Entities.Produtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4

import java.math.BigDecimal;

    @Getter
    @Setter
<<<<<<< HEAD
    @AllArgsConstructor
    @NoArgsConstructor
=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    public class ItemDTO {
        private Integer id;
        private Integer produtoId;
        private int quantidade;
        private BigDecimal precoUnitario;
        private BigDecimal subtotal;
<<<<<<< HEAD

        public ItemDTO(ItemVenda itemVenda) {
            BeanUtils.copyProperties(itemVenda, this);
        }
=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    }

