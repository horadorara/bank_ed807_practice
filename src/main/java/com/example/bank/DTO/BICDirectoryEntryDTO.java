package com.example.bank.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Schema(description = "DTO для сущности BICDirectoryEntry")
public class BICDirectoryEntryDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Size(min = 9, max = 9)
    @NotNull
    @Schema(description = "БИК", example = "024543256")
    private String bic;

    @Size(min = 4, max = 4)
    @Schema(description = "Тип изменения в Справочнике по сравнению с предыдущей версией Справочника")
    private String changeType;
    //private ParticipantInfoDTO participantInfo;
    //private List<SWBICSDTO> swbics;
    //private List<AccountsDTO> accounts;
}
