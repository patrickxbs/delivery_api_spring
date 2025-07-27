package com.patrick.delivery.infrastructure.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionDetails extends ErroFields {

    public ExceptionDetails(LocalDateTime timestamp, String title, String message, int status) {
        super(timestamp, title, message, status);
    }
}
