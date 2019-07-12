package com.ryan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019:07:09
 *
 * @Author : Lilanzhou
 * 功能 :
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String hello(){
        return "index";
    }


}
