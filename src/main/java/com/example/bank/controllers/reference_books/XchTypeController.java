package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.XchTypeDTO;
import com.example.bank.entities.referenсe_books.XchTypeEntity;
import com.example.bank.services.reference_books.XchTypeService;
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
@Tag(name = "XchTypeController", description = "Контроллер CRUD операций для сущности XchType")
public class XchTypeController {

    private final XchTypeService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/xch_type/create")
    public ResponseEntity<XchTypeDTO> create(@RequestBody XchTypeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("xch_type/all")
    public ResponseEntity<List<XchTypeDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("xch_type/get/{id}")
    public ResponseEntity<XchTypeDTO> getById(@Parameter(description = "Идентификатор XchType") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("xch_type/update/{id}")
    public ResponseEntity<XchTypeDTO> update(@Parameter(description = "Идентификатор XchType") @PathVariable Long id, @RequestBody XchTypeDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("xch_type/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор XchType") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
