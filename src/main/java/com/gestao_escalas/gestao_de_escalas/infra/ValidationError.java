package com.gestao_escalas.gestao_de_escalas.infra;

import java.time.Instant;
import java.util.Map;

public class ValidationError extends StandardError {

    private Map<String, String> errors;

    public ValidationError() {
        super();
    }

    public ValidationError(
            Instant timestamp,
            Integer status,
            String error,
            String message,
            String path,
            Map<String, String> errors) {

        super(timestamp, status, error, message, path);

        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
