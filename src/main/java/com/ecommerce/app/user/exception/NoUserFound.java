package com.ecommerce.app.user.exception;

public class NoUserFound extends RuntimeException {
    public NoUserFound(Long id){
        super("NO USER FOUND WITH ID: " + id);
    }
}
