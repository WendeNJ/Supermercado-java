package Supermercado.Program.Services;

import Supermercado.Program.DTO.CategoriaDTO;
import Supermercado.Program.Entities.CategoriaProdutos;
import Supermercado.Program.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> listaTodos() {
        List<CategoriaProdutos> CategoriaProdutos = categoriaRepository.findAll();
        return CategoriaProdutos.stream()
                .map(CategoriaDTO::new)
                .collect(Collectors.toList());
    }

    public void inserir(CategoriaDTO categoriaDTO) {
        CategoriaProdutos categoriaProdutos = new CategoriaProdutos(categoriaDTO);

        categoriaRepository.save(categoriaProdutos);
    }

    public CategoriaDTO buscarPorId(Integer id) {
        CategoriaProdutos categoriaProdutos = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria nao encontrada por ID: " + id));
        return new CategoriaDTO(categoriaProdutos);
    }
    public void excluir(Integer id) {
        CategoriaProdutos categoriaProdutos = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com ID: " + id));
        categoriaRepository.delete(categoriaProdutos);

    }
    public CategoriaDTO alterar(Integer id, CategoriaDTO categoriaDTO) {

        CategoriaProdutos categoriaProdutos = categoriaRepository.findById(categoriaDTO.getId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));


        categoriaProdutos.setNome(categoriaDTO.getNome());
        categoriaProdutos.setDescricao(categoriaDTO.getDescricao());


        categoriaProdutos = categoriaRepository.save(categoriaProdutos);


        return new CategoriaDTO(categoriaProdutos);
    }


}


