package com.vacinas.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ValidationError extends StandardError {
    private List<FieldMessages> errors = new ArrayList<>();

    public ValidationError(Long timestamp, Integer statusCode, String errorMessage) {
        super(timestamp, statusCode, errorMessage);
    }

    public void addErrors(String field, String message) {
        this.errors.add(new FieldMessages(field, message));
    }
}


