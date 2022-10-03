package com.vinicius.contact.list.api.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {

    private String uuid;

    private String name;

    private String lastName;

    private OffsetDateTime createdAt;

    private OffsetDateTime modifiedAt;

}
