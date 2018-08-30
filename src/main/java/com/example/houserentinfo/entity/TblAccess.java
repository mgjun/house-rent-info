package com.example.houserentinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_ACCESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblAccess extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCESS_ID")
    private Long accessId;

    @Column(name = "ACCESS_NAME")
    private String accessName;

    @Column(name = "ACCESS_URL")
    private String accessUrl;

    @Column(name = "PARENT_ACCESS_ID")
    private Long parentAccessId;

    @ManyToMany(mappedBy = "tblAccessList")
    private List<TblRole> tblRoleList;

}
