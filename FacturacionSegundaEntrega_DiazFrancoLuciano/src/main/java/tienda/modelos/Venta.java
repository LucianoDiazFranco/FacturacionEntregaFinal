package tienda.modelos;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Schema(description = "Modelo de Venta")
@Entity
@Table(name = "venta")
public class Venta {
	@Schema(description = "Id de Venta", requiredMode = Schema.RequiredMode.REQUIRED, example ="7")
	@Id
	@Column(name = "ID_VENTA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_venta;
	@Schema(description = "Fecha de la Venta", requiredMode = Schema.RequiredMode.REQUIRED, example ="22-2-2004")
	@Column(name = "FECHA")
	private LocalDateTime fecha;
	@Schema(description = "Tipo de Venta", requiredMode = Schema.RequiredMode.REQUIRED, example ="Efectivo")
	@Column(name = "TIPO_DE_VENTA")
	private String Tipo_de_venta;
	@Schema(description = "Descripccion de la Venta", requiredMode = Schema.RequiredMode.REQUIRED, example ="Venta Confirmada")
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	
	
	//relacion con la tabla productos
	@ManyToMany
	@JoinTable(
			 name = "venta_producto",
			 joinColumns = @JoinColumn(name = "id_venta"),
			 inverseJoinColumns = @JoinColumn(name = "id_producto"))
	private List<Producto> producto;
	
	// relacion de uno a uno con la tabla cliente(un cliente solo puede tener una venta y la venta pertenece a un solo cliente)
	@Schema(description = "Lista de ventas de los Clientes")
	@OneToOne
	@JoinColumn(name = "dni")
	private Cliente cliente;

	
	//una vez finalizada la venta, restamos la cantidad de productos seleccionados por el stock
	// y volver a guardar el objeto producto con el stock nuevo
	
	
	//Necesitamos crear una tabla/objeto comprobante que contenga id de comprobante, id de la venta, fecha de comprobante (obtenida por URL externa)
	
	public Venta() {
		
	}

	public Integer getId_venta() {
		return this.id_venta;
	}

	public void setId_venta(Integer id_venta) {
		this.id_venta = id_venta;
	}

	public LocalDateTime getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTipo_de_venta() {
		return this.Tipo_de_venta;
	}

	public void setTipo_de_venta(String tipo_de_venta) {
		Tipo_de_venta = tipo_de_venta;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Cliente getCliente() {
	        return cliente;
	}

	public void setCliente(Cliente cliente) {
	        this.cliente = cliente;
	}

	public List<Producto> getProductos() {
	        return this.producto;
	}

	public void setProductos(List<Producto> productos) {
	        this.producto = productos ;
	}
	
	
}
