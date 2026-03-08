package com.ecommerce.app.product.exception;

public class NoProductFound extends RuntimeException{
    public NoProductFound(Long id) {
        super("No Product Found With ID: " + id);
    }

    public NoProductFound(String message) {
        super(message);
    }
}
