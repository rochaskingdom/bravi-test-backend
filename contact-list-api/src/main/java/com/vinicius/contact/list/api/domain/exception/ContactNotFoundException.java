package com.vinicius.contact.list.api.domain.exception;

import org.springframework.http.HttpStatus;

public class ContactNotFoundException extends ContactListException {
    public ContactNotFoundException() {
        super(HttpStatus.NOT_FOUND, "contact-not-found", "Contato não encontrado.");
    }
}
