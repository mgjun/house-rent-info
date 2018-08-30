package com.example.houserentinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_COMPACT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblCompact extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPACT_ID")
    private Long compactId;

    @Column(name = "COMPACT_NAME")
    private String compactName;

    @Column(name = "COMPACT_START_DATE")
    private LocalDate compactStartDate;

    @Column(name = "COMPACT_END_DATE")
    private LocalDate compactEndDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "LANDLORD_ID")
    private TblUser landlordUser;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "TENANT_ID")
    private TblUser tenantUser;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSE_ID")
    private TblHouse tblHouse;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ROOM_ID")
    private TblRoom tblRoom;

    @Column(name = "RENT_PRICE")
    private BigDecimal rentPrice;

    @Column(name = "DEPOSIT_PRICE")
    private BigDecimal depositPrice;


    @Column(name = "COMPACT_IMAGE")
    private String compactImage;

    @Column(name = "COMPACT_DESCRIPTION")
    private String compactDescription;


}
