package Supermercado.Program.Services;

import Supermercado.Program.DTO.FornecedorDTO;

import Supermercado.Program.Entities.Fornecedor;
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;


    public List<FornecedorDTO> listarTodos() {
        List<Fornecedor> fornecedor = fornecedorRepository.findAll();
        return fornecedor.stream()
                .map(FornecedorDTO::new)
                .collect(Collectors.toList());
    }

    public void inserir(FornecedorDTO fornecedor) {
        Fornecedor fornecedor1 = new Fornecedor(fornecedor);
        fornecedorRepository.save(fornecedor1);

    }

    public FornecedorDTO alterar(FornecedorDTO fornecedor) {
        Fornecedor fornecedor1 = new Fornecedor(fornecedor);
        return new FornecedorDTO(fornecedorRepository.save(fornecedor1));
    }

    public void excluir(Integer id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com ID: " + id));
        fornecedorRepository.delete(fornecedor);
    }

    public FornecedorDTO buscarPorId(Integer id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com ID: " + id));
        return new FornecedorDTO(fornecedor);
    }

}



