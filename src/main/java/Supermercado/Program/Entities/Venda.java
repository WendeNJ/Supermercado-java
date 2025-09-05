package Supermercado.Program.Entities;

<<<<<<< HEAD
import Supermercado.Program.DTO.VendaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
=======
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
@Getter
@Setter
@EqualsAndHashCode
@Entity
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
public class Venda implements Serializable {
=======
public class Venda {
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private LocalDateTime dataVenda;
<<<<<<< HEAD
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
=======
    @OneToMany (mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itemVenda = new ArrayList<>();
    @ManyToOne
    @JoinColumn (name = "Client")
    private Cliente cliente;
private BigDecimal total;


>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4

}
