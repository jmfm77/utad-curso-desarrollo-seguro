package com.utad.curso.desarrollo.seguro.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utad.curso.desarrollo.seguro.dto.BankAccountDto;
import com.utad.curso.desarrollo.seguro.service.BankAccountsService;

@RestController
@RequestMapping("/api/bank-account")
public class BankAccountsController {

    @Autowired
    private BankAccountsService bankAccountsService;

    @PostMapping("/create")
    public BankAccountDto create() {

        return bankAccountsService.create();

    }

    @GetMapping("/get-all")
    public List<BankAccountDto> getAll() {

        return bankAccountsService.getAll();

    }

}
