package com.example.online_toy_store.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@OpenAPIDefinition(
        info = @Info(
                title = "Online toy store",
                description = "There is a prototype of the BackEnd Online Shop's Core Services data. <br />" +
                        "Data consist of authorities, orders, orderDetails, products, promoCodes, reviews, roles, suppliers, users and usersInfo.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Volha Zadziarkouskaya",
                        url = "https://www.linkedin.com/feed/?trk=guest_homepage-basic_google-one-tap-submit"
                )
        )
)
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.packageName:com.example.online_toy_store}")
    private String PACKAGE_NAME;
    public static final String ORDER = "order service";
    public static final String PRODUCT = "product service";
    public static final String PROMO_CODE = "promo code service";
    public static final String USER = "user service";
    public static final String SUPPLIER = "promo code service";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_NAME))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(ORDER, "API for working with orders"))
                .tags(new Tag(PRODUCT, "API for working with products"))
                .tags(new Tag(PROMO_CODE, "API for working with promo codes"))
                .tags(new Tag(USER, "API for working with users"))
                .tags(new Tag(SUPPLIER, "API for working with suppliers"));
    }
}
