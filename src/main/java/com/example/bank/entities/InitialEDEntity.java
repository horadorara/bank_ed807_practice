package com.example.bank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "initial_ed")
public class InitialEDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_initial_ed", unique = true)
    private Long id;

    @Max(999999999)
    @Column(name = "ed_no", nullable = false)
    private Integer edNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "ed_date", nullable = false)
    private Date edDate;

    @Column(name = "ed_author", nullable = false, length = 10)
    @Size(min = 10, max = 10)
    private String edAuthor;

    @JsonIgnore
    @OneToOne
    private ED807Entity ed807;

}
