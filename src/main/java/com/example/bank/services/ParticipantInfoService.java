package com.example.bank.services;

import com.example.bank.DTO.ParticipantInfoDTO;
import com.example.bank.entities.BICDirectoryEntryEntity;
import com.example.bank.entities.ParticipantInfoEntity;
import com.example.bank.entities.referenсe_books.ParticipantStatusEntity;
import com.example.bank.entities.referenсe_books.PtTypeEntity;
import com.example.bank.entities.referenсe_books.SrvcsEntity;
import com.example.bank.entities.referenсe_books.XchTypeEntity;
import com.example.bank.mappers.DTOMapper;
import com.example.bank.repositories.*;
import com.example.bank.repositories.reference_books.ParticipantStatusRepository;
import com.example.bank.repositories.reference_books.PtTypeRepository;
import com.example.bank.repositories.reference_books.SrvcsRepository;
import com.example.bank.repositories.reference_books.XchTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantInfoService {

    private final ParticipantInfoRepository repository;
    private final PtTypeRepository ptTypeRepository;
    private final SrvcsRepository srvcsRepository;
    private final XchTypeRepository xchTypeRepository;
    private final ParticipantStatusRepository participantStatusRepository;
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;
    private final DTOMapper mapper;

    @Transactional
    public ParticipantInfoDTO create(ParticipantInfoDTO  dto, Long bicDirectoryEntryId) {
        ParticipantInfoEntity entity = new ParticipantInfoEntity();
        entity.setNameP(dto.getNameP());
        entity.setEnglName(dto.getEnglName());
        entity.setRegN(dto.getRegN());
        entity.setCntrCd(dto.getCntrCd());
        entity.setRgn(dto.getRgn());
        entity.setInd(dto.getInd());
        entity.setTnp(dto.getTnp());
        entity.setNnp(dto.getNnp());
        entity.setAdr(dto.getAdr());
        entity.setPrntBic(dto.getPrntBic());
        entity.setDateIn(dto.getDateIn());
        entity.setDateOut(dto.getDateOut());
        entity.setPtType(ptTypeRepository.findByCode(dto.getPtType()));
        entity.setSrvcs(srvcsRepository.findByCode(dto.getSrvcs()));
        entity.setXchType(xchTypeRepository.findByCode(dto.getXchType()));
        entity.setUid(dto.getUid());
        entity.setParticipantStatus(participantStatusRepository.findByCode(dto.getParticipantStatus()));

        BICDirectoryEntryEntity bicDirectoryEntryEntity = bicDirectoryEntryRepository.findById(bicDirectoryEntryId)
                .orElseThrow(() -> new EntityNotFoundException("ED807 not found with id: " + bicDirectoryEntryId));

        entity.setBicDirectoryEntry(bicDirectoryEntryEntity);
        bicDirectoryEntryEntity.setParticipantInfo(entity);

        return mapper.toParticipantInfoDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public List<ParticipantInfoDTO> getAll() {
        List<ParticipantInfoEntity> entities = repository.findAll();
        return  mapper.toParticipantInfoListDto(entities);
    }

    @Transactional(readOnly = true)
    public ParticipantInfoDTO getById(Long id) {
        ParticipantInfoEntity entity = repository.findById(id).orElse(null);
        return mapper.toParticipantInfoDetailDto(entity);
    }

    @Transactional
    public ParticipantInfoDTO updateById(Long id, ParticipantInfoDTO dto) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setNameP(dto.getNameP());
                    entity.setEnglName(dto.getEnglName());
                    entity.setRegN(dto.getRegN());
                    entity.setCntrCd(dto.getCntrCd());
                    entity.setRgn(dto.getRgn());
                    entity.setInd(dto.getInd());
                    entity.setTnp(dto.getTnp());
                    entity.setNnp(dto.getNnp());
                    entity.setAdr(dto.getAdr());
                    entity.setPrntBic(dto.getPrntBic());
                    entity.setDateIn(dto.getDateIn());
                    entity.setDateOut(dto.getDateOut());
                    entity.setPtType(ptTypeRepository.findByCode(dto.getPtType()));
                    entity.setSrvcs(srvcsRepository.findByCode(dto.getSrvcs()));
                    entity.setXchType(xchTypeRepository.findByCode(dto.getXchType()));
                    entity.setUid(dto.getUid());
                    entity.setParticipantStatus(participantStatusRepository.findByCode(dto.getParticipantStatus()));
                    return mapper.toParticipantInfoDto(repository.save(entity));
                }).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        ParticipantInfoEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ParticipantInfo not found with id: " + id));

        BICDirectoryEntryEntity bicDirectoryEntry = entity.getBicDirectoryEntry();
        if (bicDirectoryEntry != null) {
            bicDirectoryEntry.setParticipantInfo(null);
        }
        repository.deleteById(id);
    }

    public ParticipantInfoEntity createParticipantInfo(String nameP,
                                                       String englName,
                                                       String regN,
                                                       String cntrCd,
                                                       String rgn,
                                                       String ind,
                                                       String tnp,
                                                       String nnp,
                                                       String adr,
                                                       String prntBic,
                                                       Date dateIn,
                                                       Date dateOut,
                                                       PtTypeEntity ptType,
                                                       SrvcsEntity srvcs,
                                                       XchTypeEntity xchType,
                                                       String uid,
                                                       ParticipantStatusEntity participantStatus,
                                                       BICDirectoryEntryEntity bicDirectoryEntry) {


            ParticipantInfoEntity newParticipantInfo = new ParticipantInfoEntity();
            newParticipantInfo.setNameP(nameP);
            newParticipantInfo.setEnglName(englName);
            newParticipantInfo.setRegN(regN);
            newParticipantInfo.setCntrCd(cntrCd);
            newParticipantInfo.setRgn(rgn);
            newParticipantInfo.setInd(ind);
            newParticipantInfo.setTnp(tnp);
            newParticipantInfo.setNnp(nnp);
            newParticipantInfo.setAdr(adr);
            newParticipantInfo.setPrntBic(prntBic);
            newParticipantInfo.setDateIn(dateIn);
            newParticipantInfo.setDateOut(dateOut);
            newParticipantInfo.setPtType(ptType);
            newParticipantInfo.setSrvcs(srvcs);
            newParticipantInfo.setXchType(xchType);
            newParticipantInfo.setUid(uid);
            newParticipantInfo.setParticipantStatus(participantStatus);
            newParticipantInfo.setBicDirectoryEntry(bicDirectoryEntry);
            bicDirectoryEntry.setParticipantInfo(newParticipantInfo);
            return newParticipantInfo;
    }
}

