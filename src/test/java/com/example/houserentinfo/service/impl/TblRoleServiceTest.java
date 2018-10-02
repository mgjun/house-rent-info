package com.example.houserentinfo.service.impl;

import com.example.houserentinfo.dto.RoleDto;
import com.example.houserentinfo.exception.EntityNotFoundException;
import com.example.houserentinfo.service.TblRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TblRoleServiceTest {

    @Autowired
    private TblRoleService tblRoleService;

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowExceptionWhenPageRoleList() {
        tblRoleService.pageAndSortRoleList(RoleDto.builder().build());
    }

}