package com.example.bank.entities;

import com.example.bank.entities.referenсe_books.ChangeTypeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "bic_directory_entry")
public class BICDirectoryEntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bic_directory_entry", unique = true, nullable = false)
    private Long id;

    @Column(name = "bic", nullable = false, length = 9)
    @Size(min = 9, max = 9)
    private String bic;

    @ManyToOne
    @JoinColumn(name = "id_change_type")
    private ChangeTypeEntity changeType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_ed807")
    private ED807Entity ed807;

    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "bicDirectoryEntry")
    private ParticipantInfoEntity participantInfo;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "bicDirectoryEntry")
    private Set<SWBICSEntity> swbics = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "bicDirectoryEntry")
    private Set<AccountsEntity> accounts = new HashSet<>();

}
