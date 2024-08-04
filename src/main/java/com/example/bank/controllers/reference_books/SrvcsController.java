package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.SrvcsDTO;
import com.example.bank.entities.referenсe_books.SrvcsEntity;
import com.example.bank.services.reference_books.SrvcsService;
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
@Tag(name = "SrvcsController", description = "Контроллер CRUD операций для сущности Srvcs")
public class SrvcsController {

    private final SrvcsService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/srvcs/create")
    public ResponseEntity<SrvcsDTO> create(@RequestBody SrvcsDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("srvcs/all")
    public ResponseEntity<List<SrvcsDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("srvcs/get/{id}")
    public ResponseEntity<SrvcsDTO> getById(@Parameter(description = "Идентификатор Srvcs") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("srvcs/update/{id}")
    public ResponseEntity<SrvcsDTO> update(@Parameter(description = "Идентификатор Srvcs") @PathVariable Long id, @RequestBody SrvcsDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("srvcs/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор Srvcs") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
