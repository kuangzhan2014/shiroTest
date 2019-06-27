package com.maitianer.shirodemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhou
 * @Date: 2019/06/26 09:53
 */
@Controller
public class UserController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("");
        return "ok";
    }

    @RequestMapping("/testThymeleaf")
    public String Thymeleaf(Model model){
        model.addAttribute("name","帅哥");
        return "test";
    }
    @RequestMapping("/add")
    public String add(){
        return  "/user/add";
    }
    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }
}
