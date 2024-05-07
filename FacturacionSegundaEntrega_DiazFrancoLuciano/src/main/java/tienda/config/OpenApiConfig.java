package tienda.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI ()
				.info(new Info()
						.title("API REST FULL / JAVA")
						.version("1.0.0")
						.description("Aplicacion de tienda")
						.contact(new Contact()
								.name("Luciano Diaz Franco")
								.email("Luciano.diaz.franco@gmail.com")
								.url("https://github.com/LucianoDiazFranco"))
						.license(new License()
								.name("Licencia")
								.url(""))
						)
						.servers(List.of(new Server()
								.url("http://localhost:8080")
								.description("Servidor Local")));
		
	}
}
