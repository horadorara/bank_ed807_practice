package com.example.bank.repositories;

import com.example.bank.entities.SWBICSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWBICSRepository extends JpaRepository<SWBICSEntity, Long> {
}
