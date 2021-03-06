package com.ledza.cryptowhaleviewer.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Profile("production")
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket configureSwagger(){
        return new Docket(DocumentationType.OAS_30)
                .enable(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ledza.cryptowhaleviewer"))
                .paths(PathSelectors.any())
                .build();

    }
}
