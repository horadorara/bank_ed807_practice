package com.example.bank.services;

import com.example.bank.DTO.RstrListDTO;
import com.example.bank.entities.ParticipantInfoEntity;
import com.example.bank.entities.RstrListEntity;
import com.example.bank.entities.referenсe_books.RstrEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.ParticipantInfoRepository;
import com.example.bank.repositories.RstrListRepository;
import com.example.bank.repositories.reference_books.RstrRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RstrListService {

    private final RstrListRepository repository;

    private final RstrRepository rstrRepository;

    private final ParticipantInfoRepository participantInfoRepository;

    private final DTOMapper mapper;

    @Transactional
    public RstrListDTO create(RstrListDTO  dto, Long participantId) {
        RstrListEntity entity = new RstrListEntity();
        entity.setRstr(rstrRepository.findByCode(dto.getRstr()));
        entity.setRstrDate(dto.getRstrDate());

        ParticipantInfoEntity participantInfoEntity = participantInfoRepository.findById(participantId)
                .orElseThrow(() -> new EntityNotFoundException("ParticipantInfo not found with id: " + participantId));

        entity.setParticipantInfos(participantInfoEntity);
        participantInfoEntity.getRstrLists().add(entity);

        return mapper.toRstrListDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<RstrListDTO> getAll() {
        List<RstrListEntity> entities = repository.findAll();
        return  mapper.toRstrsListToListDto(entities);
    }

    @Transactional(readOnly = true)
    public RstrListDTO getById(Long id) {
        RstrListEntity entity = repository.findById(id).orElse(null);
        return mapper.toRstrListDto(entity);
    }

    @Transactional
    public RstrListDTO updateById(Long id, RstrListDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setRstr(rstrRepository.findByCode(dto.getRstr()));
                    entity.setRstrDate(dto.getRstrDate());
                    return mapper.toRstrListDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public RstrListEntity createRstrList(RstrEntity rstr, Date rstrDate, ParticipantInfoEntity participantInfo) {
            RstrListEntity newRstrList = new RstrListEntity();
            newRstrList.setRstr(rstr);
            newRstrList.setRstrDate(rstrDate);
            newRstrList.setParticipantInfos(participantInfo);
            participantInfo.getRstrLists().add(newRstrList);
            return newRstrList;
    }
}
