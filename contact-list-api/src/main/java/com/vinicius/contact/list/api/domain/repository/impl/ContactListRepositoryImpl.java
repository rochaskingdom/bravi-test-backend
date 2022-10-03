package com.vinicius.contact.list.api.domain.repository.impl;

import com.vinicius.contact.list.api.domain.entities.Person;
import com.vinicius.contact.list.api.domain.repository.ContactListRepository;
import com.vinicius.contact.list.api.domain.repository.jpa.ContactListJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ContactListRepositoryImpl implements ContactListRepository {

    private final ContactListJpaRepository repository;

    @Override
    public Set<Person> listAll() {
        return repository.listAllPersons();
    }

    @Override
    public Optional<Person> findByUuid(String personUuid) {
        return repository.findByUuid(personUuid);
    }
}
