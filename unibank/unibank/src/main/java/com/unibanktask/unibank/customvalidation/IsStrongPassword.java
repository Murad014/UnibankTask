package com.unibanktask.unibank.customvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsStrongPasswordValidator.class)
public @interface IsStrongPassword {
    String message() default "Password must minimum 8 characters, contains at least one symbol and digit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
