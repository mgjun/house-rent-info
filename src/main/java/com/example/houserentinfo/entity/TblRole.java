package com.example.houserentinfo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_ROLE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblRole extends BaseEntity {

    private static final long serialVersionUID = 901625670;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long roleId;


    @Column(name = "ROLE_NAME")
    private String roleName;


    @ManyToMany
    @JoinTable(
            name = "TBL_ROLE_ACCESS_XREF",
            joinColumns = {@JoinColumn(name = "ROLE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ACCESS_ID")}
    )
    private List<TblAccess> tblAccessList;



}
