package Supermercado.Program.Entities;

import Supermercado.Program.DTO.FornecedorDTO;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.List;

=======
import java.time.LocalDateTime;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private LocalDate dataCadastro;

<<<<<<< HEAD
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Produtos> produtos;

=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
    public Fornecedor (FornecedorDTO fornecedorDTO){
        BeanUtils.copyProperties(fornecedorDTO, this);
    }
}
