package Supermercado.Program.Repository;

import Supermercado.Program.Entities.EntradaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<EntradaEstoque, Integer> {
}
