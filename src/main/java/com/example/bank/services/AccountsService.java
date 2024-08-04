package com.example.bank.services;

import com.example.bank.DTO.AccountsDTO;
import com.example.bank.entities.AccountsEntity;
import com.example.bank.entities.BICDirectoryEntryEntity;
import com.example.bank.entities.referenсe_books.AccountStatusEntity;
import com.example.bank.entities.referenсe_books.RegulationAccountTypeEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.AccountsRepository;
import com.example.bank.repositories.BICDirectoryEntryRepository;
import com.example.bank.repositories.reference_books.AccountStatusRepository;
import com.example.bank.repositories.reference_books.RegulationAccountTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsService {

    private final AccountsRepository repository;

    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    private final RegulationAccountTypeRepository regulationAccountTypeRepository;

    private final AccountStatusRepository accountStatusRepository;

    private final DTOMapper mapper;

    @Transactional
    public AccountsDTO create(AccountsDTO dto, Long bicId) {
        AccountsEntity entity = new AccountsEntity();
        entity.setAccount(dto.getAccount());
        entity.setRegulationAccountType(regulationAccountTypeRepository.findByCode(dto.getRegulationAccountType()));
        entity.setCk(dto.getCk());
        entity.setAccountCbrBic(dto.getAccountCbrBic());
        entity.setDateIn(dto.getDateIn());
        entity.setDateOut(dto.getDateOut());
        entity.setAccountStatus(accountStatusRepository.findByCode(dto.getAccountStatus()));

        BICDirectoryEntryEntity bicDirectoryEntryEntity = bicDirectoryEntryRepository.findById(bicId)
                .orElseThrow(() -> new EntityNotFoundException("BICDirectoryEntry not found with id: " + bicId));

        entity.setBicDirectoryEntry(bicDirectoryEntryEntity);
        bicDirectoryEntryEntity.getAccounts().add(entity);

        return mapper.toAccountsDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<AccountsDTO> getAll() {
        List<AccountsEntity> entities = repository.findAll();
        return mapper.toAccountsListDto(entities);
    }

    @Transactional(readOnly = true)
    public AccountsDTO getById(Long id) {
        AccountsEntity entity = repository.findById(id).orElse(null);
        return mapper.toAccountsDetailDto(entity);
    }

    @Transactional
    public AccountsDTO updateById(Long id, AccountsDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setAccount(dto.getAccount());
                    entity.setRegulationAccountType(regulationAccountTypeRepository.findByCode(dto.getRegulationAccountType()));
                    entity.setCk(dto.getCk());
                    entity.setAccountCbrBic(dto.getAccountCbrBic());
                    entity.setDateIn(dto.getDateIn());
                    entity.setDateOut(dto.getDateOut());
                    entity.setAccountStatus(accountStatusRepository.findByCode(dto.getAccountStatus()));
                    return mapper.toAccountsDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public AccountsEntity createAccounts(
            String account,
            RegulationAccountTypeEntity regulationAccountType,
            String ck,
            String accountCbrBic,
            Date dateIn,
            Date dateOut,
            AccountStatusEntity accountStatus,
            BICDirectoryEntryEntity bicDirectoryEntry
    ) {
            AccountsEntity newAccountsEntity = new AccountsEntity();
            newAccountsEntity.setAccount(account);
            newAccountsEntity.setRegulationAccountType(regulationAccountType);
            newAccountsEntity.setCk(ck);
            newAccountsEntity.setAccountCbrBic(accountCbrBic);
            newAccountsEntity.setDateIn(dateIn);
            newAccountsEntity.setDateOut(dateOut);
            newAccountsEntity.setAccountStatus(accountStatus);
            newAccountsEntity.setBicDirectoryEntry(bicDirectoryEntry);
            bicDirectoryEntry.getAccounts().add(newAccountsEntity);
            return newAccountsEntity;
    }
}
