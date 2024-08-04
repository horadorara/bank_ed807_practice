package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.SrvcsEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SrvcsRepository extends JpaRepository<SrvcsEntity, Long> {

    @Cacheable("srvcsCode")
    SrvcsEntity findByCode(String code);
}
