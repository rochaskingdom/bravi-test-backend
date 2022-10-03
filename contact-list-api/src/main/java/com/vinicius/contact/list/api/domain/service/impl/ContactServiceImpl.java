package com.vinicius.contact.list.api.domain.service.impl;

import com.vinicius.contact.list.api.controller.request.UpdateContactRequest;
import com.vinicius.contact.list.api.domain.entities.Contact;
import com.vinicius.contact.list.api.domain.exception.ContactNotFoundException;
import com.vinicius.contact.list.api.domain.exception.InvalidContactListException;
import com.vinicius.contact.list.api.domain.repository.ContactRepository;
import com.vinicius.contact.list.api.domain.service.ContactService;
import com.vinicius.contact.list.api.domain.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final PersonService personService;
    private final ContactRepository contactRepository;

    @Override
    public Set<Contact> findAllByPersonUuid(String uuid) {
        var contactList = contactRepository.findAllByPersonUuid(uuid);
        log.info("Listagem de contatos de uma pessoa concluída com sucesso - [{}]", contactList.toString());
        return contactList;
    }

    @Override
    public Contact findByUuid(String uuid) {
        var contact = contactRepository.findByUuid(uuid)
                .orElseThrow(ContactNotFoundException::new);
        log.info("Contato encontrado com sucesso - [{}]", contact.toString());
        return contact;
    }

    @Override
    public Contact save(String personUuid, Contact contact) {
        var person = personService.findByUuid(personUuid);
        var savedContact = contactRepository.save(Contact.toSave(contact, person));
        log.info("Contato criado com sucesso - [{}]", savedContact.toString());
        return savedContact;
    }

    @Override
    public Contact update(String uuid, UpdateContactRequest request) {
        var updatedContact = Optional.of(findByUuid(uuid))
                .map(contact -> contactRepository.update(Contact.toUpdate(contact, request)))
                .orElseThrow(() -> new InvalidContactListException("Ocorreu um erro ao tentar atualizar."));
        log.info("Dados do contato alterados com sucesso - [{}]", updatedContact.toString());
        return updatedContact;
    }

    @Override
    public void delete(String uuid) {
        var contact = findByUuid(uuid);
        contactRepository.delete(contact);
        log.info("Contato excluído com sucesso.");
    }
}
