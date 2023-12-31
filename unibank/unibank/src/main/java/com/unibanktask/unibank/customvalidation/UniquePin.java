package com.unibanktask.unibank.customvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePinValidator.class)
public @interface UniquePin {
    String message() default "PIN already exists";
    boolean isUnique() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
