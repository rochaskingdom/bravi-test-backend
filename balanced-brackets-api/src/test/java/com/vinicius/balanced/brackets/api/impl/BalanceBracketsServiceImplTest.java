package com.vinicius.balanced.brackets.api.impl;

import com.vinicius.balanced.brackets.api.domain.service.impl.BalanceBracketsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.vinicius.balanced.brackets.api.domain.constants.Constants.INVALID_BRACKETS;
import static com.vinicius.balanced.brackets.api.domain.constants.Constants.VALID_BRACKETS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Service - BalanceBracketsServiceImpl")
public class BalanceBracketsServiceImplTest {

    @InjectMocks
    private BalanceBracketsServiceImpl balanceBracketsService;

    @Test
    @DisplayName("Deve validar colchetes com sucesso")
    void shouldValideBracketsWithSuccess() {
        var serviceResponse = balanceBracketsService.balance("(){}[]");
        assertEquals(VALID_BRACKETS, serviceResponse);

        var serviceResponse2 = balanceBracketsService.balance("[{()}](){}");
        assertEquals(VALID_BRACKETS, serviceResponse2);
    }

    @Test
    @DisplayName("Deve validar colchetes com erro")
    void shouldValidateBracketsWithError() {
        var serviceResponse = balanceBracketsService.balance("()}[]");
        assertEquals(INVALID_BRACKETS, serviceResponse);

        var serviceResponse2 = balanceBracketsService.balance("sd");
        assertEquals(INVALID_BRACKETS, serviceResponse2);
    }
}
