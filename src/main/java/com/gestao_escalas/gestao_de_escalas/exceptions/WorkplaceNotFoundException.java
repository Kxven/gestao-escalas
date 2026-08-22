package com.gestao_escalas.gestao_de_escalas.exceptions;

public class WorkplaceNotFoundException extends RuntimeException {
    public WorkplaceNotFoundException() { super("Workplace not found!"); }

    public WorkplaceNotFoundException(String message) { super(message); }
}
