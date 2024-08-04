package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.AccountStatusDTO;
import com.example.bank.entities.referenсe_books.AccountStatusEntity;
import com.example.bank.services.reference_books.AccountStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "AccountStatusController", description = "Контроллер CRUD операций для сущности AccountStatus")
@SecurityRequirement(name = "basicAuth")
public class AccountStatusController {

    private final AccountStatusService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("account_status/create")
    public ResponseEntity<AccountStatusDTO> create(@RequestBody AccountStatusDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("account_status/all")
    public ResponseEntity<List<AccountStatusDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("account_status/{id}")
    public ResponseEntity<AccountStatusDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("account_status/{id}/update")
    public ResponseEntity<AccountStatusDTO> update(@Parameter(description = "Идентификатор AccountStatus") @PathVariable Long id, @RequestBody AccountStatusDTO entity) {
        return ResponseEntity.ok(service.updateById(id, entity));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("account_status/{id}/delete")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор AccountStatus") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
