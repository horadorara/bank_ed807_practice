package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.AccRstrEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRstrRepository extends JpaRepository<AccRstrEntity, Long> {

    @Cacheable("accRstrCode")
    AccRstrEntity findByCode(String code);
}
