package com.salesunity.systemapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI geraDocumentacao() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.description("Url de desenvolvimento local");

        Contact contact = new Contact();
        contact.setEmail("giovanniultramari@gmail.com");
        contact.setName("Giovanni");
        Info  info = new Info().title("API Sales Unity")
                .version("0.1")
                .contact(contact)
                .description("API do Projeto Sales Unity");
        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}