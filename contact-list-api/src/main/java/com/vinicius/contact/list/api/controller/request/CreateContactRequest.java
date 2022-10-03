package com.vinicius.contact.list.api.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static com.vinicius.contact.list.api.domain.constants.Constants.EMAIL_PATTER;
import static com.vinicius.contact.list.api.domain.constants.Constants.PHONE_PATTERN;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateContactRequest {

    @Pattern(regexp = PHONE_PATTERN, message = "Número de telefone inválido.")
    @NotEmpty(message = "Número de telefone é obrigatório.")
    private String phone;

    @Pattern(regexp = EMAIL_PATTER, message = "Endereço de e-mail inválido")
    private String email;

    @Pattern(regexp = PHONE_PATTERN, message = "Número de whatsapp inválido.")
    private String whatsapp;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("phone", phone)
                .append("email", email)
                .append("whatsapp", whatsapp)
                .toString();
    }
}
