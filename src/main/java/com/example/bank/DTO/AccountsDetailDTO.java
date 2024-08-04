package com.example.bank.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountsDetailDTO extends AccountsDTO {
    private List<AccRstrListDTO> accRstrLists;
}
