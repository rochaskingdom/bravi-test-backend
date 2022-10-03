package com.vinicius.contact.list.api.controller;

import com.vinicius.contact.list.api.controller.request.CreatePersonRequest;
import com.vinicius.contact.list.api.controller.request.UpdatePersonRequest;
import com.vinicius.contact.list.api.controller.response.ContactListResponse;
import com.vinicius.contact.list.api.controller.response.PersonResponse;
import com.vinicius.contact.list.api.domain.service.PersonService;
import com.vinicius.contact.list.api.translator.PersonRequestToPersonTranslator;
import com.vinicius.contact.list.api.translator.PersonToContactListResponseTranslator;
import com.vinicius.contact.list.api.translator.PersonToPersonResponseTranslator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    private final PersonRequestToPersonTranslator personRequestToPersonTranslator;
    private final PersonToPersonResponseTranslator personToPersonResponseTranslator;
    private final PersonToContactListResponseTranslator personToContactListResponseTranslator;

    @GetMapping
    public Set<PersonResponse> listAllPersons() {
        log.info("Iniciando listagem de pessoas.");
        return service.findAll()
                .stream()
                .map(personToPersonResponseTranslator::translate)
                .collect(Collectors.toSet());
    }

    @GetMapping("/{uuid}")
    public PersonResponse findByUuid(@PathVariable String uuid) {
        log.info("Iniciando busca de pessoa com uuid - [{}]", uuid);
        var person = service.findByUuid(uuid);
        return personToPersonResponseTranslator.translate(person);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactListResponse save(@RequestBody @Valid CreatePersonRequest createPersonRequest) {
        log.info("Iniciando criação de lista de contato");
        var person = personRequestToPersonTranslator.translate(createPersonRequest);
        var savePerson = service.save(person);
        return personToContactListResponseTranslator.translate(savePerson);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public ContactListResponse update(@PathVariable String uuid, UpdatePersonRequest updatePersonRequest) {
        log.info("Iniciando alteração de dados de pessoa com uuid - [{}] - [{}]", uuid, updatePersonRequest);
        var person = service.update(uuid, updatePersonRequest);
        return personToContactListResponseTranslator.translate(person);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String uuid) {
        log.info("Iniciando exclusão de pessoa com uuid - [{}]", uuid);
        service.delete(uuid);
    }
}
