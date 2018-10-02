package com.example.houserentinfo.service.impl;

import com.example.houserentinfo.entity.TblRole;
import com.example.houserentinfo.exception.EntityNotFoundException;
import com.example.houserentinfo.repository.TblRoleRepository;
import com.example.houserentinfo.service.TblRoleService;
import com.example.houserentinfo.dto.RoleDto;
import com.example.houserentinfo.util.StatusCode;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TblRoleServiceImpl implements TblRoleService {

    private final TblRoleRepository tblRoleRepository;


    @Autowired
    public TblRoleServiceImpl(TblRoleRepository tblRoleRepository) {
        this.tblRoleRepository = tblRoleRepository;
    }

    @Override
    public Boolean saveOrUpdate(RoleDto roleVo) {
        tblRoleRepository.save(packToTblRole(roleVo));
        return Boolean.TRUE;
    }

    @Override
    public Optional<TblRole> findById(Long roleId) {
        return tblRoleRepository.findById(roleId);
    }

    @Override
    public List<TblRole> pageAndSortRoleList(RoleDto roleVo) {
        if(Objects.nonNull(roleVo) && Objects.isNull(roleVo.getRoleId())) {
            throw new EntityNotFoundException(StatusCode.ENTITY_NOT_FOUND,"role not found");
        }
        return null;
    }


    private TblRole packToTblRole(RoleDto roleVo) {
        return TblRole.builder().build();
    }
}
