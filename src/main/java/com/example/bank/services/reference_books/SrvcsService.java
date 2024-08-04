package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.SrvcsDTO;
import com.example.bank.entities.referenсe_books.SrvcsEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.SrvcsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SrvcsService {

    private final SrvcsRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public SrvcsDTO create(SrvcsDTO dto) {
        SrvcsEntity entity = new SrvcsEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toSrvcsDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<SrvcsDTO> getAll() {
        return mapper.toSrvcsListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public SrvcsDTO getById(Long id) {
        SrvcsEntity entity = repository.findById(id).orElse(null);
        return mapper.toSrvcsDto(entity);
    }

    @Transactional
    public SrvcsDTO updateById(Long id, SrvcsDTO srvcs) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(srvcs.getCode());
                    entity.setDescription(srvcs.getDescription());
                    return mapper.toSrvcsDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
