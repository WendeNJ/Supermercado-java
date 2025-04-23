package Supermercado.Program.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import Supermercado.Program.DTO.ClienteDTO;
import org.springframework.beans.BeanUtils;

@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;

public Cliente ( ClienteDTO clienteDTO ){
    BeanUtils.copyProperties(clienteDTO, this);

}
}
