package Supermercado.Program.Entities;

import Supermercado.Program.DTO.EntradaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EntradaEstoque implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produtos;
    private int quantidade;
    private LocalDateTime dataEntrada;
    private BigDecimal precoUnidade;
    private BigDecimal total;

    public EntradaEstoque (EntradaDTO entradaDTO){
        BeanUtils.copyProperties(entradaDTO, this);

    }
}