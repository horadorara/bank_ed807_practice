package com.example.bank.services.reference_books;

import com.example.bank.DTO.reference_books.ParticipantStatusDTO;
import com.example.bank.entities.referenсe_books.ParticipantStatusEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.reference_books.ParticipantStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantStatusService {

    private final ParticipantStatusRepository repository;

    private final DTOMapper mapper;

    @Transactional
    public ParticipantStatusDTO create(ParticipantStatusDTO dto) {
        ParticipantStatusEntity entity = new ParticipantStatusEntity();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return mapper.toParticipantStatusDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<ParticipantStatusDTO> getAll() {
        return mapper.toParticipantStatusListDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public ParticipantStatusDTO getById(Long id) {
        ParticipantStatusEntity entity = repository.findById(id).orElse(null);
        return mapper.toParticipantStatusDto(entity);
    }

    @Transactional
    public ParticipantStatusDTO updateById(Long id, ParticipantStatusDTO participantStatus) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCode(participantStatus.getCode());
                    entity.setDescription(participantStatus.getDescription());
                    return mapper.toParticipantStatusDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
