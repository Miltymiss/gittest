package com.restserver.resourceserver.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Elearning Course Resource API").description(
                        "this is the elearning resource open api ").
                        contact(new io.swagger.v3.oas.models.info.Contact().url("").name("milty").email("1826092157@qq.com")));
    }
}
