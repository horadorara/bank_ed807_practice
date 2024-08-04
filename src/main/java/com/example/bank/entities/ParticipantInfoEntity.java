package com.example.bank.entities;

import com.example.bank.entities.referenсe_books.ParticipantStatusEntity;
import com.example.bank.entities.referenсe_books.PtTypeEntity;
import com.example.bank.entities.referenсe_books.SrvcsEntity;
import com.example.bank.entities.referenсe_books.XchTypeEntity;
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
@Table(name = "participant_info")
public class ParticipantInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participant_info", unique = true, nullable = false)
    private Long id;

    @Column(name = "name_p", nullable = false, length = 160)
    private String nameP;

    @Column(name = "engl_name", length = 140)
    private String englName;

    @Column(name = "reg_n", length = 9)
    private String regN;

    @Column(name = "cntr_cd", length = 2)
    @Size(min = 2, max = 2)
    private String cntrCd;

    @Column(name = "rgn", length = 2)
    private String rgn;

    @Column(name = "ind", length = 6)
    private String ind;

    @Column(name = "tnp", length = 5)
    private String tnp;

    @Column(name = "nnp", length = 25)
    private String nnp;

    @Column(name = "adr", length = 160)
    private String adr;

    @Column(name = "prnt_bic", length = 9)
    @Size(min = 9, max = 9)
    private String prntBic;

    @Column(name = "date_in", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateIn;

    @Column(name = "date_out")
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @ManyToOne
    @JoinColumn(name = "id_pt_type")
    private PtTypeEntity ptType;

    @ManyToOne
    @JoinColumn(name = "id_srvcs")
    private SrvcsEntity srvcs;

    @ManyToOne
    @JoinColumn(name = "id_xch_type")
    private XchTypeEntity xchType;

    @Column(name = "uid", nullable = false, length = 10)
    @Size(min = 10, max = 10)
    private String uid;

    @ManyToOne
    @JoinColumn(name = "id_participant_status")
    private ParticipantStatusEntity participantStatus;

    @JsonIgnore
    @OneToOne
    private BICDirectoryEntryEntity bicDirectoryEntry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participantInfos")
    private Set<RstrListEntity> rstrLists = new HashSet<>();

}
