package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.PtTypeDTO;
import com.example.bank.entities.referenсe_books.PtTypeEntity;
import com.example.bank.services.reference_books.PtTypeService;
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
@Tag(name = "PtTypeController", description = "Контроллер CRUD операций для сущности PtType")
public class PtTypeController {

    private final PtTypeService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/pt_type/create")
    public ResponseEntity<PtTypeDTO> create(@RequestBody PtTypeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("pt_type/all")
    public ResponseEntity<List<PtTypeDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("pt_type/get/{id}")
    public ResponseEntity<PtTypeDTO> getById(@Parameter(description = "Идентификатор PtType") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("pt_type/update/{id}")
    public ResponseEntity<PtTypeDTO> update(@Parameter(description = "Идентификатор PtType") @PathVariable Long id, @RequestBody PtTypeDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("pt_type/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор PtType") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
