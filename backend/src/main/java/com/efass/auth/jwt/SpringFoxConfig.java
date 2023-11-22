//package com.efass.auth.jwt;
//
//import io.swagger.models.Contact;
//import io.swagger.models.Info;
//import io.swagger.models.License;
//import io.swagger.models.SecurityRequirement;
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SpringFoxConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//
////    @Bean
////    public OpenAPI openAPI() {
////        return new OpenAPI().addSecurityItem(new SecurityRequirement().
////                        addList("Bearer Authentication"))
////                .components(new Components().addSecuritySchemes
////                        ("Bearer Authentication", createAPIKeyScheme()))
////                .info(new Info().title("BOI-EFASS PROJECT")
////                        .description("Bank of Industry Backend-Api.")
////                        .version("1.0").contact(new Contact().name("Neptune")
////                                .email( "neptune@gmail.com.com").url("https://www.neptune.com"))
////                        .license(new License().name("License of API")
////                                .url("https://www.neptune.com")));
////    }
//
//    private SecurityScheme createAPIKeyScheme() {
//        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
//                .bearerFormat("JWT")
//                .scheme("bearer");
//    }
//}
