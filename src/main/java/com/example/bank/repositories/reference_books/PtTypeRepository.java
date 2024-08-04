package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.PtTypeEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PtTypeRepository extends JpaRepository<PtTypeEntity, Long> {

    @Cacheable("ptTypeCode")
    PtTypeEntity findByCode(String code);
}
