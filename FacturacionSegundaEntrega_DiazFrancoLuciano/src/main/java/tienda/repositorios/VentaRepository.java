package tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tienda.modelos.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

}
