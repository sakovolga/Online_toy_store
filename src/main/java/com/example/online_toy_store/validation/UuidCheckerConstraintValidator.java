package com.example.online_toy_store.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class UuidCheckerConstraintValidator implements ConstraintValidator<UuidChecker, String> {

    private static final String UUID_INPUT = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    @Override
    public void initialize(UuidChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String uuid, ConstraintValidatorContext constraintValidatorContext) {
        return Optional.ofNullable(uuid)
                .filter(el -> !el.isBlank())
                .map(el -> el.matches(UUID_INPUT))
                .orElse(false);
    }
}
