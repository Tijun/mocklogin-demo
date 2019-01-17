package com.mock.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {



    @RequestMapping("/index")
    public Object index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/index2")
    @ResponseBody
    public Object index2(){
        return "adadad";
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String callback = request.getParameter("callback");
        response.sendRedirect(callback);
    }
}
