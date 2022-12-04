package pers.anofinda.anoblog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dongyudeng
 */
@Slf4j
@Controller
@RequestMapping("/")
public class EssayController {
    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
