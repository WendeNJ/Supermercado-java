package Supermercado.Program.Entities;

import Supermercado.Program.DTO.VendaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private LocalDateTime dataVenda;
    @JsonIgnore
    @OneToMany (mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itemVenda = new ArrayList<>();
    @ManyToOne
    @JoinColumn (name = "client_id")
    private Cliente cliente;
    private BigDecimal total;

    public Venda( VendaDTO vendaDTO){
        BeanUtils.copyProperties(vendaDTO,this);
    }

}
