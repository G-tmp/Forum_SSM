package com.xd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("")
public class AdminController {


    @RequestMapping("error")
    public String error(Model model){

        model.addAttribute("xd","xd");

        return "error";
    }

}
