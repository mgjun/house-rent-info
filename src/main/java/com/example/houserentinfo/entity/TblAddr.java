package com.example.houserentinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ADDR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblAddr extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AREA_ID")
    private Long areaId;


    @Column(name = "AREA_NAME")
    private String areaName;


    @Column(name = "AREA_TYPE")
    private String areaType;


    @Column(name = "PARENT_ID")
    private Long parentId;


}
