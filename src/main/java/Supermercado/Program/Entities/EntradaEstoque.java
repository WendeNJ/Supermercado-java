package Supermercado.Program.Entities;

<<<<<<< HEAD
import Supermercado.Program.DTO.EntradaEstoqueDTO;
=======
import Supermercado.Program.DTO.EntradaDTO;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

<<<<<<< HEAD
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
=======
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

>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    }
}