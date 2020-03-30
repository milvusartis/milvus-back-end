package br.com.milvusartis.ecommerce.config;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public String handlerException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }
}
