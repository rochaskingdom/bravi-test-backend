package com.vinicius.contact.list.api.domain.exception;

import org.springframework.http.HttpStatus;

public class PersonNotFoundException extends ContactListException {
    public PersonNotFoundException() {
        super(HttpStatus.NOT_FOUND, "person-not-found", "Dados da pessoa não encontrado.");
    }
}
