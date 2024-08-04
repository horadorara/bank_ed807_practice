package com.example.bank.controllers;

import com.example.bank.entities.ED807Entity;
import com.example.bank.repositories.ED807Repository;
import com.example.bank.services.SaveData;
import com.example.bank.services.reference_books.SaveReferenceBooks;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.cbr.ed.v2.ED807;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Tag(name = "UploadAndDownloadController", description = "Контроллер загрузки файла в БД и скачивания из БД")
public class UploadAndDownloadController {

    private final SaveData saveData;

    private final ED807Repository ed807Repository;

    @Operation(description = "Загрузка файла в БД")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("File is empty", HttpStatus.NOT_FOUND);
        }

        try (InputStream inputStream = file.getInputStream()) {
            JAXBContext jaxbContext = JAXBContext.newInstance("ru.cbr.ed.v2");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ED807 ed807 = (ED807) jaxbUnmarshaller.unmarshal(inputStream);
            String fileName = file.getOriginalFilename();
            byte[] fileData = file.getBytes();
            saveData.saveEd807(ed807, fileName, fileData);

            return new ResponseEntity<>(ed807, HttpStatus.ACCEPTED);

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(description = "Скачать файл из БД по идентфикатору ED807")
    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadFile(@Parameter(description = "Идентификатор ED807") @PathVariable Long id) {
        Optional<ED807Entity> ed807EntityOptional = ed807Repository.findById(id);
        if (ed807EntityOptional.isPresent()) {
            ED807Entity ed807Entity = ed807EntityOptional.get();
            byte[] fileData = ed807Entity.getFileData();
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ed807Entity.getFileName() + "\"")
                    .body(fileData);
        } else {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
    }
}
