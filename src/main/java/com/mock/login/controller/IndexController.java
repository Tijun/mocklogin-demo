package com.mock.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    public final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/index")
    public Object index(HttpServletRequest request){
        String callback = request.getParameter("callback");
        logger.info("callback",callback);
        request.getSession().setAttribute("callback",callback);
        return new ModelAndView("index");
    }

    @GetMapping("/auth/login")
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String callback = (String) request.getSession().getAttribute("callback");
        logger.info("callback",callback);
        Cookie cookie = new Cookie("token","xdfdfdfdfffffffffffffssdfsfsfsdfsdf");
        cookie.setMaxAge(1000000);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setDomain("127.0.0.1");
        response.addCookie(cookie);
        response.sendRedirect(callback);
    }

    @RequestMapping("/auth/info")
    @ResponseBody
    public Object info(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies){
            System.out.println(cookies);
        }
        User user = new User();
        user.setName("xiao tian");
        user.setUsername("m135");
        user.setEmail("xiaotian@h3c,com");
        return user;
    }
}
