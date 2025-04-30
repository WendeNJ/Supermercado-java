package Supermercado.Program.Services;

import Supermercado.Program.DTO.UsuarioDTO;
import Supermercado.Program.Entities.Usuario;
import Supermercado.Program.Enums.TipoUsuario;
import Supermercado.Program.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UsuarioService {
    @Autowired
    private UsuariosRepository usuariosRepository;


    public List<UsuarioDTO> listTodos() {

        List<Usuario> usuarios = usuariosRepository.findAll();


        return usuarios.stream()
                .map(usuario -> new UsuarioDTO(usuario)) // Assumindo que existe um construtor no DTO que recebe um Usuario
                .collect(Collectors.toList());
    }

    public UsuarioDTO buscarPorId(Integer id) {
        Optional<Usuario> usuario = usuariosRepository.findById(id);
        return usuario.map(UsuarioDTO::new).orElse(null);
    }


    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());



        Usuario usuarioSalvo = usuariosRepository.save(usuario);
        return new UsuarioDTO(usuarioSalvo);
    }


    public UsuarioDTO atualizarUsuario(Integer id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioDTO.getNome());
            usuario.setEmail(usuarioDTO.getEmail());


            Usuario usuarioAtualizado = usuariosRepository.save(usuario);
            return new UsuarioDTO(usuarioAtualizado);
        }
        return null; //
    }


    public boolean excluirUsuario(Integer id) {
        Optional<Usuario> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuariosRepository.delete(usuarioOptional.get());
            return true;
        }
        return false;


    }
}



