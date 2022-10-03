package com.vinicius.contact.list.api.domain.exception;

import org.springframework.http.HttpStatus;

public class InvalidContactListException extends ContactListException{

    public InvalidContactListException(String errorDescription) {
        super(HttpStatus.BAD_REQUEST, "validation-error", errorDescription);
    }
}
