package com.example.bank.repositories;

import com.example.bank.entities.AccountsEntity;
import com.example.bank.entities.referenсe_books.AccountStatusEntity;
import com.example.bank.entities.referenсe_books.RegulationAccountTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {
}
