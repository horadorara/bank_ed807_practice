package com.example.bank.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParticipantInfoDetailDTO extends ParticipantInfoDTO {
    private List<RstrListDTO> rstrLists;
}
