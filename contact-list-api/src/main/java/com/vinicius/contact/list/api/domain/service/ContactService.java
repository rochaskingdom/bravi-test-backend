package com.vinicius.contact.list.api.domain.service;

import com.vinicius.contact.list.api.controller.request.UpdateContactRequest;
import com.vinicius.contact.list.api.domain.entities.Contact;

import java.util.Set;

public interface ContactService {

    Set<Contact> findAllByPersonUuid(String uuid);

    Contact findByUuid(String uuid);

    Contact save(String personUuid, Contact contact);

    Contact update(String uuid, UpdateContactRequest updateContactRequest);

    void delete(String uuid);
}
