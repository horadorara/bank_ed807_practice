package com.example.bank.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Schema(description = "DTO для сущности RstrList")
public class RstrListDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Size(min = 4, max = 4)
    @NotNull
    @Schema(description = "Код ограничения, наложенного на учатсника", example = "URRS")
    private String rstr;

    @NotNull
    @Schema(description = "Дата начала действия ограничения участника", example = "2024-01-01")
    private Date rstrDate;
}
