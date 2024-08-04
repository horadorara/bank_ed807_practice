package com.example.bank.controllers;

import com.example.bank.DTO.AccountsDTO;
import com.example.bank.DTO.BICDirectoryEntryDTO;
import com.example.bank.services.AccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "AccountsController", description = "Контроллер CRUD операций для сущности Accounts")
public class AccountsController {

    private final AccountsService service;

    @Operation(summary = "Создание новой записи с привязкой сущности BicDirectoryEntry по идентификатору")
    @PostMapping("/bic_directory_entry/{bicId}/accounts/create")
    public ResponseEntity<AccountsDTO> create(@RequestBody AccountsDTO dto, @Parameter(description = "Идентификатор BicDirectoryEntry") @PathVariable Long bicId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto, bicId));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("/accounts/all")
    public ResponseEntity<List<AccountsDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору c дочерними записями")
    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountsDTO> getById(@Parameter(description = "Идентификатор Accounts") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("/accounts/{id}/update")
    public ResponseEntity<AccountsDTO> update(@Parameter(description = "Идентификатор Accounts") @PathVariable Long id, @RequestBody AccountsDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("/accounts/{id}/delete")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор Accounts") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
