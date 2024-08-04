package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.AccRstrDTO;
import com.example.bank.entities.referenсe_books.AccRstrEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.AccRstrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccRstrService {

    private final AccRstrRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public AccRstrDTO create(AccRstrDTO dto) {
        AccRstrEntity entity = new AccRstrEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toAccRstrDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<AccRstrDTO> getAll() {
        return mapper.toAccRstrListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public AccRstrDTO getById(Long id) {
        AccRstrEntity entity = repository.findById(id).orElse(null);
        return mapper.toAccRstrDto(entity);

    }

    @Transactional
    public AccRstrDTO updateById(Long id, AccRstrDTO accountRstr) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(accountRstr.getCode());
                    entity.setDescription(accountRstr.getDescription());
                    return mapper.toAccRstrDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
