package com.example.houserentinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_RENT_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblRentInfo implements Serializable {

    private static final long serialVersionUID = -1896621455;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long rentInfoId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSE_ID")
    private TblHouse tblHouse;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ROOM_ID")
    private TblRoom tblRoom;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "RENT_USER_ID")
    private TblUser rentUser;

    @Column(name = "PAY_PRICE")
    private BigDecimal payPrice;

    @Column(name = "PAY_DATE")
    private LocalDateTime payDate;
}
