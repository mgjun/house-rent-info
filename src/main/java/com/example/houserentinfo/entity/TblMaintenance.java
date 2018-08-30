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
@Table(name = "TBL_MAINTENANCE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblMaintenance implements Serializable {

    private static final long serialVersionUID = 599995182;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long maintenanceId;

    @Column(name = "HOUSE_ID")
    private Long houseId;

    @Column(name = "ROOM_ID")
    private Long roomId;

    @Column(name = "PAY_DATETIME")
    private LocalDateTime payDateTime;

    @Column(name = "PAY_PRICE")
    private BigDecimal payPrice;
}
