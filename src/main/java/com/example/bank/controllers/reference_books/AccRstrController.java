package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.AccRstrDTO;
import com.example.bank.entities.referenсe_books.AccRstrEntity;
import com.example.bank.services.reference_books.AccRstrService;
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
@Tag(name = "AccRstrController", description = "Контроллер CRUD операций для сущности AccRstr")
public class AccRstrController {

    private final AccRstrService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/acc_rstr/create")
    public ResponseEntity<AccRstrDTO> create(@RequestBody AccRstrDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("/acc_rstr/all")
    public ResponseEntity<List<AccRstrDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("/acc_rstr/get/{id}")
    public ResponseEntity<AccRstrDTO> getById(@Parameter(description = "Идентификатор AccRstr") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("/acc_rstr/update/{id}")
    public ResponseEntity<AccRstrDTO> update(@Parameter(description = "Идентификатор AccRstr") @PathVariable Long id, @RequestBody AccRstrDTO entity) {
        return ResponseEntity.ok(service.updateById(id, entity));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("/acc_rstr/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор AccRstr") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
