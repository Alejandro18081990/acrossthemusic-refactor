package com.example.demo.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repositorios")
public class Configuracion {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
