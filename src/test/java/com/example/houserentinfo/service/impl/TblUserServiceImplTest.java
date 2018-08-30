package com.example.houserentinfo.service.impl;

import com.example.houserentinfo.dto.UserDto;
import com.example.houserentinfo.entity.TblUser;
import com.example.houserentinfo.service.TblUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TblUserServiceImplTest {

    @Autowired
    private TblUserService tblUserService;


    @Test
    public void testSave() {
        UserDto userDto = UserDto.builder()
                .idCard("513023199009092234")
                .idCardImage("image/url/")
                .imPhoneNumber("13568902057")
                .phoneNumber("13568902057")
                .roleId(1L)
                .userAge(20)
                .userSex("男")
                .username("test")
                .userId(2L)
                .build();
        tblUserService.saveOrUpdate(userDto);
        UserDto returnUserDto = tblUserService.findById(2L);
        Assert.assertEquals("513023199009092233", returnUserDto.getIdCard());
    }


    @Test
    public void testFindByUsername() {
        TblUser user = tblUserService.findByUserName("DEMO");
        Assert.assertTrue(Objects.nonNull(user));
    }

}