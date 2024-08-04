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
@Table(name = "xch_type")
public class XchTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_xch_type", unique = true, nullable = false)
    private Long id;

    @Column(name = "code", unique = true, nullable = false, length = 1)
    private String code;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xchType")
    private Set<ParticipantInfoEntity> participantInfo;

}
