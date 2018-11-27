package com.qftx.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class Action {
    @RequestMapping("/")
    @ResponseBody
    public String index(HttpSession httpSession){
        StringBuilder sb = new StringBuilder();
        sb.append("User Index<br>");
        sb.append("session id: "+httpSession.getId()+"<br>");
        sb.append("session login: "+httpSession.getAttribute("login")+"<br>");
        return sb.toString();
    }
}
