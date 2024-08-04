package com.example.bank.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ED807DetailDTO extends ED807DTO{
    private List<BICDirectoryEntryDTO> bicDirectoryEntries;
}
