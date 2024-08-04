package com.example.bank.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Schema(description = "DTO для сущности ParticipantInfo")
public class ParticipantInfoDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Size(max = 160)
    @NotNull
    @Schema(description = "Наименование участника", example = "УФК по Красноярскому краю")
    private String nameP;

    @Size(max = 140)
    @Schema(description = "Наименование участника на английском языке", example = "UFK po Krasnoyarskomu krayu")
    private String englName;

    @Size(max = 9)
    @Schema(description = "Регистрационный порядковый номер", example = "1637/10")
    private String regN;

    @Size(min = 2, max = 2)
    @Schema(description = "Код страны", example = "RU")
    private String cntrCd;

    @Size(max = 2)
    @NotNull
    @Schema(description = "Код территории", example = "04")
    private String rgn;

    @Size(max = 6)
    @Schema(description = "Индекс", example = "660022")
    private String ind;

    @Size(max = 5)
    @Schema(description = "Тип населенного пункта", example = "г")
    private String tnp;

    @Size(max = 25)
    @Schema(description = "Наименование населенного пункта", example = "Красноярск")
    private String nnp;

    @Size(max = 160)
    @Schema(description = "Адрес", example = "ул Партизана Железняка, 44 Д")
    private String adr;

    @Size(min = 9, max = 9)
    @Schema(description = "БИК головной организации", example = "044030790")
    private String prntBic;

    @NotNull
    @Schema(description = "Дата включения в состав участников перевода", example = "2024-01-01")
    private Date dateIn;

    @Schema(description = "Дата исключения информации об Участнике", example = "2024-01-01")
    private Date dateOut;

    @Size(max = 2)
    @NotNull
    @Schema(description = "Тип участника перевода", example = "00")
    private String ptType;

    @Size(min = 1, max = 1)
    @NotNull
    @Schema(description = "Доступные сервисы перевода денежных средств", example = "6")
    private String srvcs;

    @Size(min = 1, max = 1)
    @NotNull
    @Schema(description = "Участник обмена", example = "0")
    private String xchType;

    @Size(min = 10, max = 10)
    @NotNull
    @Schema(description = "УИС", example = "0407001105")
    private String uid;

    @Size(min = 4, max = 4)
    @Schema(description = "Статус участника", example = "PSAC")
    private String participantStatus;

}
