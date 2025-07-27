package com.patrick.delivery.core.domain.exception;

public class CancelamentoNaoPermitidoException extends RuntimeException{

    public CancelamentoNaoPermitidoException(String message) {
        super(message);
    }
}
