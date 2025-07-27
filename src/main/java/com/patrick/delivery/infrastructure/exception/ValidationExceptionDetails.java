package com.patrick.delivery.infrastructure.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ValidationExceptionDetails extends ErroFields {

    private final String campos;
    private final String campoMessagem;

    public ValidationExceptionDetails(LocalDateTime timestamp, String title, String message, int status, String campos, String campoMessagem) {
        super(timestamp, title, message, status);
        this.campos = campos;
        this.campoMessagem = campoMessagem;
    }
}
