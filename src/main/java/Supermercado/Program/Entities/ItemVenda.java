package Supermercado.Program.Entities;

import Supermercado.Program.DTO.ItemDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor

@Table(name = "item_venda")

public class ItemVenda {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produto;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

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


