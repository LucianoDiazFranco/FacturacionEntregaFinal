package tienda.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tienda.modelos.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	 List<Producto> findByVentasIsNull();

}
