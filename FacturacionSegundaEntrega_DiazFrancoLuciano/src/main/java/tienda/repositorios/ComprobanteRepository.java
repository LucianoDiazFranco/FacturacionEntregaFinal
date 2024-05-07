package tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tienda.modelos.Comprobante;
@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {
}