package com.xd.controller;


import com.xd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {



    @RequestMapping("/")
    public String admin(Model model, HttpSession session){

        User user = (User) session.getAttribute("user");

        //not admin
        if (user==null || user.getIsAdmin()==0){
            model.addAttribute("error","无权限🙏🙏");
            return  "error";
        }


        return "admin";
    }



}
