package com.example.bank.services.reference_books;

import com.example.bank.entities.referenсe_books.*;
import com.example.bank.repositories.reference_books.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveReferenceBooks {

    private final CreationReasonRepository creationReasonRepository;
    private final InfoTypeCodeRepository infoTypeCodeRepository;
    private final ChangeTypeRepository changeTypeRepository;
    private final PtTypeRepository ptTypeRepository;
    private final SrvcsRepository srvcsRepository;
    private final XchTypeRepository xchTypeRepository;
    private final RstrRepository rstrRepository;
    private final ParticipantStatusRepository participantStatusRepository;
    private final AccRstrRepository accRstrRepository;
    private final AccountStatusRepository accountStatusRepository;
    private final RegulationAccountTypeRepository regulationAccountTypeRepository;


    public void saveReferenceBooks() {

        creationReasonRepository.save(createCreationReasonEntity("RQST", "Ответ на ЭС-запрос Участник"));
        creationReasonRepository.save(createCreationReasonEntity("CIBD", "Регламентное направление изменений " +
                "в Справочнике БИК в течение операционного дня."));
        creationReasonRepository.save(createCreationReasonEntity("FCBD", "1) Регламентное направление " +
                "изменений к Справочнику БИК, " +
                "формируемого в завершающем сеансе " +
                "операционного дня платежной системы " +
                "Банка России, актуальных со " +
                "следующего операционного дня (SIRR); " +
                "2) Регламентное направление из " +
                "ПС СБП в ОПКЦ полного Справочника " +
                "БИК, формируемого в завершающем " +
                "сеансе операционного дня платежной " +
                "системы Банка России, актуального со " +
                "следующего операционного дня (FIRR)."));

        infoTypeCodeRepository.save(createInfoTypeCodeEntity("FIRR", "Полный Справочник БИК"));
        infoTypeCodeRepository.save(createInfoTypeCodeEntity("SIRR", "Изменения в Справочнике БИК " +
                "(содержит только изменения относительно предыдущего Справочника БИК)"));

        changeTypeRepository.save(createChangeTypeEntity("ADDD", "Изменения в Справочнике БИК " +
                "(содержит только изменения относительно предыдущего Справочника БИК)"));
        changeTypeRepository.save(createChangeTypeEntity("CHGD", "Запись Справочника БИК была " +
                "изменена по сравнению с предыдущей " +
                "версией Справочника(под изменением " +
                "понимается любое изменение " +
                "информации, относящейся к участнику. " +
                "В том числе: добавление, удаление, " +
                "изменение характеристик счета " +
                "участника"));
        changeTypeRepository.save(createChangeTypeEntity("DLTD", "Запись Справочника БИК была удалена"));

        ptTypeRepository.save(createPtTypeEntity("00", "Главное управление Банка России"));
        ptTypeRepository.save(createPtTypeEntity("10", "Расчетно-кассовый центр"));
        ptTypeRepository.save(createPtTypeEntity("12", "Отделение, отделение – национальный " +
                "банк главного управления Банка России"));
        ptTypeRepository.save(createPtTypeEntity("15", "Структурное подразделение " +
                "центрального аппарата Банка России"));
        ptTypeRepository.save(createPtTypeEntity("16", "Кассовый центр"));
        ptTypeRepository.save(createPtTypeEntity("20", "Кредитная организация"));
        ptTypeRepository.save(createPtTypeEntity("30", "Филиал кредитной организации"));
        ptTypeRepository.save(createPtTypeEntity("40", "Полевое учреждение Банка России"));
        ptTypeRepository.save(createPtTypeEntity("51", "Федеральное казначейство"));
        ptTypeRepository.save(createPtTypeEntity("52", "Территориальный орган Федерального казначейства"));
        ptTypeRepository.save(createPtTypeEntity("60", "Иностранный банк (иностранная кредитная организация)"));
        ptTypeRepository.save(createPtTypeEntity("65", "Иностранный центральный (национальный) банк"));
        ptTypeRepository.save(createPtTypeEntity("71", "Клиент кредитной организации, " +
                "являющийся косвенным участником"));
        ptTypeRepository.save(createPtTypeEntity("75", "Клиринговая организация"));
        ptTypeRepository.save(createPtTypeEntity("78", "Внешняя платежная система"));
        ptTypeRepository.save(createPtTypeEntity("90", "Конкурсный управляющий (ликвидатор, ликвидационная комиссия)"));
        ptTypeRepository.save(createPtTypeEntity("99", "Клиент Банка России, не являющийся " +
                "участником платежной системы"));

        srvcsRepository.save(createSrvcsEntity("1", "Сервис несрочного перевода"));
        srvcsRepository.save(createSrvcsEntity("2", "Сервис срочного перевода"));
        srvcsRepository.save(createSrvcsEntity("3", "Сервис несрочного перевода и сервис срочного перевода"));
        srvcsRepository.save(createSrvcsEntity("4", "Сервис срочного перевода и сервис " +
                "быстрых платежей"));
        srvcsRepository.save(createSrvcsEntity("5", "Сервис срочного перевода, сервис " +
                "несрочного перевода и сервис быстрых платежей"));
        srvcsRepository.save(createSrvcsEntity("6", "Сервис быстрых платежей"));

        xchTypeRepository.save(createXchTypeEntity("0", "Не участник обмена"));
        xchTypeRepository.save(createXchTypeEntity("1", "Участник обмена"));

        rstrRepository.save(createRstrEntity("URRS", "Ограничение предоставления сервиса " +
                "срочного перевода"));
        rstrRepository.save(createRstrEntity("LWRS", "Отзыв (аннулирование) лицензии"));
        rstrRepository.save(createRstrEntity("MRTR", "Мораторий на удовлетворение требований кредиторов"));
        rstrRepository.save(createRstrEntity("RSIP", "Приостановление доступа к услугам по " +
                "переводу денежных средств в качестве косвенного участника"));
        rstrRepository.save(createRstrEntity("FPIP", "Приостановление предоставления " +
                "сервиса быстрых платежей косвенному участнику"));

        participantStatusRepository.save(createParticipantStatusEntity("PSAC", "«Действующий», когда текущая дата " +
                "операционного дня позднее или равна " +
                "дате активации участника и ранее даты " +
                "удаления Участника, если дата " +
                "удаления Участника была установлена"));
        participantStatusRepository.save(createParticipantStatusEntity("PSDL", "«Удаленный», если текущая дата " +
                "операционного дня равна дате " +
                "вступления в силу удаления Участника " +
                "(направляется только в «короткой» " +
                "версии ED807 содержащей только " +
                "изменения в Справочнике БИК. Только в " +
                "день удаления)"));

        accRstrRepository.save(createAccRstrEntity("LMRS", "Временное сохранение счета с его " +
                "функционированием в ограниченном режиме"));
        accRstrRepository.save(createAccRstrEntity("URRS", "Ограничение предоставления сервиса " +
                "срочного перевода"));
        accRstrRepository.save(createAccRstrEntity("CLRS", "Закрытие счета"));
        accRstrRepository.save(createAccRstrEntity("FPRS", "Приостановление предоставления " +
                "сервиса быстрых платежей"));
        accRstrRepository.save(createAccRstrEntity("SDRS", "Признак использования реквизитов " +
                "филиала кредитной организации после его преобразования во внутреннее " +
                "структурное подразделение (Признак ВСП)"));

        accountStatusRepository.save(createAccountStatusEntity("ACAC", "«Действующий», когда текущая дата " +
                "операционного дня позднее или равна " +
                "дате активации счета и ранее даты " +
                "удаления счета, или если дата " +
                "удаления счета не была установлен"));
        accountStatusRepository.save(createAccountStatusEntity("ACDL", "«Удаленный», когда текущая дата " +
                "операционного дня равна дате удаления счета"));

        regulationAccountTypeRepository.save(createRegulationAccountTypeEntity("CBRA", "Счет Банка России"));
        regulationAccountTypeRepository.save(createRegulationAccountTypeEntity("CRSA", "Корреспондентский счет (субсчет)"));
        regulationAccountTypeRepository.save(createRegulationAccountTypeEntity("BANA", "Банковский счет, не являющийся " +
                "корреспондентским счетом (субсчетом) или единым казначейским счетом"));
        regulationAccountTypeRepository.save(createRegulationAccountTypeEntity("TRSA", "Счет территориального органа " +
                "Федерального казначейства"));
        regulationAccountTypeRepository.save(createRegulationAccountTypeEntity("TRUA", "Счет доверительного управления"));
        regulationAccountTypeRepository.save(createRegulationAccountTypeEntity("CLAC", "Клиринговый счет"));
        regulationAccountTypeRepository.save(createRegulationAccountTypeEntity("UTRA", "Единый казначейский счет"));
    }

    private CreationReasonEntity createCreationReasonEntity(String code, String description) {
        CreationReasonEntity entity = new CreationReasonEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private InfoTypeCodeEntity createInfoTypeCodeEntity(String code, String description) {
        InfoTypeCodeEntity entity = new InfoTypeCodeEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private ChangeTypeEntity createChangeTypeEntity(String code, String description) {
        ChangeTypeEntity entity = new ChangeTypeEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private PtTypeEntity createPtTypeEntity(String code, String description) {
        PtTypeEntity entity = new PtTypeEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private SrvcsEntity createSrvcsEntity(String code, String description) {
        SrvcsEntity entity = new SrvcsEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private XchTypeEntity createXchTypeEntity(String code, String description) {
        XchTypeEntity entity = new XchTypeEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private RstrEntity createRstrEntity(String code, String description) {
        RstrEntity entity = new RstrEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private ParticipantStatusEntity createParticipantStatusEntity(String code, String description) {
        ParticipantStatusEntity entity = new ParticipantStatusEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private AccRstrEntity createAccRstrEntity(String code, String description) {
        AccRstrEntity entity = new AccRstrEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private AccountStatusEntity createAccountStatusEntity(String code, String description) {
        AccountStatusEntity entity = new AccountStatusEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }

    private RegulationAccountTypeEntity createRegulationAccountTypeEntity(String code, String description) {
        RegulationAccountTypeEntity entity = new RegulationAccountTypeEntity();
        entity.setCode(code);
        if (description != null) {
            entity.setDescription(description);
        }
        return entity;
    }
}
