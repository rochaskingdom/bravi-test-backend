package com.vinicius.contact.list.api.domain.service.impl;

import com.vinicius.contact.list.api.domain.entities.Person;
import com.vinicius.contact.list.api.domain.exception.ContactListNotFoundException;
import com.vinicius.contact.list.api.domain.repository.ContactListRepository;
import com.vinicius.contact.list.api.domain.service.ContactListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactListServiceImpl implements ContactListService {

    private final ContactListRepository personRepository;

    @Override
    public Set<Person> listAll() {
        var contactList = personRepository.listAll();
        log.info("Lista de contatos encontradas com sucesso - [{}]", contactList.toString());
        return contactList;
    }

    @Override
    public Person findByUuid(String personUuid) {
        var personContact = personRepository.findByUuid(personUuid)
                .orElseThrow(ContactListNotFoundException::new);
        log.info("Lista de contato encontrado com sucesso com personUuid -[{}] - [{}]", personUuid, personContact.toString());
        return personContact;
    }
}
