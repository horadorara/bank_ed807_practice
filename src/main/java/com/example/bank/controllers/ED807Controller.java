package com.example.bank.controllers;

import com.example.bank.DTO.ED807DTO;
import com.example.bank.services.ED807Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "ED807Controller", description = "Контроллер операций чтения для сущности(файла) ED807")
public class ED807Controller {

    private final ED807Service service;

    @Operation(summary = "Чтение всех существующих записей")
    @GetMapping("/ed807/all")
    public ResponseEntity<List<ED807DTO>> getAll() {
        return ResponseEntity.ok(service.getAllED807());
    }

    @Operation(summary = "Чтение существующей записи по идентификатору c дочерними записями")
    @GetMapping("/ed807/{id}")
    public ED807DTO getById(@Parameter(description = "Идентификатор ED807") @PathVariable Long id) {
        return service.getEd807ById(id);
    }

}
