package com.ecommerce.app.generalExceptionsHandler;

import com.ecommerce.app.product.exception.NoProductFound;
import com.ecommerce.app.user.exception.IdDoesNotBelong;
import com.ecommerce.app.user.exception.NoAddressFound;
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

    //Address Exception Handler
    @ExceptionHandler(NoAddressFound.class)
    public ResponseEntity<String> noAddressFound(NoAddressFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(IdDoesNotBelong.class)
    public ResponseEntity<String> idDoesNotBelong(IdDoesNotBelong exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    //Product Exception Handler
    @ExceptionHandler(NoProductFound.class)
    public ResponseEntity<String> noProductFound(NoProductFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
