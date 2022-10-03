package com.vinicius.contact.list.api.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor
public class ContactListResponse extends PersonResponse {

    private List<ContactResponse> contacts;

}
