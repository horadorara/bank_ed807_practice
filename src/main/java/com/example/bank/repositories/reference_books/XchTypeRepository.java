package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.XchTypeEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XchTypeRepository extends JpaRepository<XchTypeEntity, Long> {

    @Cacheable("xchTypeCode")
    XchTypeEntity findByCode(String code);
}
