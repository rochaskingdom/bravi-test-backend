package com.vinicius.balanced.brackets.api.domain.service.impl;

import com.vinicius.balanced.brackets.api.domain.service.BalanceBracketsService;
import org.springframework.stereotype.Service;

import static com.vinicius.balanced.brackets.api.domain.constants.Constants.INVALID_BRACKETS;
import static com.vinicius.balanced.brackets.api.domain.constants.Constants.VALID_BRACKETS;
import static java.util.Objects.isNull;

@Service
public class BalanceBracketsServiceImpl implements BalanceBracketsService {

    @Override
    public String balance(String brackets) {
        return validateBrackets(brackets);
    }

    private String validateBrackets(String brackets) {
        if (isNull(brackets) || brackets.isBlank() || ((brackets.length()%2) != 0)) {
            return INVALID_BRACKETS;
        }

        var bracketsToCharArray = brackets.toCharArray();
        var isValid = new String(bracketsToCharArray)
                .chars()
                .allMatch(bracketChar -> verifyBracketChar((char) bracketChar));

        return isValid ? VALID_BRACKETS : INVALID_BRACKETS;
    }

    private boolean verifyBracketChar(char bracketChar) {
        return bracketChar == '{' ||
                bracketChar == '[' ||
                bracketChar == '(' ||
                bracketChar == '}' ||
                bracketChar == ']' ||
                bracketChar == ')';
    }

}
