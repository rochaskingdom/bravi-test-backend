package com.vinicius.contact.list.api.domain.repository.impl;

import com.vinicius.contact.list.api.domain.entities.Contact;
import com.vinicius.contact.list.api.domain.repository.ContactRepository;
import com.vinicius.contact.list.api.domain.repository.jpa.ContactJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ContactRepositoryImpl implements ContactRepository {

    private final ContactJpaRepository repository;

    @Override
    public Set<Contact> findAllByPersonUuid(String uuid) {
        return repository.findAllByPersonUuid(uuid);
    }

    @Override
    public Optional<Contact> findByUuid(String uuid) {
        return repository.findByUuid(uuid);
    }

    @Override
    public Contact save(Contact person) {
        return repository.save(person);
    }

    @Override
    public Contact update(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        repository.delete(contact);
    }
}
