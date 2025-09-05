package Supermercado.Program.Entities;

import Supermercado.Program.DTO.EntradaEstoqueDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produtos produto;

    private int quantidade;
    private LocalDate dataEntrada;



    @PrePersist
    public void atualizarEstoque() {
        this.dataEntrada = LocalDate.now();
    }
    public EntradaEstoque (EntradaEstoqueDTO entradaEstoqueDTO){
        BeanUtils.copyProperties(entradaEstoqueDTO, this);
    }
}