package com.unibanktask.unibank.dto;

import com.unibanktask.unibank.customvalidation.IsStrongPassword;
import com.unibanktask.unibank.customvalidation.UniquePin;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
//    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min=3, max=20, message = "Name must be at least three characters and maximum 20 characters")
    private String name;

    @NotBlank
    @NotEmpty
    @Size(min=3, max=20, message = "Surname must be at least three characters and maximum 20 characters")
    private String surname;

    @NotEmpty
    @NotBlank
    @UniquePin
    @Pattern(regexp = "\\d+", message = "PIN must contain only digits")
    @Size(min = 4, message = "PIN must have at least 4 digits")
    private String pin;

    @IsStrongPassword
    private String password;
}
