package com.example.bank.controllers;

import com.example.bank.DTO.RstrListDTO;
import com.example.bank.services.RstrListService;
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
@Tag(name = "RstrListController", description = "Контроллер CRUD операций для сущности RstrList")
public class RstrListController {

    private final RstrListService service;

    @Operation(summary = "Создание новой записи с привязкой сущности ParticipantInfo по идентификатору")
    @PostMapping("/participant_info/{participantId}/rstr_list/create")
    public ResponseEntity<RstrListDTO> create(@RequestBody RstrListDTO dto, @Parameter(description = "Идентификатор ParticipantInfo") @PathVariable Long participantId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto, participantId));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("/rstr_list/all")
    public ResponseEntity<List<RstrListDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору с дочерними записями")
    @GetMapping("/rstr_list/{id}")
    public ResponseEntity<RstrListDTO> getById(@Parameter(description = "Идентификатор RstrList") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("/rstr_list/{id}/update")
    public ResponseEntity<RstrListDTO> update(@Parameter(description = "Идентификатор RstrList") @PathVariable Long id, @RequestBody RstrListDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("/rstr_list/{id}/delete")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор RstrList") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
