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
        if (isNull(brackets) || brackets.isBlank() || ((brackets.length()%2) != 0) || !isValid(brackets)) {
            return INVALID_BRACKETS;
        }
        return balancedBrackets(brackets);
    }

    private boolean isValid(String brackets) {
        var bracketsToCharArray = brackets.toCharArray();
        return new String(bracketsToCharArray)
                .chars()
                .anyMatch(bracketChar -> verifyBracketChar((char) bracketChar));
    }

    private boolean verifyBracketChar(char bracketChar) {
        return (bracketChar == '{' ||
                bracketChar == '[' ||
                bracketChar == '(' ||
                bracketChar == '}' ||
                bracketChar == ']' ||
                bracketChar == ')');
    }

    private String balancedBrackets(String brackets) {
        while (brackets.contains("()") || brackets.contains("[]") || brackets.contains("{}")) {
            brackets = brackets
                    .replaceAll("\\(\\)", "")
                    .replaceAll("\\[]", "")
                    .replaceAll("\\{}", "");
        }
        return brackets.isBlank() ? VALID_BRACKETS : INVALID_BRACKETS;
    }

}
