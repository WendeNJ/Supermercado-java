package Supermercado.Program.Services;

import Supermercado.Program.DTO.ProdutoDTO;
import Supermercado.Program.Entities.CategoriaProdutos;
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Repository.CategoriaRepository;
import Supermercado.Program.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<ProdutoDTO> listarTodos() {
        List<Produtos> produtos = produtosRepository.findAll();
        return produtos.stream()
                .map(ProdutoDTO::new)  // Converte Produto para ProdutoDTO
                .collect(Collectors.toList());
    }


    public Optional<ProdutoDTO> buscarProduto(Integer id) {
        Optional<Produtos> produto = produtosRepository.findById(id);
        return produto.map(ProdutoDTO::new);  // Converte Produto para ProdutoDTO
    }


    public ProdutoDTO inserir(ProdutoDTO produtoDTO) {
        Produtos produto = new Produtos(produtoDTO);  // Converte ProdutoDTO para Produto
        Produtos produtoSalvo = produtosRepository.save(produto);
        return new ProdutoDTO(produtoSalvo);  // Retorna ProdutoDTO após a inserção
    }


    public Optional<ProdutoDTO> atualizar(Integer id, ProdutoDTO produtoDTO) {
        return produtosRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoDTO.getNome());
                    produto.setCodigoBarras(produtoDTO.getCodigoBarras());
                    produto.setPreco(produtoDTO.getPreco());
                    produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
                    produto.setValidade(produtoDTO.getValidade());




                    produto.setFornecedor(produtoDTO.getFornecedor());
                    produto.setDataCadastro(produtoDTO.getDataCadastro());

                    Produtos produtoAtualizado = produtosRepository.save(produto);
                    return new ProdutoDTO(produtoAtualizado);
                });
    }


    public void deletar(Integer id) {
        produtosRepository.deleteById(id);
    }
}
