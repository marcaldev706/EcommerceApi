package com.ecommerce.app.user.exception;

public class NoUserFound extends RuntimeException {
    public NoUserFound(Long id){
        super("No User Found With ID: " + id);
    }
}
