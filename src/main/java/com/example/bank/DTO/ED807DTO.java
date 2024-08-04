package com.example.bank.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Schema(description = "DTO для сущности ED807")
public class ED807DTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Название файла", example = "20220222_ED807.xml", accessMode = Schema.AccessMode.READ_ONLY)
    private String fileName;

    @Max(999999999)
    @NotNull
    @Schema(description = "Номер ЭС в течение опердня", example = "753156734")
    private Integer edNo;

    @NotNull
    @Schema(description = "Дата составления ЭС", example = "2024-01-01")
    private Date edDate;

    @Size(min = 10, max = 10)
    @NotNull
    @Schema(description = "Уникальный идентификатор составителя ЭС - УИС", example = "1234567890")
    private String edAuthor;

    @Size(min = 10, max = 10)
    @NotNull
    @Schema(description = "Уникальный идентификатор получателя ЭС", example = "1234567890")
    private String edReceiver;

    @Size(min = 4, max = 4)
    @NotNull
    @Schema(description = "Код причины формирования ЭСИС", example = "RQST")
    private String creationReason;

    @NotNull
    @Schema(description = "Дата и время создания ЭС", example = "2024-01-01T13:22:54Z")
    private Date creationDateTime;

    @Size(min = 4, max = 4)
    @NotNull
    @Schema(description = "Вид представления информации", example = "FIRR")
    private String infoTypeCode;

    @NotNull
    @Schema(description = "Дата ОД, к которой относятся данные Справочника БИК", example = "2024-01-01")
    private Date businessDay;

    @Max(99)
    @Schema(description = "Номер версии Справочника БИК в течение операционного дня", example = "1")
    private Byte directoryVersion;

    @Schema(description = "дочерний DTO для сущности PartInfo")
    private PartInfoDTO partInfo;

    @Schema(description = "дочерний DTO для сущности InitialED")
    private InitialEDDTO initialEd;
}
