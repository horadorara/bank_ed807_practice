package com.example.bank.controllers;

import com.example.bank.DTO.BICDirectoryEntryDTO;
import com.example.bank.DTO.ParticipantInfoDTO;
import com.example.bank.services.ParticipantInfoService;
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
@Tag(name = "ParticipantInfoController", description = "Контроллер CRUD операций для сущности ParticipantInfo")
public class ParticipantInfoController {

    private final ParticipantInfoService service;

    @Operation(summary = "Создание новой записи с привязкой сущности BICDirectoryEntry по идентификатору")
    @PostMapping("/bic_directory_entry/{bicId}/participant_info/create")
    public ResponseEntity<ParticipantInfoDTO> create(@RequestBody ParticipantInfoDTO dto, @Parameter(description = "Идентификатор BicDirectoryEntry") @PathVariable Long bicId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto, bicId));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("/participant_info/all")
    public ResponseEntity<List<ParticipantInfoDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору с дочерними записями")
    @GetMapping("/participant_info/{id}")
    public ResponseEntity<ParticipantInfoDTO> getById(@Parameter(description = "Идентификатор ParticipantInfo") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("/participant_info/{id}/update")
    public ResponseEntity<ParticipantInfoDTO> update(@Parameter(description = "Идентификатор ParticipantInfo") @PathVariable Long id, @RequestBody ParticipantInfoDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("/participant_info/{id}/delete")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор ParticipantInfo") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
