package com.unibanktask.unibank.dto.response;

import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String message;
    private final String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details){
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }


}
