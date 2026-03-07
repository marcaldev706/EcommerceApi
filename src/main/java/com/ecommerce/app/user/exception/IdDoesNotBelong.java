package com.ecommerce.app.user.exception;

public class IdDoesNotBelong extends RuntimeException {
    public IdDoesNotBelong(Long id) {
        super("Id: " + id + " Does Not Belong To This!");
    }

    public IdDoesNotBelong() {
    }

    public IdDoesNotBelong(String message) {
        super(message);
    }
}
