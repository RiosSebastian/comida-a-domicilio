package com.RiosTech.PlataformaDeComidaADomicilio.exeption;

public class DuplicatedException extends RuntimeException{
    public DuplicatedException(String message) {
        super(message);
    }
}
