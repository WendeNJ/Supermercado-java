package Supermercado.Program.Entities;

import Supermercado.Program.DTO.ProdutoDTO;
import Supermercado.Program.DTO.UsuarioDTO;
import Supermercado.Program.Enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private Integer senha;


    public Usuario (UsuarioDTO usuDTO) {
        BeanUtils.copyProperties(usuDTO, this);
    }

    }
