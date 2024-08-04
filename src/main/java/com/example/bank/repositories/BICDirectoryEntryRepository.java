package com.example.bank.repositories;

import com.example.bank.entities.BICDirectoryEntryEntity;
import com.example.bank.entities.referenсe_books.ChangeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BICDirectoryEntryRepository extends JpaRepository<BICDirectoryEntryEntity,Long> {
}
