package com.patrick.delivery.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Slf4j
public class JwtTokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${api.security.token.issuer}")
    private String issuer;

    public String generateToken(UsuarioEntity usuarioEntity) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(usuarioEntity.getEmail())
                    .withClaim("role", usuarioEntity.getRole().name())
                    .withIssuedAt(creationDate())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new JWTCreationException("Erro ao gerar token.", exception);
        }
    }

    public String getSubjectToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        }
        catch (TokenExpiredException ex) {
            log.info("JWT expirado: " + ex.getMessage());
            throw new TokenExpiredException("Token expirado", ex.getExpiredOn());
        }
        catch (JWTVerificationException ex) {
            log.info("Erro na validação do JWT: " + ex.getMessage());
            throw new JWTVerificationException("Token inválido ou expirado.");
        }
    }

    private Instant creationDate() {
        return Instant.now();
    }

    private Instant expirationDate() {
        return Instant.now().plus(Duration.ofHours(3));
    }
}
