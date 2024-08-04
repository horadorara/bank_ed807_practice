package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.RstrDTO;
import com.example.bank.entities.referenсe_books.RstrEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.RstrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RstrService {

    private final RstrRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public RstrDTO create(RstrDTO dto) {
        RstrEntity entity = new RstrEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toRstrDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<RstrDTO> getAll() {
        return mapper.toRstrListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public RstrDTO getById(Long id) {
        RstrEntity entity = repository.findById(id).orElse(null);
        return mapper.toRstrDto(entity);
    }

    @Transactional
    public RstrDTO updateById(Long id, RstrDTO rstr) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(rstr.getCode());
                    entity.setDescription(rstr.getDescription());
                    return mapper.toRstrDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
