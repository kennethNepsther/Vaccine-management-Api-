package com.vacinas.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldMessages implements Serializable {
        private static final long serialVersionUID = 1L;
        private String field;
        private String message;
}
