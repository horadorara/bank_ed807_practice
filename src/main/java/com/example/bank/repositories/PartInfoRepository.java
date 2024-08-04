package com.example.bank.repositories;

import com.example.bank.entities.PartInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartInfoRepository extends JpaRepository<PartInfoEntity, Long> {
}
