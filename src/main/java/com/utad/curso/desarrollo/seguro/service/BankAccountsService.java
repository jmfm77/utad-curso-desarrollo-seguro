package com.utad.curso.desarrollo.seguro.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utad.curso.desarrollo.seguro.dto.BankAccountDto;
import com.utad.curso.desarrollo.seguro.entity.BankAccountEntity;
import com.utad.curso.desarrollo.seguro.exception.BusinessLogicException;
import com.utad.curso.desarrollo.seguro.mapper.BankAccountsMapper;
import com.utad.curso.desarrollo.seguro.repository.BankAccountsRepository;
import com.utad.curso.desarrollo.seguro.utils.IbanService;

@Service
@Transactional
public class BankAccountsService {

    @Autowired
    private BankAccountsRepository bankAccountsRepository;

    @Autowired
    private BankAccountsMapper bankAccountsMapper;

    @Autowired
    private IbanService ibanService;

    public BankAccountDto create() {

        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setIban(ibanService.randomIban());
        bankAccountEntity.setBalance(0.0);
        bankAccountEntity = bankAccountsRepository.save(bankAccountEntity);

        BankAccountDto bankAccountDto = bankAccountsMapper.toDto(bankAccountEntity);

        return bankAccountDto;

    }

    public List<BankAccountDto> getAll() {

        List<BankAccountEntity> bankAccountEntities = bankAccountsRepository.findAll();
        List<BankAccountDto> bankAccountDtos = bankAccountsMapper.toDto(bankAccountEntities);

        return bankAccountDtos;

    }

    public void deleteByIban(
            String iban) {

        BankAccountEntity bankAccountEntity = bankAccountsRepository.findByIban(iban);

        if (bankAccountEntity == null) {
            throw new BusinessLogicException("account-does-not-exist");
        }

        if (bankAccountEntity.getBalance() > 0) {
            throw new BusinessLogicException("account-has-funds");
        }

        bankAccountsRepository.delete(bankAccountEntity);

    }

}
