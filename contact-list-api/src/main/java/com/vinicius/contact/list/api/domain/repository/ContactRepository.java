package com.vinicius.contact.list.api.domain.repository;

import com.vinicius.contact.list.api.domain.entities.Contact;

import java.util.Optional;
import java.util.Set;

public interface ContactRepository {

    Optional<Contact> findByUuid(String uuid);

    Set<Contact> findAllByPersonUuid(String uuid);

    Contact save(Contact person);

    Contact update(Contact person);

    void delete(Contact person);

}
