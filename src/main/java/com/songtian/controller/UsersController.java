package com.songtian.controller;

import com.songtian.entity.Users;
import com.songtian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session,String userName,String password){
        Users users= userService.login(userName,password);

        if (users!=null){
            session.setAttribute("loginUser",users);
        }
        return "redirect:/index.html";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清空session中保存的数据
        session.invalidate();//使sesssion中的数据无效
        return "redirect:/index.html";
    }

    @RequestMapping("/myTest/{id}")
    public String myTest(@PathVariable Integer id){
        System.out.println("id="+id);
        return "redirect:/index.html";
}
}
