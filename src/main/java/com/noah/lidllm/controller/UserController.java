package com.noah.lidllm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author noah
 * @Date 4/27/21 2:59 PM
 * @Version 1.0
 **/
@Controller
@RequestMapping("/userPage")
public class UserController {

    @RequestMapping("/index")
    public String index(){
        return "user";
    }

}
