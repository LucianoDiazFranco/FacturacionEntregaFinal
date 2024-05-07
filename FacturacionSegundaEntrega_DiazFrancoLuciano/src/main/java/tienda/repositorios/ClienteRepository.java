package tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tienda.modelos.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
