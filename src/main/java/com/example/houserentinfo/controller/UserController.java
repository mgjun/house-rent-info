package com.example.houserentinfo.controller;

import com.example.houserentinfo.dto.UserDto;
import com.example.houserentinfo.service.TblUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
@RequiresRoles("user")
public class UserController {


    @Autowired
    private TblUserService tblUserService;

    @GetMapping("/findById/{userId}")
    public UserDto findById(@PathVariable("userId") Long userId) {
        return tblUserService.findById(userId);
    }


    @PostMapping("/create")
    public String create(@RequestBody UserDto userDto) {
        tblUserService.saveOrUpdate(userDto);
        return HttpStatus.OK.getReasonPhrase();
    }

    @PostMapping("/update")
    public String update(@RequestBody UserDto userDto) {
        tblUserService.saveOrUpdate(userDto);
        return HttpStatus.OK.getReasonPhrase();
    }

    @GetMapping("/findByIdCard/{idCard}")
    public UserDto findByIdCard(@PathVariable("idCard") String idCard) {
        return tblUserService.findByIdCard(idCard);
    }

}
