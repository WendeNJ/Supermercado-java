package Supermercado.Program.Services;

import Supermercado.Program.DTO.EntradaDTO;
import Supermercado.Program.Entities.EntradaEstoque;
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Repository.EntradaRepository;
import Supermercado.Program.Repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<EntradaEstoque> listarTodos() {
        return entradaRepository.findAll();
    }

    public EntradaEstoque buscarPorId(Integer id) {
        return entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada de estoque não encontrada"));
    }

    public EntradaEstoque criar(EntradaDTO dto) {

         {
            if (dto.getQuantidade() <= 0) {
                throw new IllegalArgumentException("Quantidade deve ser maior que zero!");
            }
            if (dto.getPrecoUnidade().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Preço unitário deve ser positivo!");
            }
        }
        Produtos produto = produtosRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        EntradaEstoque entrada = new EntradaEstoque();
        entrada.setProdutos(produto);
        entrada.setQuantidade(dto.getQuantidade());
        entrada.setPrecoUnidade(dto.getPrecoUnidade());
        entrada.setDataEntrada(LocalDateTime.now());
        entrada.setTotal(dto.getPrecoUnidade().multiply(BigDecimal.valueOf(dto.getQuantidade())));



        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + entrada.getQuantidade());
        produto.getEntradaEstoqueList().add(entrada);

        produtosRepository.save(produto);
        return entradaRepository.save(entrada);


    }

    @Transactional
    public EntradaEstoque atualizar(Integer id, EntradaDTO dto) {
        EntradaEstoque entrada = buscarPorId(id);
        Produtos produtoAntigo = entrada.getProdutos();

        Produtos produtoNovo = produtosRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Reverte o estoque do produto antigo (se o produto foi alterado)
        if (!produtoAntigo.equals(produtoNovo)) {
            produtoAntigo.setQuantidadeEstoque(produtoAntigo.getQuantidadeEstoque() - entrada.getQuantidade());
            produtoAntigo.getEntradaEstoqueList().remove(entrada);
            produtosRepository.save(produtoAntigo);
        }

        // Atualiza a entrada
        entrada.setProdutos(produtoNovo);
        entrada.setQuantidade(dto.getQuantidade());
        entrada.setPrecoUnidade(dto.getPrecoUnidade());
        entrada.setTotal(dto.getPrecoUnidade().multiply(BigDecimal.valueOf(dto.getQuantidade())));

        // Atualiza o estoque do novo produto
        produtoNovo.setQuantidadeEstoque(produtoNovo.getQuantidadeEstoque() + entrada.getQuantidade());
        produtoNovo.getEntradaEstoqueList().add(entrada);
        produtosRepository.save(produtoNovo);

        return entradaRepository.save(entrada);
    }
    public void deletar(Integer id) {
        EntradaEstoque entrada = buscarPorId(id);
        Produtos produto = entrada.getProdutos();

        // Reverte o estoque
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - entrada.getQuantidade());
        produto.getEntradaEstoqueList().remove(entrada);

        produtosRepository.save(produto);
        entradaRepository.delete(entrada);
    }
}
