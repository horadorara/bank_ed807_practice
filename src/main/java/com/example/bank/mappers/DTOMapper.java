package com.example.bank.mappers;

import com.example.bank.DTO.*;
import com.example.bank.entities.*;
import com.example.bank.entities.referenсe_books.AccRstrEntity;
import com.example.bank.entities.referenсe_books.AccountStatusEntity;
import com.example.bank.entities.referenсe_books.ChangeTypeEntity;
import com.example.bank.entities.referenсe_books.CreationReasonEntity;
import com.example.bank.entities.referenсe_books.InfoTypeCodeEntity;
import com.example.bank.entities.referenсe_books.ParticipantStatusEntity;
import com.example.bank.entities.referenсe_books.PtTypeEntity;
import com.example.bank.entities.referenсe_books.RegulationAccountTypeEntity;
import com.example.bank.entities.referenсe_books.RstrEntity;
import com.example.bank.entities.referenсe_books.SrvcsEntity;
import com.example.bank.entities.referenсe_books.XchTypeEntity;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DTOMapper {

    public ED807DetailDTO toEd807Dto(ED807Entity entity) {
        if (entity == null) {
            return null;
        }

        ED807DetailDTO dto = new ED807DetailDTO();
        dto.setId(entity.getId());
        dto.setEdNo(entity.getEdNo());
        dto.setFileName(entity.getFileName());
        dto.setEdDate(entity.getEdDate());
        dto.setEdAuthor(entity.getEdAuthor());
        dto.setEdReceiver(entity.getEdReceiver());
        dto.setCreationReason(entity.getCreationReason().getCode());
        dto.setCreationDateTime(entity.getCreationDateTime());
        dto.setInfoTypeCode(entity.getInfoTypeCode().getCode());
        dto.setBusinessDay(entity.getBusinessDay());
        dto.setDirectoryVersion(entity.getDirectoryVersion());

        if (entity.getPartInfo() != null) {
            dto.setPartInfo(toPartInfoDto(entity.getPartInfo()));
        }

        if (entity.getInitialEd() != null) {
            dto.setInitialEd(toInitialEdDto(entity.getInitialEd()));
        }

        if (entity.getBicDirectoryEntries() != null) {
            List<BICDirectoryEntryDTO> sortedBicEntries = entity.getBicDirectoryEntries().stream()
                    .map(this::toBicDirectoryDetailDto)
                    .sorted(Comparator.comparing(BICDirectoryEntryDTO::getId))
                    .collect(Collectors.toList());
            dto.setBicDirectoryEntries(sortedBicEntries);
        }

        return dto;
    }

    public List<ED807DTO> toEd807ListDto(List<ED807Entity> entities) {
        return entities.stream()
                .map(this::toEd807OnlyDto)
                .collect(Collectors.toList());
    }

    public ED807DTO toEd807OnlyDto(ED807Entity entity) {
        if (entity == null) {
            return null;
        }

        ED807DTO dto = new ED807DTO();
        dto.setId(entity.getId());
        dto.setEdNo(entity.getEdNo());
        dto.setFileName(entity.getFileName());
        dto.setEdDate(entity.getEdDate());
        dto.setEdAuthor(entity.getEdAuthor());
        dto.setEdReceiver(entity.getEdReceiver());
        dto.setCreationReason(entity.getCreationReason().getCode());
        dto.setCreationDateTime(entity.getCreationDateTime());
        dto.setInfoTypeCode(entity.getInfoTypeCode().getCode());
        dto.setBusinessDay(entity.getBusinessDay());
        dto.setDirectoryVersion(entity.getDirectoryVersion());
        dto.setPartInfo(toPartInfoDto(entity.getPartInfo()));
        dto.setInitialEd(toInitialEdDto(entity.getInitialEd()));
        return dto;
    }

    public InitialEDDTO toInitialEdDto (InitialEDEntity entity) {
        if (entity == null) {
            return null;
        }

        InitialEDDTO dto = new InitialEDDTO();
        dto.setId(entity.getId());
        dto.setEdNo(entity.getEdNo());
        dto.setEdDate(entity.getEdDate());
        dto.setEdAuthor(entity.getEdAuthor());
        return dto;
    }

    public PartInfoDTO toPartInfoDto (PartInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        PartInfoDTO dto = new PartInfoDTO();
        dto.setId(entity.getId());
        dto.setPartNo(entity.getPartNo());
        dto.setPartQuantity(entity.getPartQuantity());
        dto.setPartAggregateId(entity.getPartAggregateId());
        return dto;
    }

    public BICDirectoryEntryDTO toBicDirectoryDto(BICDirectoryEntryEntity entity) {
        if (entity == null) {
            return null;
        }

        BICDirectoryEntryDTO dto = new BICDirectoryEntryDTO();
        dto.setId(entity.getId());
        dto.setBic(entity.getBic());
        dto.setChangeType(entity.getChangeType() != null ? entity.getChangeType().getCode() : null);
        return dto;
    }

    public BICDirectoryEntryDetailDTO toBicDirectoryDetailDto(BICDirectoryEntryEntity entity) {
        if (entity == null) {
            return null;
        }

        BICDirectoryEntryDetailDTO dto = new BICDirectoryEntryDetailDTO();
        dto.setId(entity.getId());
        dto.setBic(entity.getBic());
        dto.setChangeType(entity.getChangeType() != null ? entity.getChangeType().getCode() : null);
        dto.setParticipantInfo(toParticipantInfoDetailDto(entity.getParticipantInfo()));

        if (entity.getSwbics() != null) {
            List<SWBICSDTO> sortedSwbics = entity.getSwbics().stream()
                    .map(this::toSwbicsDto)
                    .sorted(Comparator.comparing(SWBICSDTO::getId))
                    .collect(Collectors.toList());
            dto.setSwbics(sortedSwbics);
        }

        if (entity.getAccounts() != null) {
            List<AccountsDTO> sortedAccounts = entity.getAccounts().stream()
                    .map(this::toAccountsDto)
                    .sorted(Comparator.comparing(AccountsDTO::getId))
                    .collect(Collectors.toList());
            dto.setAccounts(sortedAccounts);
        }
        return dto;
    }

    public List<BICDirectoryEntryDTO> toBicDirectoryEntryListDto(List<BICDirectoryEntryEntity> entities) {
        return entities.stream()
                .map(this::toBicDirectoryDto)
                .collect(Collectors.toList());
    }

    public ParticipantInfoDetailDTO toParticipantInfoDetailDto(ParticipantInfoEntity entity) {
        ParticipantInfoDetailDTO dto = new ParticipantInfoDetailDTO();
        dto.setId(entity.getId());
        dto.setNameP(entity.getNameP());
        dto.setEnglName(entity.getEnglName() != null ? entity.getEnglName() : null);
        dto.setRegN(entity.getRegN() != null ? entity.getRegN() : null);
        dto.setCntrCd(entity.getCntrCd() != null ? entity.getCntrCd() : null);
        dto.setRgn(entity.getRgn() != null ? entity.getRgn() : null);
        dto.setInd(entity.getInd() != null ? entity.getInd() : null);
        dto.setTnp(entity.getTnp() != null ? entity.getTnp() : null);
        dto.setNnp(entity.getNnp() != null ? entity.getNnp() : null);
        dto.setAdr(entity.getAdr() != null ? entity.getAdr() : null);
        dto.setPrntBic(entity.getPrntBic() != null ? entity.getPrntBic() : null);
        dto.setDateIn(entity.getDateIn());
        dto.setDateOut(entity.getDateOut() != null ? entity.getDateOut() : null);
        dto.setPtType(entity.getPtType().getCode());
        dto.setSrvcs(entity.getSrvcs().getCode());
        dto.setXchType(entity.getXchType().getCode());
        dto.setUid(entity.getUid());
        dto.setParticipantStatus(entity.getParticipantStatus() != null ? entity.getParticipantStatus().getCode() : null);

        if (entity.getRstrLists() != null) {
            List<RstrListDTO> sortedRstrList = entity.getRstrLists().stream()
                    .map(this::toRstrListDto)
                    .sorted(Comparator.comparing(RstrListDTO::getId))
                    .collect(Collectors.toList());
            dto.setRstrLists(sortedRstrList);
        }
        return dto;
    }

    public ParticipantInfoDTO toParticipantInfoDto(ParticipantInfoEntity entity) {
        ParticipantInfoDTO dto = new ParticipantInfoDTO();
        dto.setId(entity.getId());
        dto.setNameP(entity.getNameP());
        dto.setEnglName(entity.getEnglName() != null ? entity.getEnglName() : null);
        dto.setRegN(entity.getRegN() != null ? entity.getRegN() : null);
        dto.setCntrCd(entity.getCntrCd() != null ? entity.getCntrCd() : null);
        dto.setRgn(entity.getRgn() != null ? entity.getRgn() : null);
        dto.setInd(entity.getInd() != null ? entity.getInd() : null);
        dto.setTnp(entity.getTnp() != null ? entity.getTnp() : null);
        dto.setNnp(entity.getNnp() != null ? entity.getNnp() : null);
        dto.setAdr(entity.getAdr() != null ? entity.getAdr() : null);
        dto.setPrntBic(entity.getPrntBic() != null ? entity.getPrntBic() : null);
        dto.setDateIn(entity.getDateIn());
        dto.setDateOut(entity.getDateOut() != null ? entity.getDateOut() : null);
        dto.setPtType(entity.getPtType().getCode());
        dto.setSrvcs(entity.getSrvcs().getCode());
        dto.setXchType(entity.getXchType().getCode());
        dto.setUid(entity.getUid());
        dto.setParticipantStatus(entity.getParticipantStatus() != null ? entity.getParticipantStatus().getCode() : null);
        return dto;
    }

    public List<ParticipantInfoDTO> toParticipantInfoListDto(List<ParticipantInfoEntity> entities) {
        return entities.stream()
                .map(this::toParticipantInfoDto)
                .collect(Collectors.toList());
    }
    public RstrListDTO toRstrListDto(RstrListEntity entity) {
        if (entity == null) {
            return null;
        }

        RstrListDTO dto = new RstrListDTO();
        dto.setId(entity.getId());
        dto.setRstr(entity.getRstr().getCode());
        dto.setRstrDate(entity.getRstrDate());
        return dto;
    }

    public List<RstrListDTO> toRstrsListToListDto(List<RstrListEntity> entities) {
        return entities.stream()
                .map(this::toRstrListDto)
                .collect(Collectors.toList());
    }

    public SWBICSDTO toSwbicsDto(SWBICSEntity entity) {
        if (entity == null) {
            return null;
        }

        SWBICSDTO dto = new SWBICSDTO();
        dto.setId(entity.getId());
        dto.setSwbic(entity.getSwbic());
        dto.setDefaultSwbic(entity.getDefaultSwbic());
        return dto;
    }

    public List<SWBICSDTO> toSwbicsListDto(List<SWBICSEntity> entities) {
        return entities.stream()
                .map(this::toSwbicsDto)
                .collect(Collectors.toList());
    }

    public AccountsDetailDTO toAccountsDetailDto(AccountsEntity entity) {
        if (entity == null) {
            return null;
        }

        AccountsDetailDTO dto = new AccountsDetailDTO();
        dto.setId(entity.getId());
        dto.setAccount(entity.getAccount());
        dto.setRegulationAccountType(entity.getRegulationAccountType().getCode());
        dto.setCk(entity.getCk() != null ? entity.getCk() : null);
        dto.setAccountCbrBic(entity.getAccountCbrBic());
        dto.setDateIn(entity.getDateIn());
        dto.setDateOut(entity.getDateOut() != null ? entity.getDateOut() : null);
        dto.setAccountStatus(entity.getAccountStatus() != null ? entity.getAccountStatus().getCode() : null);

        if (entity.getAccRstrLists() != null) {
            List<AccRstrListDTO> sortedAccRstrList = entity.getAccRstrLists().stream()
                    .map(this::toAccRstrListDto)
                    .sorted(Comparator.comparing(AccRstrListDTO::getId))
                    .collect(Collectors.toList());
            dto.setAccRstrLists(sortedAccRstrList);
        }
        return dto;
    }

    public AccountsDTO toAccountsDto(AccountsEntity entity) {
        if (entity == null) {
            return null;
        }

        AccountsDTO dto = new AccountsDTO();
        dto.setId(entity.getId());
        dto.setAccount(entity.getAccount());
        dto.setRegulationAccountType(entity.getRegulationAccountType().getCode());
        dto.setCk(entity.getCk() != null ? entity.getCk() : null);
        dto.setAccountCbrBic(entity.getAccountCbrBic());
        dto.setDateIn(entity.getDateIn());
        dto.setDateOut(entity.getDateOut() != null ? entity.getDateOut() : null);
        dto.setAccountStatus(entity.getAccountStatus() != null ? entity.getAccountStatus().getCode() : null);
        return dto;
    }

    public List<AccountsDTO> toAccountsListDto(List<AccountsEntity> entities) {
        return entities.stream()
                .map(this::toAccountsDto)
                .collect(Collectors.toList());
    }

    public AccRstrListDTO toAccRstrListDto(AccRstrListEntity entity) {
        if (entity == null) {
            return null;
        }

        AccRstrListDTO dto = new AccRstrListDTO();
        dto.setId(entity.getId());
        dto.setAccRstr(entity.getAccRstr().getCode());
        dto.setAccRstrDate(entity.getAccRstrDate());
        dto.setSuccessorBic(entity.getSuccessorBic() != null ? entity.getSuccessorBic() : null);
        return dto;
    }

    public List<AccRstrListDTO> toAccRstrListToListDto(List<AccRstrListEntity> entities) {
        return entities.stream()
                .map(this::toAccRstrListDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.AccountStatusDTO toAccountStatusDto(AccountStatusEntity entity) {
        com.example.bank.DTO.reference_books.AccountStatusDTO dto = new com.example.bank.DTO.reference_books.AccountStatusDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.AccountStatusDTO> toAccountStatusListDto(List<AccountStatusEntity> entities) {
        return entities.stream()
                .map(this::toAccountStatusDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.AccRstrDTO toAccRstrDto(AccRstrEntity entity) {
        com.example.bank.DTO.reference_books.AccRstrDTO dto = new com.example.bank.DTO.reference_books.AccRstrDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.AccRstrDTO> toAccRstrListDto(List<AccRstrEntity> entities) {
        return entities.stream()
                .map(this::toAccRstrDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.ChangeTypeDTO toChangeTypeDto(ChangeTypeEntity entity) {
        com.example.bank.DTO.reference_books.ChangeTypeDTO dto = new com.example.bank.DTO.reference_books.ChangeTypeDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.ChangeTypeDTO> toChangeTypeListDto(List<ChangeTypeEntity> entities) {
        return entities.stream()
                .map(this::toChangeTypeDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.CreationReasonDTO toCreationReasonDto(CreationReasonEntity entity) {
        com.example.bank.DTO.reference_books.CreationReasonDTO dto = new com.example.bank.DTO.reference_books.CreationReasonDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.CreationReasonDTO> toCreationReasonListDto(List<CreationReasonEntity> entities) {
        return entities.stream()
                .map(this::toCreationReasonDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.InfoTypeCodeDTO toInfoTypeCodeDto(InfoTypeCodeEntity entity) {
        com.example.bank.DTO.reference_books.InfoTypeCodeDTO dto = new com.example.bank.DTO.reference_books.InfoTypeCodeDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.InfoTypeCodeDTO> toInfoTypeCodeListDto(List<InfoTypeCodeEntity> entities) {
        return entities.stream()
                .map(this::toInfoTypeCodeDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.ParticipantStatusDTO toParticipantStatusDto(ParticipantStatusEntity entity) {
        com.example.bank.DTO.reference_books.ParticipantStatusDTO dto = new com.example.bank.DTO.reference_books.ParticipantStatusDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.ParticipantStatusDTO> toParticipantStatusListDto(List<ParticipantStatusEntity> entities) {
        return entities.stream()
                .map(this::toParticipantStatusDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.PtTypeDTO toPtTypeDto(PtTypeEntity entity) {
        com.example.bank.DTO.reference_books.PtTypeDTO dto = new com.example.bank.DTO.reference_books.PtTypeDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.PtTypeDTO> toPtTypeListDto(List<PtTypeEntity> entities) {
        return entities.stream()
                .map(this::toPtTypeDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.RegulationAccountTypeDTO toRegulationAccountTypeDto(RegulationAccountTypeEntity entity) {
        com.example.bank.DTO.reference_books.RegulationAccountTypeDTO dto = new com.example.bank.DTO.reference_books.RegulationAccountTypeDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.RegulationAccountTypeDTO> toRegulationAccountTypeListDto(List<RegulationAccountTypeEntity> entities) {
        return entities.stream()
                .map(this::toRegulationAccountTypeDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.RstrDTO toRstrDto(RstrEntity entity) {
        com.example.bank.DTO.reference_books.RstrDTO dto = new com.example.bank.DTO.reference_books.RstrDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.RstrDTO> toRstrListDto(List<RstrEntity> entities) {
        return entities.stream()
                .map(this::toRstrDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.SrvcsDTO toSrvcsDto(SrvcsEntity entity) {
        com.example.bank.DTO.reference_books.SrvcsDTO dto = new com.example.bank.DTO.reference_books.SrvcsDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.SrvcsDTO> toSrvcsListDto(List<SrvcsEntity> entities) {
        return entities.stream()
                .map(this::toSrvcsDto)
                .collect(Collectors.toList());
    }

    public com.example.bank.DTO.reference_books.XchTypeDTO toXchTypeDto(XchTypeEntity entity) {
        com.example.bank.DTO.reference_books.XchTypeDTO dto = new com.example.bank.DTO.reference_books.XchTypeDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public List<com.example.bank.DTO.reference_books.XchTypeDTO> toXchTypeListDto(List<XchTypeEntity> entities) {
        return entities.stream()
                .map(this::toXchTypeDto)
                .collect(Collectors.toList());
    }
}
