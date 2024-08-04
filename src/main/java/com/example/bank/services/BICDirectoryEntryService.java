package com.example.bank.services;

import com.example.bank.DTO.BICDirectoryEntryDTO;
import com.example.bank.entities.*;
import com.example.bank.entities.referenсe_books.ChangeTypeEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.BICDirectoryEntryRepository;
import com.example.bank.repositories.ED807Repository;
import com.example.bank.repositories.ParticipantInfoRepository;
import com.example.bank.repositories.reference_books.ChangeTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BICDirectoryEntryService {

    private final BICDirectoryEntryRepository repository;

    private final ChangeTypeRepository changeTypeRepository;

    private final ED807Repository ed807Repository;

    private final ParticipantInfoRepository participantInfoRepository;

    private final DTOMapper mapper;

    @Transactional
    public BICDirectoryEntryDTO create(BICDirectoryEntryDTO dto, Long ed807Id) {
        BICDirectoryEntryEntity entity = new BICDirectoryEntryEntity();
        entity.setBic(dto.getBic());
        entity.setChangeType(changeTypeRepository.findByCode(dto.getChangeType()));

        ED807Entity ed807Entity = ed807Repository.findById(ed807Id)
                .orElseThrow(() -> new EntityNotFoundException("ED807 not found with id: " + ed807Id));

        entity.setEd807(ed807Entity);
        ed807Entity.getBicDirectoryEntries().add(entity);

        return mapper.toBicDirectoryDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<BICDirectoryEntryDTO> getAll() {
        List<BICDirectoryEntryEntity> entities = repository.findAll();
        return  mapper.toBicDirectoryEntryListDto(entities);
    }

    @Transactional(readOnly = true)
    public BICDirectoryEntryDTO getById(Long id) {
        BICDirectoryEntryEntity entity = repository.findById(id).orElse(null);
        return mapper.toBicDirectoryDetailDto(entity);
    }

    @Transactional
    public BICDirectoryEntryDTO updateById(Long id, BICDirectoryEntryDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setBic(dto.getBic());
                    entity.setChangeType(changeTypeRepository.findByCode(dto.getChangeType()));
                    return mapper.toBicDirectoryDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        BICDirectoryEntryEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BICDirectoryEntry not found with id: " + id));

        if (entity.getParticipantInfo() != null) {
            ParticipantInfoEntity participantInfo = entity.getParticipantInfo();
            participantInfo.setBicDirectoryEntry(null);
        }

        repository.deleteById(id);
    }

    public BICDirectoryEntryEntity createBicDirectoryEntry(String bic, ChangeTypeEntity changeType, ED807Entity ed807Entity) {
            BICDirectoryEntryEntity newBicDirectoryEntry = new BICDirectoryEntryEntity();
            newBicDirectoryEntry.setBic(bic);
            newBicDirectoryEntry.setChangeType(changeType);
            newBicDirectoryEntry.setEd807(ed807Entity);
            ed807Entity.getBicDirectoryEntries().add(newBicDirectoryEntry);
            return newBicDirectoryEntry;
    }


}
