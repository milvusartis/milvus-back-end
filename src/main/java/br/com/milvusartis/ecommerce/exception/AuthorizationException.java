package br.com.milvusartis.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AuthorizationException extends RuntimeException {

    public AuthorizationException(String message , Throwable cause) {
        super(message, cause);
    }

    public AuthorizationException(String message) {
        super(message);
    }

}
