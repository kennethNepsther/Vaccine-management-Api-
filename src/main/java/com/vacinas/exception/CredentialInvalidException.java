package com.vacinas.exception;

import org.springframework.security.core.AuthenticationException;

public class CredentialInvalidException extends AuthenticationException {
    public CredentialInvalidException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CredentialInvalidException(String msg) {
        super(msg);
    }
}
