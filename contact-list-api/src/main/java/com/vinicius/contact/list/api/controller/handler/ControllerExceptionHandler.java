package com.vinicius.contact.list.api.controller.handler;

import com.vinicius.contact.list.api.domain.exception.ContactListException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleBadRequest(MethodArgumentNotValidException ex) {
        var errorResponse = new ErrorResponse();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorResponse.status = HttpStatus.BAD_REQUEST;
            errorResponse.errorCode = "contact-list-validation-error";
            errorResponse.errorDescription = fieldError.getDefaultMessage();
        });
        log.error("Validation error - [{}]", errorResponse);
        return errorResponse;
    }

    @ExceptionHandler(ContactListException.class)
    public ResponseEntity<ErrorResponse> handleContactList(ContactListException ex) {
        var errorResponse = new ErrorResponse(ex.getStatus(), ex.getErrorCode(), ex.getErrorDescription());
        log.error("Validation error - [{}]", errorResponse, ex);
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ErrorResponse {
        HttpStatus status;
        String errorCode;
        String errorDescription;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("status", status)
                    .append("errorCode", errorCode)
                    .append("errorDescription", errorDescription)
                    .toString();
        }
    }
}
