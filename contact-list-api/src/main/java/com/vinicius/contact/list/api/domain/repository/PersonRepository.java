package com.vinicius.contact.list.api.domain.repository;

import com.vinicius.contact.list.api.domain.entities.Person;

import java.util.Optional;
import java.util.Set;

public interface PersonRepository {

    Set<Person> findAll();

    Optional<Person> findByUuid(String uuid);

    Set<Person> findAllContactList();

    Person save(Person person);

    Person update(Person person);

    void delete(Person person);

}
