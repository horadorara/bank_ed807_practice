package com.example.bank.repositories;

import com.example.bank.entities.RstrListEntity;
import com.example.bank.entities.referenсe_books.RstrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RstrListRepository extends JpaRepository<RstrListEntity, Long> {
}
