package com.example.houserentinfo.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class RoleDto extends BaseDto {
    private Long roleId;
    private String roleName;
    private List<Long> accessIdList;
}
