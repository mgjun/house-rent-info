package com.example.houserentinfo.service;

import com.example.houserentinfo.entity.TblRole;
import com.example.houserentinfo.dto.RoleDto;

import java.util.List;
import java.util.Optional;

public interface TblRoleService {

    Boolean saveOrUpdate(RoleDto roleVo);

    Optional<TblRole> findById(Long roleId);

    List<TblRole> pageAndSortRoleList(RoleDto roleVo);
}
