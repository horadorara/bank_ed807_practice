package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.XchTypeDTO;
import com.example.bank.entities.referenсe_books.XchTypeEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.XchTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class XchTypeService {

    private final XchTypeRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public XchTypeDTO create(XchTypeDTO dto) {
        XchTypeEntity entity = new XchTypeEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toXchTypeDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<XchTypeDTO> getAll() {
        return mapper.toXchTypeListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public XchTypeDTO getById(Long id) {
        XchTypeEntity entity = repository.findById(id).orElse(null);
        return mapper.toXchTypeDto(entity);
    }

    @Transactional
    public XchTypeDTO updateById(Long id, XchTypeDTO xchType) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(xchType.getCode());
                    entity.setDescription(xchType.getDescription());
                    return mapper.toXchTypeDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
