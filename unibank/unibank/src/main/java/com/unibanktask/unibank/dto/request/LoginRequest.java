package com.unibanktask.unibank.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String pin;
    private String password;
}
