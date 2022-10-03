package com.vinicius.contact.list.api.domain.service;

import com.vinicius.contact.list.api.controller.request.UpdatePersonRequest;
import com.vinicius.contact.list.api.domain.entities.Person;

import java.util.Set;

public interface PersonService {

    Set<Person> findAll();

    Person findByUuid(String uuid);

    Person save(Person person);

    Person update(String uuid, UpdatePersonRequest updatePersonRequest);

    void delete(String uuid);
}
