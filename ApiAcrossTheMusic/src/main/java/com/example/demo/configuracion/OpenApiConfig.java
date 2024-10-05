package com.example.demo.configuracion;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "PI: Across the music",
                version = "1.0.0",
                description = "Api para consumo de app Android"
        )
)
public class OpenApiConfig {
}
