package com.vinicius.contact.list.api.controller.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Builder
public class CreatePersonRequest {

    @NotEmpty(message = "O nome é obrigatório.")
    @Size(min = 2, max = 30, message = "O nome precisa ter no mínimo 2 e no máximo 20 caractéres.")
    private String name;

    @NotEmpty(message = "O sobrenome é obrigatório.")
    @Size(min = 2, max = 30, message = "O sobrenome precisa ter no mínimo 2 e no máximo 20 caractéres.")
    private String lastName;

    @NotEmpty(message = "Necessário passar ao menos um contato, número de telefone é obrigatório.")
    private Set<@Valid CreateContactRequest> contacts;

}
