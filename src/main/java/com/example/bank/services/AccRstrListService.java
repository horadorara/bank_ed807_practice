package com.example.bank.services;

import com.example.bank.DTO.AccRstrListDTO;
import com.example.bank.DTO.AccountsDTO;
import com.example.bank.entities.AccRstrListEntity;
import com.example.bank.entities.AccountsEntity;
import com.example.bank.entities.BICDirectoryEntryEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.AccRstrListRepository;
import com.example.bank.repositories.AccountsRepository;
import com.example.bank.repositories.reference_books.AccRstrRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccRstrListService {

    private final AccRstrListRepository repository;

    private final AccRstrRepository accRstrRepository;

    private final AccountsRepository accountsRepository;

    private final DTOMapper mapper;


    @Transactional
    public AccRstrListDTO create(AccRstrListDTO dto, Long accId) {
        AccRstrListEntity entity = new AccRstrListEntity();
        entity.setAccRstr(accRstrRepository.findByCode(dto.getAccRstr()));
        entity.setAccRstrDate(dto.getAccRstrDate());
        entity.setSuccessorBic(dto.getSuccessorBic());

        AccountsEntity accountsEntity = accountsRepository.findById(accId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id: " + accId));

        entity.setAccounts(accountsEntity);
        accountsEntity.getAccRstrLists().add(entity);

        return mapper.toAccRstrListDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<AccRstrListDTO> getAll() {
        List<AccRstrListEntity> entities = repository.findAll();
        return mapper.toAccRstrListToListDto(entities);
    }

    @Transactional(readOnly = true)
    public AccRstrListDTO getById(Long id) {
        AccRstrListEntity entity = repository.findById(id).orElse(null);
        return mapper.toAccRstrListDto(entity);
    }

    @Transactional
    public AccRstrListDTO updateById(Long id, AccRstrListDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setAccRstr(accRstrRepository.findByCode(dto.getAccRstr()));
                    entity.setAccRstrDate(dto.getAccRstrDate());
                    entity.setSuccessorBic(dto.getSuccessorBic());
                    return mapper.toAccRstrListDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
