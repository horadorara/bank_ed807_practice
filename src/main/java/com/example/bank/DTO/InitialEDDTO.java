package com.example.bank.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Schema(description = "DTO для сущности InitialED")
public class InitialEDDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Max(999999999)
    @NotNull
    @Schema(description = "Номер ЭС в течение опердня", example = "123456789")
    private Integer edNo;

    @NotNull
    @Schema(description = "Дата составления ЭС", example = "2024-01-01")
    private Date edDate;

    @Size(min = 10, max = 10)
    @NotNull
    @Schema(description = "Уникальный идентификатор составителя ЭС - УИС", example = "0123456789")
    private String edAuthor;
}
