package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.InfoTypeCodeDTO;
import com.example.bank.entities.referenсe_books.InfoTypeCodeEntity;
import com.example.bank.services.reference_books.InfoTypeCodeService;
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
@Tag(name = "InfoTypeCodeControllerr", description = "Контроллер CRUD операций для сущности InfoTypeCode")
public class InfoTypeCodeController {

    private final InfoTypeCodeService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/info_type_code/create")
    public ResponseEntity<InfoTypeCodeDTO> create(@RequestBody InfoTypeCodeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("info_type_code/all")
    public ResponseEntity<List<InfoTypeCodeDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("info_type_code/get/{id}")
    public ResponseEntity<InfoTypeCodeDTO> getById(@Parameter(description = "Идентификатор InfoTypeCode") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("info_type_code/update/{id}")
    public ResponseEntity<InfoTypeCodeDTO> update(@Parameter(description = "Идентификатор InfoTypeCode") @PathVariable Long id, @RequestBody InfoTypeCodeDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("info_type_code/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор InfoTypeCode") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
