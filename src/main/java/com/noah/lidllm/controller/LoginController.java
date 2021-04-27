package com.noah.lidllm.controller;

import com.oracle.tools.packager.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author noah
 * @Date 4/27/21 11:49 AM
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
@Slf4j
public class LoginController {

    /**
     *
     * @Author yz
     * @Description 登录接口
     * @Date 4/27/21 12:04 PM
     * @param name
     * @param password
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("/login")
    public String login(@RequestParam("name")String name,
                        @RequestParam("password")String password,
                        Model model,
                        HttpSession httpSession){
        Log.info("登录请求");
        httpSession.setAttribute("loginUser",name);
        if (!StringUtils.isEmpty(name) && "123123".equals(password)) {
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","登录失败");
            return "index";
        }
    }

    /**
     *
     * @Author yz
     * @Description 注销
     * @Date 4/27/21 5:01 PM
     * @param httpSession
     * @return java.lang.String
     */
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:index.html";
    }
}
