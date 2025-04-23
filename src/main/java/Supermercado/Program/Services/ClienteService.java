package Supermercado.Program.Services;


import Supermercado.Program.DTO.ClienteDTO;

import Supermercado.Program.DTO.FornecedorDTO;
import Supermercado.Program.Entities.Cliente;
import Supermercado.Program.Entities.Fornecedor;
import Supermercado.Program.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(ClienteDTO::new).orElse(null);
    }

    public void inserir(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        clienteRepository.save(cliente);

    }
    public ClienteDTO alterar(Integer id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());

        cliente = clienteRepository.save(cliente);

        return new ClienteDTO(cliente);
    }



    public void excluir(Integer id) {
         Cliente clientes  = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("CLiente não encontrado com ID: " + id));clienteRepository.delete(clientes);

    }
}






