package br.com.milvusartis.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class MailNotSendException extends RuntimeException {
    public MailNotSendException() {
        super();
    }

    public MailNotSendException(String message , Throwable cause) {
        super(message, cause);
    }

    public MailNotSendException(String message) {
        super(message);
    }
    public MailNotSendException(Throwable cause) {
        super(cause);
    }
}
