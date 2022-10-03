package com.vinicius.contact.list.api.translator;

import com.vinicius.contact.list.api.controller.response.ContactResponse;
import com.vinicius.contact.list.api.domain.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactToContactResponseTranslator {

    ContactResponse translate(Contact contact);

}
