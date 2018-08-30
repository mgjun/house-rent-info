package com.example.houserentinfo.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "TBL_ROOM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblRoom extends BaseEntity {

    private static final long serialVersionUID = 889177106;

    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(name = "ROOM_PRICE")
    private BigDecimal roomPrice;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSE_ID")
    private TblHouse tblHouse;

    @Column(name = "ROOM_NAME")
    private String roomName;

    @Column(name = "ROOM_DESCRIPTION")
    private String roomDescription;

    @OneToMany(mappedBy = "tblRoom")
    private List<TblGoods> tblGoodsList;
}
