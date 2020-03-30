package br.com.milvusartis.ecommerce.exception;

import javax.persistence.EntityNotFoundException;

public class ResourceNotFoundException  extends EntityNotFoundException {
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
