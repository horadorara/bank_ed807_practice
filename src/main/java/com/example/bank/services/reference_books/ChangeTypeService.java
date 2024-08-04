package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.ChangeTypeDTO;
import com.example.bank.entities.referenсe_books.ChangeTypeEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.ChangeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeTypeService {

    private final ChangeTypeRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public ChangeTypeDTO create(ChangeTypeDTO dto) {
        ChangeTypeEntity entity = new ChangeTypeEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toChangeTypeDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<ChangeTypeDTO> getAll() {
        return mapper.toChangeTypeListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public ChangeTypeDTO getById(Long id) {
        ChangeTypeEntity entity = repository.findById(id).orElse(null);
        return mapper.toChangeTypeDto(entity);
    }

    @Transactional
    public ChangeTypeDTO updateById(Long id, ChangeTypeDTO changeType) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(changeType.getCode());
                    entity.setDescription(changeType.getDescription());
                    return mapper.toChangeTypeDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
