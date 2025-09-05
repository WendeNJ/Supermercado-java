package Supermercado.Program.Entities;

<<<<<<< HEAD
import Supermercado.Program.DTO.ItemDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
=======
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4

import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
@Entity
<<<<<<< HEAD
@NoArgsConstructor

@Table(name = "item_venda")
=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4

public class ItemVenda {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
<<<<<<< HEAD
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produto;
    @JsonIgnore
=======
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produto;
    private int quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

<<<<<<< HEAD
    private int quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;

    public BigDecimal getSubtotal(){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));

    }
    public ItemVenda(ItemDTO itemDTO) {
        BeanUtils.copyProperties(itemDTO, this);
    }
}


=======

}

>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
