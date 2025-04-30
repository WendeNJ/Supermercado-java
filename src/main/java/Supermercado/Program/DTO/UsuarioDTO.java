package Supermercado.Program.DTO;

import Supermercado.Program.Entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;


    @Getter
    @Setter
    @AllArgsConstructor

    public class UsuarioDTO {
        private Integer id;
        private String nome;
        private String email;
        private Integer senha; // A senha pode vir criptografada, dependendo da situação

      public UsuarioDTO ( Usuario user){
          BeanUtils.copyProperties(user, this);
      }
      public UsuarioDTO(){

      }



        }



