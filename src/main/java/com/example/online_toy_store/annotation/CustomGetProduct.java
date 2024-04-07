package com.example.online_toy_store.annotation;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(summary = "Show product by ID", description = "Retrieve a product by its unique identifier", tags = {"PRODUCT"})
public @interface CustomGetProduct {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
