package com.example.bank.entities;

import com.example.bank.entities.referenсe_books.AccountStatusEntity;
import com.example.bank.entities.referenсe_books.RegulationAccountTypeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "accounts")
public class AccountsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account", unique = true, nullable = false)
    private Long id;

    @Column(name = "account", nullable = false, length = 20)
    @Size(min = 20, max = 20)
    private String account;

    @ManyToOne
    @JoinColumn(name = "id_regulation_account_type")
    private RegulationAccountTypeEntity regulationAccountType;

    @Column(name = "ck", length = 2)
    @Size(min = 2, max = 2)
    private String ck;

    @Column(name = "account_cbr_bic", nullable = false, length = 9)
    @Size(min = 9, max = 9)
    private String accountCbrBic;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_in", nullable = false)
    private Date dateIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_out")
    private Date dateOut;

    @ManyToOne
    @JoinColumn(name = "id_account_status")
    private AccountStatusEntity accountStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_bic_directory_entry")
    private BICDirectoryEntryEntity bicDirectoryEntry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accounts")
    private Set<AccRstrListEntity> accRstrLists = new HashSet<>();

}
