package Supermercado.Program.Controller;

import Supermercado.Program.DTO.ClienteDTO;
import Supermercado.Program.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteDTO salvar(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.salvar(clienteDTO);
    }

    @GetMapping
    public List<ClienteDTO> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable Integer id) {
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizar(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.atualizar(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        clienteService.deletar(id);
    }
}