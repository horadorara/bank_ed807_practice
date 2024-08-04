package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.RegulationAccountTypeDTO;
import com.example.bank.entities.referenсe_books.RegulationAccountTypeEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.RegulationAccountTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegulationAccountTypeService {

    private final RegulationAccountTypeRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public RegulationAccountTypeDTO create(RegulationAccountTypeDTO dto) {
        RegulationAccountTypeEntity entity = new RegulationAccountTypeEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toRegulationAccountTypeDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<RegulationAccountTypeDTO> getAll() {
        return mapper.toRegulationAccountTypeListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public RegulationAccountTypeDTO getById(Long id) {
        RegulationAccountTypeEntity entity = repository.findById(id).orElse(null);
        return mapper.toRegulationAccountTypeDto(entity);
    }

    @Transactional
    public RegulationAccountTypeDTO updateById(Long id, RegulationAccountTypeDTO regulationAccountType) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(regulationAccountType.getCode());
                    entity.setDescription(regulationAccountType.getDescription());
                    return mapper.toRegulationAccountTypeDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
