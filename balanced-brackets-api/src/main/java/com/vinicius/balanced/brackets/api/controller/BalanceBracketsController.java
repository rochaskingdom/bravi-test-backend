package com.vinicius.balanced.brackets.api.controller;

import com.vinicius.balanced.brackets.api.domain.service.BalanceBracketsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brackets")
public class BalanceBracketsController {

    private final BalanceBracketsService balanceBracketsService;

    public BalanceBracketsController(BalanceBracketsService balanceBracketsService) {
        this.balanceBracketsService = balanceBracketsService;
    }

    @GetMapping
    public String balance(@RequestParam(name = "value") String value) {
        return balanceBracketsService.balance(value);
    }
}
