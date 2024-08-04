package com.example.bank.entities.referenсe_books;

import com.example.bank.entities.ParticipantInfoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "srvcs")
public class SrvcsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_srvcs", unique = true, nullable = false)
    private Long id;

    @Column(name = "code", unique = true, nullable = false, length = 1)
    private String code;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "srvcs")
    private Set<ParticipantInfoEntity> participantInfo;

}
