package com.vinicius.contact.list.api.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ContactListException extends RuntimeException {

    private final HttpStatus status;
    private final String errorCode;
    private final String errorDescription;

    public ContactListException(HttpStatus status, String errorCode, String errorDescription) {
        super(errorDescription);
        this.status = status;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }


}
