package com.vinicius.contact.list.api.translator;

import com.vinicius.contact.list.api.controller.request.CreateContactRequest;
import com.vinicius.contact.list.api.domain.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactRequestToContactTranslator {

    Contact translate(CreateContactRequest createContactRequest);

}
