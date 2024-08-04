package com.example.bank.DTO.reference_books;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO для сущности PtType")
public class PtTypeDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Size(min = 2, max = 2)
    @NotNull
    @Schema(description = "Код значения в ЭСИС", example = "00")
    private String code;

    @Schema(description = "Значение реквизита", example = "Это пример значение реквизита")
    private String description;
}
