package com.vacinas.exception;

import org.springframework.security.authentication.AccountStatusException;

public class UserDisabledException extends AccountStatusException {
    public UserDisabledException(String msg) {
        super(msg);
    }

    public UserDisabledException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
