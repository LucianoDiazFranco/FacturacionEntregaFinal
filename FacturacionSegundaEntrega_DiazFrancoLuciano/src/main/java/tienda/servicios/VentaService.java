package tienda.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tienda.modelos.Venta;
import tienda.repositorios.VentaRepository;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	public List<Venta> listarVenta() {
		return ventaRepository.findAll();
	}
	
	public Venta mostrarVentaPorId(Integer id) {
		return ventaRepository.findById(id).orElse(null);
	}
	
	public Venta agregarVenta(Venta venta) {
		return ventaRepository.save(venta);
	}
	
	public Venta editarVentaPorId(Integer id, Venta venta) {
		try {
			if (ventaRepository.existsById(id)) {
				venta.setId_venta(id);;
				return ventaRepository.save(venta);
			}
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return null;
	}
	
	public boolean eliminarVentaPorDNI (Integer id) {
		try {
			ventaRepository.deleteById(id);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
	
}
