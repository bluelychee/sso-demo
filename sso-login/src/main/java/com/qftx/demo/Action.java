package com.qftx.demo;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Controller
public class Action {

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        Object login = session.getAttribute("login");
        if(login==null || StringUtils.isEmpty(login)){
            login = UUID.randomUUID();
            session.setAttribute("login",login);
            response.setHeader("token",String.valueOf(login));
        }
        String url = request.getParameter("from");

        if(StringUtils.isEmpty(url)){
            url =  "/";
        }else{
            if(!url.contains("?")) url+="?";
            url+="&token="+login;
            url ="http://"+url;
        }
        response.sendRedirect(url);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession httpSession){
        return "logout";
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "login Index";
    }
}
