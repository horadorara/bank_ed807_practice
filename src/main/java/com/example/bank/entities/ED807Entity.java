package com.example.bank.entities;


import com.example.bank.entities.referenсe_books.CreationReasonEntity;
import com.example.bank.entities.referenсe_books.InfoTypeCodeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "ed807")
public class ED807Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ed", unique = true, nullable = false)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @Max(999999999)
    @Column(name = "ed_no", nullable = false)
    private Integer edNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "ed_date", nullable = false)
    private Date edDate;

    @Column(name = "ed_author", nullable = false, length = 10)
    @Size(min = 10, max = 10)
    private String edAuthor;

    @Column(name = "ed_receiver", length = 10)
    @Size(min = 10, max = 10)
    private String edReceiver;

    @ManyToOne(cascade = CascadeType.ALL)
    private CreationReasonEntity creationReason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date_time", nullable = false)
    private Date creationDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private InfoTypeCodeEntity infoTypeCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "business_day", nullable = false)
    private Date businessDay;

    @Max(99)
    @Column(name = "directory_version")
    private Byte directoryVersion;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ed807")
    private PartInfoEntity partInfo;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ed807")
    private InitialEDEntity initialEd;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "ed807")
    private Set<BICDirectoryEntryEntity> bicDirectoryEntries = new HashSet<>();

}
