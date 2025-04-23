package Supermercado.Program.DTO;

import Supermercado.Program.Entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    public ClienteDTO ( Cliente cliente){
        BeanUtils.copyProperties(cliente, this);
    }
}
