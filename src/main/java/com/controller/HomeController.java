package com.controller;

import com.model.ReturnValue;
import com.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {

    @ResponseBody
    @RequestMapping("/index")
    public  String index(@RequestBody UserInfo userInfo, HttpServletRequest request, HttpSession session){

        ReturnValue returnValue = new ReturnValue();
        if(userInfo != null){
            returnValue.put("wx_name",userInfo.getNickName());
            returnValue.put("welcome","WELCOME TO FARM!");
        }
        return returnValue.toString();
    }
}