package com.vinicius.contact.list.api.controller;

import com.vinicius.contact.list.api.controller.response.ContactListResponse;
import com.vinicius.contact.list.api.domain.service.ContactListService;
import com.vinicius.contact.list.api.translator.PersonToContactListResponseTranslator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/contact-list")
public class ContactListController {

    private final ContactListService service;
    private final PersonToContactListResponseTranslator personToContactListResponseTranslator;

    @GetMapping
    public Set<ContactListResponse> listAll() {
        log.info("Iniciando busca de todas as listas de contatos.");
        return service.listAll()
                .stream()
                .map(personToContactListResponseTranslator::translate)
                .collect(Collectors.toSet());
    }

    @GetMapping("/{personUuid}")
    public ContactListResponse findByPersonUuid(@PathVariable String personUuid) {
        var person = service.findByUuid(personUuid);
        return personToContactListResponseTranslator.translate(person);
    }
}
