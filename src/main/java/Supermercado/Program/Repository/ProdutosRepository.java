package Supermercado.Program.Repository;

import Supermercado.Program.Entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository <Produtos, Integer> {
}
