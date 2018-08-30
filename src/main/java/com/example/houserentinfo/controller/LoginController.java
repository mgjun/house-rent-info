package com.example.houserentinfo.controller;


import com.example.houserentinfo.dto.UserDto;
import com.example.houserentinfo.service.TblUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {


    @Autowired
    private TblUserService userService;

    @GetMapping(value = "/test")
    public String test() {
        Subject subject = SecurityUtils.getSubject();

        boolean admin = subject.isPermitted("admin");
        return String.valueOf(admin);
    }

    @PostMapping(value = "/login")
    public Object testLogin(@RequestBody UserDto userDto) {
        Subject currentUsr = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userDto.getUsername(), userDto.getPassword());
        currentUsr.login(token);

        if(currentUsr.hasRole("admin”")) {
            //有权限
        } else {
            //无权限
        }
        return currentUsr.getSession().getId();
    }


    @PostMapping("/changePassword")
    public String changePassWord(@RequestBody UserDto userDto) {
        userService.changePassword(userDto.getUsername(), userDto.getPassword());
        return "SUCCESS";
    }


//    @RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
//    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
//        System.out.println("HomeController.login()");
//        String exception = (String) request.getAttribute("shiroLoginFailure");
//
//        System.out.println("exception=" + exception);
//        String msg = "";
//        if (exception != null) {
//            if (UnknownAccountException.class.getName().equals(exception)) {
//                System.out.println("UnknownAccountException -- > 账号不存在：");
//                msg = "UnknownAccountException -- > 账号不存在：";
//            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//                msg = "IncorrectCredentialsException -- > 密码不正确：";
//            } else if ("kaptchaValidateFailed".equals(exception)) {
//                System.out.println("kaptchaValidateFailed -- > 验证码错误");
//                msg = "kaptchaValidateFailed -- > 验证码错误";
//            } else {
//                msg = "else >> "+exception;
//                System.out.println("else -- >" + exception);
//            }
//        }
//        map.put("msg", msg);
//        return "/login";
//    }
}
