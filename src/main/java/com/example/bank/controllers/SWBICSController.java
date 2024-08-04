package com.example.bank.controllers;

import com.example.bank.DTO.ParticipantInfoDTO;
import com.example.bank.DTO.SWBICSDTO;
import com.example.bank.services.SWBICSService;
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
@Tag(name = "SWBICSController", description = "Контроллер CRUD операций для сущности SWBICS")
public class SWBICSController {

    private final SWBICSService service;

    @Operation(summary = "Создание новой записи с привязкой сущности BICDirectoryEntry по идентификатору")
    @PostMapping("/bic_directory_entry/{bicId}/swbics/create")
    public ResponseEntity<SWBICSDTO> create(@RequestBody SWBICSDTO dto, @Parameter(description = "Идентификатор BICDirectoryEntry") @PathVariable Long bicId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto, bicId));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("/swbics/all")
    public ResponseEntity<List<SWBICSDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("/swbics/{id}")
    public ResponseEntity<SWBICSDTO> getById(@Parameter(description = "Идентификатор SWBICS") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("/swbics/{id}/update")
    public ResponseEntity<SWBICSDTO> update(@Parameter(description = "Идентификатор SWBICS") @PathVariable Long id, @RequestBody SWBICSDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("/swbics/{id}/delete")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор SWBICS") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
