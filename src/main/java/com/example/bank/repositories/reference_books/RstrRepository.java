package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.RstrEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RstrRepository extends JpaRepository<RstrEntity, Long> {

    @Cacheable("rstrCode")
    RstrEntity findByCode(String code);
}
