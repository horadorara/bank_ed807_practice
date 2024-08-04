package com.example.bank.entities;

import com.example.bank.entities.referenсe_books.AccRstrEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "acc_rstr_list")
public class AccRstrListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acc_rstr_list", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_acc_rstr")
    private AccRstrEntity accRstr;

    @Temporal(TemporalType.DATE)
    @Column(name = "acc_rstr_date", nullable = false)
    private Date accRstrDate;

    @Column(name = "successor_bic", length = 9)
    @Size(min = 9, max = 9)
    private String successorBic;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_account")
    private AccountsEntity accounts;
}
