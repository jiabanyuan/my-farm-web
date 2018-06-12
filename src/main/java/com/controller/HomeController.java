package com.controller;

import com.model.ReturnValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {

    @ResponseBody
    @RequestMapping("/index")
    public  String index(HttpServletRequest request, HttpSession session){
        String wxName = request.getParameter("nickName");
        ReturnValue returnValue = new ReturnValue();
        if(wxName != null){
            returnValue.put("wx_name",wxName);
            returnValue.put("welcome","WELCOME TO FARM!");
        }
        return returnValue.toString();
    }
}