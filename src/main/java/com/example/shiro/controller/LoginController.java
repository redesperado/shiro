package com.example.shiro.controller;

import com.example.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String toLogin(){
        return "login/login";
    }

    @RequestMapping("/main")
    public String admin(){
        return "login/main";
    }

//    @RequestMapping("/noRole")
//    public String noRole(){
//        return "login/noRole";
//    }

    @RequestMapping("/loginOut")
    public String loginOut(){
        return "login/login";
    }

//    @RequestMapping("/success")
//    public String success(){
//        return "success";
//    }
//
//    @RequestMapping("/error")
//    public String error(){
//        return "error";
//    }

    @ResponseBody
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public Map<String,Object> loginIn(String username,String password){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);
        String role = userService.getRole(username);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","success");
        map.put("role",role);
        map.put("username",username);

        if(role != "" && role != null){
            map.put("resultCode",1);
        }else{
            map.put("resultCode",2);
        }

        return map;
    }


}
