package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.CreationReasonEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreationReasonRepository extends JpaRepository<CreationReasonEntity, Long> {

    @Cacheable("creationReasonCode")
    CreationReasonEntity findByCode(String code);
}
