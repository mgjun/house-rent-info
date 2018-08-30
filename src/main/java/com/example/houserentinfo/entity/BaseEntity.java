package com.example.houserentinfo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @CreatedDate
    @Column(name = "CREATE_DATETIME")
    private LocalDateTime createDateTime;

    @LastModifiedDate
    @Column(name = "MODIFY_DATETIME")
    private LocalDateTime modifyDateTime;
}
