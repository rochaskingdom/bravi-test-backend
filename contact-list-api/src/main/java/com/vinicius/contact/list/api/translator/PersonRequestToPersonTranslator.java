package com.vinicius.contact.list.api.translator;

import com.vinicius.contact.list.api.controller.request.CreatePersonRequest;
import com.vinicius.contact.list.api.domain.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonRequestToPersonTranslator {

    Person translate(CreatePersonRequest createPersonRequest);

}
