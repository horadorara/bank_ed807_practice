package com.example.bank.services;

import com.example.bank.DTO.SWBICSDTO;
import com.example.bank.entities.BICDirectoryEntryEntity;
import com.example.bank.entities.SWBICSEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.BICDirectoryEntryRepository;
import com.example.bank.repositories.SWBICSRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SWBICSService {

    private final SWBICSRepository repository;
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;
    private final DTOMapper mapper;


    @Transactional
    public SWBICSDTO create(SWBICSDTO dto, Long bicDirectoryEntryId) {
        SWBICSEntity entity = new SWBICSEntity();
        entity.setSwbic(dto.getSwbic());
        entity.setDefaultSwbic(dto.isDefaultSwbic());

        BICDirectoryEntryEntity bicDirectoryEntryEntity = bicDirectoryEntryRepository.findById(bicDirectoryEntryId)
                .orElseThrow(() -> new EntityNotFoundException("ED807 not found with id: " + bicDirectoryEntryId));

        entity.setBicDirectoryEntry(bicDirectoryEntryEntity);
        bicDirectoryEntryEntity.getSwbics().add(entity);

        return mapper.toSwbicsDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<SWBICSDTO> getAll() {
        List<SWBICSEntity> entities = repository.findAll();
        return  mapper.toSwbicsListDto(entities);
    }

    @Transactional(readOnly = true)
    public SWBICSDTO getById(Long id) {
        SWBICSEntity entity = repository.findById(id).orElse(null);
        return mapper.toSwbicsDto(entity);
    }

    @Transactional
    public SWBICSDTO updateById(Long id, SWBICSDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setSwbic(dto.getSwbic());
                    entity.setDefaultSwbic(dto.isDefaultSwbic());
                    return mapper.toSwbicsDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
