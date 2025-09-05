package Supermercado.Program.Services;

import Supermercado.Program.DTO.ItemDTO;
import Supermercado.Program.Entities.ItemVenda;
import Supermercado.Program.Repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;



    public List<ItemDTO> ListarTodos() {
        List<ItemVenda> itemVendas = itemVendaRepository.findAll();
        return itemVendas.stream().map(ItemDTO::new).toList();
    }

    public void inserir( ItemDTO itemDTO){
        ItemVenda itemVenda = new ItemVenda(itemDTO);
        itemVendaRepository.save(itemVenda);
    }
    public ItemDTO alterar ( ItemDTO itemDTO){
        ItemVenda itemVenda = new ItemVenda(itemDTO);
        return new ItemDTO(itemVendaRepository.save(null));
    }
    public void excluir ( Integer id){
        ItemVenda itemVenda = itemVendaRepository.findById(id).get();
        itemVendaRepository.delete(itemVenda);
    }
}