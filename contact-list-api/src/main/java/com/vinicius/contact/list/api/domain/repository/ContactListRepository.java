package com.vinicius.contact.list.api.domain.repository;

import com.vinicius.contact.list.api.domain.entities.Person;

import java.util.Optional;
import java.util.Set;

public interface ContactListRepository {

    Set<Person> listAll();

    Optional<Person> findByUuid(String personUuid);

}
