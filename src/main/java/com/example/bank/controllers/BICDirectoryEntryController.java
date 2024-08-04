
package com.example.bank.controllers;

import com.example.bank.DTO.BICDirectoryEntryDTO;
import com.example.bank.services.BICDirectoryEntryService;
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
@Tag(name = "BICDirectoryEntryController", description = "Контроллер CRUD операций для сущности BICDirectoryEntry")
public class BICDirectoryEntryController {

    private final BICDirectoryEntryService service;

    @Operation(summary = "Создание новой записи с привязкой сущности ED807 по идентификатору")
    @PostMapping("/ed807/{ed807Id}/bic_directory_entry/create")
    public ResponseEntity<BICDirectoryEntryDTO> create(@RequestBody BICDirectoryEntryDTO dto, @Parameter(description = "Идентификатор ED807") @PathVariable Long ed807Id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto, ed807Id));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("/bic_directory_entry/all")
    public ResponseEntity<List<BICDirectoryEntryDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору с дочерними записями")
    @GetMapping("/bic_directory_entry/{id}")
    public ResponseEntity<BICDirectoryEntryDTO> getById(@Parameter(description = "Идентификатор BICDirectoryEntry") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("/bic_directory_entry/{id}/update")
    public ResponseEntity<BICDirectoryEntryDTO> update(@Parameter(description = "Идентификатор BICDirectoryEntry") @PathVariable Long id, @RequestBody BICDirectoryEntryDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("/bic_directory_entry/{id}/delete")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор BICDirectoryEntry") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

