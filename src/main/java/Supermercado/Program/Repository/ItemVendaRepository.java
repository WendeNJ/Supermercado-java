package Supermercado.Program.Repository;

import Supermercado.Program.Entities.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVendaRepository extends JpaRepository <ItemVenda, Integer> {
}
