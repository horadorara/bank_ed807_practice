package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.CreationReasonDTO;
import com.example.bank.entities.referenсe_books.CreationReasonEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.CreationReasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreationReasonService {

    private final CreationReasonRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public CreationReasonDTO create(CreationReasonDTO dto) {
        CreationReasonEntity entity = new CreationReasonEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toCreationReasonDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<CreationReasonDTO> getAll() {
        return mapper.toCreationReasonListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public CreationReasonDTO getById(Long id) {
        CreationReasonEntity entity = repository.findById(id).orElse(null);
        return mapper.toCreationReasonDto(entity);
    }

    @Transactional
    public CreationReasonDTO updateById(Long id, CreationReasonDTO creationReason) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(creationReason.getCode());
                    entity.setDescription(creationReason.getDescription());
                    return mapper.toCreationReasonDto(entity);
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
