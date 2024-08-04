package com.example.bank.repositories;

import com.example.bank.entities.ED807Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ED807Repository extends JpaRepository<ED807Entity, Long> {
}
