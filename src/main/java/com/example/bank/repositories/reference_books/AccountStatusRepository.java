package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.AccountStatusEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStatusRepository extends JpaRepository<AccountStatusEntity, Long> {

    @Cacheable("accountStatusCode")
    AccountStatusEntity findByCode(String code);
}
