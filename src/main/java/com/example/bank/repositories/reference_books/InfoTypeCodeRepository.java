package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.InfoTypeCodeEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoTypeCodeRepository extends JpaRepository<InfoTypeCodeEntity, Long> {

    @Cacheable("infoTypeCodeCode")
    InfoTypeCodeEntity findByCode(String code);
}
