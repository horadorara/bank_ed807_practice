package com.example.bank.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Schema(description = "DTO для сущности AccRstrList")
public class AccRstrListDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Size(min = 4, max = 4)
    @NotNull
    @Schema(description = "Код ограничения операций по счету", example = "LMRS")
    private String accRstr;

    @NotNull
    @Schema(description = "Дата начала действия Ограничения операций по счету", example = "2024-01-01")
    private Date accRstrDate;

    @Size(min = 9, max = 9)
    private String successorBic;
}
