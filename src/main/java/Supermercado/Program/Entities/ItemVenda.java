package Supermercado.Program.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@EqualsAndHashCode
@Entity

public class ItemVenda {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produto;
    private int quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;


}

