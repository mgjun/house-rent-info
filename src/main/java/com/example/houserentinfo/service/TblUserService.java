package com.example.houserentinfo.service;

import com.example.houserentinfo.entity.TblUser;
import com.example.houserentinfo.dto.UserDto;

import java.util.List;

public interface TblUserService {

    void saveOrUpdate(UserDto userDto);

    void changePassword(String username,String password);

    UserDto findById(Long userId);

    TblUser findByUserName(String userName);

    UserDto findByIdCard(String idCard);

    List<TblUser> pageAndSortUserList(UserDto userDto);

}
