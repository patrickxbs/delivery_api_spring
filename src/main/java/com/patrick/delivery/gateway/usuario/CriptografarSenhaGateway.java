package com.patrick.delivery.gateway.usuario;

public interface CriptografarSenhaGateway {

    boolean verificar(String senha, String senhaCriptografada);

    String criptografar(String senha);
}
