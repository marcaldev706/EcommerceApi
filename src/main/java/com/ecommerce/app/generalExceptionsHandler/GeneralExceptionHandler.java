package com.ecommerce.app.generalExceptionsHandler;

import com.ecommerce.app.user.exception.NoUserFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    //General Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generalExceptionHandler(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    //User Exception Handler
    @ExceptionHandler(NoUserFound.class)
    public ResponseEntity<String> userNotFound(NoUserFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
