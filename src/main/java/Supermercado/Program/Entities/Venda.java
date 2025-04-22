package Supermercado.Program.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private LocalDateTime dataVenda;
    @OneToMany (mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itemVenda = new ArrayList<>();
    @ManyToOne
    @JoinColumn (name = "Client")
    private Cliente cliente;
private BigDecimal total;



}
