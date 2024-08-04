package com.example.bank.entities.referenсe_books;

import com.example.bank.entities.AccountsEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "account_status")
public class AccountStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_status", unique = true, nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 4)
    @Size(min = 4, max = 4)
    private String code;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountStatus")
    private Set<AccountsEntity> accounts;
}
