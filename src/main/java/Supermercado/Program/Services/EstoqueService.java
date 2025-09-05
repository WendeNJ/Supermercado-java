package Supermercado.Program.Services;

import Supermercado.Program.DTO.EntradaEstoqueDTO;
import Supermercado.Program.Entities.EntradaEstoque;
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Repository.EntradaEstoqueRepository;
import Supermercado.Program.Repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    private final EntradaEstoqueRepository entradaEstoqueRepository;
    private final ProdutosRepository produtosRepository;

    @Autowired
    public EstoqueService(EntradaEstoqueRepository entradaEstoqueRepository,
                          ProdutosRepository produtosRepository) {
        this.entradaEstoqueRepository = entradaEstoqueRepository;
        this.produtosRepository = produtosRepository;
    }

    @Transactional
    public void registrarEntrada(EntradaEstoqueDTO dto) {

        Produtos produto = produtosRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));


        EntradaEstoque entrada = new EntradaEstoque();
        entrada.setProduto(produto);
        entrada.setQuantidade(dto.getQuantidade());


        produto.atualizarEstoque(dto.getQuantidade()); // Método na entidade Produto
        if (produto.getQuantidadeEstoque() < 0) {
            throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa.");
        }


        entradaEstoqueRepository.save(entrada);
    }
    }