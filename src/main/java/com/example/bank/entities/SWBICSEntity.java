package com.example.bank.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "swbics")
public class SWBICSEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_swbic", unique = true, nullable = false)
    private Long id;

    @Column(name = "swbic", nullable = false, length = 11)
    @Pattern(regexp = "^[A-Z]{4}[A-Z]{2}[A-Z0-9]{2}([A-Z0-9]{3})?$", message = "Invalid SWIFT code")
    private String swbic;

    @Column(name = "default_swbic", nullable = false)
    private Boolean defaultSwbic;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_bic_directory_entry")
    private BICDirectoryEntryEntity bicDirectoryEntry;
}
