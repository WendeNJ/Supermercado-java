package Supermercado.Program.Services;

import Supermercado.Program.DTO.ItemDTO;
import Supermercado.Program.DTO.VendaDTO;
import Supermercado.Program.Entities.Cliente;
import Supermercado.Program.Entities.ItemVenda;
import Supermercado.Program.Entities.Produtos;
import Supermercado.Program.Entities.Venda;
import Supermercado.Program.Repository.ClienteRepository;
import Supermercado.Program.Repository.ProdutosRepository;
import Supermercado.Program.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public VendaDTO realizarVenda(VendaDTO vendaDTO) {
        Venda venda = new Venda();

        // Busca cliente
        Cliente cliente = clienteRepository.findById(vendaDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + vendaDTO.getClienteId()));
        venda.setCliente(cliente);

        venda.setDataVenda(LocalDateTime.now());

        AtomicReference<BigDecimal> total = new AtomicReference<>(BigDecimal.ZERO);

        List<ItemVenda> itens = vendaDTO.getItemVenda().stream().map(itemDTO -> {
            Produtos produto = produtosRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + itemDTO.getProdutoId()));

            ItemVenda item = new ItemVenda();
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPrecoUnitario(BigDecimal.valueOf(produto.getPreco()));
            item.setSubtotal(item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
            item.setVenda(venda);

            // Soma subtotal ao total
            total.updateAndGet(v -> v.add(item.getSubtotal()));

            // Atualiza o estoque
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());
            produtosRepository.save(produto);

            return item;
        }).collect(Collectors.toList());

        venda.setItemVenda(itens);
        venda.setTotal(total.get());


        Venda vendaSalva = vendaRepository.save(venda);
        return new VendaDTO(vendaSalva);
    }

    public List<VendaDTO> listarVendas() {
        return vendaRepository.findAll().stream().map(VendaDTO::new).collect(Collectors.toList());
    }

    public Optional<VendaDTO> buscarPorId(Integer id) {
        return vendaRepository.findById(id).map(VendaDTO::new);
    }

    public void deletarVenda(Integer id) {
        vendaRepository.deleteById(id);
    }
}
