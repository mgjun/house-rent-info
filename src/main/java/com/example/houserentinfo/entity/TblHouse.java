package com.example.houserentinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_HOUSE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblHouse extends BaseEntity {

    private static final long serialVersionUID = -1297698360;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOUSE_ID")
    private Long houseId;

    @Column(name = "VILLAGE_NAME")
    private String villageName;


    @Column(name = "HOUSE_ADDRESS")
    private String houseAddress;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "AREA_ID")
    private Long areaId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "OWNER_ID")
    private TblUser tblUser;


    @Column(name = "HOUSE_DESCRIPTION")
    private String houseDescription;

    @OneToMany(mappedBy = "tblHouse")
    private List<TblGoods> tblGoodsList;
}
