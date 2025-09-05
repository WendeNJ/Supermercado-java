package Supermercado.Program.Services;

<<<<<<< HEAD
import Supermercado.Program.DTO.ClienteDTO;
import Supermercado.Program.Entities.Cliente;
=======

import Supermercado.Program.DTO.ClienteDTO;

import Supermercado.Program.DTO.FornecedorDTO;
import Supermercado.Program.Entities.Cliente;
import Supermercado.Program.Entities.Fornecedor;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import Supermercado.Program.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

<<<<<<< HEAD
    // CREATE
    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return new ClienteDTO(clienteSalvo);
    }

    // READ (todos)
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll().stream()
=======
    public List<ClienteDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }

<<<<<<< HEAD
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

=======
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






>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
