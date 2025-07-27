package com.patrick.delivery.core.domain.exception;

public class QuantidadeInsuficienteException extends RuntimeException{

    public QuantidadeInsuficienteException(String message) {
        super(message);
    }
}
