package com.example.houserentinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TBL_GOODS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblGoods extends BaseEntity {

    private static final long serialVersionUID = -666267549;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_ID")
    private Long goodsId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSE_ID")
    private TblHouse tblHouse;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ROOM_ID")
    private TblRoom tblRoom;

    @Column(name = "GOODS_BELONG_TYPE")
    private String goodsBelongType;

    @Column(name = "GOODS_COUNT")
    private Integer goodsCount;

    @Column(name = "GOODS_NAME")
    private String goodsName;

    @Column(name = "GOODS_PRICE")
    private BigDecimal goodsPrice;

    @Column(name = "GOODS_STATUS")
    private String goodsStatus;
}
