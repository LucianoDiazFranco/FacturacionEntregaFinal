package tienda.modelos;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Schema(description = "Modelo de Comprobante")
@Entity
@Table(name = "comprobante")
public class Comprobante {
    @Schema(description = "ID del Comprobante", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPROBANTE")
    private Comprobante idComprobante;

    @Schema(description = "ID de la Venta asociada al Comprobante", required = true, example = "1")
    @OneToOne
    @JoinColumn(name = "ID_VENTA")
    private Venta venta;

    @Schema(description = "Fecha del Comprobante", required = true, example = "2024-05-07T10:00:00")
    @Column(name = "FECHA_COMPROBANTE")
    private LocalDateTime fechaComprobante;

    public Comprobante( ) {
        
    }

    public Comprobante getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Comprobante comprobante) {
        this.idComprobante = comprobante;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta2) {
        this.venta = venta2;
    }

    public LocalDateTime getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(LocalDateTime fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

	public void setDescripcion(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setFecha(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
    
}
