package com.vinicius.contact.list.api.domain.repository.impl;

import com.vinicius.contact.list.api.domain.entities.Person;
import com.vinicius.contact.list.api.domain.repository.PersonRepository;
import com.vinicius.contact.list.api.domain.repository.jpa.PersonJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final PersonJpaRepository repository;

    @Override
    public Optional<Person> findByUuid(String uuid) {
        return repository.findByUuid(uuid);
    }

    @Override
    public Set<Person> findAll() {
        return repository.listAllPersons();
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public Person update(Person person) {
        return repository.save(person);
    }

    @Override
    public void delete(Person person) {
        repository.delete(person);
    }
}
