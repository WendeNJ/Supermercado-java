package Supermercado.Program.Entities;

<<<<<<< HEAD
import Supermercado.Program.DTO.ClienteDTO;
=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
<<<<<<< HEAD
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
=======

import java.time.LocalDateTime;
import Supermercado.Program.DTO.ClienteDTO;
import org.springframework.beans.BeanUtils;

>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD

=======
@Getter
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
<<<<<<< HEAD
    private String cpf;
    private String email;
    private String telefone;

    public Cliente(ClienteDTO clienteDTO) {
        BeanUtils.copyProperties(clienteDTO, this);

    }
}
=======
    private String email;
    private String telefone;

public Cliente ( ClienteDTO clienteDTO ){
    BeanUtils.copyProperties(clienteDTO, this);

}
}
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
