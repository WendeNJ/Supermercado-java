package Supermercado.Program.Services;

import Supermercado.Program.DTO.ProdutoDTO;
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Repository.FornecedorRepository;
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
    @Autowired
    FornecedorRepository fornecedorRepository;

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
        Produtos produto = new Produtos(produtoDTO);


        if (produtoDTO.getFornecedorId() != null) {
            fornecedorRepository.findById(produtoDTO.getFornecedorId())
                    .ifPresent(produto::setFornecedor);
        }

        Produtos produtoSalvo = produtosRepository.save(produto);
        return new ProdutoDTO(produtoSalvo);
    }


    public Optional<ProdutoDTO> atualizar(Integer id, Produtos produtoDTO) {
        return produtosRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoDTO.getNome());
                    produto.setCodigoBarras(produtoDTO.getCodigoBarras());
                    produto.setPreco(produtoDTO.getPreco());
                    produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
                    produto.setValidade(produtoDTO.getValidade());
                    produto.setCategoria(produtoDTO.getCategoria());
                    produto.setFornecedor(produtoDTO.getFornecedor());
                    produto.setDataCadastro(produtoDTO.getDataCadastro());  // Corrigido aqui

                    Produtos produtoAtualizado = produtosRepository.save(produto);
                    return new ProdutoDTO(produtoAtualizado);  // Retorna ProdutoDTO atualizado
                });
    }

    public ProdutoDTO buscarPorId(Integer id) {
        Produtos produtos = produtosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
        return new ProdutoDTO(produtos);
    }


    public void deletar(Integer id) {
        if (!produtosRepository.existsById(id)) {
            throw new IllegalArgumentException("Produto com ID " + id + " não existe.");
        }
        produtosRepository.deleteById(id);
    }
}
