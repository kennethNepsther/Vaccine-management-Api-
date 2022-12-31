package com.vacinas.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
    private Long timestamp;
    private Integer statusCode;
    private String errorMessage;
}
