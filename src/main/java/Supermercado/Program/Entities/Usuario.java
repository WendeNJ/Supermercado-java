package Supermercado.Program.Entities;

import Supermercado.Program.DTO.ProdutoDTO;
import Supermercado.Program.DTO.UsuarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String tipoDoUsuario;
    public Usuario (UsuarioDTO usuDTO) {
        BeanUtils.copyProperties(usuDTO, this);
    }

    }
