package Supermercado.Program.Controller;



import Supermercado.Program.DTO.ClienteDTO;

import Supermercado.Program.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listarTodos() {
       return  clienteService.listarTodos();

    }


    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer id) {
        ClienteDTO clients = clienteService.buscarPorId(id);
        if (clients == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clients);
    }


    @PostMapping
    public ResponseEntity<ClienteDTO> inserir (@RequestBody ClienteDTO clienteDTO){
        clienteService.inserir(clienteDTO);
        return ResponseEntity.status(201).body(clienteDTO);}

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> alterar(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO atualizado = clienteService.alterar(id, clienteDTO);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        try {
            clienteService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

