package com.vinicius.contact.list.api.translator;

import com.vinicius.contact.list.api.controller.response.PersonResponse;
import com.vinicius.contact.list.api.domain.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonToPersonResponseTranslator {

    PersonResponse translate(Person person);

}
