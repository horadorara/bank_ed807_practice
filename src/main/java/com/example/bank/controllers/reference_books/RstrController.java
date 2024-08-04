package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.RstrDTO;
import com.example.bank.entities.referenсe_books.RstrEntity;
import com.example.bank.services.reference_books.RstrService;
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
@Tag(name = "RstrController", description = "Контроллер CRUD операций для сущности Rstr")
public class RstrController {

    private final RstrService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/rstr/create")
    public ResponseEntity<RstrDTO> create(@RequestBody RstrDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("rstr/all")
    public ResponseEntity<List<RstrDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("rstr/get/{id}")
    public ResponseEntity<RstrDTO> getById(@Parameter(description = "Идентификатор Rstr") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("rstr/update/{id}")
    public ResponseEntity<RstrDTO> update(@Parameter(description = "Идентификатор Rstr") @PathVariable Long id, @RequestBody RstrDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("rstr/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор Rstr") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
