package com.mask.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZYF
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    String hello() {
        return "hello world";
    }
}
