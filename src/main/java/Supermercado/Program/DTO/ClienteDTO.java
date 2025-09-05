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
<<<<<<< HEAD

public class ClienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    public ClienteDTO ( Cliente cliente) {
        BeanUtils.copyProperties(cliente, this);
}

=======
public class ClienteDTO {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    public ClienteDTO ( Cliente cliente){
        BeanUtils.copyProperties(cliente, this);
    }
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
}
