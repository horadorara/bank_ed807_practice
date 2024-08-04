package com.example.bank.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BICDirectoryEntryDetailDTO extends BICDirectoryEntryDTO {
    private ParticipantInfoDTO participantInfo;
    private List<SWBICSDTO> swbics;
    private List<AccountsDTO> accounts;
}
