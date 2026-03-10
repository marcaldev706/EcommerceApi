package com.ecommerce.app.order.exception;

public class NoOrderFound extends RuntimeException{
    public NoOrderFound(Long id) {
        super("Order Not Found With Id: " + id);
    }

    public NoOrderFound(String message) {
        super(message);
    }
}
