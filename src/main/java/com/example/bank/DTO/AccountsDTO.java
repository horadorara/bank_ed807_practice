package com.example.bank.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Schema(description = "DTO для сущности Accounts")
public class AccountsDTO {

    @Schema(description = "ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Size(min = 20, max = 20)
    @NotNull
    @Schema(description = "Номер счета", example = "11111111111111111111")
    private String account;

    @Size(min = 4, max = 4)
    @Schema(description = "Тип счета в соответсвии с нормативом", example = "BANA")
    private String regulationAccountType;

    @Size(min = 2, max = 2)
    @Schema(description = "Котрольный ключ", example = "11")
    private String ck;

    @Size(min = 9, max = 9)
    @NotNull
    @Schema(description = "БИК ПБР, обслуживающего счет участника переводаю", example = "013421234")
    private String accountCbrBic;

    @NotNull
    @Schema(description = "Дата открытия счета", example = "2024-01-01")
    private Date dateIn;

    @Schema(description = "Дата исключения информации о счете участника", example = "2024-01-01")
    private Date dateOut;

    @Size(min = 4, max = 4)
    @Schema(description = "Статус счета", example = "ACAC")
    private String accountStatus;
}
