package com.example.bank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@Table(name = "part_info")
public class PartInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_part_info", unique = true, nullable = false)
    private Long id;

    @Max(999999)
    @Column(name = "part_no", nullable = false)
    private Integer partNo;

    @Max(999999)
    @Column(name = "part_quantity", nullable = false, length = 6)
    private Integer partQuantity;

    @Column(name = "part_aggregate_id", nullable = false, length = 27)
    private String partAggregateId;

    @JsonIgnore
    @OneToOne
    private ED807Entity ed807;

}
