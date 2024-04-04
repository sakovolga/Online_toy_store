package com.example.online_toy_store.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Constraint(validatedBy = UuidCheckerConstraintValidator.class)
public @interface UuidChecker {

    String message() default "!!! IT IS NOT [UUID] FORMAT";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
