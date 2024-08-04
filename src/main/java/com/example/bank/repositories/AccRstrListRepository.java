package com.example.bank.repositories;

import com.example.bank.entities.AccRstrListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRstrListRepository extends JpaRepository<AccRstrListEntity, Long> {
}
