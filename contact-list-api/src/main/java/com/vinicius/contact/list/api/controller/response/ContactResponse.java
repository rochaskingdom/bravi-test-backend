package com.vinicius.contact.list.api.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {

    private String uuid;

    private String phone;

    private String email;

    private String whatsapp;

    private OffsetDateTime createdAt;

    private OffsetDateTime modifiedAt;
}
