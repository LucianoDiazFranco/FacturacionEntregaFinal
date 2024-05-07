package tienda.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tienda.modelos.Comprobante;
import tienda.repositorios.ComprobanteRepository;

@Service
public class ComprobanteService {
	@Autowired
    private final ComprobanteRepository comprobanteRepository;

    
    public ComprobanteService(ComprobanteRepository comprobanteRepository) {
        this.comprobanteRepository = comprobanteRepository;
    }

    public Comprobante guardarComprobante(Comprobante comprobante) {
        return comprobanteRepository.save(comprobante);
    }


}