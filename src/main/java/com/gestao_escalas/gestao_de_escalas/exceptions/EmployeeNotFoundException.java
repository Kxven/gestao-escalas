package com.gestao_escalas.gestao_de_escalas.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() { super("Employee not found!"); }

    public EmployeeNotFoundException( String message) { super(message); }
}
