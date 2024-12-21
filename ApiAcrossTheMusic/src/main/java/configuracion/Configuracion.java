package configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "repositorios")
public class Configuracion {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
