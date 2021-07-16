package com.test.test.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testing {
    @GetMapping("/hello")
    public String test() {
        return "Hello! Akhirnya Bisa! :D";
    }

}
