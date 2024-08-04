package com.example.bank.repositories.reference_books;

import com.example.bank.entities.referenсe_books.ParticipantStatusEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantStatusRepository extends JpaRepository<ParticipantStatusEntity, Long> {

    @Cacheable("participantStatusCode")
    ParticipantStatusEntity findByCode(String code);
}
