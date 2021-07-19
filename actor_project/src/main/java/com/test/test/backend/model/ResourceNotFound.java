package com.test.test.backend.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception {

    private static final Integer serialVersionId = 1;

    public ResourceNotFound(String errorMessage) {
        super(errorMessage);
    }

}
