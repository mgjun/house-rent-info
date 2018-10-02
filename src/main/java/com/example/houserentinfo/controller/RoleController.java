package com.example.houserentinfo.controller;

import com.example.houserentinfo.dto.RoleDto;
import com.example.houserentinfo.entity.TblRole;
import com.example.houserentinfo.service.TblRoleService;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final TblRoleService tblRoleService;

    public RoleController(TblRoleService tblRoleService) {
        this.tblRoleService = tblRoleService;
    }

    @PostMapping("/pageAndSort")
    public List<TblRole> pageAndSortRoles(RoleDto roleDto) {
        return tblRoleService.pageAndSortRoleList(roleDto);
    }
}
