package com.vinicius.contact.list.api.controller.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdatePersonRequest {

    private String name;
    private String lastName;

}
