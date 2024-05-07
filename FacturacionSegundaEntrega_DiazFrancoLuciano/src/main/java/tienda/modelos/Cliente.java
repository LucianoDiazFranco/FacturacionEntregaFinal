package tienda.modelos;


import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Schema(description = "Modelo de Cliente")
@Entity
@Table(name = "cliente")
public class Cliente {	
	@Schema(description = "DNI del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example ="28333555")
	@Id
	@Column(name = "DNI")
	private Integer dni;
	@Schema(description = "Nombre del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example ="Facundo")
	@Column(name = "NOMBRE")
	private String nombre;
	@Schema(description = "Apellido del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example ="Garcia")
	@Column(name = "APELLIDO")
	private String apellido;
	@Schema(description = "Orden del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example ="123")
	@Column(name = "ORDEN")
	private Integer orden;
	
	@Schema(description = "Id de la venta asignada al Cliente")
	// relacion con la tabla venta uno a uno
	@OneToOne(mappedBy = "cliente")
	private Venta venta;
	
	public Cliente() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(orden);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(orden, other.orden);
	}
	

}