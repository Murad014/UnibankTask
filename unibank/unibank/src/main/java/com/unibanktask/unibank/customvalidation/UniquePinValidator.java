package com.unibanktask.unibank.customvalidation;

import com.unibanktask.unibank.entity.User;
import com.unibanktask.unibank.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UniquePinValidator implements ConstraintValidator<UniquePin, String> {

    private final UserRepository userRepository;

    @Autowired
    public UniquePinValidator(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniquePin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String pin, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByPin(pin);
    }
}
