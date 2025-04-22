package Supermercado.Program.DTO;

import Supermercado.Program.Entities.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FornecedorDTO {
    private Integer id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private LocalDate dataCadastro;

    public FornecedorDTO ( Fornecedor fornecedor){
        BeanUtils.copyProperties(fornecedor, this);
    }
}
