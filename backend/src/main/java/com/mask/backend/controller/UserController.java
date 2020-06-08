package com.mask.backend.controller;

import com.mask.backend.resource.LoginResource;
import com.mask.backend.resource.ResponceBody;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

@RestController
public class UserController {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "123456";

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody @Valid LoginResource resource, HttpSession session) {

        if(resource.getUsername().equals(USERNAME)
           && resource.getPassword().equals(PASSWORD)) {
            session.setAttribute("user", resource.getUsername());
            return ResponceBody.ok("登录成功", null);
        } else {
            return ResponceBody.error("用户名或密码错误");
        }
    }

    @GetMapping("/logout")
    @ResponseBody
    public Object logout(HttpSession session) {

        session.removeAttribute("user");
        return ResponceBody.ok("已退出登录", null);
    }

}
