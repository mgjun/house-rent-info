package com.example.houserentinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_RENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblRent extends BaseEntity {

    private static final long serialVersionUID = 1054901261;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENT_ID")
    private Long rentId;

    @Column(name = "COMPACT_ID")
    private Long compactId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "RENT_USER_ID")
    private TblUser rentUser;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSE_ID")
    private TblHouse tblHouse;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ROOM_ID")
    private TblRoom tblRoom;

    @Column(name = "RENT_CYCLE")
    private String rentCycle;

    @Column(name = "RENT_REMIND_DATE")
    private LocalDateTime rentRemindDate;
}
