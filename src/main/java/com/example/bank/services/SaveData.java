package com.example.bank.services;

import com.example.bank.entities.*;
import com.example.bank.repositories.*;
import com.example.bank.repositories.reference_books.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cbr.ed.v2.*;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SaveData {
    private final InfoTypeCodeRepository infoTypeCodeRepository;
    private final CreationReasonRepository creationReasonRepository;
    private final RstrListService rstrListService;
    private final ED807Repository ed807Repository;
    private final BICDirectoryEntryService bicDirectoryEntryService;
    private final ParticipantInfoService participantInfoService;
    private final SWBICSService swbicsService;
    private final AccountsService accountsService;
    private final AccRstrListService accRstrListService;
    private final ChangeTypeRepository changeTypeRepository;
    private final PtTypeRepository ptTypeRepository;
    private final SrvcsRepository srvcsRepository;
    private final XchTypeRepository xchTypeRepository;
    private final RstrRepository rstrRepository;
    private final ParticipantStatusRepository participantStatusRepository;
    private final AccRstrRepository accRstrRepository;
    private final AccountStatusRepository accountStatusRepository;
    private final RegulationAccountTypeRepository regulationAccountTypeRepository;
    private final InitialEDRepository initialEDRepository;
    private final PartInfoRepository partInfoRepository;

    @CacheEvict(allEntries = true, beforeInvocation = true, value = {
            "infoTypeCodeCode",
            "creationReasonCode",
            "changeTypeCode",
            "ptTypeCode",
            "srvcsCode",
            "xchTypeCode",
            "participantStatusCode",
            "rstrCode",
            "accountStatusCode",
            "accRstrCode",
            "regulationAccountTypeCode"})
    public void saveEd807(ED807 ed807, String fileName, byte[] fileData) {
        ED807Entity ed807Entity = new ED807Entity();
        ed807Entity.setEdNo(Integer.parseInt(String.valueOf(ed807.getEDNo())));
        ed807Entity.setFileName(fileName);
        ed807Entity.setFileData(fileData);
        ed807Entity.setEdDate(ed807.getEDDate().toGregorianCalendar().getTime());
        ed807Entity.setEdAuthor(ed807.getEDAuthor());
        if (ed807.getEDReceiver() != null) {
            ed807Entity.setEdReceiver(ed807.getEDReceiver());
        } else {
            ed807Entity.setEdReceiver(null);
        }
        ed807Entity.setCreationReason(creationReasonRepository.findByCode(ed807.getCreationReason().name()));
        ed807Entity.setCreationDateTime(ed807.getCreationDateTime().getTime());
        ed807Entity.setInfoTypeCode(infoTypeCodeRepository.findByCode(ed807.getInfoTypeCode().name()));
        ed807Entity.setBusinessDay(ed807.getBusinessDay().toGregorianCalendar().getTime());
        ed807Entity.setDirectoryVersion(Byte.parseByte(String.valueOf(ed807.getDirectoryVersion())));

        if (ed807.getInitialED() != null) {
            InitialEDEntity initialEDEntity = new InitialEDEntity();
            initialEDEntity.setEdNo(Integer.parseInt(String.valueOf(ed807.getInitialED().getEDNo())));
            initialEDEntity.setEdDate(ed807.getInitialED().getEDDate().toGregorianCalendar().getTime());
            initialEDEntity.setEdAuthor(ed807.getInitialED().getEDAuthor());
            initialEDEntity.setEd807(ed807Entity);
            ed807Entity.setInitialEd(initialEDEntity);
        }

        if (ed807.getPartInfo() != null) {
            PartInfoEntity partInfoEntity = new PartInfoEntity();
            partInfoEntity.setPartNo(ed807Entity.getPartInfo().getPartNo());
            partInfoEntity.setPartQuantity(ed807Entity.getPartInfo().getPartQuantity());
            partInfoEntity.setPartAggregateId(ed807Entity.getPartInfo().getPartAggregateId());
            partInfoEntity.setEd807(ed807Entity);
            ed807Entity.setPartInfo(partInfoEntity);
        }

        if (ed807.getBICDirectoryEntries() != null) {
            List<BICDirectoryEntryType> bicDirectoryEntries = ed807.getBICDirectoryEntries();
            for (BICDirectoryEntryType bicEntry : bicDirectoryEntries) {
                BICDirectoryEntryEntity bicEntity = bicDirectoryEntryService.createBicDirectoryEntry(
                        bicEntry.getBIC(),
                        bicEntry.getChangeType() != null ? changeTypeRepository.findByCode(bicEntry.getChangeType().name()) : null,
                        ed807Entity
                );

                ParticipantInfoType participantInfo = bicEntry.getParticipantInfo();
                ParticipantInfoEntity participantEntity = participantInfoService.createParticipantInfo(
                       participantInfo.getNameP(),
                       participantInfo.getEnglName() != null ? participantInfo.getEnglName() : null,
                        participantInfo.getRegN() != null ? participantInfo.getRegN() : null,
                        participantInfo.getCntrCd() != null ? participantInfo.getCntrCd() : null,
                        participantInfo.getRgn(),
                        participantInfo.getInd() != null ? participantInfo.getInd() : null,
                        participantInfo.getTnp() != null ? participantInfo.getTnp() : null,
                        participantInfo.getNnp() != null ? participantInfo.getNnp() : null,
                        participantInfo.getAdr() != null ? participantInfo.getAdr() : null,
                        participantInfo.getPrntBIC() != null ? participantInfo.getPrntBIC() : null,
                        participantInfo.getDateIn().toGregorianCalendar().getTime(),
                        participantInfo.getDateOut() != null ? participantInfo.getDateIn().toGregorianCalendar().getTime() : null,
                        ptTypeRepository.findByCode(participantInfo.getPtType()),
                        srvcsRepository.findByCode(participantInfo.getSrvcs()),
                        xchTypeRepository.findByCode(participantInfo.getXchType()),
                        participantInfo.getUID(),
                        participantInfo.getParticipantStatus() != null ? participantStatusRepository.findByCode(participantInfo.getParticipantStatus().name()) : null,
                        bicEntity
                );

                if (participantInfo.getRstrLists() != null) {
                    List<RstrListType> rstrLists = participantInfo.getRstrLists();
                    for (RstrListType rstrList : rstrLists) {
                        RstrListEntity rstrEntity = rstrListService.createRstrList(
                                rstrRepository.findByCode(rstrList.getRstr().name()),
                                rstrList.getRstrDate().toGregorianCalendar().getTime(),
                                participantEntity
                        );
                    }
                }

                if (bicEntry.getSWBICS() != null) {
                    List<SWBICList> swbicLists = bicEntry.getSWBICS();
                    if (swbicLists != null) {
                        for (SWBICList swbicList : swbicLists) {
                            SWBICSEntity swbicsEntity = new SWBICSEntity();
                            swbicsEntity.setSwbic(swbicList.getSWBIC());
                            swbicsEntity.setDefaultSwbic(swbicList.isDefaultSWBIC());
                            swbicsEntity.setBicDirectoryEntry(bicEntity);
                            bicEntity.getSwbics().add(swbicsEntity);
                        }
                    }
                }

                if (bicEntry.getAccounts() != null) {
                    List<AccountsType> accountsTypes = bicEntry.getAccounts();
                    for (AccountsType accountsType : accountsTypes) {
                        AccountsEntity accountsEntity = accountsService.createAccounts(
                                accountsType.getAccount(),
                                regulationAccountTypeRepository.findByCode(accountsType.getRegulationAccountType().name()),
                                accountsType.getCK() != null ? accountsType.getCK() : null,
                                accountsType.getAccountCBRBIC(),
                                accountsType.getDateIn().toGregorianCalendar().getTime(),
                                accountsType.getDateOut() != null ? accountsType.getDateOut().toGregorianCalendar().getTime() : null,
                                accountsType.getAccountStatus() != null ? accountStatusRepository.findByCode(accountsType.getAccountStatus().name()) : null,
                                bicEntity
                        );

                        if (accountsType.getAccRstrLists() != null) {
                            List<AccRstrListType> accRstrListTypes = accountsType.getAccRstrLists();
                            for (AccRstrListType accRstrListType : accRstrListTypes) {
                                AccRstrListEntity accRstrListEntity = new AccRstrListEntity();
                                accRstrListEntity.setAccRstr(accRstrRepository.findByCode(accRstrListType.getAccRstr().name()));
                                accRstrListEntity.setAccRstrDate(accRstrListType.getAccRstrDate().toGregorianCalendar().getTime());
                                if (accRstrListType.getSuccessorBIC() != null) {
                                    accRstrListEntity.setSuccessorBic(accRstrListType.getSuccessorBIC());
                                } else {
                                    accRstrListEntity.setSuccessorBic(null);
                                }
                                accRstrListEntity.setAccounts(accountsEntity);
                                accountsEntity.getAccRstrLists().add(accRstrListEntity);
                            }
                        }
                    }
                }
            }
        }
        ed807Repository.save(ed807Entity);
    }
}