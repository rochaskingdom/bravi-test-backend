package com.vinicius.contact.list.api.domain.exception;

import org.springframework.http.HttpStatus;

public class ContactListNotFoundException extends ContactListException {
    public ContactListNotFoundException() {
        super(HttpStatus.NOT_FOUND, "contact-list-not-found", "Lista de contato não encontrada.");
    }
}
