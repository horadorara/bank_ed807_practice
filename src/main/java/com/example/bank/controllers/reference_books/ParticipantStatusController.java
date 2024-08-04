package com.example.bank.controllers.reference_books;

import com.example.bank.DTO.reference_books.ParticipantStatusDTO;
import com.example.bank.entities.referenсe_books.ParticipantStatusEntity;
import com.example.bank.services.reference_books.ParticipantStatusService;
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
@Tag(name = "ParticipantStatusController", description = "Контроллер CRUD операций для сущности ParticipantStatus")
public class ParticipantStatusController {

    private final ParticipantStatusService service;

    @Operation(summary = "Создание новой записи")
    @PostMapping("/participant_status/create")
    public ResponseEntity<ParticipantStatusDTO> create(@RequestBody ParticipantStatusDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("participant_status/all")
    public ResponseEntity<List<ParticipantStatusDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору")
    @GetMapping("participant_status/get/{id}")
    public ResponseEntity<ParticipantStatusDTO> getById(@Parameter(description = "Идентификатор ParticipantStatus") @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(summary = "Редактирование существующей записи по идентификатору")
    @PutMapping("participant_status/update/{id}")
    public ResponseEntity<ParticipantStatusDTO> update(@Parameter(description = "Идентификатор ParticipantStatus") @PathVariable Long id, @RequestBody ParticipantStatusDTO dto) {
        return ResponseEntity.ok(service.updateById(id, dto));
    }

    @Operation(summary = "Удаление существующей записи по идентификатору")
    @DeleteMapping("participant_status/delete/{id}")
    public ResponseEntity<Void> delete(@Parameter(description = "Идентификатор ParticipantStatus") @PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
