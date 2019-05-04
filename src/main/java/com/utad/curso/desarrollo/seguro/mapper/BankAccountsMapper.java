package com.utad.curso.desarrollo.seguro.mapper;

import org.springframework.stereotype.Service;

import com.utad.curso.desarrollo.seguro.dto.BankAccountDto;
import com.utad.curso.desarrollo.seguro.entity.BankAccountEntity;

@Service
public class BankAccountsMapper {

    public BankAccountDto toDto(
            BankAccountEntity bankAccountEntity) {

        if (bankAccountEntity == null) {
            return null;
        }

        BankAccountDto bankAccountDto = new BankAccountDto();

        bankAccountDto.setIban(bankAccountEntity.getIban());
        bankAccountDto.setBalance(bankAccountEntity.getBalance());

        return bankAccountDto;

    }

}
