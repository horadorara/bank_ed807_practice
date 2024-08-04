package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.InfoTypeCodeDTO;
import com.example.bank.entities.referenсe_books.InfoTypeCodeEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.InfoTypeCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoTypeCodeService {

    private final InfoTypeCodeRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public InfoTypeCodeDTO create(InfoTypeCodeDTO dto) {
        InfoTypeCodeEntity entity = new InfoTypeCodeEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toInfoTypeCodeDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<InfoTypeCodeDTO> getAll() {
        return mapper.toInfoTypeCodeListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public InfoTypeCodeDTO getById(Long id) {
        InfoTypeCodeEntity entity = repository.findById(id).orElse(null);
        return mapper.toInfoTypeCodeDto(entity);
    }

    @Transactional
    public InfoTypeCodeDTO updateById(Long id, InfoTypeCodeDTO infoTypeCode) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(infoTypeCode.getCode());
                    entity.setDescription(infoTypeCode.getDescription());
                    return mapper.toInfoTypeCodeDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
