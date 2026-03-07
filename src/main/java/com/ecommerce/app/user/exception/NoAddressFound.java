package com.ecommerce.app.user.exception;

public class NoAddressFound extends RuntimeException{
    public NoAddressFound(Long id) {
        super("No Address Found With ID: " + id);
    }

    public NoAddressFound(String message) {
        super(message);
    }
}
