package com.example.bank.repositories;

import com.example.bank.entities.InitialEDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitialEDRepository extends JpaRepository<InitialEDEntity, Long> {
}
