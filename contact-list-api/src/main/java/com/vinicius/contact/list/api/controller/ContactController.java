package com.vinicius.contact.list.api.controller;

import com.vinicius.contact.list.api.controller.request.CreateContactRequest;
import com.vinicius.contact.list.api.controller.request.UpdateContactRequest;
import com.vinicius.contact.list.api.controller.response.ContactResponse;
import com.vinicius.contact.list.api.domain.service.ContactService;
import com.vinicius.contact.list.api.translator.ContactRequestToContactTranslator;
import com.vinicius.contact.list.api.translator.ContactToContactResponseTranslator;
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
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService service;

    private final ContactToContactResponseTranslator contactToContactResponse;
    private final ContactRequestToContactTranslator contactRequestToContactTranslator;

    @GetMapping("/person/{uuid}")
    public Set<ContactResponse> findAllByPersonUuid(@PathVariable String uuid) {
        log.info("Iniciando busca de lista de contato por personUuid - [{}]", uuid);
        return service.findAllByPersonUuid(uuid)
                .stream()
                .map(contactToContactResponse::translate)
                .collect(Collectors.toSet());
    }

    @GetMapping("/{uuid}")
    public ContactResponse findByUuid(@PathVariable String uuid) {
        log.info("Iniciando busca de lista de contato por uuid - [{}]", uuid);
        var contact = service.findByUuid(uuid);
        return contactToContactResponse.translate(contact);
    }

    @PostMapping("/{personUuid}")
    public ContactResponse save(@PathVariable String personUuid, @RequestBody @Valid CreateContactRequest createContactRequest) {
        log.info("Iniciando criação de contato para o personUuid - [{}] - [{}]", personUuid, createContactRequest.toString());
        var contact = contactRequestToContactTranslator.translate(createContactRequest);
        var contactSave = service.save(personUuid, contact);
        return contactToContactResponse.translate(contactSave);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public ContactResponse update(@PathVariable String uuid, UpdateContactRequest updatePersonRequest) {
        log.info("Iniciando alteração de dados do contato com uuid - [{}] - [{}]", uuid, updatePersonRequest.toString());
        log.info("Iniciando alteração de contato");
        var person = service.update(uuid, updatePersonRequest);
        return contactToContactResponse.translate(person);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String uuid) {
        log.info("Iniciando exclusão de contato com uuid - [{}]", uuid);
        service.delete(uuid);
    }
}
