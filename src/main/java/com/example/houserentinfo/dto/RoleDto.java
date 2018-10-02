package com.example.houserentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto extends BaseDto {
    private Long roleId;
    private String roleName;
    private List<Long> accessIdList;
}
