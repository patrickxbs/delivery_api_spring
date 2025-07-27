package com.patrick.delivery.infrastructure.exception.handler;

import com.patrick.delivery.core.domain.exception.*;
import com.patrick.delivery.infrastructure.exception.ExceptionDetails;
import com.patrick.delivery.infrastructure.exception.ValidationExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CampoJaExisteException.class)
    public ResponseEntity<ExceptionDetails> handlerCampoJaExisteException(CampoJaExisteException ex) {
        return new ResponseEntity<>(new ExceptionDetails(
                        LocalDateTime.now(),
                        "Field Error",
                        ex.getMessage(),
                        HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SenhaInvalidaException.class)
    public ResponseEntity<ExceptionDetails> handlerSenhaInvalidaException(SenhaInvalidaException ex) {
        return new ResponseEntity<>(new ExceptionDetails(
                LocalDateTime.now(),
                "Senha Error",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<ExceptionDetails> handlerEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex) {
        return new ResponseEntity<>(new ExceptionDetails(
                LocalDateTime.now(),
                "Entidade não encontrado",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(QuantidadeInsuficienteException.class)
    public ResponseEntity<ExceptionDetails> handlerQuantidadeInsuficienteException(QuantidadeInsuficienteException ex) {
        return new ResponseEntity<>(new ExceptionDetails(
                LocalDateTime.now(),
                "Produto Indisponivel",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CancelamentoNaoPermitidoException.class)
    public ResponseEntity<ExceptionDetails> handlerCancelamentoNaoPermitidoException(CancelamentoNaoPermitidoException ex) {
        return new ResponseEntity<>(new ExceptionDetails(
                LocalDateTime.now(),
                "Cancelamento Error",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EnderecoInvalidoException.class)
    public ResponseEntity<ExceptionDetails> handlerEnderecoInvalidoException(EnderecoInvalidoException ex) {
        return new ResponseEntity<>(new ExceptionDetails(
                LocalDateTime.now(),
                "Endereco Error",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsuarioInativoException.class)
    public ResponseEntity<ExceptionDetails> handlerUsuarioInativoException(UsuarioInativoException ex) {
        return new ResponseEntity<>(new ExceptionDetails(
                LocalDateTime.now(),
                "Usuario Inativo",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionDetails> handlerAccessDeniedException(AccessDeniedException ex) {
        return new ResponseEntity<>(new ExceptionDetails(
                LocalDateTime.now(),
                "Não Possui Permissão de Acesso a Esse Recurso",
                ex.getMessage(),
                HttpStatus.FORBIDDEN.value()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerValidationException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        String campos = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));

        String campoMensagem = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(new ValidationExceptionDetails(
                LocalDateTime.now(),
                "Campo(s) invalido(s)!",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                campos, campoMensagem), HttpStatus.BAD_REQUEST);
    }


}
