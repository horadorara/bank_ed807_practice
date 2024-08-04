package com.example.bank.utils;

import com.example.bank.services.reference_books.SaveReferenceBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitReferencesBooks implements CommandLineRunner {

    private final SaveReferenceBooks saveReferenceBooks;

    @Override
    public void run(String... args) throws Exception {
        saveReferenceBooks.saveReferenceBooks();
    }
}
