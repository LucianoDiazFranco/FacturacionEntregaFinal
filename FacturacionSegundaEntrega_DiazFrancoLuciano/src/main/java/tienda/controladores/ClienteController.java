package tienda.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tienda.modelos.Cliente;
import tienda.servicios.ClienteService;

@RestController
@RequestMapping("/clientes")
@Tag(name= "Gestion de Clientes", description = "Endpoints para Gestionar Clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Operation(summary = "Obtener la Lista de Clientes")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Lista de Clientes Obtenida Correctamente",
						content = {@Content(mediaType = "appication/json", schema = @Schema(implementation = Cliente.class))}),
				@ApiResponse(responseCode = "500", description = "Error interno del Servidor", content = @Content)})
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Cliente>> listarCliente() {
		try {
			List<Cliente> cliente = clienteService.listarCliente();
			return new ResponseEntity<>(cliente, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
	@Operation(summary = "Obtener Clientes por DNI")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Clientes Encontrado Correctamente",
						content = {@Content(mediaType = "appication/json", schema = @Schema(implementation = Cliente.class))}),
				@ApiResponse(responseCode = "500", description = "Cliente no Encontrado ", content = @Content)})
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> mostrarClientePorDNI(@PathVariable("id") Integer dni) {
		try {
			Cliente cliente = clienteService.mostrarAlumnoPorDNI(dni);
			if (cliente != null) {
				return new ResponseEntity<>(cliente, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500

		}
	}
	
	@Operation(summary = "Agregar Clientes")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Clientes Agragado Correctamente",
						content = {@Content(mediaType = "appication/json", schema = @Schema(implementation = Cliente.class))}),
				@ApiResponse(responseCode = "500", description = "Error interno del Servidor", content = @Content)})
	@PostMapping(value = "/agregar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
		clienteService.agregarCliente(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED); // Codigo 201
	}
	
	@Operation(summary = "Editar Clientes")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Clientes Editado Correctamente",
						content = {@Content(mediaType = "appication/json", schema = @Schema(implementation = Cliente.class))}),
				@ApiResponse(responseCode = "404", description = "Error al editar al Cliente", content = @Content)})
	@PutMapping(value = "/{id}/editar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> ediarCliente (@PathVariable("id") Integer dni, @RequestBody Cliente cliente){
		Cliente clienteEditado = clienteService.editarClientePorDNI(dni,cliente);
		if (clienteEditado != null) {
			return new ResponseEntity<>(clienteEditado, HttpStatus.OK); // Codigo 200
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
	
	@Operation(summary = "Eliminar Clientes")
	@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Clientes Eliminado Correctamente", content = @Content),
				@ApiResponse(responseCode = "404", description = "Error al Eliminar al Cliente", content = @Content)})
	@DeleteMapping(value = "/{id}/eliminar")
	public ResponseEntity<Void> eliminarCLiente(@PathVariable("id") Integer dni) {
		boolean eliminado = clienteService.eliminarClientePorDNI(dni);
		if (eliminado){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Codigo 204
		} else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}

	}
	
}
