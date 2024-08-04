package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.RegulationAccountTypeEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulationAccountTypeRepository extends JpaRepository<RegulationAccountTypeEntity, Long> {

    @Cacheable("regulationAccountTypeCode")
    RegulationAccountTypeEntity findByCode(String code);
}
