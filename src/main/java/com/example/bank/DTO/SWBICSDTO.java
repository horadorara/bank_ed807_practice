package com.example.bank.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO для сущности SWBICS")
public class SWBICSDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    @Pattern(regexp = "^[A-Z]{4}[A-Z]{2}[A-Z0-9]{2}([A-Z0-9]{3})?$", message = "Invalid SWIFT code")
    @Schema(description = "БИК (СВИФТ) (по справочнику СВИФТ, стандарт ИСО 9362)", example = "CAIWRUMMXXX")
    private String swbic;

    @NotNull
    @Schema(description = "Признак использования БИК (СВИФТ), «по умолчанию»", example = "0")
    private boolean defaultSwbic;
}
