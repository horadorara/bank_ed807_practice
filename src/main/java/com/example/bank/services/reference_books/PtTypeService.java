package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.PtTypeDTO;
import com.example.bank.entities.referenсe_books.PtTypeEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.PtTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PtTypeService {

    private final PtTypeRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public PtTypeDTO create(PtTypeDTO dto) {
        PtTypeEntity entity = new PtTypeEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toPtTypeDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<PtTypeDTO> getAll() {
        return mapper.toPtTypeListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public PtTypeDTO getById(Long id) {
        PtTypeEntity entity = repository.findById(id).orElse(null);
        return mapper.toPtTypeDto(entity);
    }

    @Transactional
    public PtTypeDTO updateById(Long id, PtTypeDTO ptType) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(ptType.getCode());
                    entity.setDescription(ptType.getDescription());
                    return mapper.toPtTypeDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
