package tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tienda.modelos.Cliente;
import tienda.repositorios.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}
	
	public Cliente mostrarAlumnoPorDNI(Integer dni) {
		return clienteRepository.findById(dni).orElse(null);
	}
	
	public Cliente agregarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente editarClientePorDNI(Integer dni, Cliente cliente) {
		try {
			if (clienteRepository.existsById(dni)) {
				cliente.setDni(dni);
				return clienteRepository.save(cliente);
			}
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return null;
	}
	
	public boolean eliminarClientePorDNI (Integer dni) {
		try {
			clienteRepository.deleteById(dni);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
	
}
