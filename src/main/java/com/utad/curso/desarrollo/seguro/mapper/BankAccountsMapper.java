package com.utad.curso.desarrollo.seguro.mapper;

import java.util.ArrayList;
import java.util.List;

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

    public List<BankAccountDto> toDto(
            List<BankAccountEntity> bankAccountEntities) {

        if (bankAccountEntities == null) {
            return null;
        }

        List<BankAccountDto> bankAccountDtos = new ArrayList<>(bankAccountEntities.size());

        for (BankAccountEntity bankAccountEntity : bankAccountEntities) {
            BankAccountDto bankAccountDto = toDto(bankAccountEntity);
            bankAccountDtos.add(bankAccountDto);
        }

        return bankAccountDtos;

    }

}
