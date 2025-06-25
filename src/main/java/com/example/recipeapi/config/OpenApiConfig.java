package com.example.recipeapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Recipe Orchestration API")
                        .version("1.0")
                        .description("API for loading and searching recipes from external sources")
                        .contact(new Contact()
                                .name("Recipe API Team")
                                .email("team@recipeapi.com")));
    }
}