package com.vinicius.contact.list.api.domain.service.impl;

import com.vinicius.contact.list.api.controller.request.UpdatePersonRequest;
import com.vinicius.contact.list.api.domain.entities.Person;
import com.vinicius.contact.list.api.domain.exception.InvalidContactListException;
import com.vinicius.contact.list.api.domain.exception.PersonNotFoundException;
import com.vinicius.contact.list.api.domain.repository.PersonRepository;
import com.vinicius.contact.list.api.domain.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Set<Person> findAll() {
        var personList =  personRepository.findAll();
        log.info("Listagem de pessoas concluída com sucesso - [{}]", personList.toString());
        return personList;
    }

    @Override
    public Person findByUuid(String uuid) {
        var person = personRepository.findByUuid(uuid)
                .orElseThrow(PersonNotFoundException::new);
        log.info("Pessoa encontrada com sucesso - [{}]", person.toString());
        return person;
    }

    @Override
    public Person save(Person person) {
        var savedPerson = personRepository.save(Person.toSave(person));
        log.info("Lista de contato criada com sucesso - [{}]", savedPerson.toString());
        return savedPerson;
    }

    @Override
    public Person update(String uuid, UpdatePersonRequest updatePersonRequest) {
        var updatedPerson = Optional.of(findByUuid(uuid))
                .map(person -> personRepository.update(Person.toUpdate(person, updatePersonRequest)))
                .orElseThrow(() -> new InvalidContactListException("Ocorreu um erro ao tentar atualizar dados da pessoa."));
        log.info("Dados da pessoa alterados com sucesso - [{}]", updatedPerson.toString());
        return updatedPerson;
    }

    @Override
    public void delete(String uuid) {
        var personUpdate = findByUuid(uuid);
        personRepository.delete(personUpdate);
        log.info("Pessoa excluída com sucesso.");
    }
}
