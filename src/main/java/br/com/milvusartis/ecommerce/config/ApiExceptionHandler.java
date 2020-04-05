package br.com.milvusartis.ecommerce.config;

import br.com.milvusartis.ecommerce.exception.MailNotSendException;
import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.service.MockEmailService;
import com.sun.mail.util.MailConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()) ;
    }

    @ExceptionHandler(MailNotSendException.class)
    public ResponseEntity<?> handleExceptionSendEmail(MailNotSendException ex){
        LOG.info("Email não pode ser enviado!");
        return ResponseEntity.status(HttpStatus.CREATED).body(ex.getMessage()) ;

    }
}
