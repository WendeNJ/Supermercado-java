package Supermercado.Program.Repository;

import Supermercado.Program.Entities.EntradaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaEstoqueRepository extends JpaRepository<EntradaEstoque, Integer> {

}
