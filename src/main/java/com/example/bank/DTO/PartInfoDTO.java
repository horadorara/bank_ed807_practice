package com.example.bank.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class PartInfoDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Max(999999)
    @NotNull
    @Schema(description = "Номер части", example = "123456")
    private Integer partNo;

    @Max(999999)
    @NotNull
    @Schema(description = "Количество частей", example = "123456")
    private Integer partQuantity;

    @Size(max = 27)
    @NotNull
    @Schema(description = "Уникальный идентификатор совокупности частей", example = "123456789012345678901234567")
    private String partAggregateId;
}
