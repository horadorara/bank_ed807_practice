package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.ChangeTypeDTO;
import com.example.bank.entities.referenсe_books.ChangeTypeEntity;
import com.example.bank.services.reference_books.ChangeTypeService;
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
@Tag(name = "ChangeTypeController", description = "Контроллер CRUD операций для сущности ChangeType")
public class ChangeTypeController {

    private final ChangeTypeService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/change_type/create")
    public ResponseEntity<ChangeTypeDTO> create(@RequestBody ChangeTypeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("change_type/all")
    public ResponseEntity<List<ChangeTypeDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("change_type/get/{id}")
    public ResponseEntity<ChangeTypeDTO> getById(@Parameter(description = "Идентификатор ChangeType") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("change_type/update/{id}")
    public ResponseEntity<ChangeTypeDTO> update(@Parameter(description = "Идентификатор ChangeType") @PathVariable Long id, @RequestBody ChangeTypeDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("change_type/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор ChangeType") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
