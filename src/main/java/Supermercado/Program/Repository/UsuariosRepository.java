package Supermercado.Program.Repository;

import Supermercado.Program.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
}
