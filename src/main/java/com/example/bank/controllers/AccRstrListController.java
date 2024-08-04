package com.example.bank.controllers;

import com.example.bank.DTO.AccRstrListDTO;
import com.example.bank.services.AccRstrListService;
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
@Tag(name = "AccRstrListController", description = "Контроллер CRUD операций для сущности AccRstrList")
public class AccRstrListController {

    private final AccRstrListService service;

    @Operation(summary = "Создание новой записи с привязкой сущности Accounts по идентификатору")
    @PostMapping("/accounts/{accId}/acc_rstr_list/create")
    public ResponseEntity<AccRstrListDTO> create(@RequestBody AccRstrListDTO dto, @Parameter(description = "Идентификатор Accounts") @PathVariable Long accId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto, accId));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("/acc_rstr_list/all")
    public ResponseEntity<List<AccRstrListDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("/acc_rstr_list/{id}")
    public ResponseEntity<AccRstrListDTO> getById(@Parameter(description = "Идентификатор AccRstrList") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("/acc_rstr_list/{id}/update")
    public ResponseEntity<AccRstrListDTO> update(@Parameter(description = "Идентификатор AccRstrList") @PathVariable Long id, @RequestBody AccRstrListDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("/acc_rstr_list/{id}/delete")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор AccRstrList") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
