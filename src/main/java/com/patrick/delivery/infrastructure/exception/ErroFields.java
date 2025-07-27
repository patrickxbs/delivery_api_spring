package com.patrick.delivery.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErroFields {

    private LocalDateTime timestamp;
    private String title;
    private String message;
    private int status;

}
