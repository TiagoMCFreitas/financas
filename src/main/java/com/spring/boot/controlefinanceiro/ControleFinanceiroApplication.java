package com.spring.boot.controlefinanceiro;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}", version = "${info.build.version}", description = "${info.app.description}",
        contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Time Controle de Finanças", email = "tiagofreitas85862@gmail.com")))
@SpringBootApplication
public class ControleFinanceiroApplication  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry ) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
    public static void main(String[] args) {
        SpringApplication.run(ControleFinanceiroApplication.class, args);
    }

}
