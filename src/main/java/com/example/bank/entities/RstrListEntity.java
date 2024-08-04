package com.example.bank.entities;

import com.example.bank.entities.referenсe_books.RstrEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "rstr_list")
public class RstrListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rstr_list", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @Size(min = 4, max = 4)
    @JoinColumn(name = "id_rstr")
    private RstrEntity rstr;

    @Temporal(TemporalType.DATE)
    @Column(name = "rstr_date", nullable = false)
    private Date rstrDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_participant_info")
    private ParticipantInfoEntity participantInfos;
}
