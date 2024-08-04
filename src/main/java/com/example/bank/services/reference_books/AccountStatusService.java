package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.AccountStatusDTO;
import com.example.bank.entities.AccountsEntity;
import com.example.bank.entities.referenсe_books.AccountStatusEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.AccountStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountStatusService {

    private final AccountStatusRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public AccountStatusDTO create(AccountStatusDTO dto) {
        AccountStatusEntity entity = new AccountStatusEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toAccountStatusDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<AccountStatusDTO> getAll() {
        return  mapper.toAccountStatusListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public AccountStatusDTO getById(Long id) {
        AccountStatusEntity entity = repository.findById(id).orElse(null);
        return mapper.toAccountStatusDto(entity);
    }

    @Transactional
    public AccountStatusDTO updateById(Long id, AccountStatusDTO accountStatus) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(accountStatus.getCode());
                    entity.setDescription(accountStatus.getDescription());
                    return mapper.toAccountStatusDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
