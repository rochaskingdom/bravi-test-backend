package com.vinicius.contact.list.api.domain.service;

import com.vinicius.contact.list.api.domain.entities.Person;

import java.util.Set;

public interface ContactListService {

    Set<Person> listAll();

    Person findByUuid(String uuid);

}
