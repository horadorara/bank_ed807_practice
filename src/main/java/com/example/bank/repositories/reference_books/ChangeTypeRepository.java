package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.ChangeTypeEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeTypeRepository extends JpaRepository<ChangeTypeEntity,Long> {

    @Cacheable("changeTypeCode")
    ChangeTypeEntity findByCode(String code);
}
