package tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.modelos.Comprobante;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {
}