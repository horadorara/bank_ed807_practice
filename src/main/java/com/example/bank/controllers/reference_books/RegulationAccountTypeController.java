package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.RegulationAccountTypeDTO;
import com.example.bank.entities.referenсe_books.RegulationAccountTypeEntity;
import com.example.bank.services.reference_books.RegulationAccountTypeService;
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
@Tag(name = "RegulationAccountTypeController", description = "Контроллер CRUD операций для сущности RegulationAccountType")
public class RegulationAccountTypeController {

    private final RegulationAccountTypeService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/regulation_account_type/create")
    public ResponseEntity<RegulationAccountTypeDTO> create(@RequestBody RegulationAccountTypeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("regulation_account_type/all")
    public ResponseEntity<List<RegulationAccountTypeDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("regulation_account_type/get/{id}")
    public ResponseEntity<RegulationAccountTypeDTO> getById(@Parameter(description = "Идентификатор RegulationAccountType") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("regulation_account_type/update/{id}")
    public ResponseEntity<RegulationAccountTypeDTO> update(@Parameter(description = "Идентификатор RegulationAccountType") @PathVariable Long id, @RequestBody RegulationAccountTypeDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("regulation_account_type/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор RegulationAccountType") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
