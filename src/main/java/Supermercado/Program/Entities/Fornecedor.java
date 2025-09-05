package Supermercado.Program.Entities;

import Supermercado.Program.DTO.FornecedorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Produtos> produtos;

    public Fornecedor (FornecedorDTO fornecedorDTO){
        BeanUtils.copyProperties(fornecedorDTO, this);
    }
}
