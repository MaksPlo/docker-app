package ru.demo.dockerapp.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    @Bean
    KeycloakSpringBootConfigResolver superKeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}
