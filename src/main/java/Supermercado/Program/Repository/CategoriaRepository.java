package Supermercado.Program.Repository;

import Supermercado.Program.Entities.CategoriaProdutos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaProdutos, Integer> {
}
