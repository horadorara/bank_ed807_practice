package com.example.bank.repositories;

import com.example.bank.entities.ParticipantInfoEntity;
import com.example.bank.entities.referenсe_books.ParticipantStatusEntity;
import com.example.bank.entities.referenсe_books.PtTypeEntity;
import com.example.bank.entities.referenсe_books.SrvcsEntity;
import com.example.bank.entities.referenсe_books.XchTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ParticipantInfoRepository extends JpaRepository<ParticipantInfoEntity, Long> {
}
