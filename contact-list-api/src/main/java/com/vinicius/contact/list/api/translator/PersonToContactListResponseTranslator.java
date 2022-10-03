package com.vinicius.contact.list.api.translator;

import com.vinicius.contact.list.api.controller.response.ContactListResponse;
import com.vinicius.contact.list.api.domain.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonToContactListResponseTranslator {

    ContactListResponse translate(Person person);

}
