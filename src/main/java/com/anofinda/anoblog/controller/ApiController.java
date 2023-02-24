package com.anofinda.anoblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongyudeng
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
