package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.CreationReasonDTO;
import com.example.bank.entities.referenсe_books.CreationReasonEntity;
import com.example.bank.services.reference_books.CreationReasonService;
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
@Tag(name = "CreationReasonController", description = "Контроллер CRUD операций для сущности CreationReason")
public class CreationReasonController {

    private final CreationReasonService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/creation_reason/create")
    public ResponseEntity<CreationReasonDTO> create(@RequestBody CreationReasonDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("creation_reason/all")
    public ResponseEntity<List<CreationReasonDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("creation_reason/get/{id}")
    public ResponseEntity<CreationReasonDTO> getById(@Parameter(description = "Идентификатор CreationReason") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("creation_reason/update/{id}")
    public ResponseEntity<CreationReasonDTO> update(@Parameter(description = "Идентификатор CreationReason") @PathVariable Long id, @RequestBody CreationReasonDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("creation_reason/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор CreationReason") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
