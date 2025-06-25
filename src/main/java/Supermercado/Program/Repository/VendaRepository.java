package Supermercado.Program.Repository;

import Supermercado.Program.Entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository <Venda, Integer> {
}
