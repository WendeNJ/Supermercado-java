package Supermercado.Program.Services;

import Supermercado.Program.DTO.ClienteDTO;
import Supermercado.Program.Entities.Cliente;
import Supermercado.Program.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // CREATE
    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return new ClienteDTO(clienteSalvo);
    }

    // READ (todos)
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }

    // READ (por id)
    public ClienteDTO buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .map(ClienteDTO::new)
                .orElse(null);
    }

    // UPDATE
    public ClienteDTO atualizar(Integer id, ClienteDTO clienteDTO) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteDTO.getNome());
                    cliente.setCpf(clienteDTO.getCpf());
                    cliente.setEmail(clienteDTO.getEmail());
                    cliente.setTelefone(clienteDTO.getTelefone());
                    Cliente atualizado = clienteRepository.save(cliente);
                    return new ClienteDTO(atualizado);
                })
                .orElse(null);
    }

    // DELETE
    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}

